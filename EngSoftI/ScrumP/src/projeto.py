#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''
from tarefa import Tarefa 
from productBackLog import ProductBackLog
from listaTarefas import ListaTarefas

class Projeto(object):
    '''
    classdocs
    '''

    def __init__(self, id, nome, time, productOwner, scrumMaster):
        self.__nome = nome
        self.__time = time
        self.__productOwner = productOwner
        self.__scrumMaster = scrumMaster
        self.__id = id
        self.__prodBackLog = ProductBackLog()
        self.__tarefas = ListaTarefas()
        
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
        
    #TODO: verificar tarefas
    def criarTarefa(self,dificuldade, tempoEst, nome, requisitos=[]):
        self.__tarefas[id] = Tarefa(id, dificuldade, tempoEst, nome, requisitos)
        return id
    
    def adicionarEstoria(self,estoria):
        self.__prodBackLog.adicionarEstoria(estoria)
    
    def obterEstoria(self,idEstoria):
        return self.__prodBackLog.obterEstoria(idEstoria)