#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''
from threading import Thread
import logging

class CamadaAplicacao(Thread):
    def __init__(self, id, camadaTransporte):
        Thread.__init__(self)
        self.camadaTransporte = camadaTransporte
        self.aplicacao = None
        self.id = id
        self.cid = None
        
        self.log = logging.getLogger("computador{0}".format(self.id))
        
    def run(self):
        self.escutar(self.id)

    def conectar(self, remoto):
        '''
        Tentar obter uma conexao com o computador identificado por "remoto". 
        '''
        self.log.info("CA: Conectando com {0}".format(remoto))
        self.cid = self.camadaTransporte.conectar(self.id, remoto)
        
        if self.cid > 0:
            self.log.info("CA: Conexao entre {0} e {1} estabelecida".format(self.id, remoto))
        else:
            self.log.error("CA: Conexao falhou")
    
    def escutar(self, t):
        '''
        Envia mensagem a camada de transporte para permanecer aguardando por
        uma nova conexao no endereco "t"
        '''
        self.cid = self.camadaTransporte.escutar(t)
    
    def fecharConexao(self):
        '''
        Encerra a conexao atual.
        '''
        return self.camadaTransporte.desconectar(self.cid);
    
    def enviarMensagem(self, s):
        '''
        Informa a camada de transporte para enviar a mensagem "s" ao computador remoto.
        '''
        self.log.info("CA: Enviando mensagem: {0}".format(s))
        bytes = [s]
        self.camadaTransporte.enviar(self.cid, bytes, 1)
    
    def receberMensagem(self, origem, s):
        '''
        Metodo invocado pela camada de transporte sempre que um novo pacote chega.
        '''
        self.log.info("CA: Recebi mensagem".format(origem, s))
        if self.aplicacao != None:
            self.aplicacao.receberMensagem(s, self.id)
