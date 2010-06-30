/*
 * NodoArvoreBinaria.h
 *
 *  Created on: May 22, 2010
 *      Author: pedropaulo
 */

#ifndef NODOBINARIO_H_
#define NODOBINARIO_H_

#include <cstdlib>
//TODO: Eliminar dependência de EDs do C++
#include <list>
#include <stack>
#include <iostream>

using namespace std;

template<class T>
class NodoBinario {
private:
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;
	T* info;

public:
	NodoBinario(T* info, NodoBinario<T>* filhoEsquerda,
			NodoBinario<T>* filhoDireita);
	virtual ~NodoBinario();

	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);
	void alterarInfo(T* info);

	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	T* obterInfo();

	void percorrePreOrdemRecursivo(std::list<T*>* lista);
	void percorreEmOrdemRecursivo(std::list<T*>* lista);
	void percorrePosOrdemRecursivo(std::list<T*>* lista);

	std::list<T*>* percorrePreOrdemIterativo();
	std::list<T*>* percorreEmOrdemIterativo();
	std::list<T*>* percorrePosOrdemIterativo();
};

template<class T>
NodoBinario<T>::NodoBinario(T* info = NULL, NodoBinario<T>* filhoEsquerda = NULL,
		NodoBinario<T>* filhoDireita = NULL) {
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
void NodoBinario<T>::percorrePreOrdemRecursivo(std::list<T*>* lista = NULL) {
	if (lista == NULL)
		lista = new list<T*> ();

	lista->push_back(this->info);
	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePreOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePreOrdemRecursivo(lista);
}

template<class T>
void NodoBinario<T>::percorreEmOrdemRecursivo(std::list<T*>* lista = NULL) {
	if (lista == NULL)
		lista = new list<T*> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorreEmOrdemRecursivo(lista);
	lista->push_back(this->info);
	if (filhoDireita != NULL)
		filhoDireita->percorreEmOrdemRecursivo(lista);
}

template<class T>
void NodoBinario<T>::percorrePosOrdemRecursivo(std::list<T*>* lista = NULL) {
	if (lista == NULL)
		lista = new list<T*> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePosOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePosOrdemRecursivo(lista);
	lista->push_back(this->info);
}

template<class T>
std::list<T*>* NodoBinario<T>::percorreEmOrdemIterativo() {
	std::stack<NodoBinario<T>*>* pilha = new stack<NodoBinario<T>*> ();
	std::list<T*>* lista = new list<T*> ();

	NodoBinario<T>* nodoAtual = this;

	do {
		while (nodoAtual != NULL) {
			pilha->push(nodoAtual);
			nodoAtual = nodoAtual->obterFilhoEsquerda();
		}

		if (pilha->empty())
			return lista;

		nodoAtual = pilha->top();
		pilha->pop();
		lista->push_back(nodoAtual->obterInfo());
		nodoAtual = nodoAtual->obterFilhoDireita();
	} while (true);
}

template<class T>
std::list<T*>* NodoBinario<T>::percorrePreOrdemIterativo() {
	std::stack<NodoBinario<T>*>* pilha = new stack<NodoBinario<T>*> ();
	std::list<T*>* lista = new list<T*> ();

	NodoBinario<T>* nodoAtual = this;

	do {
		while (nodoAtual != NULL) {
			lista->push_back(nodoAtual->obterInfo());
			pilha->push(nodoAtual);
			nodoAtual = nodoAtual->obterFilhoEsquerda();
		}

		if (pilha->empty())
			return lista;

		nodoAtual = pilha->top();
		pilha->pop();

		nodoAtual = nodoAtual->obterFilhoDireita();
	} while (true);
}

#endif /* NODOBINARIO_H_ */
