#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

class Excecoes(Exception):
    pass

class EstoriaNaoExiste(Excecoes):
    pass

class DuracaoInvalida(Excecoes):
    pass

class LoginJaExiste(Excecoes):
    pass

class ProjetoNaoExiste(Excecoes):
    pass

class SenhaInvalida(Excecoes):
    pass

class TarefaJaExiste(Excecoes):
    pass

class TarefaNaoExiste(Excecoes):
    pass

class UsuarioNaoExiste(Excecoes):
    pass

class UsuarioNaoLogado(Excecoes):
    pass

class SemProjetoAberto(Excecoes):
    pass