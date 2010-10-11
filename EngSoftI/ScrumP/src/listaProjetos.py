#-*- coding: utf-8 -*-
from excecoes import ProjetoNaoExiste
class ListaProjetos(object):
	def __init__(self):
		self.__listaProjetos = {}
		
	# @ParamType login 
	def obterProjParticipados(self, login):
		projetos = self.__listaProjetos.values()
		participados = []
		
		for projeto in projetos:
			if projeto.usuarioParticipa(login):
				participados += [projeto.obterId()]
		return participados
		
	# @ParamType idProjeto 
	def obterInfoProjeto(self, idProjeto):
		return self.obterProjeto(idProjeto).obterInfo()

	def obterProjeto(self, idProjeto):
		projeto = self.__listaProjetos.get(idProjeto)
		if projeto == None:
			raise ProjetoNaoExiste
		return projeto
	
	# @ParamType projeto 
	def adicionarProjeto(self, projeto):
		self.__listaProjetos[projeto.obterId()] = projeto
