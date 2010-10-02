#-*- coding: utf-8 -*-
class Tarefa(object):
	def __init__(self, nome, descricao, requisitos, dificuldade):
		self.__nome = nome
		self.__descricao = descricao
		self.__requisitos = requisitos
		self.__dificuldade = dificuldade
		self.__responsavel = None

	
	def obterNome(self):
		return self.__nome

	def obterId(self):
		return self.__id

	# @ParamType idMembro 
	def definirResponsavel(self, idMembro):
		self.__responsavel = idMembro


