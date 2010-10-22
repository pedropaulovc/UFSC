#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
from usuario import Usuario
from recursos.singleton import Singleton

class FabricaUsuarios(Singleton):
	
	def criarUsuario(self, nome, login, senha):
		usuario = Usuario(nome, login, senha)
		return usuario
	