#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Tarefa(object):
    '''
    classdocs
    '''


    def __init__(self,id,dificuldade, tempoEst, nome, requisitos=[]):
        self.__id = id
        self.__dificuldade = dificuldade
        self.__tempoEst = tempoEst
        self.__nome = nome
        self.__requisitos = requisitos
        
    def obterId(self):
        return self.__id