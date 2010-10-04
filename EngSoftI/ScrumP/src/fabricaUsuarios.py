#-*- coding: utf-8 -*-
from usuario import Usuario

class FabricaUsuarios(object):
	
	@staticmethod
	def criarUsuario(nome, login, senha):
		usuario = Usuario(nome, login, senha)
		return usuario
