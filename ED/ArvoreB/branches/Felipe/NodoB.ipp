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
	if (folha)
		return this;

	for (int i = 0; i < (numChavesNodo); i++)
		if (tipo < *infos[i])
			return filhos[i]->selecionaRamoDescida(tipo);

	return filhos[numChavesNodo - 1];
}

template<class T> NodoB<T>* NodoB<T>::divideNodo() {
	NodoB<T>* nodoEsquerda = new NodoB<T> (ordem);
	NodoB<T>* nodoDireita = new NodoB<T> (ordem);

	// Cria um nodo com os filhos à esquerda da chave do meio do pai
	for (int i = 0; i < ordem - 1; i++)
		nodoEsquerda->insere(*infos[i]);

	// Cria um nodo com os filhos à direita da chave do meio do pai
	for (int i = ordem; i < (2 * ordem - 1); i++)
		nodoDireita->insere(*infos[i]);

	// Coloca a chave do meio na primeira posição e anula o resto
	infos[0] = infos[ordem - 1];
	for (int i = 1; i < (2 * ordem - 1); i++)
		infos[i] = NULL;

	filhos[0] = nodoEsquerda;
	filhos[1] = nodoDireita;

	// Anula os outros filhos
	for (int i = 2; i < (2 * ordem - 1); i++)
		filhos[i] = NULL;

	numChavesNodo = 1;
	folha = false;

	atualizaAltura();
	atualizaQtdElementos();

	return this;
}

template<class T> void NodoB<T>::atualizaAltura() {
	if (folha) {
		altura = 0;
		return;
	}

	int i = 0;
	int maxAltura = 0;
	int alturaFilho;
	while (filhos[i] != NULL) {
		alturaFilho = filhos[i]->retornaAltura();
		if (alturaFilho > maxAltura)
			maxAltura = alturaFilho;
		i++;
	}

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

template<class T> int NodoB<T>::retornaNumeroDeChaves(){
	return numChavesNodo;
}

template<class T> int NodoB<T>::retornaNumeroDeElementos() {
	return totalChaves;
}

template<class T> int NodoB<T>::retornaAltura() {
	return altura;
}

template<class T> void NodoB<T>::retornaPrefixada(
		ListaEncadeada<const T>* lista) {

	lista->adicionarNoFim(infos[0]);

	if (filhos[0] != NULL)
		filhos[0]->retornaPrefixada(lista);
	if (filhos[1] != NULL)
		filhos[1]->retornaPrefixada(lista);

	int i = 1;
	while (infos[i] != NULL && i < 2 * ordem - 1) {
		lista->adicionarNoFim(infos[i]);
		if (filhos[i + 1] != NULL)
			retornaPrefixada(lista);
		i++;
	}
}

template<class T> void NodoB<T>::retornaInfixada(ListaEncadeada<const T>* lista) {
	if (filhos[0] != NULL)
		filhos[0]->retornaInfixada(lista);

	lista->adicionarNoFim(infos[0]);

	if (filhos[1] != NULL)
		filhos[1]->retornaInfixada(lista);

	int i = 1;
	while (infos[i] != NULL && i < 2 * ordem - 1) {
		if (filhos[i + 1] != NULL)
			retornaInfixada(lista);
		lista->adicionarNoFim(infos[i]);
		i++;
	}
}

template<class T> void NodoB<T>::retornaPosfixada(ListaEncadeada<const T>* lista) {

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

}
