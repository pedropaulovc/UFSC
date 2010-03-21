/*
 * lista.c
 *
 *  Created on: Mar 21, 2010
 *      Author: pedropaulo
 */

#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

//TODO: Será que é melhor colocar em lista.h?
int vagarPosicao(int posicao);

int adiciona(tAgenda dado) {
	if(aLista.ultimo == MAXELEMENTOS - 1)
		return ERRO_LISTA_CHEIA;

	aLista.ultimo++;
	aLista.elementos[aLista.ultimo] = dado;

	return aLista.ultimo;
}

int adicionaNoInicio(tAgenda dado) {
	return adicionaNaPosicao(dado, 0);
}

int adicionaNaPosicao(tAgenda dado, int posicao) {
	int resultado = vagarPosicao(posicao);

	if(resultado != 0)
		return resultado;

	aLista.elementos[posicao] = dado;
	return 0;
}

int vagarPosicao(int posicao){
	//TODO: Verificar se a lista está vazia ou se a posicão não é valida.

	int i;
	for(i = aLista.ultimo; i > posicao; i--)
		aLista.elementos[i] = aLista.elementos[i + 1];
	return 0;
}

int adicionaEmOrdem(tAgenda dado);
tAgenda retira();
tAgenda retiraDoInicio();
tAgenda retiraDaPosicao(int posicao);
int listaCheia();
int listaVazia();
int posicao(tAgenda dado);
int contem(tAgenda dado);
int igual(tAgenda dado1, tAgenda dado2);
int maior(tAgenda dado1, tAgenda dado2);
int menor(tAgenda dado1, tAgenda dado2);
void inicializaLista();
void destroiLista();
