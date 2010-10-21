#-*- coding: utf-8 -*-
from excecoes import UsuarioNaoLogado, DuracaoInvalida, \
	SemProjetoAberto, UsuarioSemPermissao, NaoParticipaDoProjeto
from fabricaProjetos import FabricaProjetos
from listaProjetos import ListaProjetos
from listaUsuarios import ListaUsuarios

# 3 Situações do Scrum:
#	- Usuário não logado:
#		-	logarUsuario
#		?	obterUsuarios
#	- Usuário logado:
#		-	cadastrarUsuario
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
	'''
    O ScrumPy gerencia toda a parte lógica e a comunicação
    com a Interface com o Usuário (ScrumPy é uma Fachada).
    '''

	def __init__(self):
		self.__listaUsuarios = ListaUsuarios()
		self.__listaProjetos = ListaProjetos()
		self.__projetoAtual = None
		self.__usuarioAtual = None

	# @ParamType login 
	# @ParamType senha 
	def logarUsuario(self, login, senha):
		'''
		Consulta a lista de usuários em busca do usuário que possui o
		login informado, a partir do login e da senha, e o define como
		o usuário atual do programa.
		'''		
		usuario = self.__listaUsuarios.logarUsuario(login, senha)
		self.__definirUsuarioAtual(usuario)

	# @ParamType usuario 
	def __definirUsuarioAtual(self, usuario):
		'''
		Define o usuário dado como o usuário atual do programa, 
		registrando-o no ScrumPy.
		'''		
		self.__usuarioAtual = usuario

	# @ParamType nome 
	# @ParamType login 
	# @ParamType senha 
	def cadastrarUsuario(self, nome, login, senha):
		'''
		Delega o cadastro de um novo usuário à lista de usuários, 
		informando o nome, login e senha do novo usuário.
		'''
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		
		if not self.__listaUsuarios.ehAdmin(self.__usuarioAtual.obterLogin()):
			raise UsuarioSemPermissao
		self.__listaUsuarios.cadastrarUsuario(nome, login, senha)

	def obterUsuarios(self):
		'''
		Informa o login de todos os usuários cadastrados no sistema.
		'''
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		return self.__listaUsuarios.obterUsuarios()

	# @ParamType nome 
	# @ParamType time 
	# @ParamType prodOwner 
	# @ParamType scrumMaster 
	def criarProjeto(self, nome, time, prodOwner, scrumMaster):
		'''
		Primeiro, verifica se todos os logins informados são validos.
		Após isso, delega a criação de um novo projeto à fabrica de projetos,
		informando todos os logins necessários: nome, time, prodOwner e
		scrumMaster. Por fim, registra este projeto na lista de projetos.
		'''
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		
		if not self.__listaUsuarios.ehAdmin(self.__usuarioAtual.obterLogin()):
			raise UsuarioSemPermissao
		
		logins = time + [prodOwner, scrumMaster]
		self.__listaUsuarios.verificarUsuarios(logins)
		fabricaProjetos = FabricaProjetos.getInstance()
		projeto = fabricaProjetos.criarProjeto(nome, time, prodOwner, scrumMaster)
		self.__listaProjetos.adicionarProjeto(projeto)

	def obterProjetosParticipados(self):
		'''
		Informa todos os projetos com participação do usuário atual.
		'''
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		return self.__listaProjetos.obterProjParticipados(self.__usuarioAtual.obterLogin())

	# @ParamType idProj 
	def abrirProjeto(self, idProj):
		
		'''
		Informa o nome e o id do projeto cuja id foi informada e
		registra o projeto como atual no sistema.
		'''
		projetosParticipados = self.obterProjetosParticipados()		
		
		projeto = self.__listaProjetos.obterProjeto(idProj)
		
		if projeto not in projetosParticipados:
			raise NaoParticipaDoProjeto
		
		info = projeto.obterInfo()
		self.__definirProjetoAtual(projeto)
		return info

	def obterEstorias(self):
		'''
		Informa todas as estorias e tarefas do projeto atual.
		'''
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		
		estorias = self.__projetoAtual.obterEstorias()
		tarefas = self.__projetoAtual.obterTarefasDeEstorias(estorias)
		return (tarefas, estorias)

	# @ParamType projeto 
	def __definirProjetoAtual(self, projeto):
		'''
		Define o projeto dado como o atual, armazenando o seu id.
		'''
		self.__projetoAtual = projeto

	# @ParamType duracao 
	# @ParamType estoriasEscolhidas 
	# @ParamType mapaTarefasMembros 
	def criarSprintBackLog(self, duracao, estoriasEscolhidas, mapaTarefasMembros):
		'''
		Verifica se a duração da sprint é valida, se os usuários existem.
		Delega  a verificação da existencia das estorias, das tarefas, a
		definição dos responsáveis das respectivas tarefas e delega a 
		criação da sprintBackLog ao projeto atual.
		'''
		if self.__projetoAtual == None:
			raise SemProjetoAberto

		if self.__projetoAtual.obterProdOwner() != self.__usuarioAtual.obterLogin():
			raise UsuarioSemPermissao
				
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
		
		'''
		Delega a criação de uma estoria ao projeto atual, informando
		o nome, descrição e tarefas dados.
		'''
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		
		if self.__projetoAtual.obterProdOwner() != self.__usuarioAtual.obterLogin():
			raise UsuarioSemPermissao
		
		self.__projetoAtual.criarEstoria(nome, descricao, tarefas)

	# @ParamType idTarefa 
	def marcarTarefaConcluida(self, idTarefa):
		'''
		Delega a definição de uma tarefa concluída ao projeto atual que
		removendo-a da lista de tarefas.
		'''
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		
		if not self.__projetoAtual.pertenceAoTime(self.__usuarioAtual.obterLogin()):
			raise UsuarioSemPermissao
		
		self.__projetoAtual.marcarTarefaConcluida(idTarefa)

	def obterTarefas(self):
		'''
		Informa as tarefas do projeto atual(contidas na lista de tarefas).
		'''
		return self.__projetoAtual.obterTarefas()

	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisitos 
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisitos):
		'''
		Delega criação de uma Tarefa ao projeto atual.
		'''
	# TODO: Já Modificado!!! -> Como estamos usando o projetoAtual, deve-se verificar se há Projeto Aberto.	
		if self.__usuarioAtual.obterLogin() != self.__projetoAtual.obterScrumMaster():
			raise UsuarioSemPermissao
		
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		
		self.__projetoAtual.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisitos)

	def obterUsuarioAtual(self):
		'''
		Retorna o usuário atualmente logando no ScrumPy.
		'''
		if self.__usuarioAtual == None:
			raise UsuarioNaoLogado
		return self.__usuarioAtual.obterLogin()
	
	def obterProjetoAtual(self):
		'''
		Retorna o projeto atulamente aberto no ScrumPy.
		'''
		if self.__projetoAtual == None:
			raise SemProjetoAberto
		return self.__projetoAtual.obterId()
