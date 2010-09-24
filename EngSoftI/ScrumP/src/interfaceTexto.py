#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''
from scrumP import ScrumP
import uuid

if __name__ == '__main__':
    instScrump = ScrumP()
    instScrump.criarUsuario("Um", "um", "123")
    instScrump.criarUsuario("Dois", "dois", "123")
    instScrump.criarUsuario("ProdOwn", "prod", "123")
    instScrump.criarUsuario("scrumMaster", "scrum", "123")
    instScrump.criarUsuario("scrumMaster", "scrum2", "123")
    instScrump.criarUsuario("Tres", "tres", "123")
    instScrump.criarUsuario("scrumMaster", "prod2", "123")
    id = instScrump.criarProjeto("teste", ["um","dois"], "prod", "scrum")
    
    
    id2 = instScrump.criarProjeto("teste2", ["dois", "tres"], "prod2", "scrum2")
    
    print instScrump.obterListaProjetosParticipados("um")
    print instScrump.obterListaProjetosParticipados("dois")
    print instScrump.obterListaProjetosParticipados("tres")
    print instScrump.obterListaProjetosParticipados("prod")
    print instScrump.obterListaProjetosParticipados("scrum2")
    
    
        