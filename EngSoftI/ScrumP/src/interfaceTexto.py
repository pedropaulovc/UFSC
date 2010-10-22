#-*- coding: utf-8 -*-
# TODO: - obterInfoSprintBackLog()
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from scrumPy import ScrumPy
from excecoes import *


def main():
    exibirIntroducao()
    scrumPy = ScrumPy()
    
    ##################
    ##Bloco de aceleração de input.##
    scrumPy.logarUsuario("admin", "admin")
    scrumPy.cadastrarUsuario("t0", "t0","t0")
    scrumPy.cadastrarUsuario("t1", "t1","t1")
    scrumPy.cadastrarUsuario("s", "s","s")
    scrumPy.cadastrarUsuario("p", "p","p")
    scrumPy.criarProjeto("Projeto Teste", ["admin", "t0"], "p", "s")
    scrumPy.logarUsuario("p", "p")
    scrumPy.abrirProjeto("PROJ-0")
    scrumPy.criarTarefa("Tarefa teste 0", "Testando tarefa 0", "2", [], "5")
    scrumPy.criarTarefa("Tarefa teste 1", "Testando tarefa 1", "2", [], "5")
    scrumPy.criarTarefa("Tarefa teste 2", "Testando tarefa 2", "1", ['TAR-0'], "3")
    scrumPy.criarTarefa("Tarefa teste 3", "Testando tarefa 3", "4", ['TAR-0'], "3")
    scrumPy.logarUsuario("t0", "t0")
    scrumPy.abrirProjeto("PROJ-0")
    scrumPy.marcarTarefaConcluida("TAR-0")
    scrumPy.logarUsuario("p", "p")
    scrumPy.abrirProjeto("PROJ-0")
    scrumPy.criarEstoria("Estória teste 0", "Testando estória 0", ['TAR-1', 'TAR-2'])
    scrumPy.criarEstoria("Estória teste 1", "Testando estória 1", ['TAR-2', 'TAR-3'])
    scrumPy.criarSprintBackLog(32, ['EST-0'], {'TAR-1': 't0', 'TAR-2': 'admin'})
    ##################
    
    while True:
        exibirMenu()
        opcao = raw_input()
        
        if opcao == "oua":
            try:
                print scrumPy.obterUsuarioAtual()
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "opa":
            try:
                print scrumPy.obterProjetoAtual()
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
        elif opcao == "cu":
            nome = raw_input("Forneça nome usuário: ")
            login = raw_input("Forneça login: ")
            senha = raw_input("Forneça senha: ")
            try:
                scrumPy.cadastrarUsuario(nome, login, senha)
            except (LoginJaExiste):
                print "Login já existe."
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
            except (UsuarioSemPermissao):
                print "Usuário não tem permissão para a opção escolhida."
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
                id = scrumPy.criarProjeto(nome, time, prodOwner, scrumMaster)
                print "Foi criado um novo projeto com a ID:", id
            except (UsuarioNaoExiste):
                print "Algum usuário enviado não existe"
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
            except (UsuarioSemPermissao):
                print "Usuário não tem permissão para a opção escolhida."
        elif opcao == "opp":
            try:
                print scrumPy.obterProjetosParticipados()
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "ap":
            idProj = raw_input("Forneça o Id do projeto: ")
            try:
                aberto = scrumPy.abrirProjeto(idProj)
                print "Projeto Aberto. Nome: {0}; ID: {1}".format(aberto[0], aberto[1])
            except (ProjetoNaoExiste):
                print "Projeto não existe."
            except (NaoParticipaDoProjeto):
                print "Usuário não participa do projeto escolhido."
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "oe":
            try:
                print "Estória - Tarefas"
                for estoria, tarefas in scrumPy.obterEstorias():
                    print "{0} - {1}".format(estoria, tarefas)
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
        elif opcao == "csb":
            duracao = raw_input("Forneça a duração: ")
            print "Forneça uma id de estória por linha. Uma linha em branco encerra a lista"
            estoriasEscolhidas = []
            estoria = None
            while estoria != "":
                estoria = raw_input()
                if estoria != "":
                    estoriasEscolhidas += [estoria]
    
            mapaTarefasMembros = {}
            try:
                for estoria in estoriasEscolhidas:
                    tarefas = scrumPy.obterTarefasDeEstoria(estoria)
                    print "Forneça o usuário responsável por cada tarefa de {0}: ".format(estoria)
                    for tarefa in tarefas:
                        membro = raw_input(tarefa + ": ")
                        mapaTarefasMembros[tarefa] = membro
                scrumPy.criarSprintBackLog(duracao, estoriasEscolhidas, mapaTarefasMembros)
                print "Sprint BackLog criado com sucesso."
            except (TarefaNaoExiste):
                print "Alguma tarefa fornecida não existe"
            except (UsuarioNaoExiste):
                print "Algum usuário fornecido não existe"
            except (EstoriaNaoExiste):
                print "Alguma estória fornecida não existe"
            except (DuracaoInvalida):
                print "Duração fornecida <= 0"
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
            except (UsuarioSemPermissao):
                print "Usuário não tem permissão para a opção escolhida."
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
        elif opcao == "ot":
            try:
                __exibirTarefas(scrumPy.obterTarefas())
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
                
        elif opcao == "ce":
            nome = raw_input("Forneça o nome: ")
            descricao = raw_input("Forneça a descrição: ")
            
            criarTarefa = "s"
            while criarTarefa == "s":
                criarTarefa = raw_input("Deseja criar uma tarefa? S/[N] ").lower()
                if criarTarefa == "s":
                    __criarTarefa(scrumPy)

            print "Forneça um idTarefa por linha. Uma linha em branco encerra a lista"
            tarefas = []
            id = None
            while id != "":
                id = raw_input()
                if id != "":
                    tarefas += [id]
            try:
                scrumPy.criarEstoria(nome, descricao, tarefas)
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
            except (UsuarioSemPermissao):
                print "Usuário não tem permissão para a opção escolhida."
            except (UsuarioNaoLogado):
                print "Usuário não está logado."
            except (TarefaNaoExiste):
                print "Uma tarefa fornecida não existe."
            except (TarefaJaConcluida):
                print "Uma tarefa fornecida já foi concluída"
            
        elif opcao == "ct":
            __criarTarefa(scrumPy)
        elif opcao == "mtc":
            try:
                scrumPy.obterTarefas()
                idTarefa = raw_input("Forneça o IdTarefa: ")
                scrumPy.marcarTarefaConcluida(idTarefa)
            except (TarefaNaoExiste):
                print "Não há tarefa pendente com o ID fornecido."
            except (SemProjetoAberto):
                print "Nenhum projeto aberto."
            except (UsuarioSemPermissao):
                print "Usuário não tem permissão para a opção escolhida."
            except (UsuarioNaoLogado):
                print "Usuário não está logado."

        else:
            print "Opção inválida"
        

def exibirMenu():
    print "\nEscolha uma opção:"
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
    print "ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI"

def __exibirTarefas(tarefas):
    if tarefas[0] == []:
        print "Sem tarefas pendentes"
    else:
        print "Tarefas pendentes: "
    for tarefa in tarefas[0]:
        print tarefa
        
    if tarefas[1] == []:
        print "Sem tarefas concluídas"
    else:
        print "Tarefas concluídas: "
    for concluida in tarefas[1]:
        print concluida

def __criarTarefa(scrumPy):
    nome = raw_input("Forneça o nome: ")
    descricao = raw_input("Forneça a descricao: ")
    dificuldade = raw_input("Forneça a dificuldade: ")
    estimativa = raw_input("Forneça a estimativa: ")
    try:
        tarefas = scrumPy.obterTarefas()
    except (SemProjetoAberto):
        print "Nenhum projeto aberto."
    tarefasPreRequisito = []
    if tarefas[0] != [] or tarefas[1] != []:
        __exibirTarefas(tarefas)
        print "Forneça um idTarefa pré-requisito por linha. Uma linha em branco encerra a lista"
        id = None
        while id != "":
            id = raw_input()
            if id != "":
                tarefasPreRequisito += [id]
    
    try:
        scrumPy.criarTarefa(nome, descricao, dificuldade, tarefasPreRequisito, estimativa)
    except (TarefaJaExiste):
        print "Nome de tarefa já existe"
    except (TarefaNaoExiste):
        print "Uma tarefa fornecida não existe"
    except (SemProjetoAberto):
        print "Nenhum projeto aberto."
    except (UsuarioSemPermissao):
        print "Usuário não tem permissão para a opção escolhida."
    except (UsuarioNaoLogado):
        print "Usuário não está logado."

if __name__ == "__main__":
    main()