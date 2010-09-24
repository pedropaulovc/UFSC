#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Excecoes(Exception):
    pass

class UsuarioExistente(Excecoes):
    pass

class UsuarioNaoExistente(Excecoes):
    pass