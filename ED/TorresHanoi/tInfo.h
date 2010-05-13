/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em tInfo.c referentes ao à estrutura
de dados pilha encadeada.

TIPOS
tInfo
	informações referentes a um elemento da pilha, no caso, um disco de um pino do jogo das Torres de Hanoi. É composto
	por seu tamanho além de ponteiros para as pilhas anterior e atual que encontra-se.

*/

#ifndef TINFO_H_
#define TINFO_H_
#include "PilhaEncadeada.h"

typedef struct tInfo{
	int tamanho;
	struct tPilha* pilhaAnterior;
	struct tPilha* pilhaAtual;
} tInfo;

void destruirInfo(tInfo* info);

#endif /* TINFO_H_ */
