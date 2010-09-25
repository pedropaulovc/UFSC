#-*- coding: utf-8 -*-
'''
Created on 24/09/2010

@author: pepe
'''
from scrumP import ScrumP

if __name__ == '__main__':
    instScrump = ScrumP()
    instScrump.criarUsuario("Um", "um", "123")
    instScrump.criarUsuario("Dois", "dois", "123")
    instScrump.criarUsuario("ProdOwn", "prod", "123")
    instScrump.criarUsuario("scrumMaster", "scrum", "123")
    instScrump.criarUsuario("scrumMaster", "scrum2", "123")
    instScrump.criarUsuario("Tres", "tres", "123")
    instScrump.criarUsuario("scrumMaster", "prod2", "123")
    
    proj1 = instScrump.criarProjeto("teste", ["um","dois"], "prod", "scrum")
    
    
    proj2 =  instScrump.criarProjeto("teste2", ["dois", "tres"], "prod2", "scrum2")
    
    print proj1,proj2
    
    tarefa1 = instScrump.criarTarefa(proj1,"facil", 10, "bla", [])
    tarefa2 = instScrump.criarTarefa(proj1,"facil", 10, "ble", [])
    
    print tarefa1
    
    estoria1 = instScrump.criarEstoria(proj1, [tarefa1,tarefa2])
    
    print estoria1 , instScrump.obterEstoria(proj1, estoria1).obterTarefas()
    
#    print instScrump.obterListaProjetosParticipados("um")
#    print instScrump.obterListaProjetosParticipados("dois")
#    print instScrump.obterListaProjetosParticipados("tres")
#    print instScrump.obterListaProjetosParticipados("prod")
#    print instScrump.obterListaProjetosParticipados("scrum2")
    
    
        