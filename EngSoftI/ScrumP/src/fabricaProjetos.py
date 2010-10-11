#-*- coding: utf-8 -*-
from projeto import Projeto
from recursos.Singleton import Singleton

class FabricaProjetos(Singleton):

	__projeto = 0
	
	def criarProjeto(self, nome, time, productOwner, scrumMaster):
		id = self.__gerarIdProjeto()
		return Projeto(nome, time, productOwner, scrumMaster, id)
	
	def __gerarIdProjeto(self):
		id = "PROJ-" + str(FabricaProjetos.__projeto)
		FabricaProjetos.__projeto += 1 
		return id