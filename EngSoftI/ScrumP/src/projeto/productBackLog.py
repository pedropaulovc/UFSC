#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
from excecoes.excecoes import EstoriaNaoExiste
from estoria.fabricaEstorias import FabricaEstorias
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
		fabrica = FabricaEstorias.getInstance()
		estoria = fabrica.criarEstoria(nome, descricao, tarefas)
		self.__listaEstorias[estoria.obterId()] = estoria
		
	# @ParamType idEstoria
	def obterEstoria(self, idEstoria):
		estoria = self.__listaEstorias.get(idEstoria)
		if estoria == None:
			raise EstoriaNaoExiste
		return estoria


