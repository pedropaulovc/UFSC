#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

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