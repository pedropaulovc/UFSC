#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
class Estoria(object):
	def __init__(self, nome, tarefas, id, descricao):
		self.__nome = nome
		self.__tarefas = tarefas
		self.__id = id
		self.__descricao = descricao

	def obterTarefas(self):
		return self.__tarefas

	def obterId(self):
		return self.__id
