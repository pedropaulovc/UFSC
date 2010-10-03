#-*- coding:utf-8 -*-
'''
Created on 02/10/2010

@author: PedroPaulo
'''
from math import floor, log, ceil
class BlocoMemoria(object):
        def __init__(self, proc, tam):
            self.proc = proc
            self.tam = tam

class BuddyMemory(object):    
    def __init__(self, tamMemoria, tamPagina, limInferior, limSuperior):
        self.__tamMemoria = tamMemoria
        self.__tamPagina = tamPagina
        self.__limInferior = limInferior
        self.__limSuperior = limSuperior
        self.__memoria = []
        self.__verificarParametros()
        self.__mapearMemoria()
    
    def __verificarParametros(self):
        if self.__tamMemoria <= 0:
            raise RuntimeError("Memória <= 0")
        if self.__limInferior > self.__limSuperior:
            raise RuntimeError("Limite inferior > Limite superior")
    
    def __mapearMemoria(self):
        memAAlocar = self.__tamMemoria
        blocoMinimo = 2 ** self.__limInferior
        
        while memAAlocar >= blocoMinimo:
            tamBlocoAtual = 2 ** min(self.__limSuperior, floor(log(memAAlocar, 2)))
            self.__memoria.insert(0, BlocoMemoria(None, tamBlocoAtual))
            memAAlocar -= tamBlocoAtual
    

    def __tamanhoAlocacao(self, requisitado):      
        return int(2 ** max(ceil(log(requisitado, 2)), self.__limInferior))

    def alocarMemoria(self, processo, requisitado):
        #Decidindo o melhor tamanho de alocação
        tamanho = self.__tamanhoAlocacao(requisitado)
        
        #Encontrando o primeiro bloco livre que comporte o tamanho
        atual = 0
        infoAtual = self.__memoria[atual]
        while (infoAtual.proc != None or infoAtual.tam < tamanho) and atual < len(self.__memoria): 
            atual += 1
            if atual < len(self.__memoria):
                infoAtual = self.__memoria[atual]
            
        print "Processo {0} requisita memória {1}K ..".format(processo, requisitado),
        #Verificando se foi encontrado algum bloco válido
        if atual == len(self.__memoria):
            print "sem memória suficiente"
            return
        print "{0}K é alocado".format(tamanho)
        
        self.__dividirBlocoMemoria(processo, tamanho, atual)
        
    
    def __dividirBlocoMemoria(self, processo, tamanho, blocoAtual):
        infoBlocoAtual = self.__memoria[blocoAtual]
        
        while infoBlocoAtual.tam != tamanho:
            infoBlocoAtual.tam /= 2
            self.__memoria.insert(blocoAtual + 1, BlocoMemoria(None, infoBlocoAtual.tam))
        infoBlocoAtual.proc = processo
        
    def liberarMemoria(self, processo, tamanho):
        tamanho = self.__tamanhoAlocacao(tamanho)
        atual = 0
        infoAtual = self.__memoria[atual]
        while (infoAtual.proc != processo or infoAtual.tam != tamanho) and atual < len(self.__memoria): 
            atual += 1
            if atual < len(self.__memoria):
                infoAtual = self.__memoria[atual]
        
        if atual == len(self.__memoria):
            print "Nenhum bloco | {0} - {1} | encontrado".format(processo, tamanho)
            return
        
        infoAtual.proc = None
        self.__unirBlocosMemoria(atual, infoAtual.tam)
        print "Processo {0} libera {1}K de memória".format(processo, tamanho)
        
    def __unirBlocosMemoria(self, pos, tamanho):
        if(pos != 0):
            blocoAnterior = self.__memoria[pos - 1]
            if(blocoAnterior.proc == None and blocoAnterior.tam == tamanho):
                self.__memoria.pop(pos)
                blocoAnterior.tam *= 2
                self.__unirBlocosMemoria(pos - 1, blocoAnterior.tam)
        if(pos < len(self.__memoria) - 1):
            blocoPosterior = self.__memoria[pos + 1]
            if(blocoPosterior.proc == None and blocoPosterior.tam == tamanho):
                self.__memoria.pop(pos)
                blocoPosterior.tam *= 2
                self.__unirBlocosMemoria(pos, blocoPosterior.tam)
        
    def obterMapaAlocacao(self):
        print "|",
        for bloco in self.__memoria: 
            print str(bloco.proc) + " - " + str(int(bloco.tam)) + "K |",
        print ""
