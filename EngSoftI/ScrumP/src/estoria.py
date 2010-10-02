#-*- coding: utf-8 -*-
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
