#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from threading import Thread
import logging

class CamadaAplicacao(Thread):
    '''
    classdocs
    '''

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
        self.log.info("CA: Conectando com {0}".format(remoto))
        self.cid = self.camadaTransporte.conectar(self.id, remoto)
        
        if self.cid > 0:
            self.log.info("CA: Conexão entre {0} e {1} estabelecida".format(self.id, remoto))
        else:
            self.log.error("CA: Conexão falhou")
    
    def escutar(self, t):
        self.cid = self.camadaTransporte.escutar(t)
    
    def fecharConexao(self):
        return self.camadaTransporte.desconectar(self.cid);
    
    def enviarMensagem(self, s):
        self.log.info("CA: Enviando mensagem: {0}".format(s))
        bytes = [s]
        self.camadaTransporte.enviar(self.cid, bytes, 1)
    
    def receberMensagem(self, origem, s):
        self.log.info("CA: Recebi mensagem".format(origem, s))
        if self.aplicacao != None:
            self.aplicacao.receberMensagem(s, self.id)
