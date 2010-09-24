#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Estoria(object):
    '''
    classdocs
    '''


    def __init__(self,id,tarefas):
        self.__tarefas = {}
        self.__id = id

    def obterId(self):
        return self.__id
    
    def criarEstoria(self,tarefas):
        self.__init__(id,tarefas)