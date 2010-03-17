/**
ARQUIVO:       fila.c
TÍTULO:        Implementação da Filas de Strings com Vetores em "C"
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         18 de março de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila.


FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de filas. Ele possui um menu simples que aceita do usuário comandos para os principais
usos da estrutura: "enfileirar, desenfileirar, limpar, mostrar fila, sair do programa".
No mesmo enunciado, foi definido que seria criada uma variável global, aFila, inicializada
em fila.h, contendo uma fila de 100 vetores de strings de comprimento 30.

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

mostrarFila
	exibe na saída padrão os conteúdos da fila no formato "elemento - posição", um elemento por linha.

verPosicaoFinal
	retorna a posição do último elemento da fila.

obterPrimeiroElemento
	retorna o elementoDaFila que se encontra na primeira posição da fila.

aFilaEstaVazia
	retorna 1 caso a fila não possua elementos e 0 em caso contário.

ARQUIVOS INCLUSOS:
   stdio.h
   stdlib.h
   fila.h

ARQUIVOS DE DADOS:
   nenhum

*/

#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

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
void inicializar(){
	aFila.ultimo = -1;
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
int enfileirar(elementoDaFila elemento){
	if(aFila.ultimo == MAXFILA-1)
		return (ERRO_FILA_CHEIA);
	aFila.ultimo++;
	aFila.elementos[aFila.ultimo] = elemento;
	return aFila.ultimo;
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
void desenfileirar(){
	int i;

	for(i = 0; i <= aFila.ultimo; i++)
		aFila.elementos[i] = aFila.elementos[i + 1];

	aFila.ultimo--;
}

/**
NOME DA FUNÇÃO: obterPrimeiroElemento
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função retorna o elementoDaFila que se encontra na primeira posição da fila.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome                   tipo              descrição
---------------------------------------------------------------------
aFila.elementos[0]     elementoDaFila    primeiro elemento da fila

CHAMA: nada

CHAMADA DE: main
*/
elementoDaFila obterPrimeiroElemento(){
	return aFila.elementos[0];
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
int verPosicaoFinal(){
	return aFila.ultimo;
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
void limpar(){
	aFila.ultimo = -1;
}

/**
NOME DA FUNÇÃO: aFilaEstaVazia
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função retorna 1 caso a fila não possua elementos e 0 em caso contário.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome                   tipo              descrição
---------------------------------------------------------------------
--                     int               valor lógico para a expressão "a fila está vazia"

CHAMA: nada

CHAMADA DE: main, mostrarFila
*/
int aFilaEstaVazia(){
	if(aFila.ultimo == -1)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: mostrarFila
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Esta função exibe na saída padrão os conteúdos da fila no formato "elemento - posição",
	um elemento por linha.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

CHAMA: aFilaEstaVazia

CHAMADA DE: main
*/
void mostrarFila(){
	int i;
	if(aFilaEstaVazia())
		puts("A fila está vazia");

	printf("\n");
	for(i = 0; i <= aFila.ultimo; i++)
		printf("%s - %d\n", aFila.elementos[i].texto, i);
	printf("\n");
}
