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

template<class T>
class NodoB {

private:
	ListaEncadeada<const T>* infos;
	ListaEncadeada<NodoB<T> >* filhos;
	int numChavesNodo;
	int totalChaves;
	int altura;
	int ordem;
	bool folha;
	bool raiz;

	void divideNodo(NodoB<T>* raiz, NodoB<T>* filho);
	NodoB<T>* selecionaRamoDescida(T const &tipo);
	int posicaoRamoDescida(T const &tipo);

	void atualizaAltura();
	void atualizaQtdElementos();
	void atualizaElemento();

	void insereFolha(T const &tipo);

	int encontrarPosicaoNovoNodo(T const &tipo);
	void moverChavesMenores(NodoB<T> *& origem, NodoB<T> *& destino, int & limite);
	void moverRamosMenores(NodoB<T> *& origem, NodoB<T> *& destino, int limite);

public:
	NodoB(int ordem);
	virtual ~NodoB();

	NodoB<T>* insere(T const &tipo);
	NodoB<T>* remove(T const &tipo);

	int retornaAltura();
	int retornaNumeroDeElementos();
	int retornaNumeroDeChaves();
	int retornaNumeroDeFilhos();

	void retornaPrefixada(ListaEncadeada<const T>* lista);
	void retornaPosfixada(ListaEncadeada<const T>* lista);
	void retornaInfixada(ListaEncadeada<const T>* lista);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	bool nodoCheio();
	bool nodoVazio();

};

#include "NodoB.ipp"

#endif /* NODOB_H_ */
