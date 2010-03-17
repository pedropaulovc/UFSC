//Arquivo: pilha.c
//Nome: Trabalho de implementação: Pilha.
//Alunos: Felipe dos Santos Silveira 09132014 e Pedro Paulo Vezzá Campos 09132033
//Data de Criação: 13/03/2010
//Disciplina: INE5408 - Estruturas de Dados
//Data de Entrega: 15/03/2010
//Função: Implementação das funções da pilha

#include <stdio.h>
#include "pilha.h"


Pilha aPilha; // Variável global aPilha que será manipulada pelas funções.

//Método para iniciar ou limpar a pilha.
//A pilha é iniciada com topo -1 para dizer que
//está vazia.
void limparPilha(){
	aPilha.topo = -1;
}

//Retira o elemento do fim da pilha.
//Essa função retira o último elemento que foi
//adicionado na pilha e o retorna.
//Se a pilha estiver vazia, é retornado -1
int desempilha(){
	int topo;
	if(aPilha.topo == -1){
		printf("ERRO: Pilha está vazia");
		return ERRO_PILHA_VAZIA;
	}

	topo = aPilha.topo;
	aPilha.topo--;

	return topo;
}

//Insere um elemento no fim da pilha.
//Recebe um elemento e o coloca no fim da pilha.
//Se a pilha estiver cheia, retorna -2
int empilha(int dado){
	if(MAXPILHA-1 == aPilha.topo){
		printf("ERRO: Pilha está cheia\n");
		return ERRO_PILHA_CHEIA;
	}

	aPilha.topo++;
	aPilha.dados[aPilha.topo] = dado;
	return aPilha.topo;
}

//Mostra os elementos da pilha na forma: Elemento,Posição.
//Se a pilha estiver vazia, informa que está vazia.
void mostraPilha(){
	int i;

	if(aPilha.topo == -1)
		printf("A pilha está vazia\n");
	printf("Dado - Posição:\n");
	for(i = 0; i <= aPilha.topo; i++)
		printf("%d - %d\n",aPilha.dados[i],i);
}
