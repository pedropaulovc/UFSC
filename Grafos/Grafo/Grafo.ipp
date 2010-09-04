#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <list>
#include "Grafo.h"

template<class T>
Grafo<T>::Grafo() {
	this->vertices = *(new map<T const, list<T> > ());
}

template<class T>
Grafo<T>::~Grafo() {
}

template<class T>
void Grafo<T>::adicionaVertice(T const &v) {
	list<T> lista = *(new list<T> ());
	this->vertices[v] = lista;
}

template<class T>
void Grafo<T>::removeVertice(T const &v) {
	this->vertices.erase(v);
}

template<class T>
void Grafo<T>::conecta(T const &v1, T const &v2) {
	this->vertices[v1].push_back(v2);
	this->vertices[v2].push_back(v1);
}

template<class T>
void Grafo<T>::desconecta(T const &v1, T const &v2) {
	this->vertices[v1].remove(v2);
	this->vertices[v2].remove(v1);
}

template<class T>
int Grafo<T>::obterOrdem() {
	return this->vertices.size();
}

template<class T>
vector<T> Grafo<T>::obterVertices() {
	vector<T> v = *(new vector<T> ());
	for (typename map<T, list<T> >::iterator it = vertices.begin(); it
			!= vertices.end(); ++it) {
		v.push_back(it->first);
	}
	return v;
}

template<class T>
T Grafo<T>::obterVerticeAleatorio() {
	vector<T> v = obterVertices();
	return v[rand() % v.size()];
}

template<class T>
vector<T> Grafo<T>::obterAdjacentes(T const &v) {
	vector<T> clone = *(new vector<T>());
	copy(vertices[v].begin(), vertices[v].end(), back_inserter(clone));
	return clone;
}

template<class T>
int Grafo<T>::obterGrau(T const &v) {
	return this->vertices[v].size();
}

template<class T>
bool Grafo<T>::ehRegular() {
	int n = obterGrau(obterVerticeAleatorio());
	int tam = obterOrdem();

	vector<T> vert = obterVertices();
	for(int i = 0; i < tam; i++){
		if(obterGrau(vert[i]) != n)
			return false;
	}
	return true;
}

template<class T>
bool Grafo<T>::ehCompleto() {
	return 0;
}

template<class T>
bool Grafo<T>::obterFechoTransitivo(T const &v) {
	return 0;
}

template<class T>
bool Grafo<T>::ehConexo() {
	return 0;
}

template<class T>
bool Grafo<T>::ehArvore() {
	return 0;
}
