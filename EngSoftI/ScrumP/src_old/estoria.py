#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Estoria(object):
    '''
    classdocs
    '''


    def __init__(self,id,nome,tarefas):
        self.__id = id
        self.__tarefas = tarefas

    def obterId(self):
        return self.__id
    
    def obterTarefas(self):
        return self.__tarefas