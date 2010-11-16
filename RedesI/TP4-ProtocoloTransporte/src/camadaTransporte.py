#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaRede import CamadaRede
from pacote import Pacote

class CamadaTransporte(object):
    '''
    classdocs
    '''

    def __init__(self, camadaRede):
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
        
        self.endTransporte
        self.endEscuta
        self.conexaoEscuta
        self.acordado = True
        self.dados = []
        self.conexoes = []
        
        self.pacote
        
        self.camadaRede = camadaRede
        self.camadaAplicacao
        
        for _ in xrange(self.maxConexoes):
            self.conexoes.append(Conexao())
        
    def dormir(self):
        self.acordado = False
        
        while(not self.acordado):
            pass
        
    def acordar(self):
        self.acordado = True
        
    def paraRede(self, cid, q, m, pt, data, bytes):
        pacote = Pacote(cid, q, m, pt, data, bytes)
        self.camadaRede.enviarPacote(self, pacote)
        
    def daRede(self, pacote):
        self.recebimentoPacote(pacote, 1)
    
    def escutar(self, t):
        i = 1
        encontrado = 0
        
        for i in xrange(self.maxConexoes):
            if self.conexoes[i].estado != 'ENFILEIRADO' or \
                self.conexoes[i].enderecoLocal != t:
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
    
    def conectar(self, l, r):
        self.dados[0] = str(r)
        self.dados[1] = str(l)
        
        i = 31
        while self.conexoes[i].estado != 'INATIVO' and i > 0:
            i -= 1
        
        if self.conexoes[i].estado == 'INATIVO':
            cptr = self.conexoes[i]
            cptr.enderecoLocal = l
            cptr.enderecoRemoto = r
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
        pass
    
    def recebimentoPacote(self, pacote, contagem):
        pass
    
class Conexao(object):
    
    def __init__(self):
        self.enderecoLocal
        self.enderecoRemoto
        self.estado = 'INATIVO'
        self.enderecoBufferUsuario = []
        self.numBytes
        self.clearRequestRecebido
        self.timer
        self.creditos
        self.tamBuffer = 100
        
        for _ in xrange(100):
            self.enderecoBufferUsuario.append("")