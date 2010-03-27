/*
 * lista.c
 *
 *  Created on: Mar 21, 2010
 *      Author: pedropaulo
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

//TODO: Será que é melhor colocar em lista.h?
//Mudei para lá

//TODO:As funções de retirar devem retornar int


int adiciona(tAgenda dado) {
	if (aLista.ultimo == MAXELEMENTOS - 1)
		return ERRO_LISTA_CHEIA;

	aLista.ultimo++;
	aLista.elem[aLista.ultimo] = dado;

	return aLista.ultimo;
}

int adicionaNoInicio(tAgenda dado) {
	return adicionaNaPosicao(dado, 0);
}

int adicionaNaPosicao(tAgenda dado, int posicao) {
	int resultado = vagarPosicao(posicao);

	if (resultado != 0)
		return resultado;

	aLista.elem[posicao] = dado;
	aLista.ultimo++;
	return 0;
}

int vagarPosicao(int posicao) {
	//Numa lista vazia não é necessário fazer nada.
	//Além disso, a função falharia em vagar a posição 0 de uma lista vazia pois 0 > -1 (ultimo)
	if (listaVazia() == 1)
		return 0;

	//Caso a lista estiver cheia não tem como deslocar
	if (listaCheia() == 1)
		return ERRO_LISTA_CHEIA;

	if (posicao > aLista.ultimo || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	// Estava fazendo cópias do último elemento do vetor
	// elemento[i] recebia elemento[i+1], elemento[i-1] recebia elemento[i](elemento[i+1])
	int i;
	for (i = aLista.ultimo; i >= posicao; i--)
		aLista.elem[i + 1] = aLista.elem[i];
	return 0;
}

int adicionaEmOrdem(tAgenda dado) {
	int pos = 0;
	while (pos <= aLista.ultimo && maior(dado, aLista.elem[pos]))
		pos++;

	// Estava sempre adicionando em uma posição a mais, e quando
	// posição era igual a último não fazia a comparação.
	return adicionaNaPosicao(dado, pos);
}

//TODO: Implementar
tAgenda obter() {
	tAgenda contato;
	return contato;
}

//TODO: Implementar
tAgenda obterDoInicio() {
	tAgenda contato;
	return contato;
}

//TODO: Implementar
tAgenda obterDaPosicao(int posicao) {
	tAgenda contato;
	return contato;
}

int retira() {
	return retiraDaPosicao(aLista.ultimo);
}

int retiraDoInicio() {
	return retiraDaPosicao(0);
}

int retiraDaPosicao(int posicao) {
	if (posicao > aLista.ultimo || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	for (; posicao <= aLista.ultimo; posicao++)
		aLista.elem[posicao] = aLista.elem[posicao + 1];

	aLista.ultimo--;
	return 0;
}

int listaCheia() {
	if (aLista.ultimo == MAXELEMENTOS - 1)
		return 1;
	return 0;
}

int listaVazia() {
	if (aLista.ultimo == LISTAVAZIA)
		return 1;
	return 0;
}

int posicaoValida(int posicao) {
	if (posicao <= aLista.ultimo && posicao >= 0)
		return 1;
	return 0;
}

// Retorna -1 se o dado não está na agenda.
//TODO: #define ERRO_CONTATO_INEXISTENTE -4?
int posicao(tAgenda dado) {
	int i;
	for (i = 0; i <= aLista.ultimo; i++)
		if (igual(dado, aLista.elem[i]))
			return i;
	return -1;
}

int contem(tAgenda dado) {
	int i;
	for (i = 0; i <= aLista.ultimo; i++)
		if (igual(dado, aLista.elem[i]))
			return 1;
	return 0;
}

int igual(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) == 0)
		return 1;
	return 0;
}

int maior(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) > 0)
		return 1;
	return 0;
}

int menor(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) < 0)
		return 1;
	return 0;
}

void inicializaLista() {
	aLista.ultimo = -1;
}

void destroiLista() {
	aLista.ultimo = -1;
}
