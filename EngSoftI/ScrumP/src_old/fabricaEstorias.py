'''
Created on 27/09/2010

@author: pepe
'''
from estoria import Estoria
class Callable:
    def __init__(self, anycallable):
        self.__call__ = anycallable

class FabricaEstorias(object):
    '''
    classdocs
    '''
    __estoria = 0

    def __init__(self):
        '''
        Constructor
        '''
        
    def __gerarIdEstoria(): #@NoSelf
        id = "EST-" + str(FabricaEstorias.__estoria)
        FabricaEstorias.__estoria += 1 
        return id
    __gerarIdEstoria = Callable(__gerarIdEstoria)
    
    def criarEstoria(nome,tarefas): #@NoSelf
        id = FabricaEstorias.__gerarIdEstoria()
        estoria = Estoria(id,nome,tarefas)
        return estoria
    criarEstoria = Callable(criarEstoria)
    
    
    
    
    
    