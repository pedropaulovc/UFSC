#-*- coding: utf-8 -*-
'''    
Created on Nov 14, 2010

@author: pedropaulovc
'''

class CamadaRede(object):
    '''
    classdocs
    '''
    
    def __init__(self):
        self.origem = None
        self.destino = None
    
    def enviarPacote(self, emissor, pacote):
        print "Camada de rede enviando pacote"
        if emissor == self.origem:
            receptor = self.destino
        else:
            receptor = self.origem
        
        receptor.daRede(pacote)