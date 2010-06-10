#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>

template<class U> NodoB<U>::NodoB(int ordem) {
	this->ordem = ordem;
	numChavesNodo = 0;
	totalChaves = 0;
	altura = 0;
	folha = true;
	raiz = true;
	infos = new ListaEncadeada<const U> ();
	filhos = new ListaEncadeada<NodoDef > ();
}

template<class U> NodoB<U>::~NodoB() {
}

template<class U> NodoB<U>* NodoB<U>::insere(U const &tipo) {
	NodoB<U>* filho = NULL;
	NodoB<U>* novaRaiz = this;

	if (folha) {
		insereFolha(tipo);
	} else {
		filho = selecionaRamoDescida(tipo);
		filho->insere(tipo);
	}

	if (filho != NULL && filho->nodoCheio())
		divideNodo(this, filho);

	if (raiz && nodoCheio()) {
		novaRaiz = new NodoB<U> (ordem);
		divideNodo(novaRaiz, this);
	}

	novaRaiz->atualizaAltura();
	novaRaiz->atualizaQtdElementos();

	return novaRaiz;
}

template<class U> void NodoB<U>::insereFolha(U const &tipo) {
	if (nodoCheio() || !folha)
		return;

	infos->adicionarEmOrdem(&tipo);

	numChavesNodo++;
	totalChaves++;
}

template<class U> NodoB<U>* NodoB<U>::selecionaRamoDescida(U const &tipo) {
	const U* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;
		infoAtual = infos->obterDaPosicao(i);
	}

	return filhos->obterDaPosicao(i);
}

template<class U> void NodoB<U>::divideNodo(NodoB<U>* raiz, NodoB<U>* filho) {
	if (!filho->nodoCheio())
		return;

	int nodoMeio = (2 * ordem + 1) / 2;
	const U* infoSobe = filho->infos->obterDaPosicao(nodoMeio);
	NodoB<U>* outroFilho = new NodoB<U> (ordem);

	const U* infoAtual;
	ListaEncadeada<const U>* chavesFilho = filho->infos;
	ListaEncadeada<const U>* chavesOutroFilho = outroFilho->infos;
	for (int i = 1; i < nodoMeio; i++) {
		infoAtual = chavesFilho->removerDaPosicao(i);
		chavesOutroFilho->adicionarEmOrdem(infoAtual);
	}

	NodoB<U>* filhoAtual;
	ListaEncadeada<NodoB<U> >* filhosDoFilho = filho->filhos;
	ListaEncadeada<NodoB<U> >* filhosDoOutroFilho = outroFilho->filhos;
	for (int i = 1; i <= nodoMeio + 1; i++) {
		filhoAtual = filhosDoFilho->removerDaPosicao(i);
		filhosDoOutroFilho->adicionarNaPosicao(filhoAtual, i);
	}

	filho->atualizaQtdElementos();
	outroFilho->atualizaQtdElementos();

	int posicaoNovoFilho = raiz->encontrarPosicaoNovoNodo(*infoSobe);
	raiz->infos->adicionarEmOrdem(infoSobe);
	raiz->filhos->adicionarNaPosicao(outroFilho, posicaoNovoFilho);

	if (raiz->filhos->obterDaPosicao(posicaoNovoFilho + 1) != filho)
		raiz->filhos->adicionarNaPosicao(filho, posicaoNovoFilho + 1);

	raiz->folha = false;
}

template<class U> int NodoB<U>::encontrarPosicaoNovoNodo(U const &tipo) {
	const U* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;
		infoAtual = infos->obterDaPosicao(i);
	}

	return i;
}

template<class U> void NodoB<U>::atualizaAltura() {
	int i = 1;
	int maxAltura = 0;
	int alturaFilho;
	while (i <= filhos->obterTamanho()) {
		alturaFilho = filhos->obterDaPosicao(i)->retornaAltura();
		if (alturaFilho > maxAltura)
			maxAltura = alturaFilho;
		i++;
	}

	if (maxAltura == 0)
		altura = 0;
	else
		altura = maxAltura + 1;
}

template<class U> void NodoB<U>::atualizaQtdElementos() {
	int i = 1;
	int numElementosSubarvores = 0;
	while (i <= filhos->obterTamanho()) {
		numElementosSubarvores
				+= filhos->obterDaPosicao(i)->retornaNumeroDeElementos();
		i++;
	}

	totalChaves = numElementosSubarvores + infos->obterTamanho();
}

template<class U> bool NodoB<U>::nodoCheio() {
	return numChavesNodo == 2 * ordem + 1;
}

template<class U> bool NodoB<U>::nodoVazio() {
	return numChavesNodo == 0;
}

template<class U> int NodoB<U>::retornaNumeroDeElementos() {
	return totalChaves;
}

template<class U> int NodoB<U>::retornaAltura() {
	return altura;
}

template<class U> void NodoB<U>::retornaPrefixada(
		ListaEncadeada<const U>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const U> ();

	lista->adicionarNoFim(infos->obterDoInicio());
	if (filhos->obterDoInicio() != NULL)
		retornaPrefixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		retornaPrefixada(lista);

	int i = 2;
	while (i <= numChavesNodo) {
		lista->adicionarNoFim(infos->obterDaPosicao(i));
		if (filhos->obterDaPosicao(i + 1) != NULL)
			retornaPrefixada(lista);
		i++;
	}

}

template<class U> void NodoB<U>::retornaInfixada(ListaEncadeada<U>* lista) {

}

template<class U> void NodoB<U>::retornaPosfixada(ListaEncadeada<U>* lista) {

}

template<class U> std::string NodoB<U>::retornaPrefixada() {
	ListaEncadeada<const U>* lista = new ListaEncadeada<const U> ();
	retornaPrefixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

template<class U> std::string NodoB<U>::retornaInfixada() {
	return "";
}

template<class U> std::string NodoB<U>::retornaPosfixada() {
	return "";
}
