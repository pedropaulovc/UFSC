'''
Created on 24/09/2010

@author: pepe
'''

class Id(object):
    '''
    classdocs
    '''
    __projeto = 0
    __sprint = 0
    __tarefa = 0
    __backLog = 0
    
    def __init__(self):
        self.__projeto = 0    
    
    def gerarIdProjeto(self):
        id = "PROJ-" + str(self.__class__.__projeto)
        self.__class__.__projeto += 1 
        return id
    
    def gerarIdSprint(self):
        id = "SPR-" + str(self.__class__.__sprint)
        self.__class__.__sprint += 1 
        return id
    
    def gerarIdTarefa(self):
        id = "TAR-" + str(self.__class__.__tarefa)
        self.__class__.__tarefa += 1 
        return id
    
    def gerarIdBackLog(self):
        id = "BKL-" + str(self.__class__.__backLog)
        self.__class__.__backLog += 1 
        return id