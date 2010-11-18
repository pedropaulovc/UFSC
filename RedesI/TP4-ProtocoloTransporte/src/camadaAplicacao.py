#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaTransporte import CamadaTransporte
from threading import Thread
from time import sleep

class CamadaAplicacao(Thread):
    '''
    classdocs
    '''


    def __init__(self, id, camadaTransporte):
        Thread.__init__(self)
        self.camadaTransporte = camadaTransporte
        self.id = id
        self.cid = None
        
    def run(self):
        pass
#        if self.id == 1:
#            self.conectar(2)
#            sleep(1)
#            self.enviarMensagem("Olá mundo!")
#            self.enviarMensagem("Olá mundo!2")
#        elif self.id == 2:
#            self.escutar(2)
#            self.enviarMensagem("Hello world!")
    
    def conectar(self, remoto):
        print "Camada aplicação conectando"
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
        bytes = [s]
        self.camadaTransporte.enviar(self.cid, bytes, 1)
    
    def receberMensagem(self, s):
        print "CA{0}: Recebi mensagem: {1}".format(self.id, s)