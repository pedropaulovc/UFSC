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
	const T** infos;
	NodoB** filhos;
	int numChavesNodo;
	int totalChaves;
	int altura;
	int ordem;
	bool folha;

	//void insereFolha(T const &tipo);
	NodoB<T>* divideNodo();
	NodoB<T>* selecionaRamoDescida(T const &tipo);

	void atualizaAltura();
	void atualizaQtdElementos();


public:
	NodoB(int ordem);
	virtual ~NodoB();

	NodoB<T>* insere(T const &tipo);
	NodoB<T>* remove(T const &tipo);

	int retornaAltura();
	int retornaNumeroDeElementos();

	void retornaPrefixada(ListaEncadeada<const T>* lista);
	void retornaPosfixada(ListaEncadeada<T>* lista);
	void retornaInfixada(ListaEncadeada<T>* lista);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	bool nodoCheio();
	bool nodoVazio();

	void insereFolha(T const &tipo);
};

#include "NodoB.ipp"

#endif /* NODOB_H_ */
