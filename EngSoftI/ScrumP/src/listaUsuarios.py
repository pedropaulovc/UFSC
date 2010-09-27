'''
Created on 27/09/2010

@author: pepe
'''
from excecoes import UsuarioJaExiste
from usuario import Usuario

class ListaUsuarios(object):
    '''
    classdocs
    '''


    def __init__(self):
        self.__listaUsuarios = {}
    
    def cadastrarUsuario(self,nome, login, senha): 
        if not self.__listaUsuarios.has_key(login):
            usuario = Usuario(nome, login, senha) 
            self.__listaUsuarios[login] = usuario
        else:
            raise UsuarioJaExiste