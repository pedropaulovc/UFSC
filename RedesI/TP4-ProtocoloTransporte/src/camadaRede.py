#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''

class CamadaRede(object):
    
    def __init__(self):
        self.origem = None
        self.destino = None
            
    def enviarPacote(self, emissor, pacote):
        '''
        Redireciona um pacote de uma camada de transporte para a outra.
        '''
        if emissor == self.origem:
            receptor = self.destino
        else:
            receptor = self.origem
        
        receptor.daRede(pacote)