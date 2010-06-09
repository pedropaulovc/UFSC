#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>

template<class T> NodoB<T>::NodoB(int ordem) {
	this->ordem = ordem;
	numChavesNodo = 0;
	totalChaves = 0;
	altura = 0;
	folha = true;
	int maxFilhos = 2 * ordem;
	infos = new const T*[maxFilhos - 1];
	filhos = new NodoB*[maxFilhos];

	for (int i = 0; i < maxFilhos - 1; i++) {
		infos[i] = NULL;
		filhos[i] = NULL;
	}
	filhos[maxFilhos - 1] = NULL;
}

template<class T> NodoB<T>::~NodoB() {
}

template<class T> NodoB<T>* NodoB<T>::insere(T const &tipo) {
	NodoB<T>* filho;
	NodoB<T>* novaRaiz = this;

	if (folha) {
		insereFolha(tipo);
	} else {
		filho = selecionaRamoDescida(tipo);
		filho->insere(tipo);
	}

	if (nodoCheio())
		novaRaiz = divideNodo();

	atualizaAltura();
	atualizaQtdElementos();

	return novaRaiz;
}

template<class T> void NodoB<T>::insereFolha(T const &tipo) {
	const T* infoAtual = infos[0];
	if (nodoCheio() || !folha)
		return;

	int i = 0;
	while (infoAtual != NULL && tipo > *infoAtual) {
		i++;
		infoAtual = infos[i];
	}

	int posicaoAInserir = i;

	int posicaoAtual = numChavesNodo;
	while (posicaoAtual > posicaoAInserir) {
		infos[posicaoAtual] = infos[posicaoAtual - 1];
		posicaoAtual--;
	}

	infos[posicaoAInserir] = &tipo;

	numChavesNodo++;
	totalChaves++;
}

template<class T> NodoB<T>* NodoB<T>::selecionaRamoDescida(T const &tipo) {

}

template<class T> NodoB<T>* NodoB<T>::divideNodo() {

}

template<class T> void NodoB<T>::atualizaAltura() {
	int i = 0;
	int maxAltura = 0;
	int alturaFilho;
	while (filhos[i] != NULL) {
		alturaFilho = filhos[i]->retornaAltura();
		if (alturaFilho > maxAltura)
			maxAltura = alturaFilho;
		i++;
	}

	if (maxAltura == 0)
		altura = 0;
	else
		altura = maxAltura + 1;
}

template<class T> void NodoB<T>::atualizaQtdElementos() {
	int i = 0;
	int numElementosSubarvores = 0;
	while (filhos[i] != NULL) {
		numElementosSubarvores += filhos[i]->retornaNumeroDeElementos();
		i++;
	}

	totalChaves = numElementosSubarvores + numChavesNodo;
}

template<class T> bool NodoB<T>::nodoCheio() {
	return numChavesNodo == 2 * ordem - 1;
}

template<class T> bool NodoB<T>::nodoVazio() {
	return numChavesNodo == 0;
}

template<class T> int NodoB<T>::retornaNumeroDeElementos() {
	return totalChaves;
}

template<class T> int NodoB<T>::retornaAltura() {
	return altura;
}

template<class T> void NodoB<T>::retornaPrefixada(
		ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	lista->adicionarNoFim(infos[0]);
	if (filhos[0] != NULL)
		retornaPrefixada(lista);
	if (filhos[1] != NULL)
		retornaPrefixada(lista);

	int i = 1;
	while (infos[i] != NULL && i < 2 * ordem - 1) {
		lista->adicionarNoFim(infos[i]);
		if (filhos[i + 1] != NULL)
			retornaPrefixada(lista);
		i++;
	}

}

template<class T> void NodoB<T>::retornaInfixada(ListaEncadeada<T>* lista) {

}

template<class T> void NodoB<T>::retornaPosfixada(ListaEncadeada<T>* lista) {

}

template<class T> std::string NodoB<T>::retornaPrefixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPrefixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

template<class T> std::string NodoB<T>::retornaInfixada() {

}

template<class T> std::string NodoB<T>::retornaPosfixada() {

}
