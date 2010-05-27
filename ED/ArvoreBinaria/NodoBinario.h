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

	void percorrePreOrdemIterativo(std::list<T*>* lista);
	void percorreEmOrdemIterativo(std::list<T*>* lista);
	void percorrePosOrdemIterativo(std::list<T*>* lista);
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

template <class T>
void NodoBinario<T>::alterarInfo(T* info){
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

//TODO: Testar
/*1. Crie uma pilha e monte uma árvore
 2. Empilhe nodo e ache o filho da esquerda até NULO
 3. Se o nodo for NULO, desempilhe
 4. Imprima o nodo e ache o filho da direita (empilhe), vá para passo 2
 5. Se o filho da direita for NULO, desempilhe e vá para o passo 4
 6. Se o filho da direita for NULO e a pilha estiver vazia, pare.*/
template<class T>
void NodoBinario<T>::percorreEmOrdemIterativo(std::list<T*>* lista = NULL) {
	std::stack<T*>* pilha = new stack<T*> ();

	NodoBinario<T>* nodoAtual = this;
	NodoBinario<T>* filhoDireita;

	do {
		//Passo 2
		while (nodoAtual != NULL) {
			pilha->push(nodoAtual);
			nodoAtual = nodoAtual->obterFilhoEsquerda();
		}
		//Passo 4
		nodoAtual = pilha->pop();
		lista->push_back(nodoAtual);
		filhoDireita = nodoAtual->obterFilhoDireita();

		if (filhoDireita != NULL)
			pilha->push(filhoDireita);
		else {
			nodoAtual = pilha->pop();
			lista->push_back(nodoAtual);
			filhoDireita = nodoAtual->obterFilhoDireita();
			pilha->push(filhoDireita);
		}

	} while (filhoDireita != NULL || !(pilha->empty()));

}

#endif /* NODOBINARIO_H_ */
