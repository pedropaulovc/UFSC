#-*- coding: utf-8 -*-
from fabricaProjetos import FabricaProjetos
from listaProjetos import ListaProjetos
from listaUsuarios import ListaUsuarios
from excecoes import ProjetoNaoExiste, DuracaoInvalida, UsuarioNaoLogado,\
	SemProjetoAberto

# 3 Situações do Scrum:
#	- Usuário não logado:
#		-	cadastrarUsuario
#		-	logarUsuario
#		?	obterUsuarios
#	- Usuário logado:
#		- criarProjeto
#		- obterProjetosPraticipados
#		- obterInfoProjeto (abrirProjeto)
#	- Projeto aberto:
#			- obterEstorias
#			- obterTarefas
#
#		- Usuário é ScrumMaster:
#			- criarSprintBackLog
#			- criarEstoria
#			- criartarefa
#		- Usuário é TeamMember
#			- marcarTarefaConcluída

#Alterações:
# obterInfoProjeto -> abrirProjeto

class ScrumPy(object):
	# O ScrumPy gerencia toda a parte lógica e a comunicação
	# com a Interface com o Usuário (ScrumPy é uma Fachada).
	
	def __init__(self):
		self.__listaUsuarios = ListaUsuarios()
		self.__listaProjetos = ListaProjetos()
		self.__projetoAtual = None
		self.__usuarioAtual = None

	# @ParamType login 
	# @ParamType senha 
	def logarUsuario(self, login, senha):
		# Consulta a lista de usuários em busca do usuário que possui o
		# login informado, a partir do login e da senha, e o define como
		# o usuário atual do programa.		
		usuario = self.__listaUsuarios.logarUsuario(login, senha)
		self.__definirUsuarioAtual(usuario)

	# @ParamType usuario 
	def __definirUsuarioAtual(self, usuario):
		# Define o usuário dado como o usuário atual do programa, 
		# registrando-o no ScrumPy.		
		self.__usuarioAtual = usuario

	# @ParamType nome 
	# @ParamType login 
	# @ParamType senha 
	def cadastrarUsuario(self, nome, login, senha):
		# Delega o cadastro de um novo usuário à lista de usuários, 
		# informando o nome, login e senha do novo usuário.
		self.__listaUsuarios.cadastrarUsuario(nome, login, senha)

	def obterUsuarios(self):
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		# Informa o login de todos os usuários cadastrados no sistema.
		return self.__listaUsuarios.obterUsuarios()

	# @ParamType nome 
	# @ParamType time 
	# @ParamType prodOwner 
	# @ParamType scrumMaster 
	def criarProjeto(self, nome, time, prodOwner, scrumMaster):
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		#TODO: Verificar se usuário é scrumMaster (?)
		# Primeiro, verifica se todos os logins informados são validos.
		# Após isso, delega a criação de um novo projeto à fabrica de projetos,
		# informando todos os logins necessários: nome, time, prodOwner e
		# scrumMaster. Por fim, registra este projeto na lista de projetos.
		logins = time + [prodOwner, scrumMaster]
		self.__listaUsuarios.verificarUsuarios(logins)
		projeto = FabricaProjetos.criarProjeto(nome, time, prodOwner, scrumMaster)
		self.__listaProjetos.adicionarProjeto(projeto)

	def obterProjetosParticipados(self):
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		# Informa todos os projetos com participação do usuário atual.
		return self.__listaProjetos.obterProjParticipados(self.__usuarioAtual.obterLogin())

	# @ParamType idProj 
	def abrirProjeto(self, idProj):
		# TODO - Porque o metodo retorna o id tbm? Já que o id é um parametro, não há necessidade...
		# Informa o nome e o id do projeto cuja id foi informada e
		# registra o projeto como atual no sistema.
		projeto = self.__listaProjetos.obterProjeto(idProj)
		info = self.__listaProjetos.obterInfoProjeto(idProj)
		self.__definirProjetoAtual(projeto)
		return info

	def obterEstorias(self):
		# Informa todas as estorias e tarefas do projeto atual.
		if self.__projetoAtual == None:
			raise ProjetoNaoExiste
		estorias = self.__projetoAtual.obterEstorias()
		tarefas = self.__projetoAtual.obterTarefasDeEstorias(estorias)
		return (tarefas, estorias)

	# @ParamType projeto 
	def __definirProjetoAtual(self, projeto):
		# Define o projeto dado como o atual, armazenando o seu id.
		self.__projetoAtual = projeto

	# @ParamType duracao 
	# @ParamType estoriasEscolhidas 
	# @ParamType mapaTarefasMembros 
	def criarSprintBackLog(self, duracao, estoriasEscolhidas, mapaTarefasMembros):
		# TODO - Verificar se o usuário atual tem permissão(ou ocultar a opção na interface).
		# TODO - Verificar se há um projeto aberto(ou ocultar a opção na interface).
		# Verifica se a duração da sprint é valida, se os usuários existem.
		# Delega  a verificação da existencia das estorias, das tarefas, a
		# definição dos responsáveis das respectivas tarefas e delega a 
		# criação da sprintBackLog ao projeto atual.
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
		# TODO - Verificar Tarefas(ou defini-las em conjunto na IU).
		# Delega a criação de uma estoria ao projeto atual, informando
		# o nome, descrição e tarefas dados.
		self.__projetoAtual.criarEstoria(nome, descricao, tarefas)

	# @ParamType idTarefa 
	def marcarTarefaConcluida(self, idTarefa):
		# TODO - Remove apenas da ListaTarefas do projeto, não da estoria.
		# Delega a definição de uma tarefa concluída ao projeto atual que
		# removendo-a da lista de tarefas.
		self.__projetoAtual.marcarTarefaConcluida(idTarefa)

	def obterTarefas(self):
		# Informa as tarefas do projeto atual(contidas na lista de tarefas).
		return self.__projetoAtual.obterTarefas()

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisitos 
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisitos):
		# TODO - letra maiuscula
		# Delega criação de uma Tarefa ao projeto atual.
		self.__projetoAtual.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisitos)

	def obterUsuarioAtual(self):
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		return self.__usuarioAtual.obterLogin()
	
	def obterProjetoAtual(self):
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		return self.__projetoAtual.obterId()
