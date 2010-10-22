#-*- coding: utf-8 -*-
class Tarefa(object):
	def __init__(self, id, nome, descricao, dificuldade, requisitos, estimativa):
		self.__id = id
		self.__nome = nome
		self.__descricao = descricao
		self.__requisitos = requisitos
		self.__dificuldade = dificuldade
		self.__estimativa = estimativa
		self.__responsavel = None

	
	def obterNome(self):
		return self.__nome

	def obterId(self):
		return self.__id

	# @ParamType idMembro 
	def definirResponsavel(self, idMembro):
		self.__responsavel = idMembro
	
	def __repr__(self):
		return u'{0} - Nome:{1}; Descrição: {2}; Requisitos: {3}'.format(\
				self.__id, self.__nome, self.__descricao, self.__requisitos)