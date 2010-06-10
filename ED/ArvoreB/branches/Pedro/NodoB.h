/*
 * NodoB.h
 *
 *  Created on: Jun 4, 2010
 *      Author: pedropaulo
 */

#ifndef NODOB_H_
#define NODOB_H_

#include <string>
#include "Estruturas/ListaEncadeada.h"

template<class U>
class NodoB {

private:
	ListaEncadeada<const U>* infos;
	ListaEncadeada<NodoB<U> >* filhos;
	int numChavesNodo;
	int totalChaves;
	int altura;
	int ordem;
	bool folha;
	bool raiz;

public:
	NodoB(int ordem);
	virtual ~NodoB();

	NodoB<U>* insere(U const &tipo);
	NodoB<U>* remove(U const &tipo);

	int retornaAltura();
	int retornaNumeroDeElementos();

	void retornaPrefixada(ListaEncadeada<const U>* lista);
	void retornaPosfixada(ListaEncadeada<U>* lista);
	void retornaInfixada(ListaEncadeada<U>* lista);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	bool nodoCheio();
	bool nodoVazio();
	/* Tornar privados após testes */
	void divideNodo(NodoB<U>* raiz, NodoB<U>* filho);
	NodoB<U>* selecionaRamoDescida(U const &tipo);

	void atualizaAltura();
	void atualizaQtdElementos();

	void insereFolha(U const &tipo);

	int encontrarPosicaoNovoNodo(U const &tipo);
};

#include "NodoB.ipp"

#endif /* NODOB_H_ */
