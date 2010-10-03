# By Juarez 03-out 15:41
# 		adicionado: 	obterEstoria(idEstoria)

#-*- coding: utf-8 -*-
from excecoes import EstoriaNaoExiste
from fabricaEstorias import FabricaEstorias
class ProductBackLog(object):
	def __init__(self):
		self.__listaEstorias = {}

	
	def obterEstorias(self):
		return self.__listaEstorias.keys()

	# @ParamType estoriasEscolhidas 
	def verificarEstorias(self, estoriasEscolhidas):
		for estoria in estoriasEscolhidas:
			if not self.__listaEstorias.has_key(estoria):
				raise EstoriaNaoExiste
			
	# @ParamType estoria 
	def criarEstoria(self, nome, descricao, tarefas):
		estoria = FabricaEstorias.criarEstoria(nome, descricao, tarefas)
		self.__listaEstorias[estoria.obterId()] = estoria
		
	# @ParamType idEstoria
	def obterEstoria(self, idEstoria):
		estoria = self.__listaEstoria.get(idEstoria)
		if estoria == None:
			raise EstoriaNaoExiste
		return estoria


