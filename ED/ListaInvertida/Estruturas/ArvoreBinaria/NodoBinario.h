/*
 * NodoArvoreBinaria.h
 *
 *  Created on: May 22, 2010
 *      Author: pedropaulo
 */

#ifndef NODOBINARIO_H_
#define NODOBINARIO_H_

#include <cstdlib>
#include "../ListaEncadeada/ListaEncadeada.h"

using namespace std;

template<class T>
class NodoBinario {
private:
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;
	T* info;

public:
	NodoBinario(T* info, NodoBinario<T>* filhoEsquerda = NULL,
			NodoBinario<T>* filhoDireita = NULL);
	virtual ~NodoBinario();

	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);
	void alterarInfo(T* info);

	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	T* obterInfo();

	ListaEncadeada<T>* percorrePreOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
	ListaEncadeada<T>* percorreEmOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
	ListaEncadeada<T>* percorrePosOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
};

template<class T>
NodoBinario<T>::NodoBinario(T* info, NodoBinario<T>* filhoEsquerda,
		NodoBinario<T>* filhoDireita) {
	this->info = info;
	this->filhoEsquerda = filhoEsquerda;
	this->filhoDireita = filhoDireita;
}

template<class T>
NodoBinario<T>::~NodoBinario() {
}

template<class T>
void NodoBinario<T>::alterarFilhoEsquerda(NodoBinario<T>* filho) {
	this->filhoEsquerda = filho;
}

template<class T>
void NodoBinario<T>::alterarFilhoDireita(NodoBinario<T>* filho) {
	this->filhoDireita = filho;
}

template<class T>
void NodoBinario<T>::alterarInfo(T* info) {
	this->info = info;
}

template<class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoEsquerda() {
	return this->filhoEsquerda;
}

template<class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoDireita() {
	return this->filhoDireita;
}

template<class T>
T* NodoBinario<T>::obterInfo() {
	return this->info;
}

template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorrePreOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	lista->adicionarNoFim(this->info);
	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePreOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePreOrdemRecursivo(lista);
	return lista;
}

template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorreEmOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorreEmOrdemRecursivo(lista);
	lista->adicionarNoFim(this->info);
	if (filhoDireita != NULL)
		filhoDireita->percorreEmOrdemRecursivo(lista);
	return lista;
}

template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorrePosOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePosOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePosOrdemRecursivo(lista);
	lista->adicionarNoFim(this->info);
}
#endif /* NODOBINARIO_H_ */
