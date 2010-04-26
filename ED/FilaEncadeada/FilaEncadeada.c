/**
ARQUIVO:       FilaEncadeada.c
TÍTULO:        Implementação da filas encadeadas
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         27 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila encadeada.


FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de filas. Ele possui um menu simples que aceita do usuário comandos para os principais
usos da estrutura: "enfileirar, desenfileirar, limpar, mostrar fila, sair do programa" em um programa
de exemplo que funciona como sistema de controle de ordem de serviços de uma empresa de manutenção
de computadores.


FUNÇÕES:

inicializar
	prepara a fila para ser utilizada, através da definição da posição do último elemento como -1,
	ou seja, que a fila está vazia.

enfileirar
	recebe como parâmetro um elementoDaFila e, se for posível, adiciona-o ao final da fila.

desenfileirar
	remove o último elemento da fila, se possível, além de reordenar os elementos restantes dentro da fila.

limpar
	reinicializa a fila, tornando-a vazia novamente ao definir o últmo elemento como -1.

verPosicaoFinal
	retorna a posição do último elemento da fila.

obterPrimeiroElemento
	retorna o elementoDaFila que se encontra na primeira posição da fila.

aFilaEstaVazia
	retorna 1 caso a fila não possua elementos e 0 em caso contário.

obterFimDaFila
	retorna, se possível, o último elemento armazenado na fila.

ARQUIVOS INCLUSOS:
   stdio.h
   stdlib.h
   fila.h

ARQUIVOS DE DADOS:
   nenhum

*/
#include <stdio.h>
#include <stdlib.h>
#include "FilaEncadeada.h"
#include "tInfo.h"

/**
NOME DA FUNÇÃO: inicializar
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função prepara a fila para ser utilizada, através da definição da posição do
	último elemento como -1, ou seja, que a fila está vazia.
PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

CHAMA: nada

CHAMADA DE: main
*/
tFila* inicializar() {
	tFila* fila = (tFila*) malloc(sizeof(tFila));

	if (fila != NULL) {
		fila->tamanho = 0;
		fila->fim = NULL;
		fila->inicio = NULL;
	}
	return fila;
}

/**
NOME DA FUNÇÃO: enfileirar
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função prepara a fila para ser utilizada, através da definição da posição do
	último elemento como -1, ou seja, que a fila está vazia.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
elemento     elementoDaFila   valor              elemento a ser enfileirado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
aFila.ultimo   int   posição do último elemento da fila, ou um código
					 de erro caso não seja posível enfileirar o elemento.

CHAMA: nada

CHAMADA DE: main
*/
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

/**
NOME DA FUNÇÃO: desenfileirar
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função remove o último elemento da fila, se possível,
	além de reordenar os elementos restantes dentro da fila.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

CHAMA: nada

CHAMADA DE: main
*/
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

/**
NOME DA FUNÇÃO: limpar
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função reinicializa a fila, tornando-a vazia
	novamente ao definir o últmo elemento como -1.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

CHAMA: nada

CHAMADA DE: main
*/
void limpar(tFila* fila) {
	while(!aFilaEstaVazia(fila))
		destruirInfo(desenfileirar(fila));
}

/**
NOME DA FUNÇÃO: verPosicaoFinal
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função retorna a posição do último elemento da fila.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome                   tipo              descrição
---------------------------------------------------------------------
aFila.ultimo           int               posição do último elemento da fila

CHAMA: nada

CHAMADA DE: main
*/
int verPosicaoFinal(tFila* fila) {
	return fila->tamanho - 1;
}


/**
NOME DA FUNÇÃO: obterFimDaFila
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função retorna, se possível, o último elemento armazenado na fila.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
elemento     elementoDaFila   valor              elemento a ser enfileirado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
aFila.ultimo   int   posição do último elemento da fila, ou um código
					 de erro caso não seja posível enfileirar o elemento.

CHAMA: nada

CHAMADA DE: main
*/
tInfo* obterFimDaFila(tFila* fila) {
	if(!aFilaEstaVazia(fila))
		return fila->fim->info;
	return NULL;
}

/**
NOME DA FUNÇÃO: verPosicaoFinal
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função retorna a posição do último elemento da fila.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome                   tipo              descrição
---------------------------------------------------------------------
aFila.ultimo           int               posição do último elemento da fila

CHAMA: nada

CHAMADA DE: main
*/
int aFilaEstaVazia(tFila* fila) {
	return fila->tamanho == 0;
}
