#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Excecoes(Exception):
    pass

class UsuarioJaExiste(Excecoes):
    pass

class UsuarioNaoExiste(Excecoes):
    pass

class ProjetoNaoExistente(Excecoes):
    pass