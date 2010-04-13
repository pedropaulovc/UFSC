/*
 * filaEncadeada.h
 *
 *  Created on: 13/04/2010
 *      Author: aluno
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
tInfo* obterPrimeiroElemento(tFila* fila);
int aFilaEstaVazia(tFila* fila);

#endif /* FILAENCADEADA_H_ */
