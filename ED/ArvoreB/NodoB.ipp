#include "Estruturas/ListaEncadeada.h"

template<class T> NodoB<T>::NodoB(int ordem) {
	numChaves = 0;
	folha = true;
	int maxFilhos = 2 * ordem;
	infos = new T*[maxFilhos - 1];
	filhos = new NodoB*[maxFilhos];

	for (int i = 0; i < maxFilhos - 1; i++) {
		infos[i] = NULL;
		filhos[i] = NULL;
	}
	filhos[maxFilhos - 1] = NULL;
}

template<class T> NodoB<T>::~NodoB() {
}

template<class T> NodoB<T>* NodoB<T>::insere(const T& tipo) {
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

template<class T> void NodoB<T>::insereFolha(const T& tipo) {
	if (nodoCheio() || !folha)
		return;

	folha = false;
	int i = 0;

}

template<class T> NodoB<T>* NodoB<T>::selecionaRamoDescida(const T& tipo) {

}

template<class T> NodoB<T>* NodoB<T>::divideNodo() {

}

template<class T> void NodoB<T>::atualizaAltura() {

}

template<class T> void NodoB<T>::atualizaQtdElementos() {

}

template<class T> bool NodoB<T>::nodoCheio() {

}

template<class T> int NodoB<T>::retornaNumeroDeElementos() {

}

template<class T> int NodoB<T>::retornaAltura() {

}

template<class T> void NodoB<T>::retornaPrefixada(ListaEncadeada<T>* lista) {

}

template<class T> void NodoB<T>::retornaInfixada(ListaEncadeada<T>* lista) {

}

template<class T> void NodoB<T>::retornaPosfixada(ListaEncadeada<T>* lista) {

}

template<class T> std::string NodoB<T>::retornaPrefixada() {

}

template<class T> std::string NodoB<T>::retornaInfixada() {

}

template<class T> std::string NodoB<T>::retornaPosfixada() {

}
