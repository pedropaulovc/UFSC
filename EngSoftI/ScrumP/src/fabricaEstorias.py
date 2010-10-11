#-*- coding: utf-8 -*-
from estoria import Estoria
from recursos.singleton import Singleton


class FabricaEstorias(Singleton):

	__estoria = 0

	def criarEstoria(self, nome, descricao, tarefas):
		id = self.__gerarIdEstoria()
		estoria = Estoria(nome, tarefas, id, descricao)
		return estoria

	def __gerarIdEstoria(self):
		id = "EST-" + str(FabricaEstorias.__estoria)
		FabricaEstorias.__estoria += 1 
		return id
