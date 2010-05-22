/*
 * NodoArvoreBinaria.h
 *
 *  Created on: May 22, 2010
 *      Author: pedropaulo
 */

#ifndef NODOBINARIO_H_
#define NODOBINARIO_H_

template<class T>
class NodoBinario {
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;

public:
	NodoBinario(NodoBinario<T>* filhoEsquerda, NodoBinario<T>* filhoDireita);
	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);
	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	virtual ~NodoBinario();
};

template<class T>
NodoBinario<T>::NodoBinario(NodoBinario<T>* filhoEsquerda, NodoBinario<T>* filhoDireita) {
	this->filhoEsquerda = filhoEsquerda;
	this->filhoDireita = filhoDireita;
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
void NodoBinario<T>::obterFilhoEsquerda() {
	return filhoEsquerda;
}

template<class T>
void NodoBinario<T>::obterFilhoDireita() {
	return filhoDireita;
}

template<class T>
NodoBinario<T>::~NodoBinario() {
}

#endif /* NODOBINARIO_H_ */
