#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''

from fabricaEstorias import FabricaEstorias
from fabricaProjetos import FabricaProjetos
from listaProjetos import ListaProjetos
from listaUsuarios import ListaUsuarios

class ScrumP(object):    
    
    def __init__(self):
        self.__listaUsuarios = ListaUsuarios()
        self.__listaProjetos = ListaProjetos()
    
    def criarUsuario(self, nome, login, senha):
        self.__listaUsuarios.cadastrarUsuario(nome, login, senha)
    
    def criarProjeto(self, nome, time, prodOwn, scrumMaster):
        projeto = FabricaProjetos.criarProjeto(nome, time, prodOwn, scrumMaster)
        self.__listaProjetos.adicionarProjeto(projeto)
    
    def criarEstoria(self,idProjeto,tarefas):
        estoria = FabricaEstorias.criarEstoria(tarefas)
        self.__listaProjetos.adicionarEstoria(estoria, idProjeto)
    
    def obterEstoria(self,idProjeto,idEstoria):
        return self.__listaProjetos.obterEstoria(idProjeto, idEstoria)
    
    def criarTarefa(self,idProjeto, dificuldade, tempoEst, nome, requisitos=[]):
        return self.__listaProjetos.criarTarefa(idProjeto,dificuldade, tempoEst, nome, requisitos)
    
    def obterListaProjetosParticipados(self, login):
        participados = []
        for projeto in self.__listaProjetos.values():
            if projeto.participa(login):
                participados.append(projeto.obterId())
        return participados
        
    #TODO: criar projeto atual, refatorar 
    #Ideia para refatoração: Criar fábricas de projetos, usuários, etc.