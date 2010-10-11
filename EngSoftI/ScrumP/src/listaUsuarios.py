#-*- coding: utf-8 -*-
from excecoes import UsuarioNaoExiste, SenhaInvalida, LoginJaExiste
from fabricaUsuarios import FabricaUsuarios
class ListaUsuarios(object):
	def __init__(self):
		self.__listaUsuarios = {}
	
	# @ParamType nome 
	# @ParamType login 
	# @ParamType senha 
	def cadastrarUsuario(self, nome, login, senha):
		if self.__listaUsuarios.has_key(login):
			raise LoginJaExiste
		fabricaUsuarios = FabricaUsuarios.getInstance()
		usuario = fabricaUsuarios.criarUsuario(nome, login, senha)
		self.__listaUsuarios[login] = usuario

	def obterUsuarios(self):
		return self.__listaUsuarios.keys()

	# @ParamType logins 
	def verificarUsuarios(self, logins):
		for login in logins:
			if not self.__listaUsuarios.has_key(login):
				raise UsuarioNaoExiste
		

	# @ParamType login 
	# @ParamType senha 
	def logarUsuario(self, login, senha):
		usuario = self.__listaUsuarios.get(login)
		if usuario == None:
			raise UsuarioNaoExiste
		verificado = usuario.verificarSenha(senha)
		if not verificado:
			raise SenhaInvalida
		return usuario
		