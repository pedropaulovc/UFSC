#-*- coding:utf-8 -*-
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from buddyMemory import BuddyMemory
def main():    
    exibirIntroducao()
    buddyMemory = inicializar()
    while True:
        exibirMenu()
        opcao = raw_input()
        
        if opcao == "a":
            processo = raw_input("Forneça o nome do processo: ")
            tamanho = int(raw_input("Forneça a quantidade de memória a alocar: "))
            buddyMemory.alocarMemoria(processo, tamanho)
        elif opcao == "l":
            processo = raw_input("Forneça o nome do processo: ")
            tamanho = int(raw_input("Forneça a quantidade de memória a liberar: "))
            buddyMemory.liberarMemoria(processo, tamanho)
        elif opcao == "m":
            buddyMemory.obterMapaAlocacao()
        elif opcao == "f":
            print "Fim!"
            return
        else:
            print "Opção inválida"
    
    
def exibirIntroducao():
    print "INE5412 - SISTEMAS OPERACIONAIS I"
    print "LABORATÓRIO 5 - BUDDY MEMORY ALLOCATION"
    print "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E TARCÍSIO EDUARDO MOREIRA CROCOMO\n"
    
def inicializar():
    tamMemoria = int(raw_input("Forneça o tamanho da memória (em kB): "))
    tamPagina = int(raw_input("Forneça o tamanho da página (em kB): "))
    limInferior = int(raw_input("Forneça o limite inferior (em 2^i kB): "))
    limSuperior =  int(raw_input("Forneça o limite inferior (em 2^s kB): "))
    return BuddyMemory(tamMemoria, tamPagina, limInferior, limSuperior)
    
def exibirMenu():
    print "Escolha uma opção: "
    print "a - Alocar memória"
    print "l - Liberar memória"
    print "m - Mostrar mapa da alocação"
    print "f - Finalizar simulação"