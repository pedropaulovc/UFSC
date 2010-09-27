'''
Created on 27/09/2010

@author: pepe
'''

class ProductBackLog(object):
    '''
    classdocs
    '''


    def __init__(self):
        self.__listaEstorias = {}
    
    def adicionarEstoria(self,estoria):
        self.__listaEstorias[estoria.obterId()] = estoria
        
    def obterEstoria(self,idEstoria):
        return self.__listaEstorias.get(idEstoria)