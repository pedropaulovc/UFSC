#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''
from pacote import Pacote
import logging

class CamadaTransporte(object):

    def __init__(self, id, camadaRede):
        '''
        Inicializacao de configuracoes da camada de transporte. O endereco
        da camada e definido por "id" e a sua camada de rede correspondente
        e definida por "camadaRede".
        '''
        self.maxConexoes = 32
        self.tamMaxMsg = 8129
        self.tamMaxPacote = 512
        self.timeout = 20
        self.cred = 1
        self.OK = 0
        self.erroCheio = -1
        self.erroRejeitado = -2
        self.erroFechado = -3
        self.erroMenor = -3
        
        self.endTransporte = 0
        self.endEscuta = 0
        self.conexaoEscuta = 0
        self.acordado = True
        self.dados = []
        self.conexoes = []
        
        self.pacote = None
        
        self.camadaRede = camadaRede
        self.camadaAplicacao = None
        self.id = id
        
        for _ in xrange(self.maxConexoes):
            self.conexoes.append(Conexao())
            self.dados.append("")
        
        self.__configurarLog()


        
    def dormir(self):
        '''
        Suspende a execucao da camada de transporte ate que seja acordada novamente
        por algum evento.
        '''
        self.log.info("CT: Indo dormir")
        
        self.acordado = False
        while(not self.acordado):
            pass
        
    def acordar(self):
        '''
        Reinicia a execucao da camada de transporte.
        '''
        self.log.info("CT: Acordando")
        self.acordado = True
        
    def paraRede(self, cid, q, m, pt, data, bytes):
        '''
        Metodo invocado pela camada de transporte para montar um pacote e
        envia-lo a camada de rede.
        '''
        self.log.info("CT: Enviando {0} para CR".format(pt))
        pacote = Pacote(cid, q, m, pt, data, bytes)
        self.camadaRede.enviarPacote(self, pacote)
        
    def daRede(self, pacote):
        '''
        Metodo invocado pela camada de rede para informar a camada de transporte
        que um novo pacote esta disponivel no buffer da camada de rede.
        '''
        self.log.info("CT: Recebendo dado da CR")
        self.chegadaPacote(pacote, 1)
    
    def escutar(self, t):
        '''
        Metodo para permanecer aguardando por uma nova conexao no endereco "t"
        '''
        self.log.info("CT: Escutando a rede")
        i = 1
        encontrado = 0
        
        for i in xrange(self.maxConexoes):
            if self.conexoes[i].estado != 'ENFILEIRADO' or self.conexoes[i].enderecoLocal != t:
                continue
            encontrado = i
            break
        
        if encontrado == 0:
            self.endEscuta = t
            self.dormir()
            i = self.conexaoEscuta
        
        self.conexoes[i].estado = 'ESTABELECIDO'
        self.conexoes[i].timer = 0
        self.conexaoEscuta = 0
        self.paraRede(i, 0, 0, 'CHAMADA_ACEITA', self.dados, 0)
        return i
    
    def conectar(self, local, remoto):
        '''
        Metodo para tentar estabelecer uma conexao entre "local" e "remoto"
        '''
        self.log.info("CT: Iniciando conexao")
        self.dados[0] = str(remoto)
        self.dados[1] = str(local)
        
        i = 31
        while self.conexoes[i].estado != 'INATIVO' and i > 0:
            i -= 1
        
        if self.conexoes[i].estado == 'INATIVO':
            cptr = self.conexoes[i]
            cptr.enderecoLocal = local
            cptr.enderecoRemoto = remoto
            cptr.estado = 'AGUARDANDO'
            cptr.clearRequestRecebido = 0
            cptr.creditos = 0
            cptr.timer = 0
            self.paraRede(i, 0, 0, 'REQ_CHAMADA', self.dados, 2)
            self.dormir()
            
            if cptr.estado == 'ESTABELECIDO':
                return i
            
            if cptr.clearRequestRecebido != 0:
                cptr.estado = 'AGUARDANDO'
                self.paraRede(i, 0, 0, 'CONF_LIVRE', self.dados, 0)
                return -2
            else:
                return 0
        else:
            return -1
    
    def enviar(self, cid, pontBuf, bytes):
        '''
        Metodo para enviar um pacote com dados armazenados no endereco
        "pontBuf" e de tamanho "bytes" bytes a conexao estabelecida previamente "cid".
        '''
        self.log.info("CT: Enviando dados")
        cptr = self.conexoes[cid]
        if cptr.estado == 'AGUARDANDO':
            return -3
        cptr.estado = 'ENVIANDO'
        cptr.numBytes = 0
        if cptr.clearRequestRecebido == 0:
            while cptr.numBytes < bytes:
                if bytes - cptr.numBytes > 512:
                    contagem = 512
                    m = 1
                else:
                    contagem = bytes - cptr.numBytes
                    m = 0
                for i in xrange(contagem):
                    self.dados[i] = pontBuf[cptr.numBytes + i]
                    self.paraRede(cid, 0, m, 'PACOTE_DADOS', self.dados, contagem)
                    cptr.numBytes += contagem
            cptr.estado = 'ESTABELECIDO'
            return 0
        else:
            cptr.estado = 'ESTABELECIDO'
            return -3
    
    def receber(self, cid, pontBuf, bytes):
        '''
        O usuario esta preparado para receber uma mensagem. 
        '''
        self.log.info("CT: Recebendo dados")
        cptr = self.conexoes[cid]
        if cptr.clearRequestRecebido == 0:
            cptr.estado = 'RECEBENDO'
            cptr.enderecoBufferUsuario = pontBuf
            cptr.numBytes = 0
            self.dados[0] = 'CRED'
            self.dados[1] = '1'
            self.paraRede(cid, 1, 0, 'CREDITO', self.dados, 2)
    
        cptr.estado = 'ESTABELECIDO'
        if cptr.clearRequestRecebido != 1:
            return 0
        return -3
    
    def desconectar(self, cid):
        '''
        Metodo invocado para desconectar a conexao estabelecida "cid" 
        '''
        self.log.info("CT: Desconectando")
        cptr = self.conexoes[cid]
        if cptr.clearRequestRecebido == 1:
            cptr.estado = 'INATIVO'
            self.paraRede(cid, 0, 0, 'CONF_LIVRE', self.dados, 0)
        else:
            cptr.estado = 'DESCONECTADO'
            self.paraRede(cid, 0, 0, 'REQ_LIVRE', self.dados, 0)
        return 0
    
    def chegadaPacote(self, pacote, contagem):
        '''
        Metodo invocado pela propria camada de transporte para analizar
        um pacote recebido da camada de rede e fornecer um destino adequado.
        '''
        self.log.info("CT: Chegou pacote")
        cid = int(pacote.cid)
        tipo = pacote.pt
        dados = pacote.p
        cptr = self.conexoes[cid]
        if tipo == 'REQ_CHAMADA':
            cptr.enderecoLocal = int(dados[0])
            cptr.enderecoRemoto = int(dados[1])
            if cptr.enderecoLocal == self.endEscuta:
                self.conexaoEscuta = cid
                cptr.estado = 'ESTABELECIDO'
                self.acordar()
            else:
                cptr.estado = 'ENFILEIRADO'
                cptr.timer = 20
            cptr.clearRequestRecebido = 0
            cptr.creditos = 0
        elif tipo == 'CHAMADA_ACEITA' :
            cptr.estado = 'ESTABELECIDO'
            self.acordar()
        elif tipo == 'REQ_LIVRE':
            cptr.clearRequestRecebido = 1
            if cptr.estado == 'ESTABELECIDO':
                cptr.estado = 'INATIVO'
                self.desconectar(cid)
            if cptr.estado == 'ESPERANDO' or cptr.estado == 'RECEBENDO' or \
                cptr.estado == 'ENVIANDO':
                self.acordar()
        elif tipo == 'CONF_LIVRE':
            cptr.estado = 'INATIVO'
            print "Desconectado"
        elif tipo == 'CREDITO':
            cptr.creditos += int(dados[1])
            if cptr.estado == 'ENVIANDO':
                self.acordar()
        elif tipo == 'PACOTE_DADOS':
            for i in xrange(contagem):
                cptr.enderecoBufferUsuario[0] = dados[i]
            
            cptr.numBytes += contagem
            self.camadaAplicacao.receberMensagem(cptr.enderecoRemoto, cptr.enderecoBufferUsuario[0])
            
    def relogio(self):
        '''
        Houve um pulso de relogio. Verifica timeouts de solicitacoes de conexoes 
        enfileiradas.
        '''
        for i in range(1,32):
            cptr = self.conexoes[i]
            if cptr.timer > 0:
                cptr.timer -= 1
                if cptr.timer == 0:
                    cptr.estado = 'INATIVO'
                    self.paraRede(i, 0, 0, 'REQ_LIVRE', self.dados, 0)
                
    def __configurarLog(self):
        '''
        Configura a infraestrutura de log para analise do funcionamento da
        camada de transporte.
        '''
        self.log = logging.getLogger("computador{0}".format(self.id))
        self.log.setLevel(logging.INFO)
        ch = logging.StreamHandler()
        ch.setLevel(logging.INFO)
        self.log.addHandler(ch)
   
   
class Conexao(object):
    
    def __init__(self):
        '''
        Definicao de uma conexao utilizada por essa implementacao de
        camada de transporte. 
        '''
        self.enderecoLocal = 0
        self.enderecoRemoto = 0
        self.estado = 'INATIVO'
        self.enderecoBufferUsuario = []
        self.numBytes = 0
        self.clearRequestRecebido = 0
        self.timer = 0
        self.creditos = 0
        self.tamBuffer = 100
        
        for _ in xrange(100):
            self.enderecoBufferUsuario.append("")