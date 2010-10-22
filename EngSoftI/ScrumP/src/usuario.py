#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
class Usuario(object):
	def __init__(self, nome, login, senha):
		self.__nome = nome
		self.__login = login
		self.__senha = senha

	# @ParamType senha 
	def verificarSenha(self, senha):
		return senha == self.__senha
	
	def obterLogin(self):
		return self.__login