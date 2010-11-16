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
        self.origem
        self.destino
    
    def enviarPacote(self, emissor, pacote):
        if emissor == self.origem:
            receptor = self.destino
        else:
            receptor = self.origem
        
        receptor.receberRede(pacote)