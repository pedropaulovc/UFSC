/*
 * NodoArvoreBinaria.h
 *
 *  Created on: May 22, 2010
 *      Author: pedropaulo
 */

#ifndef NODOBINARIO_H_
#define NODOBINARIO_H_

#include <string>
#include <cstdlib>
#include <iostream>

using namespace std;

template<class T>
class NodoBinario {
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;
	T* info;

public:
	NodoBinario(T* info, NodoBinario<T>* filhoEsquerda, NodoBinario<T>* filhoDireita);
	virtual ~NodoBinario();

	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);

	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	T* obterInfo();

	void percorrePreOrdemRecursivo();
	void percorreEmOrdemRecursivo();
	void percorrePosOrdemRecursivo();

	void percorrePreOrdemIterativo();
	void percorreEmOrdemIterativo();
	void percorrePosOrdemIterativo();

	NodoBinario<string>* criaArvore(string expressao, int *i);

};

template<class T>
NodoBinario<T>::NodoBinario(T* info, NodoBinario<T>* filhoEsquerda, NodoBinario<T>* filhoDireita) {
	this->info = info;
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
NodoBinario<T>* NodoBinario<T>::obterFilhoEsquerda() {
	return filhoEsquerda;
}

template<class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoDireita() {
	return filhoDireita;
}

template<class T>
T* NodoBinario<T>::obterInfo(){
	return info;
}

//TODO: criaArvore deveria ser estático
template<class T>
NodoBinario<string>* NodoBinario<T>::criaArvore(string expressao, int *i){
	string t = expressao.substr(*i, 1);
	(*i)++;

	NodoBinario<string>* novoNodo;

	if(t == "+" || t == "-" || t == "*" || t == "/")
		novoNodo = new NodoBinario(&t, criaArvore(expressao, i), criaArvore(expressao, i));
	else
		novoNodo = new NodoBinario(&t, NULL, NULL);

	return novoNodo;
}

template<class T>
NodoBinario<T>::~NodoBinario() {
}

#endif /* NODOBINARIO_H_ */
