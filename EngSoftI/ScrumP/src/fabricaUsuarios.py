#-*- coding: utf-8 -*-
from usuario import Usuario

class Callable:
	def __init__(self, anycallable):
		self.__call__ = anycallable

class FabricaUsuarios(object):
	def criarUsuario(nome, login, senha):#@NoSelf
		usuario = Usuario(nome, login, senha)
		return usuario
	criarUsuario = Callable(criarUsuario)