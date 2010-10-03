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
            pass
        elif opcao == "cp":
            pass
        elif opcao == "opp":
            pass
        elif opcao == "ap":
            pass
        elif opcao == "oe":
            pass
        elif opcao == "csb":
            pass
        elif opcao == "ot":
            pass
        elif opcao == "ce":
            pass
        elif opcao == "ct":
            pass
        elif opcao == "mtc":
            pass
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