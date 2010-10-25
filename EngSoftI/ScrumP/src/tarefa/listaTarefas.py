#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
from excecoes.excecoes import TarefaNaoExiste, TarefaJaExiste, TarefaJaConcluida
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
		tarefas = []
		tarefasConcluidas = []
		for tarefa in self.__listaTarefas.values():
			tarefas.append(tarefa.__repr__())
		for tarefaConcluida in self.__listaTarefasConcluidas.values():
			tarefasConcluidas.append(tarefaConcluida.__repr__())
		return (tarefas, tarefasConcluidas)

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade TarefasPreRequisito 
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisito, estimativa):
		tarefas = self.__listaTarefas.values()
		for tarefa in tarefas:
			if nome == tarefa.obterNome():
				raise TarefaJaExiste
			
		fabricaTarefas = FabricaTarefas.getInstance()
		tarefa = fabricaTarefas.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisito, estimativa)
		self.__listaTarefas[tarefa.obterId()] = tarefa
		

	# @ParamType tarefas 
	def verificarTarefasExistem(self, tarefas):
		for tarefa in tarefas:
			if tarefa not in self.__listaTarefas and tarefa not in self.__listaTarefasConcluidas:
				raise TarefaNaoExiste
	
	def verificarTarefasPendentes(self, tarefas):
		for tarefa in tarefas:
			if tarefa not in self.__listaTarefas:
				raise TarefaJaConcluida
	
	# @ParamType mapaTarefasMembros 
	def definirResponsaveis(self, mapaTarefasMembros):
		idsTarefas = mapaTarefasMembros.keys()
		
		for idTarefa in idsTarefas:
			idMembro = mapaTarefasMembros.get(idTarefa)
			tarefa = self.__listaTarefas.get(idTarefa)
			tarefa.definirResponsavel(idMembro)
