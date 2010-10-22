#-*- coding: utf-8 -*-
# By Juarez 03-out 15:41
# 		modificado: 	obterTarefasDeEstorias(estorias)
#			old:	tarefas = estoria.obterTarefas()
#			new:	story = self.__productBackLog.obterEstoria(estoria)
#					tarefas = story.obterTarefas()

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
		return login in self.__time or self.__scrumMaster == login or self.__productOwner == login

	def obterId(self):
		return self.__id

	def obterInfo(self):
		return (self.__nome, self.__id)
	
	def obterProdOwner(self):
		return self.__productOwner
	
	def obterScrumMaster(self):
		return self.__scrumMaster

	def obterEstorias(self):
		return self.__productBackLog.obterEstorias()

	# @ParamType estorias 
	def obterTarefasDeEstoria(self, estoria):
		return self.__productBackLog.obterEstoria(estoria).obterTarefas()

	def pertenceAoTime(self, login):
		return login in self.__time
	
	# @ParamType estoriasEscolhidas 
	def verificarEstorias(self, estoriasEscolhidas):
		self.__productBackLog.verificarEstorias(estoriasEscolhidas)

	# @ParamType tarefas 
	def verificarTarefasExistem(self, tarefas):
		self.__listaTarefas.verificarTarefasExistem(tarefas)

	def verificarTarefasPendentes(self, tarefas):
		self.__listaTarefas.verificarTarefasPendentes(tarefas)
		
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
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisitos, estimativa):
		self.__listaTarefas.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisitos, estimativa)
	
	def criarSprintBackLog(self, estoriasEscolhidas, duracao):
		self.__sprintBackLog = SprintBackLog(estoriasEscolhidas, duracao)

