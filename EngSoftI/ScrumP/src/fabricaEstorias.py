#-*- coding: utf-8 -*-
from estoria import Estoria

class Callable:
	def __init__(self, anycallable):
		self.__call__ = anycallable

class FabricaEstorias(object):
	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType tarefas 
	__estoria = 0
	
	def criarEstoria(nome, descricao, tarefas): #@NoSelf
		id = FabricaEstorias.__gerarIdEstoria()
		estoria = Estoria(nome, tarefas, id, descricao)
		return estoria
	criarEstoria = Callable(criarEstoria)

	def __gerarIdEstoria(): #@NoSelf
		id = "EST-" + str(FabricaEstorias.__estoria)
		FabricaEstorias.__estoria += 1 
		return id
	__gerarIdEstoria = Callable(__gerarIdEstoria)

