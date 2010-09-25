#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''
from estoria import Estoria
from identidade import Id
from tarefa import Tarefa 

class Projeto(object):
    '''
    classdocs
    '''

    def __init__(self, nome, time, productOwner, scrumMaster, id):
        self.__nome = nome
        self.__time = time
        self.__productOwner = productOwner
        self.__scrumMaster = scrumMaster
        self.__id = id
        self.__prodBackLog = {}
        self.__tarefas = {}
        
    def obterNome(self):
        return self.__nome
    
    def obterTime(self):
        return self.__time
    
    def obterScrumMaster(self):
        return self.__scrumMaster
    
    def obterProductOwner(self):
        return self.__productOwner
    
    def obterId(self):
        return self.__id
    
    def participa(self, login):
        for usuario in self.__time:
            if usuario == login:
                return True
        if login == self.__productOwner:
            return True
        if login == self.__scrumMaster:
            return True
        
        return False
    
    def adicionarEstoria(self,tarefas):
        id = Id.gerarIdEstoria()
        tarefasParaAdicionar = []
        for tarefa in tarefas:
            tarefaTemp = self.__tarefas[tarefa].obterId()
            tarefasParaAdicionar.append(tarefaTemp)
            print tarefasParaAdicionar
        self.__prodBackLog[id] = Estoria(id, tarefasParaAdicionar)
        print self.__prodBackLog[id].obterTarefas()
        return id
        
    def adicionarTarefa(self,dificuldade, tempoEst, nome, requisitos=[]):
        id = Id.gerarIdTarefa()
        self.__tarefas[id] = Tarefa(id, dificuldade, tempoEst, nome, requisitos)
        return id
    
    def obterEstoria(self,idEstoria):
        return self.__prodBackLog[idEstoria]