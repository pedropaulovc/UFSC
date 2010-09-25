#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe

Receita de métodos e atributos estáticos retirados de
http://code.activestate.com/recipes/52304-static-methods-aka-class-methods-in-python/
Pydev reclama dos métodos não terem self mas código funciona, é possível desabilitar
os erros
'''
class Callable:
    def __init__(self, anycallable):
        self.__call__ = anycallable

class Id(object):
    '''
    classdocs
    '''
    __projeto = 0
    __sprint = 0
    __tarefa = 0
    __backLog = 0
    __estoria = 0
    
    def gerarIdProjeto(): #@NoSelf
        id = "PROJ-" + str(Id.__projeto)
        Id.__projeto += 1 
        return id
    gerarIdProjeto = Callable(gerarIdProjeto)
    
    def gerarIdSprint(): #@NoSelf
        id = "SPR-" + str(Id.__sprint)
        Id.__sprint += 1 
        return id
    gerarIdSprint = Callable(gerarIdSprint)
    
    def gerarIdTarefa(): #@NoSelf
        id = "TAR-" + str(Id.__tarefa)
        Id.__tarefa += 1 
        return id
    gerarIdTarefa = Callable(gerarIdTarefa)
    
    def gerarIdBackLog(): #@NoSelf
        id = "BKL-" + str(Id.__backLog)
        Id.__backLog += 1 
        return id
    gerarIdBackLog = Callable(gerarIdBackLog)
    
    def gerarIdEstoria(): #@NoSelf
        id = "EST-" + str(Id.__estoria)
        Id.__estoria += 1 
        return id
    gerarIdEstoria = Callable(gerarIdEstoria)