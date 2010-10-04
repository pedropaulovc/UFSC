#-*- coding: utf-8 -*-
from estoria import Estoria


class FabricaEstorias(object):
	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType tarefas 
	__estoria = 0
	
	@staticmethod
	def criarEstoria(nome, descricao, tarefas):
		id = FabricaEstorias.__gerarIdEstoria()
		estoria = Estoria(nome, tarefas, id, descricao)
		return estoria

	@staticmethod
	def __gerarIdEstoria():
		id = "EST-" + str(FabricaEstorias.__estoria)
		FabricaEstorias.__estoria += 1 
		return id

