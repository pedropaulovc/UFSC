/*
 * PilhaEncadeada.c
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */

#include <stdlib.h>
#include "PilhaEncadeada.h"
#include "tInfo.h"

tPilha* criaPilha() {
	tPilha* pilha = (tPilha*) malloc(sizeof(tPilha));

	if (pilha != NULL) {
		pilha->tamanho = 0;
		pilha->topo = NULL;
	}

	return pilha;
}

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

tInfo* obterTopo(tPilha* pilha) {
	if (pilha == NULL)
		return NULL;
	return pilha->topo->info;
}

void limparPilha(tPilha* pilha) {
	if (pilha == NULL)
		return;

	while (pilha->tamanho > 0)
		destruirInfo(desempilha(pilha));
}

void destruirPilha(tPilha* pilha) {
	if (pilha == NULL)
		return;

	limparPilha(pilha);

	free(pilha);
}
