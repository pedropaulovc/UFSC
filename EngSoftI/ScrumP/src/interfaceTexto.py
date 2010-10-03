#-*- coding: utf-8 -*-
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from scrumPy import ScrumPy
def main():
    exibirIntroducao()
    scrumPy = ScrumPy()
    
    ##################
    ##Bloco de aceleração de input. Remover antes do release##
    scrumPy.cadastrarUsuario("Pedro Paulo", "pp", "pp")
    scrumPy.logarUsuario("pp", "pp")
    scrumPy.criarProjeto("Projeto", ["pp"], "pp", "pp")
    ##################
    
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
                if login != "":
                    time += [login]
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
            duracao = int(raw_input("Forneça a duração: "))
            print "Forneça uma id de estória por linha. Uma linha em branco encerra a lista"
            estoriasEscolhidas = []
            estoria = None
            while estoria != "":
                estoria = raw_input()
                if estoria != "":
                    estoriasEscolhidas += [estoria]
            print "Forneça uma id de tarefa e um login separados por vírgula por linha. Uma linha em branco encerra a lista"
            mapaTarefasMembros = {}
            linhaStr = None
            while linhaStr != "":
                linhaStr = raw_input()
                if linhaStr != "":
                    linha = linhaStr.split(",")
                    mapaTarefasMembros[linha[0]] = linha[1]
            scrumPy.criarSprintBackLog(duracao, estoriasEscolhidas, mapaTarefasMembros)
        elif opcao == "ot":
            tarefas = []
            tarefas = scrumPy.obterTarefas()
            for idTarefa in tarefas:
                print idTarefa
        elif opcao == "ce":
            nome = raw_input("Forneça o nome: ")
            descricao = raw_input("Forneça a descrição: ")
            print "Forneça um idTarefa por linha. Uma linha em branco encerra a lista"
            tarefas = []
            id = None
            while login != "":
                id = raw_input()
                tarefas += [id]
            scrumPy.criarEstoria(nome, descricao, tarefas)
        elif opcao == "ct":
            nome = raw_input("Forneça o nome: ")
            descricao = raw_input("Forneça a descricao: ")
            dificuldade = raw_input("Forneça a dificuldade: ")

            print "Forneça um idTarefa por linha. Uma linha em branco encerra a lista"
            tarefas = []
            id = None
            while login != "":
                id = raw_input()
                tarefas += [id]
            scrumPy.criarTarefa(nome, descricao, dificuldade, tarefas)
        elif opcao == "mtc":
            scrumPy.obterTarefas()
            idTarefa = raw_input("Forneça o IdTarefa: ")
            scrumPy.marcarTarefaConcluida(idTarefa)
        else:
            print "Opção inválida"
        

def exibirMenu():
    print "Escolha uma opção:"
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
    
def exibirIntroducao():
    print "INE5417 - ENGENHARIA DE SOFTWARE I"
    print "ITERAÇÃO 1 - SCRUMPY"
    print "ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI\n"

if __name__ == "__main__":
    main()