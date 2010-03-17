/**
ARQUIVO:       fila.h
TÍTULO:        Implementação da Filas de Strings com Vetores em "C"
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         18 de março de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em fila.c referentes à estrutura de
dados fila, além de definições de constantes usadas ao longo do programa.

DEFINIÇÕES:
MAXFILA
	Tamanho máximo da fila, por padrão definido no enunciado, 100

TAM_STRING
	Tamanho máximo de cada string que será um elemento da fila, valor padrão: 31

ERRO_FILA_VAZIA
	Código de erro retornado pela fila em caso de uma operação inválida de desenfileirar uma fila vazia.
	Valor padrão: -1

ERRO_FILA_CHEIA
	Código de erro retornado pela fila em caso de uma operação inválida de enfineirar um elemento em uma
	fila cheia. Valor padrão -2

TIPOS:
elementoDaFila
	Definição de um elemento da fila, como pedido, um vetor de string com tamanho 30 (Mais 1 para o caractere
	nulo)
Fila
	Definição de uma fila, contendo um vetor que armazena 100 dados do tipo elementoDaFila, além de um inteiro
	que indica a posição do último elemento na fila.

*/

#ifndef FILA_H_
#define FILA_H_

#define MAXFILA 100
#define TAM_STRING 31
#define ERRO_FILA_VAZIA -1
#define ERRO_FILA_CHEIA -2

typedef struct {
	char texto[TAM_STRING];
} elementoDaFila;

typedef struct {
	elementoDaFila elementos[MAXFILA];
	int ultimo;
} Fila;

Fila aFila;

void inicializar();
int enfileirar(elementoDaFila elemento);
void desenfileirar();
void limpar();
void mostrarFila();
int verPosicaoFinal();
elementoDaFila obterPrimeiroElemento();
int aFilaEstaVazia();

#endif /* FILA_H_ */
