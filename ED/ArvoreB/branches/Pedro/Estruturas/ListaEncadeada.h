#ifndef LISTAENCADEADA_H_
#define LISTAENCADEADA_H_

#include "Elemento.h"
#include <cstdlib>

//TODO exceptions ou códigos de erro?

template<class T>

class ListaEncadeada {
	Elemento<T>* primeiro;
	int tamanho;

public:
	ListaEncadeada();
	virtual ~ListaEncadeada();

	bool listaVazia();
	int obterTamanho();

	int adicionarNoInicio(T* info);
	int adicionarNaPosicao(T* info, int posicao);
	int adicionarNoFim(T* info);
	int adicionarEmOrdem(T* info);

	T* removerDoInicio();
	T* removerDaPosicao(int posicao);
	T* removerDoFim();

	T* obterDoInicio();
	T* obterDaPosicao(int posicao);
	T* obterDoFim();
};

template<class T>
ListaEncadeada<T>::ListaEncadeada() {
	tamanho = 0;
	primeiro = NULL;
}

template<class T>
ListaEncadeada<T>::~ListaEncadeada() {
	for (int i = 0; i < tamanho; i++) {
		/*removerDoFim();*/
	}
}

template<class T>
bool ListaEncadeada<T>::listaVazia() {
	return tamanho == 0;
}

template<class T>
int ListaEncadeada<T>::obterTamanho() {
	return tamanho;
}

template<class T>
int ListaEncadeada<T>::adicionarNoInicio(T* info) {
	Elemento<T>* novoElemento = new Elemento<T> (info, primeiro);
	primeiro = novoElemento;
	tamanho++;
	return 1;
}

template<class T>
int ListaEncadeada<T>::adicionarNaPosicao(T* info, int posicao) {
	if (posicao > this->tamanho + 1 || posicao < 1)
		return -1; // ERRO POSICAO INVALIDA

	if (posicao == 1)
		return adicionarNoInicio(info);

	int posicaoAtual = 1;
	Elemento<T> *ultimoElementoObtido, *penultimoElementoObtido;
	ultimoElementoObtido = primeiro;

	while (posicaoAtual != posicao) {
		penultimoElementoObtido = ultimoElementoObtido;
		ultimoElementoObtido = ultimoElementoObtido->getProximo();
		posicaoAtual++;
	}

	Elemento<T>* novoElemento = new Elemento<T> (info, ultimoElementoObtido);
	penultimoElementoObtido->setProximo(novoElemento);

	tamanho++;

	return 1;
}

template<class T>
int ListaEncadeada<T>::adicionarNoFim(T* info) {
	return adicionarNaPosicao(info, tamanho + 1);
}

//TODO verificar logica
template<class T>
int ListaEncadeada<T>::adicionarEmOrdem(T* info) {
	if (listaVazia())
		return adicionarNoInicio(info);

	Elemento<T> *elementoAComparar = primeiro;

	int posicaoElemento = 1;

	while (elementoAComparar->getProximo() != NULL
			&& *elementoAComparar->getInfo() < *info) {
		elementoAComparar = elementoAComparar->getProximo();
		posicaoElemento++;
	}

	if (*info > *elementoAComparar->getInfo())
		return adicionarNaPosicao(info, posicaoElemento + 1);
	else
		return adicionarNaPosicao(info, posicaoElemento);
}

template<class T>
T* ListaEncadeada<T>::obterDoInicio() {
	if(tamanho > 0)
		return primeiro->getInfo();
	return NULL;
}

template<class T>
T* ListaEncadeada<T>::obterDoFim() {
	return obterDaPosicao(tamanho);
}

template<class T>
T* ListaEncadeada<T>::obterDaPosicao(int posicao) {

	if (posicao > tamanho || posicao < 1)
		return NULL;
	if (posicao == 1)
		return obterDoInicio();

	Elemento<T>* atual = primeiro;
	int posicaoAtual = 1;
	while(posicaoAtual != posicao){
		atual = atual->getProximo();
		posicaoAtual++;
	}

	return atual->getInfo();
}

template<class T>
T* ListaEncadeada<T>::removerDoInicio() {
	if (listaVazia())
		return NULL;

	Elemento<T>* aDeletar;
	aDeletar = this->primeiro;
	primeiro = aDeletar->getProximo();
	tamanho--;
	return aDeletar->getInfo();
}

template<class T>
T* ListaEncadeada<T>::removerDaPosicao(int posicao){
	if(listaVazia())
		return NULL;
	if(posicao > tamanho || posicao < 1)
		return NULL;

	if(posicao == 1)
		return removerDoInicio();

	Elemento<T> *penultimoElemento, *ultimoElemento;
	int posicaoAtual = 1;

	while(posicao != posicaoAtual){
		penultimoElemento = ultimoElemento;
		ultimoElemento = ultimoElemento->getProximo();
		posicaoAtual++;
	}

	penultimoElemento->setProximo(ultimoElemento->getProximo());
	return ultimoElemento->getInfo();
}

template<class T>
T* ListaEncadeada<T>::removerDoFim(){
	return removerDaPosicao(tamanho);
}

#endif /* LISTAENCADEADA_H_ */
