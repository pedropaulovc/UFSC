'''
Created on 27/09/2010

@author: pepe
'''
from projeto import Projeto

class Callable:
    def __init__(self, anycallable):
        self.__call__ = anycallable


class FabricaProjetos(object):
    '''
    classdocs
    '''
    __projeto = 0

    def __init__(self):
        '''
        Constructor
        '''
        
    def __gerarIdProjeto(): #@NoSelf
        id = "PROJ-" + str(FabricaProjetos.__projeto)
        FabricaProjetos.__projeto += 1 
        return id
    __gerarIdProjeto = Callable(__gerarIdProjeto)
    
    def criarProjeto(nome, time, productOwner, scrumMaster): #@NoSelf
        id = FabricaProjetos.__gerarIdProjeto()
        projeto = Projeto(id, nome, time, productOwner, scrumMaster)
        return projeto
    criarProjeto = Callable(criarProjeto)