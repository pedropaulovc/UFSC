/*
 * pilha.h
 *
 *  Created on: 13/03/2010
 *      Author: berr
 */

#define ERRO_PILHA_CHEIA -1
#define ERRO_PILHA_VAZIA -2
#define MAXPILHA 30

int topo();

void limparPilha();

int desempilha();

int empilha(int dado);

void mostraPilha();

typedef struct {
	int dados[MAXPILHA];
	int topo;
} Pilha;
