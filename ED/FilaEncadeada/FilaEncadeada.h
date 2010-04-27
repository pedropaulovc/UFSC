/**
ARQUIVO:       FilaEncadeada.h
TÍTULO:        Implementação da filas encadeadas
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         27 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila encadeada.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em FilaEncadeada.c referentes à estrutura de
dados fila, além de definições de constantes usadas ao longo do programa.

DEFINIÇÕES:
ERRO_FILA_CHEIA
	Código de erro retornado pela fila em caso de uma operação inválida de enfineirar um elemento em uma
	fila cheia. Valor padrão -1

TIPOS:
tElemento
	Definição de um elemento da fila, contendo um ponteiro para o próximo elemento da fila e um ponteiro para o seu TAD de informações.
tFila
	Definição de uma fila, uma cabeça de fila, contendo um ponteiro para o primeiro e último elemento da fila
	 além do tamanho atual da fila.
*/

#ifndef FILAENCADEADA_H_
#define FILAENCADEADA_H_
#include "tInfo.h"

typedef struct tElemento {
  tInfo *info;
  struct tElemento *proximo;
} tElemento;

typedef struct {
  tElemento *inicio;
  tElemento *fim;
  int tamanho;
} tFila;

#define ERROFILACHEIA -1

tFila* inicializar();
int enfileirar(tFila* fila, tInfo* info);
tInfo* desenfileirar(tFila* fila);
void limpar(tFila* fila);
int verPosicaoFinal(tFila* fila);
tInfo* obterFimDaFila(tFila* fila);
int aFilaEstaVazia(tFila* fila);

#endif /* FILAENCADEADA_H_ */
