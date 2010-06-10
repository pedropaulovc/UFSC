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
	}

	if (filho != NULL && filho->nodoCheio())
		divideNodo(this, filho);

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

template<class T> void NodoB<T>::divideNodo(NodoB<T>* raiz, NodoB<T>* filho) {
	if (!filho->nodoCheio())
		return;

	int nodoMeio = ordem + 1;
	const T* infoSobe = filho->infos->removerDaPosicao(nodoMeio);
	NodoB<T>* outroFilho = new NodoB<T> (ordem);


	ListaEncadeada<const T>* chavesFilho = filho->infos;
	ListaEncadeada<const T>* chavesOutroFilho = outroFilho->infos;
	const T* infoAtual = chavesFilho->obterDoInicio();
	int i = 1;
	while(i < nodoMeio && infoAtual != NULL){
		chavesFilho->removerDoInicio();
		chavesOutroFilho->adicionarEmOrdem(infoAtual);
		i++;
		infoAtual = chavesFilho->obterDoInicio();
	}

	ListaEncadeada<NodoB<T> >* filhosDoFilho = filho->filhos;
	ListaEncadeada<NodoB<T> >* filhosDoOutroFilho = outroFilho->filhos;
	NodoB<T>* filhoAtual = filhosDoFilho->obterDoInicio();
	i = 1;
	while(i <= nodoMeio && filhoAtual != NULL){
		filhosDoOutroFilho->adicionarNaPosicao(filhoAtual, i);
		filhosDoFilho->removerDoInicio();
		i++;
		filhoAtual = filhosDoFilho->obterDoInicio();
	}

	filho->atualizaQtdElementos();
	filho->atualizaAltura();
	outroFilho->atualizaQtdElementos();
	outroFilho->atualizaAltura();

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
	int numElementosSubarvores = 0;
	while (i <= filhos->obterTamanho()) {
		numElementosSubarvores
				+= filhos->obterDaPosicao(i)->retornaNumeroDeElementos();
		i++;
	}
	numChavesNodo = infos->obterTamanho();
	totalChaves = numElementosSubarvores + infos->obterTamanho();
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

	if(infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);
	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaPrefixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaPrefixada(lista);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		infoAtual = infos->obterDaPosicao(i);
		if(infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		if (filhos->obterDaPosicao(i + 1) != NULL)
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
	return "";
}

template<class T> std::string NodoB<T>::retornaPosfixada() {
	return "";
}
