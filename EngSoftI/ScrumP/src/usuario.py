#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Usuario(object):
    '''
    classdocs
    '''


    def __init__(self,nome, login, senha):
        self.__nome = nome
        self.__login = login
        self.__senha = senha
        
    def obterNome(self):
        return self.__nome
    
    def obterLogin(self):
        return self.__login