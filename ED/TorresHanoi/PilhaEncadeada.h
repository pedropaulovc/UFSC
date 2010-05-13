/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em PilhaEncadeada.c referentes ao à estrutura
de dados pilha encadeada.

TIPOS
tElemento
	elemento da pilha, com um ponteiro para suas informações e um ponteiro para o próximo elemento.

tPilha
	a pilha propriamente dita, com ponteiro para o elemento do topo e seu tamanho.

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


#endif /* PILHAENCADEADA_H_ */
