/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é uma implementação do algoritmo para solver o problema
das Torres de Hanoi de maneira iterativa além de conter extensões que permitem ao usuário verificar sua complexidade.

FUNÇÕES
criaPilha
	retorna um ponteiro para uma nova pilha alocada dinamicamente na memória.

empilha
	se possível, empilha um dado elemento na pilha informada.

desempilha
	se possível, desmpilha um dado elemento da pilha informada.

obterTopo
	retorna o elemento contido no topo da pilha.

limparPilha
	elimina da memória todos os elementos contidos na pilha.

destruirPilha
	além de eliminar da memória todos os elementos contidos na pilha também desaloca a memória reservada à pilha.

*/

#include <stdlib.h>
#include "PilhaEncadeada.h"
#include "tInfo.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna um ponteiro para uma nova pilha alocada dinamicamente na memória.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a pilha criada ou um ponteiro nulo caso não seja possível.

*/
tPilha* criaPilha() {
	tPilha* pilha = (tPilha*) malloc(sizeof(tPilha));

	if (pilha != NULL) {
		pilha->tamanho = 0;
		pilha->topo = NULL;
	}

	return pilha;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	se possível, empilha um dado elemento na pilha informada.

PARÂMETROS:
	a pilha a ser operada e o elemento a ser empilhado.

VALOR DE RETORNO:
	o novo tamanho da pilha

*/
int empilha(tPilha* pilha, tInfo* info) {
	if (pilha == NULL || info == NULL)
		return ERRO_DADOS_INVALIDOS;

	tElemento* novo = (tElemento*) malloc(sizeof(tElemento));

	if (novo == NULL)
		return ERRO_PILHA_CHEIA;

	novo->proximo = pilha->topo;
	novo->info = info;

	pilha->topo = novo;
	pilha->tamanho++;

	return pilha->tamanho;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	se possível, desmpilha um dado elemento da pilha informada.

PARÂMETROS:
	a pilha a ter um elemento desempilhado.

VALOR DE RETORNO:
	o elemento desempilhado.

*/
tInfo* desempilha(tPilha* pilha) {
	if (pilha == NULL || pilha->tamanho == 0)
		return NULL;

	tElemento* sai = pilha->topo;
	tInfo* infoSai = sai->info;

	pilha->topo = sai->proximo;
	pilha->tamanho--;

	free(sai);
	return (infoSai);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o elemento contido no topo da pilha.

PARÂMETROS:
	a pilha a ter seu topo obtido

VALOR DE RETORNO:
	o topo da pilha ou um ponteiro nulo caso esteja vazia.

*/
tInfo* obterTopo(tPilha* pilha) {
	if (pilha == NULL || pilha->topo == NULL)
		return NULL;
	return pilha->topo->info;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	elimina da memória todos os elementos contidos na pilha.

PARÂMETROS:
	a pilha a ser limpa.

VALOR DE RETORNO:
	nenhum

*/
void limparPilha(tPilha* pilha) {
	if (pilha == NULL)
		return;

	while (pilha->tamanho > 0)
		destruirInfo(desempilha(pilha));
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	além de eliminar da memória todos os elementos contidos na pilha também desaloca a memória reservada à pilha.

PARÂMETROS:
	a pilha a ser destruída

VALOR DE RETORNO:
	nenhum

*/
void destruirPilha(tPilha* pilha) {
	if (pilha == NULL)
		return;

	limparPilha(pilha);

	free(pilha);
}
