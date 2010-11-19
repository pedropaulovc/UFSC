#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from threading import Thread

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
        
    def run(self):
        self.escutar(self.id)

    def conectar(self, remoto):
        print "CA{0} conectando com {1}".format(self.id, remoto)
        self.cid = self.camadaTransporte.conectar(self.id, remoto)
        
        if self.cid > 0:
            print "Conexão entre {0} e {1} estabelecida: {2}".format(self.id, remoto, self.cid)
        else:
            print "Conexão falhou"
    
    def escutar(self, t):
        self.cid = self.camadaTransporte.escutar(t)
    
    def fecharConexao(self):
        return self.camadaTransporte.desconectar(self.cid);
    
    def enviarMensagem(self, s):
        print "CA{0}: Enviando mensagem: {1}".format(self.id, s)
        bytes = [s]
        self.camadaTransporte.enviar(self.cid, bytes, 1)
    
    def receberMensagem(self, origem, s):
        print "CA{0}: Recebi de {1} mensagem: {2}".format(self.id, origem, s)
        if self.aplicacao != None:
            self.aplicacao.receberMensagem(s, self.id)