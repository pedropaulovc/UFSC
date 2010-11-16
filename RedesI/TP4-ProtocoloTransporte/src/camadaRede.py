#-*- coding: utf-8 -*-
'''    
Created on Nov 14, 2010

@author: pedropaulovc
'''

from socket import *
from threading import *

class CamadaRede(object):
    '''
    classdocs
    '''

    def __init__(self, ender):
        print "Inciando Camada de Rede ", ender
        self.socket = socket(AF_INET, SOCK_STREAM)
        self.remotos = {}
        self.ender = ender
        
        ServidorCamadaRede(self).start()
        ClienteCamadaRede(self).start()
    
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
    

class ServidorCamadaRede(Thread):
    def __init__(self, rede):
        Thread.__init__(self)
        self.rede = rede
    
    def run(self):
        print "Inciando servidor ", self.rede.ender
        self.rede.socket.bind(self.rede.ender)
        self.rede.socket.listen(self.rede.obterTamFila())
        
        while True:
            socketRemoto, enderRemoto = self.rede.socket.accept()
            print "Foi aceita conexão com ", enderRemoto
            self.rede.remotos[enderRemoto] = socketRemoto
    
    
class ClienteCamadaRede(Thread):
    def __init__(self, rede):       
        Thread.__init__(self)
        self.rede = rede
        
    def run(self):
#        print "Inciando cliente ", self.rede.ender
        pass
    