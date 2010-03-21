/*
 * lista.h
 *
 *  Created on: Mar 21, 2010
 *      Author: pedropaulo
 */

#ifndef LISTA_H_
#define LISTA_H_

#define MAXELEMENTOS 100
#define MAXNOME 31

typedef struct {
	char nome[MAXNOME];
	long int numero;
} tAgenda;

typedef struct {
	tAgenda elementos[MAXELEMENTOS];
} tLista;


int adiciona(tAgenda dado);
int adicionaNoInicio(tAgenda dado);
int adicionaNaPosicao(tAgenda dado, int posicao);
int adicionaEmOrdem(tAgenda dado);
tAgenda retira();
tAgenda retiraDoInicio();
tAgenda retiraDaPosicao(posicao);
int listaCheia();
int listaVazia();
int posicao(tAgenda dado);
int contem(tAgenda dado);
int igual(tAgenda dado1, tAgenda dado2);
int maior(tAgenda dado1, tAgenda dado2);
int menor(tAgenda dado1, tAgenda dado2);
void inicializaLista();
void destroiLista();



#endif /* LISTA_H_ */
