/*
 * Digrafo.ipp
 *
 *  Created on: Sep 4, 2010
 *      Author: pedropaulo
 */

#ifndef DIGRAFO_IPP_
#define DIGRAFO_IPP_

#include "Digrafo.h"

template<class T>
Digrafo<T>::Digrafo() {
	this->vertices = *(new map<T const, list<T> > ());
}

template<class T>
Digrafo<T>::~Digrafo() {
}

template<class T>
void Digrafo<T>::adicionaVertice(T const &v) {
	list < T > lista = *(new list<T> ());
	this->vertices[v] = lista;
}

template<class T>
void Digrafo<T>::removeVertice(T const &v) {
	this->vertices.erase(v);
}

template<class T>
void Digrafo<T>::conecta(T const &v1, T const &v2) {
	this->vertices[v1].push_back(v2);
}

template<class T>
void Digrafo<T>::desconecta(T const &v1, T const &v2) {
	this->vertices[v1].remove(v2);
}

template<class T>
int Digrafo<T>::obterOrdem() {
	return this->vertices.size();
}

template<class T>
vector<T> Digrafo<T>::obterVertices() {
	vector < T > v = *(new vector<T> ());
	for (typename map<T, list<T> >::iterator it = vertices.begin(); it
			!= vertices.end(); ++it) {
		v.push_back(it->first);
	}
	return v;
}

template<class T>
T Digrafo<T>::obterVerticeAleatorio() {
	vector < T > v = obterVertices();
	return v[rand() % v.size()];
}

template<class T>
vector<T> Digrafo<T>::obterSucessores(T const &v) {
	vector < T > sucessores = *(new vector<T> ());
	copy(vertices[v].begin(), vertices[v].end(), back_inserter(sucessores));
	return sucessores;
}

template<class T>
vector<T> Digrafo<T>::obterAntecessores(T const &v) {
	vector<T> antecessores = *(new vector<T> ());
	list<T> sucessores;

	for (typename map<T, list<T> >::iterator it = vertices.begin(); it
			!= vertices.end(); ++it) {
		sucessores = it->second;
		if(find(sucessores.begin(), sucessores.end(), v) != sucessores.end()){
			antecessores.push_back(it->first);
		}
	}

	return antecessores;
}

template<class T>
int Digrafo<T>::obterGrauEmissao(T const &v) {
	return obterSucessores(v).size();
}

template<class T>
int Digrafo<T>::obterGrauRecepcao(T const &v) {
	return obterAntecessores(v).size();
}

#endif /* DIGRAFO_IPP_ */
