#-*- coding: utf-8 -*-
'''    
Created on Nov 14, 2010

@author: pedropaulovc
'''

from socket import *
from threading import *

class CamadaRede(Thread):
    '''
    classdocs
    '''

    def __init__(self, ender):
        Thread.__init__(self)
        print "Inciando Camada de Rede ", ender
        self.socket = socket(AF_INET, SOCK_STREAM)
        self.remotos = {}
        self.ender = ender
        

    def run(self):
        self.iniciarEscuta()

    def iniciarEscuta(self):
        print "Inciando escuta ", self.ender
        self.socket.bind(self.ender)
        self.socket.listen(self.obterTamFila())
        
        while True:
            socketRemoto, enderRemoto = self.socket.accept()
            print "Foi aceita conexão com ", enderRemoto
            self.remotos[enderRemoto] = socketRemoto
        
    @staticmethod
    def obterTamBuf():
        return 1024
    
    @staticmethod
    def obterTamFila():
        return 2
    
    def enviarRede(self, enderRemoto, pacote):
        print "Enviando pacote para " , enderRemoto
        self.remotos[enderRemoto].send(pacote)
        
    def receberRede(self, enderRemoto):
        print "Recebendo dados de ", enderRemoto
        return self.remotos[enderRemoto].recv(CamadaRede.obterTamBuf())
    
    def conectar(self, enderRemoto):
        print self.ender, "conectando com", enderRemoto
        socketRemoto = socket(AF_INET, SOCK_STREAM)
        socketRemoto.connect(enderRemoto)
        self.remotos[enderRemoto] = socketRemoto
    
    def desconectar(self, enderRemoto):
        print "Desconectando com", enderRemoto
        self.remotos.pop(enderRemoto).close()
    
    def obterRemotos(self):
        return self.remotos
