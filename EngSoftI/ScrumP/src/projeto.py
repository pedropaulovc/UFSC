#-*- coding: utf-8 -*-
from listaTarefas import ListaTarefas
from sprintBackLog import SprintBackLog
from productBackLog import ProductBackLog
class Projeto(object):
	def __init__(self, nome, time, prodOwn, scrumMaster, id):
		self.__nome = nome
		self.__time = time
		self.__productOwner = prodOwn
		self.__scrumMaster = scrumMaster
		self.__productBackLog = ProductBackLog()
		self.__sprintBackLog = None
		self.__id = id
		self.__listaTarefas = ListaTarefas()

	
	# @ParamType login 
	def usuarioParticipa(self, login):
		return self.__time.contains(login) or self.__scrumMaster == login or self.__productOwner == login

	def obterId(self):
		return id

	def obterInfo(self):
		return (self.__nome, self.__id)

	def obterEstorias(self):
		return self.__productBackLog.obterEstorias()

	# @ParamType estorias 
	def obterTarefasDeEstorias(self, estorias):
		listaTarefas = []
		for estoria in estorias:
			tarefas = estoria.obterTarefas()
			listaTarefas += tarefas
		return listaTarefas

	# @ParamType estoriasEscolhidas 
	def verificarEstorias(self, estoriasEscolhidas):
		self.__productBackLog.verificarEstorias(estoriasEscolhidas)

	# @ParamType tarefas 
	def verificarTarefas(self, tarefas):
		self.__listaTarefas.verificarTarefas(tarefas)

	# @ParamType mapaTarefasMembros 
	def definirResponsaveis(self, mapaTarefasMembros):
		self.__listaTarefas.definirResponsaveis(mapaTarefasMembros)

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType tarefas 
	def criarEstoria(self, nome, descricao, tarefas):
		self.__productBackLog.criarEstoria(nome, descricao, tarefas)

	# @ParamType idTarefa 
	def marcarTarefaConcluida(self, idTarefa):
		self.__listaTarefas.marcarConcluida(idTarefa)

	def obterTarefas(self):
		return self.__listaTarefas.obterTarefas()

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisitos 
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisitos):
		self.__listaTarefas.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisitos)
	
	def criarSprintBackLog(self, estoriasEscolhidas, duracao):
		self.__sprintBackLog = SprintBackLog(estoriasEscolhidas, duracao)

