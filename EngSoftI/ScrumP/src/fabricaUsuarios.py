#-*- coding: utf-8 -*-
from usuario import Usuario
from recursos.Singleton import Singleton

class FabricaUsuarios(Singleton):
	
	def criarUsuario(self, nome, login, senha):
		usuario = Usuario(nome, login, senha)
		return usuario
	