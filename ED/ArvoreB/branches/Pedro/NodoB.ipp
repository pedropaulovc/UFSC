#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>

template<class T> NodoB<T>::NodoB(int ordem) {
	this->ordem = ordem;
	numChavesNodo = 0;
	totalChaves = 0;
	altura = 0;
	folha = true;
	raiz = true;
	infos = new ListaEncadeada<const T> ();
	filhos = new ListaEncadeada<NodoB<T> > ();
}

template<class T> NodoB<T>::~NodoB() {
}

template<class T> NodoB<T>* NodoB<T>::insere(T const &tipo) {
	NodoB<T>* filho = NULL;
	NodoB<T>* novaRaiz = this;

	if (folha) {
		insereFolha(tipo);
	} else {
		filho = selecionaRamoDescida(tipo);
		filho->insere(tipo);

		if (filho->nodoCheio())
			divideNodo(this, filho);
	}

	if (raiz && nodoCheio()) {
		novaRaiz = new NodoB<T> (ordem);
		divideNodo(novaRaiz, this);
	}

	novaRaiz->atualizaAltura();
	novaRaiz->atualizaQtdElementos();

	return novaRaiz;
}

template<class T> void NodoB<T>::insereFolha(T const &tipo) {
	if (nodoCheio() || !folha)
		return;

	infos->adicionarEmOrdem(&tipo);

	numChavesNodo++;
	totalChaves++;
}

template<class T> NodoB<T>* NodoB<T>::selecionaRamoDescida(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;
		infoAtual = infos->obterDaPosicao(i);
	}

	return filhos->obterDaPosicao(i);
}

template<class T> void NodoB<T>::moverChavesMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int & limite) {
	ListaEncadeada<const T> *chavesOrigem = origem->infos;
	ListaEncadeada<const T> *chavesDestino = destino->infos;
	const T *chaveAtual = chavesOrigem->obterDoInicio();
	int i = 1;
	while (i < limite) {
		chavesOrigem->removerDoInicio();
		chavesDestino->adicionarEmOrdem(chaveAtual);
		i++;
		chaveAtual = chavesOrigem->obterDoInicio();
	}
}

template<class T> void NodoB<T>::moverRamosMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int limite) {
	ListaEncadeada<NodoB<T> > *ramosOrigem = origem->filhos;
	ListaEncadeada<NodoB<T> > *ramosDestino = destino->filhos;
	NodoB<T> *ramoAtual = ramosOrigem->obterDoInicio();
	int i = 1;
	while (i <= limite && ramoAtual != NULL) {
		ramosOrigem->removerDoInicio();
		ramosDestino->adicionarNaPosicao(ramoAtual, i);
		i++;
		ramoAtual = ramosOrigem->obterDoInicio();
	}
}

template<class T> void NodoB<T>::divideNodo(NodoB<T>* raiz, NodoB<T>* filho) {
	if (!filho->nodoCheio())
		return;

	int nodoMeio = ordem + 1;
	const T* infoSobe = filho->infos->removerDaPosicao(nodoMeio);
	NodoB<T>* outroFilho = new NodoB<T> (ordem);

	moverChavesMenores(filho, outroFilho, nodoMeio);

	moverRamosMenores(filho, outroFilho, nodoMeio);

	filho->atualizaQtdElementos();
	filho->atualizaAltura();
	filho->raiz = false;
	outroFilho->atualizaQtdElementos();
	outroFilho->atualizaAltura();
	outroFilho->raiz = false;

	int posicaoNovoFilho = raiz->encontrarPosicaoNovoNodo(*infoSobe);
	raiz->infos->adicionarEmOrdem(infoSobe);
	raiz->numChavesNodo++;
	raiz->filhos->adicionarNaPosicao(outroFilho, posicaoNovoFilho);

	if (raiz->filhos->obterDaPosicao(posicaoNovoFilho + 1) != filho)
		raiz->filhos->adicionarNaPosicao(filho, posicaoNovoFilho + 1);

	raiz->folha = false;
}

template<class T> int NodoB<T>::encontrarPosicaoNovoNodo(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;
		infoAtual = infos->obterDaPosicao(i);
	}

	return i;
}

template<class T> void NodoB<T>::atualizaAltura() {
	int i = 1;
	int maxAltura = -1;
	int alturaFilho;
	while (i <= filhos->obterTamanho()) {
		alturaFilho = filhos->obterDaPosicao(i)->retornaAltura();
		if (alturaFilho > maxAltura)
			maxAltura = alturaFilho;
		i++;
	}

	if (maxAltura == -1)
		altura = 0;
	else
		altura = maxAltura + 1;
}

template<class T> void NodoB<T>::atualizaQtdElementos() {
	int i = 1;
	int totalSubarvores = 0;
	while (i <= filhos->obterTamanho()) {
		totalSubarvores
				+= filhos->obterDaPosicao(i)->retornaNumeroDeElementos();
		i++;
	}
	numChavesNodo = infos->obterTamanho();
	totalChaves = totalSubarvores + infos->obterTamanho();
}

template<class T> bool NodoB<T>::nodoCheio() {
	return numChavesNodo == 2 * ordem + 1;
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

	const T* infoAtual = infos->obterDoInicio();

	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);
	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaPrefixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaPrefixada(lista);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaPrefixada(lista);
		i++;
	}

}

template<class T> void NodoB<T>::retornaInfixada(ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	const T* infoAtual = infos->obterDoInicio();

	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaInfixada(lista);
	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaInfixada(lista);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaInfixada(lista);
		i++;
	}
}

template<class T> void NodoB<T>::retornaPosfixada(
		ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	const T* infoAtual = infos->obterDoInicio();

	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaPosfixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaPosfixada(lista);
	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaPosfixada(lista);
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		i++;
	}
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
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaInfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

template<class T> std::string NodoB<T>::retornaPosfixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPosfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}
