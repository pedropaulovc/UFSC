/*
 * filaEncadeada.c
 *
 *  Created on: 13/04/2010
 *      Author: aluno
 */
#include <stdio.h>
#include <stdlib.h>
#include "FilaEncadeada.h"
#include "tInfo.h"

tFila* inicializar() {
	tFila* fila = (tFila*) malloc(sizeof(tFila));

	if (fila != NULL) {
		fila->tamanho = 0;
		fila->fim = NULL;
		fila->inicio = NULL;
	}
	return fila;
}

int enfileirar(tFila* fila, tInfo* info) {
	tElemento* elemento = (tElemento*) malloc(sizeof(tElemento));

	if (elemento == NULL)
		return ERROFILACHEIA;

	if (aFilaEstaVazia(fila))
		fila->inicio = elemento;
	else
		fila->fim->proximo = elemento;

	elemento->proximo = NULL;
	elemento->info = info;

	fila->fim = elemento;
	fila->tamanho++;

	return fila->tamanho;
}

tInfo* desenfileirar(tFila* fila) {
	tElemento* sai;
	tInfo* infoSai;

	if (aFilaEstaVazia(fila))
		return NULL;

	sai = fila->inicio;
	infoSai = sai->info;

	fila->inicio = sai->proximo;

	if (fila->tamanho == 1)
		fila->fim = NULL;

	fila->tamanho--;
	free(sai);
	return infoSai;
}

void limpar(tFila* fila) {
	while(!aFilaEstaVazia(fila))
		destruirInfo(desenfileirar(fila));
}

int verPosicaoFinal(tFila* fila) {
	return fila->tamanho - 1;
}

tInfo* obterFimDaFila(tFila* fila) {
	if(!aFilaEstaVazia(fila))
		return fila->fim->info;
	return NULL;
}

int aFilaEstaVazia(tFila* fila) {
	return fila->tamanho == 0;
}
