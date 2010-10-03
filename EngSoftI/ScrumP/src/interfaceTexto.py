#-*- coding: utf-8 -*-
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from scrumPy import ScrumPy
def main():
    scrumPy = ScrumPy()
    
    while True:
        exibirMenu()
        opcao = raw_input()
        
        if opcao == "cu":
            nome = raw_input("Forneça nome usuário: ")
            login = raw_input("Forneça login: ")
            senha = raw_input("Forneça senha: ")
            scrumPy.cadastrarUsuario(nome, login, senha)
        elif opcao == "lu":
            login = raw_input("Forneça login: ")
            senha = raw_input("Forneça senha: ")
            scrumPy.logarUsuario(login, senha)
        elif opcao == "ou":
            print scrumPy.obterUsuarios()
        elif opcao == "cp":
            nome = raw_input("Forneça o nome do projeto: ")
            print "Forneça um login do time por linha. Uma linha em branco encerra a lista"
            time = []
            login = None
            while login != "":
                login = raw_input()
                time += login
            prodOwner = raw_input("Forneça o Product Owner: ")
            scrumMaster = raw_input("Forneça o Scrum Master: ")
            scrumPy.criarProjeto(nome, time, prodOwner, scrumMaster)
        elif opcao == "opp":
            print scrumPy.obterProjetosParticipados()
        elif opcao == "ap":
            idProj = raw_input("Forneça o Id do projeto: ")
            print scrumPy.abrirProjeto(idProj)
        elif opcao == "oe":
            print scrumPy.obterEstorias()
        elif opcao == "csb":
#            duracao = int(raw_input("Forneça a duração: "))
#            print "Forneça uma id de estória por linha. Uma linha em branco encerra a lista"
#            estoriasEscolhidas = []
#            estoria = None
#            while estoria != "":
#                estoria = raw_input()
#                estoriasEscolhidas += estoria
#            print "Forneça uma id de estória por linha. Uma linha em branco encerra a lista"
#            scrumPy.criarSprintBackLog(duracao, estoriasEscolhidas, mapaTarefasMembros)
            pass
        elif opcao == "ot":
            pass
        elif opcao == "ce":
            pass
        elif opcao == "ct":
            pass
        elif opcao == "mtc":
            scrumPy.obterTarefas()
            idTarefa = raw_input("Forneça o IdTarefa: ")
            scrumPy.marcarTarefaConcluida(idTarefa)
        else:
            print "Opção inválida"
        

def exibirMenu():
    print "cu - Criar Usuário"
    print "lu - Logar Usuário"
    print "ou - Obter Usuários"
    print "cp - Criar Projeto"
    print "opp - Obter Projetos Participados"
    print "ap - Abrir Projeto"
    print "oe - Obter Estorias"
    print "csb - Criar Sprint BackLog"
    print "ot - Obter Tarefas"
    print "ce - Criar Estoria"
    print "ct - Criar Tarefa"
    print "mtc - Marcar Tarefa como Concluída"
    

if __name__ == "__main__":
    main()