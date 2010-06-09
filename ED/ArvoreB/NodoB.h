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
	T** infos;
	NodoB** filhos;
	int numChaves;
	bool folha;

	void insereFolha(const T& tipo);
	NodoB<T>* divideNodo();
	NodoB<T>* selecionaRamoDescida(const T& tipo);

	void atualizaAltura();
	void atualizaQtdElementos();


public:
	NodoB(int ordem);
	virtual ~NodoB();

	NodoB<T>* insere(const T& tipo);
	NodoB<T>* remove(const T& tipo);

	int retornaAltura();
	int retornaNumeroDeElementos();

	void retornaPrefixada(ListaEncadeada<T>* lista);
	void retornaPosfixada(ListaEncadeada<T>* lista);
	void retornaInfixada(ListaEncadeada<T>* lista);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	bool nodoCheio();
};

#include "NodoB.ipp"

#endif /* NODOB_H_ */
