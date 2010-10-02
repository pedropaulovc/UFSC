#-*- coding: utf-8 -*-
from excecoes import TarefaNaoExiste, TarefaJaExiste
from fabricaTarefas import FabricaTarefas
class ListaTarefas(object):
	def __init__(self):
		self.__listaTarefas = {}
		self.__listaTarefasConcluidas = {}

	
	# @ParamType idTarefa 
	def marcarConcluida(self, idTarefa):
		if not self.__listaTarefas.has_key(idTarefa):
			raise TarefaNaoExiste
		tarefa = self.__listaTarefas.pop(idTarefa)
		self.__listaTarefasConcluidas[idTarefa] = tarefa

	def obterTarefas(self):
		return self.__listaTarefas.keys()

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade TarefasPreRequisito 
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisito):
		tarefas = self.__listaTarefas.values()
		for tarefa in tarefas:
			if nome == tarefa.obterNome():
				raise TarefaJaExiste
		tarefa = FabricaTarefas.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisito)
		self.__listaTarefas[tarefa.obterId()] = tarefa
		

	# @ParamType tarefas 
	def verificarTarefas(self, tarefas):
		for tarefa in tarefas:
			if not self.__listaTarefas.has_key(tarefa.obterId()):
				raise TarefaNaoExiste

	# @ParamType mapaTarefasMembros 
	def definirResponsaveis(self, mapaTarefasMembros):
		idsTarefas = mapaTarefasMembros.keys()
		
		for idTarefa in idsTarefas:
			idMembro = mapaTarefasMembros.get(idTarefa)
			tarefa = self.__listaTarefas.get(idTarefa)
			tarefa.definirResponsavel(idMembro)


