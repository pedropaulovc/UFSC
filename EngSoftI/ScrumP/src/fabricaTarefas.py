'''
Created on 27/09/2010

@author: pepe
'''
from tarefa import Tarefa
class Callable:
    def __init__(self, anycallable):
        self.__call__ = anycallable

class FabricaTarefa(object):
    '''
    classdocs
    '''
    
    __tarefa = 0

    def __init__(self):
        '''
        Constructor
        '''

    def __gerarIdTarefa(): #@NoSelf
        id = "TAR-" + str(FabricaTarefa.__tarefa)
        FabricaTarefa.__tarefa += 1 
        return id
    __gerarIdTarefa = Callable(__gerarIdTarefa)
    
    def criarTarefa(dificuldade, tempoEst, nome, requisitos): #@NoSelf
        id = FabricaTarefa.__gerarIdTarefa()
        tarefa = Tarefa(dificuldade, tempoEst, nome, requisitos)
        return tarefa
    criarTarefa = Callable(criarTarefa)