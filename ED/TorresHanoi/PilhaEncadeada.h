/*
 * PilhaEncadeada.h
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */

#ifndef PILHAENCADEADA_H_
#define PILHAENCADEADA_H_
#include "tInfo.h"

typedef struct tElemento {
	struct tInfo* info;
	struct tElemento* proximo;
} tElemento;

typedef struct tPilha{
	int tamanho;
	tElemento* topo;
} tPilha;


#define ERRO_DADOS_INVALIDOS -1
#define ERRO_PILHA_CHEIA -2

tPilha* criaPilha();
int empilha(tPilha* pilha, struct tInfo* info);
struct tInfo* desempilha(tPilha* pilha);
struct tInfo* obterTopo(tPilha* pilha);
void limparPilha(tPilha* pilha);
void destruirPilha(tPilha* pilha);
struct tInfo* obterElemento(tPilha* pilha, int elemento);


#endif /* PILHAENCADEADA_H_ */
