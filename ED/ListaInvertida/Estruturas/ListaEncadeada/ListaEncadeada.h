/**
 TÍTULO:        Implementação de lista encadeada
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 lista encadeada.

 SOBRE O ARQUIVO:
 Elemento "container" de um dado a ser armazenado em uma lista encadeada.

 */

#ifndef LISTAENCADEADA_H_
#define LISTAENCADEADA_H_

#include "Elemento.h"
#include <cstdlib>

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

	bool contem(T* info);
	int posicao(T* info);

	ListaEncadeada<T>* intersecao(ListaEncadeada<T>* outraLista);
};

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Construtor da lista encadeada.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 ponteiro para a nova lista

 */
template<class T>
ListaEncadeada<T>::ListaEncadeada() {
	tamanho = 0;
	primeiro = NULL;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 destrutor da lista encadeada.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 */
template<class T>
ListaEncadeada<T>::~ListaEncadeada() {
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna verdadeiro se a lista está vazia e falso se não.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 valor booleano se a lista está vazia.

 */
template<class T>
bool ListaEncadeada<T>::listaVazia() {
	return tamanho == 0;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna o tamanho da lista encadeada

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o tamanho da lista encadeada.

 */
template<class T>
int ListaEncadeada<T>::obterTamanho() {
	return tamanho;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 adiciona um dado na primeira posição da lista encadeada.

 PARÂMETROS:
 o dado a ser armazenado.

 VALOR DE RETORNO:
 1 se a operação foi realizada.

 */
template<class T>
int ListaEncadeada<T>::adicionarNoInicio(T* info) {
	Elemento<T>* novoElemento = new Elemento<T> (info, primeiro);
	primeiro = novoElemento;
	tamanho++;
	return 1;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 adiciona um dado em uma posição arbitrária da lista encadeada.

 PARÂMETROS:
 a posição a ser inserida e o dado.

 VALOR DE RETORNO:
 1 em caso de sucesso ou -1 em caso de erro.

 */
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

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 adiciona um elemento na última posição da lista encadeada.

 PARÂMETROS:
 o dado a ser armazenado.

 VALOR DE RETORNO:
 1 em caso de sucesso ou -1 em caso de erro.

 */
template<class T>
int ListaEncadeada<T>::adicionarNoFim(T* info) {
	return adicionarNaPosicao(info, tamanho + 1);
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 adiciona um elemento segundo a ordem definida pelo tipo de dados que a lista encadeada armazena.

 PARÂMETROS:
 o dado a ser inserido.

 VALOR DE RETORNO:
 1 em caso de sucesso

 */
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

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna o primeiro elemento da lista ou NULL caso esteja vazia

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o primeiro elemento da lista ou NULL caso esteja vazia

 */
template<class T>
T* ListaEncadeada<T>::obterDoInicio() {
	if (listaVazia())
		return NULL;

	return primeiro->getInfo();
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna o último elemento da lista ou NULL caso esteja vazia

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o último elemento da lista ou NULL caso esteja vazia

 */
template<class T>
T* ListaEncadeada<T>::obterDoFim() {
	if (listaVazia())
		return NULL;

	return obterDaPosicao(tamanho);
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna um elemento de uma posição arbitrária da lista ou NULL caso a lista não contenha
 elemento nessa posição.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 um elemento de uma posição arbitrária da lista ou NULL caso a lista não contenha
 elemento nessa posição.

 */
template<class T>
T* ListaEncadeada<T>::obterDaPosicao(int posicao) {
	if (posicao > tamanho || posicao < 1)
		return NULL;
	if (posicao == 1)
		return obterDoInicio();

	Elemento<T>* atual = primeiro;
	int posicaoAtual = 1;
	while (posicaoAtual != posicao) {
		atual = atual->getProximo();
		posicaoAtual++;
	}

	return atual->getInfo();
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 remove um elemento da primeira posição da lista e o retorna, ou retorna NULL caso a lista esteja vazia.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o elemento removido ou NULL caso a lista esteja vazia.

 */
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

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 remove um elemento de posição arbitrária da lista e o retorna, ou retorna NULL caso a lista não
 contenha elemento nessa posição.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o elemento removido ou NULL caso a lista não contenha elemento nessa posição.

 */
template<class T>
T* ListaEncadeada<T>::removerDaPosicao(int posicao) {
	if (listaVazia())
		return NULL;
	if (posicao > tamanho || posicao < 1)
		return NULL;

	if (posicao == 1)
		return removerDoInicio();

	Elemento<T> *penultimoElemento, *ultimoElemento;
	int posicaoAtual = 1;

	ultimoElemento = primeiro;

	while (posicao != posicaoAtual && ultimoElemento->getProximo() != NULL) {
		penultimoElemento = ultimoElemento;
		ultimoElemento = ultimoElemento->getProximo();
		posicaoAtual++;
	}

	tamanho--;
	penultimoElemento->setProximo(ultimoElemento->getProximo());
	return ultimoElemento->getInfo();
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 remove um elemento da última posição da lista e o retorna, ou retorna NULL caso a lista esteja vazia.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 o elemento removido ou NULL caso a lista esteja vazia.

 */
template<class T>
T* ListaEncadeada<T>::removerDoFim() {
	return removerDaPosicao(tamanho);
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna um valor booleano informando se a lista encadeada contém referência para o valor
 fornecido via parâmetro

 PARÂMETROS:
 o valor a ser buscado

 VALOR DE RETORNO:
 verdadeiro caso a lista contenha o elemento, falso em caso contrário

 */
template<class T>
bool ListaEncadeada<T>::contem(T* info) {
	return posicao(info) != -1;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 retorna a posição do dado informado via parâmetro na lista encadeada ou -1 caso o
 elemento não esteja presente.

 PARÂMETROS:
 o valor a ter sua posição buscada

 VALOR DE RETORNO:
 a posição do dado ou -1 caso ele não pertença à lista.

 */
template<class T>
int ListaEncadeada<T>::posicao(T* info) {
	Elemento<T>* elemento = primeiro;

	for (int i = 1; i <= tamanho; i++) {
		if (*elemento->getInfo() == *info)
			return i;
		elemento = elemento->getProximo();
	}

	return -1;
}

template<class T>
ListaEncadeada<T>* ListaEncadeada<T>::intersecao(ListaEncadeada<T>* outraLista) {
	ListaEncadeada<T> *novaLista = new ListaEncadeada<T> ();
	T* elementoAtual;

	for(int i = 1; i <= this->tamanho; i++){
		elementoAtual = obterDaPosicao(i);
		if(outraLista->contem(elementoAtual))
			novaLista->adicionarNoInicio(elementoAtual);
	}

	return novaLista;
}

#endif /* LISTAENCADEADA_H_ */
