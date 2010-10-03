# By Juarez 03-out 15:41
# modificado elif "ce" e elif "ct":
#            while id != "":
#                id = raw_input()
# >>> add:       if id != "":
#                    tarefas += [id]

# TODO: - obterInfoSprintBackLog()

#-*- coding: utf-8 -*-
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from scrumPy import ScrumPy
from excecoes import UsuarioNaoExiste, LoginJaExiste, UsuarioNaoLogado,\
    SemProjetoAberto, ProjetoNaoExiste, TarefaNaoExiste, TarefaJaExiste,\
    EstoriaNaoExiste, DuracaoInvalida
from excecoes import SenhaInvalida
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
        
        if opcao == "oua":
            try:
                print scrumPy.obterUsuarioAtual()
            except (UsuarioNaoLogado):
                print "Sem usuário logado."
        elif opcao == "opa":
            try:
                print scrumPy.obterProjetoAtual()
            except (SemProjetoAberto):
                print "Sem projeto aberto."
        elif opcao == "cu":
            nome = raw_input("Forneça nome usuário: ")
            login = raw_input("Forneça login: ")
            senha = raw_input("Forneça senha: ")
            try:
                scrumPy.cadastrarUsuario(nome, login, senha)
            except (LoginJaExiste):
                print "Login já existe."
        elif opcao == "lu":
            login = raw_input("Forneça login: ")
            senha = raw_input("Forneça senha: ")
            try:
                scrumPy.logarUsuario(login, senha)
            except (UsuarioNaoExiste):
                print "Usuário não existe."
            except (SenhaInvalida):
                print "Senha incorreta."
        elif opcao == "ou":
            try:
                print scrumPy.obterUsuarios()
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
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
            try:
                scrumPy.criarProjeto(nome, time, prodOwner, scrumMaster)
            except (UsuarioNaoExiste):
                print "Algum usuário enviado não existe"
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "opp":
            try:
                print scrumPy.obterProjetosParticipados()
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "ap":
            idProj = raw_input("Forneça o Id do projeto: ")
            try:
                print scrumPy.abrirProjeto(idProj)
            except (ProjetoNaoExiste):
                print "Projeto não existe"
        elif opcao == "oe":
            try:
                print "(tarefas, estorias):", scrumPy.obterEstorias()
            except (ProjetoNaoExiste):
                print "Nenhum projeto aberto."
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
            try:
                scrumPy.criarSprintBackLog(duracao, estoriasEscolhidas, mapaTarefasMembros)
            except (TarefaNaoExiste):
                print "Alguma tarefa fornecida não existe"
            except (UsuarioNaoExiste):
                print "Algum usuário fornecido não existe"
            except (EstoriaNaoExiste):
                print "Alguma estória fornecida não existe"
            except (DuracaoInvalida):
                print "Duração fornecida <= 0"
        elif opcao == "ot":
            print scrumPy.obterTarefas()
        elif opcao == "ce":
            nome = raw_input("Forneça o nome: ")
            descricao = raw_input("Forneça a descrição: ")
            print "Forneça um idTarefa por linha. Uma linha em branco encerra a lista"
            tarefas = []
            id = None
            while id != "":
                id = raw_input()
                if id != "":
                    tarefas += [id]
            scrumPy.criarEstoria(nome, descricao, tarefas)
        elif opcao == "ct":
            nome = raw_input("Forneça o nome: ")
            descricao = raw_input("Forneça a descricao: ")
            dificuldade = raw_input("Forneça a dificuldade: ")

            print "Forneça um idTarefa pré-requisito por linha. Uma linha em branco encerra a lista"
            tarefas = []
            id = None
            while id != "":
                id = raw_input()
                if id != "":
                    tarefas += [id]
            try:
                scrumPy.criarTarefa(nome, descricao, dificuldade, tarefas)
            except (TarefaJaExiste):
                print "Nome de tarefa já existe"
        elif opcao == "mtc":
            scrumPy.obterTarefas()
            idTarefa = raw_input("Forneça o IdTarefa: ")
            try:
                scrumPy.marcarTarefaConcluida(idTarefa)
            except (TarefaNaoExiste):
                print "Tarefa não existe."
        else:
            print "Opção inválida"
        

def exibirMenu():
    print "Escolha uma opção:"
    print "oua - Obter Usuário Atual"
    print "opa - Obter Projeto Atual"
    print "cu  - Criar Usuário"
    print "lu  - Logar Usuário"
    print "ou  - Obter Usuários"
    print "cp  - Criar Projeto"
    print "opp - Obter Projetos Participados"
    print "ap  - Abrir Projeto"
    print "oe  - Obter Estorias"
    print "csb - Criar Sprint BackLog"
    print "ot  - Obter Tarefas"
    print "ce  - Criar Estoria"
    print "ct  - Criar Tarefa"
    print "mtc - Marcar Tarefa como Concluída"
    
def exibirIntroducao():
    print "INE5417 - ENGENHARIA DE SOFTWARE I"
    print "ITERAÇÃO 1 - SCRUMPY"
    print "ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI\n"

if __name__ == "__main__":
    main()