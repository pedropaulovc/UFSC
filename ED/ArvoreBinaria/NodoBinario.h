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
#include <list>

using namespace std;

template <class T>
class NodoBinario {
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;
	T* info;

public:
	NodoBinario(T* info, NodoBinario<T>* filhoEsquerda,
			NodoBinario<T>* filhoDireita);
	NodoBinario(string expressao, int *i);
	virtual ~NodoBinario();

	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);

	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	T* obterInfo();

	void percorrePreOrdemRecursivo(std::list<T*>* lista);
	std::list<T*>* percorreEmOrdemRecursivo();
	void percorrePosOrdemRecursivo(std::list<T*>* lista);

	void percorrePreOrdemIterativo(std::list<T*>* lista);
	void percorreEmOrdemIterativo(std::list<T*>* lista);
	void percorrePosOrdemIterativo(std::list<T*>* lista);

	NodoBinario<char>* criaArvore(string expressao, int *i);


private:
	void percorreEmOrdemRecursivo(std::list<T*>* lista);
};

template <class T>
NodoBinario<T>::NodoBinario(T* info, NodoBinario<T>* filhoEsquerda,
		NodoBinario<T>* filhoDireita) {
	this->info = info;
/*	if (info != NULL)
		std::cout << "info construtor: " << *this->info << "\n";*/
	this->filhoEsquerda = filhoEsquerda;
	this->filhoDireita = filhoDireita;
}

template <class T>
NodoBinario<T>::NodoBinario(string expressao, int *i){
	criaArvore(expressao, i);
}

template <class T>
void NodoBinario<T>::alterarFilhoEsquerda(NodoBinario<T>* filho) {
	this->filhoEsquerda = filho;
}

template <class T>
void NodoBinario<T>::alterarFilhoDireita(NodoBinario<T>* filho) {
	this->filhoDireita = filho;
}

template <class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoEsquerda() {
	return this->filhoEsquerda;
}

template <class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoDireita() {
	return this->filhoDireita;
}

template <class T>
T* NodoBinario<T>::obterInfo() {
/*	if (this->info != NULL)
		std::cout << "obter info: " << *this->info << "\n";*/
	return this->info;
}

template <class T>
void NodoBinario<T>::percorrePreOrdemRecursivo(std::list<T*>* lista) {
	lista->push_back(this->info);
	if(filhoEsquerda != NULL)
		percorrePreOrdemRecursivo(lista);
	if(filhoDireita != NULL)
		percorrePreOrdemRecursivo(lista);
}

template <class T>
void NodoBinario<T>::percorreEmOrdemRecursivo(std::list<T*>* lista){
	if(filhoEsquerda != NULL)
		filhoEsquerda->percorreEmOrdemRecursivo(lista);
	lista->push_back(this->info);
	if(filhoDireita != NULL)
		filhoDireita->percorreEmOrdemRecursivo(lista);
}

template <class T>
std::list<T*>* NodoBinario<T>::percorreEmOrdemRecursivo(){
	std::list<T*>* lista = new list<T*>();

	percorreEmOrdemRecursivo(lista);

	return lista;
}

template <class T>
void NodoBinario<T>::percorrePosOrdemRecursivo(std::list<T*>* lista){
	if(filhoEsquerda != NULL)
		percorrePosOrdemRecursivo(lista);
	if(filhoDireita != NULL)
		percorrePosOrdemRecursivo(lista);
	lista->push_back(info);
}

//TODO: criaArvore deveria ser estático
template <class T>
NodoBinario<char>* NodoBinario<T>::criaArvore(string expressao, int *i) {
	char t = expressao[*i];
	std::cout << "t: " << t << "\n";
	(*i)++;

	info = new char(t);

	if (obterInfo() != NULL)
			std::cout << "info1 : " << *obterInfo() << "\n";

	if (t == '+' || t == '-' || t == '*' || t == '/') {
		filhoEsquerda = new NodoBinario<char>(expressao, i);
		filhoDireita = new NodoBinario<char>(expressao, i);
	} else {
		filhoEsquerda = NULL;
		filhoDireita = NULL;
	}

	if (obterInfo() != NULL)
		std::cout << "info2 : " << *obterInfo() << "\n";

	return this;
}

template <class T>
NodoBinario<T>::~NodoBinario() {
}

#endif /* NODOBINARIO_H_ */
