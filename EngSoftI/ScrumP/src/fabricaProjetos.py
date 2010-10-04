#-*- coding: utf-8 -*-
from projeto import Projeto

class FabricaProjetos(object):
	# @ParamType nome 
	# @ParamType time 
	# @ParamType productOwner 
	# @ParamType scrumMaster 
	__projeto = 0
	
	@staticmethod
	def criarProjeto(nome, time, productOwner, scrumMaster):
		id = FabricaProjetos.__gerarIdProjeto()
		return Projeto(nome, time, productOwner, scrumMaster, id)
	
	@staticmethod
	def __gerarIdProjeto():
		id = "PROJ-" + str(FabricaProjetos.__projeto)
		FabricaProjetos.__projeto += 1 
		return id