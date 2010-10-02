#-*- coding: utf-8 -*-
from fabricaProjetos import FabricaProjetos
from listaProjetos import ListaProjetos
from listaUsuarios import ListaUsuarios
from excecoes import ProjetoNaoExiste, DuracaoInvalida

class ScrumPy(object):
	def __init__(self):
		self.__listaUsuarios = ListaUsuarios()
		self.__listaProjetos = ListaProjetos()
		self.__projetoAtual = None
		self.__usuarioAtual = None

	# @ParamType login 
	# @ParamType senha 
	def logarUsuario(self, login, senha):
		usuario = self.__listaUsuarios.logarUsuario(login, senha)
		self.__definirUsuarioAtual(usuario)

	# @ParamType usuario 
	def __definirUsuarioAtual(self, usuario):
		self.__usuarioAtual = usuario

	# @ParamType nome 
	# @ParamType login 
	# @ParamType senha 
	def cadastrarUsuario(self, nome, login, senha):
		self.__listaUsuarios.cadastrarUsuario(nome, login, senha)

	def obterUsuarios(self):
		return self.__listaUsuarios.obterUsuarios()

	# @ParamType nome 
	# @ParamType time 
	# @ParamType prodOwner 
	# @ParamType scrumMaster 
	def criarProjeto(self, nome, time, prodOwner, scrumMaster):
		logins = time + [prodOwner, scrumMaster]
		self.__listaUsuarios.verificarUsuarios(logins)
		projeto = FabricaProjetos.criarProjeto(self, nome, time, prodOwner, scrumMaster)
		self.__listaProjetos.adicionarProjeto(projeto)

	def obterProjetosParticipados(self):
		return self.__listaProjetos.obterProjParticipados(self.__usuarioAtual.obterLogin())

	# @ParamType idProj 
	def obterInfoProjeto(self, idProj):
		projeto = self.__listaProjetos.obterProjeto(idProj)
		info = self.__listaProjetos.obterInfoProjeto(idProj)
		self.__definirProjetoAtual(projeto)
		return info

	def obterEstorias(self):
		if self.__projetoAtual == None:
			raise ProjetoNaoExiste
		estorias = self.__projetoAtual.obterEstorias()
		tarefas = self.__projetoAtual.obterTarefasDeEstorias(estorias)
		return (tarefas, estorias)

	# @ParamType projeto 
	def __definirProjetoAtual(self, projeto):
		self.__projetoAtual = projeto

	# @ParamType duracao 
	# @ParamType estoriasEscolhidas 
	# @ParamType mapaTarefasMembros 
	def criarSprintBackLog(self, duracao, estoriasEscolhidas, mapaTarefasMembros):
		if duracao <= 0:
			raise DuracaoInvalida
		self.__projetoAtual.verificarEstorias(estoriasEscolhidas)
		self.__projetoAtual.verificarTarefas(mapaTarefasMembros.keys())
		self.__listaUsuarios.verificarUsuarios(mapaTarefasMembros.values())
		self.__projetoAtual.definirResponsaveis(mapaTarefasMembros)
		self.__projetoAtual.criarSprintBackLog(estoriasEscolhidas, duracao)


	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType tarefas 
	def criarEstoria(self, nome, descricao, tarefas):
		self.__projetoAtual.criarEstoria(nome, descricao, tarefas)

	# @ParamType idTarefa 
	def marcarTarefaConcluida(self, idTarefa):
		self.__projetoAtual.marcarTarefaConcluida(idTarefa)

	def obterTarefas(self):
		return self.__projetoAtual.obterTarefas()

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisitos 
	def criartarefa(self, nome, descricao, dificuldade, tarefasPreRequisitos):
		self.__projetoAtual.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisitos)



