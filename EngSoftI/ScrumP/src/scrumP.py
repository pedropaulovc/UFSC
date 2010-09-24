#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''
from excecoes import UsuarioExistente, UsuarioNaoExistente
from projeto import Projeto
from usuario import Usuario
import uuid

class ScrumP(object):    
    
    def __init__(self):
        self.__listaUsuarios = {}
        self.__listaProjetos= {}
    
    def criarUsuario(self,nome,login, senha):
        if not self.__listaUsuarios.has_key(login):
            usuario = Usuario(nome, login, senha) 
            self.__listaUsuarios[login] = usuario
        else:
            raise UsuarioExistente
    
    def criarProjeto(self, nome, time, prodOwn, scrumMaster):
        membros = time
        membros.append(prodOwn)
        membros.append(scrumMaster)
        for usuario in membros:
            if not self.__listaUsuarios.has_key(usuario):
                raise UsuarioNaoExistente
        id = uuid.uuid4()
        projeto = Projeto(nome, time, prodOwn, scrumMaster, id)
        self.__listaProjetos[id] = projeto
        return id
    
    def obterListaProjetosParticipados(self, login):
        participados = []
        for projeto in self.__listaProjetos.values():
            if projeto.participa(login):
                participados.append(projeto.obterId())
        return participados
        
    