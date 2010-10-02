#-*- coding: utf-8 -*-
from projeto import Projeto
class Callable:
	def __init__(self, anycallable):
		self.__call__ = anycallable

class FabricaProjetos(object):
	# @ParamType nome 
	# @ParamType time 
	# @ParamType productOwner 
	# @ParamType scrumMaster 
	__projeto = 0
	
	def criarProjeto(nome, time, productOwner, scrumMaster): #@NoSelf
		id = FabricaProjetos.__gerarIdProjeto()
		return Projeto(nome, time, productOwner, scrumMaster, id)

	def __gerarIdProjeto(): #@NoSelf
		id = "PROJ-" + str(FabricaProjetos.__projeto)
		FabricaProjetos.__projeto += 1 
		return id
	__gerarIdProjeto = Callable(__gerarIdProjeto)

