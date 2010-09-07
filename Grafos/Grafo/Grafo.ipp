#include <cstdlib>
#include <list>
#include <set>
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
	vector<T> clone = *(new vector<T> ());
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
	for (int i = 0; i < tam; i++) {
		if (obterGrau(vert[i]) != n)
			return false;
	}
	return true;
}

template<class T>
bool Grafo<T>::ehCompleto() {
	int n = obterOrdem() - 1;

	vector<T> vert = obterVertices();
	for (int i = 0; i < n + 1; i++) {
		if (obterGrau(vert[i]) != n)
			return false;
	}
	return true;
}

template<class T>
set<T> Grafo<T>::obterFechoTransitivo(T const &v) {
	set<T> vazio = *(new set<T> ());
	return procuraFechoTransitivo(v, vazio);
}

template<class T>
set<T> Grafo<T>::procuraFechoTransitivo(T const &v, set<T> &visitados) {
	set<T> ft = *(new set<T> ());
	visitados.insert(v);
	ft.insert(v);
	vector<T> adjacentes = obterAdjacentes(v);
	int nAdj = adjacentes.size();

	for (int i = 0; i < nAdj; i++) {
		if (visitados.find(adjacentes[i]) == visitados.end()) {
			set<T> fecho = procuraFechoTransitivo(adjacentes[i], visitados);
			ft.insert(fecho.begin(), fecho.end());
		}
	}
	return ft;
}

template<class T>
bool Grafo<T>::ehConexo() {
	vector<T> vertices = obterVertices();
	set<T> setVertices = *(new set<T> ());
	copy(vertices.begin(), vertices.end(), inserter(setVertices,
			setVertices.end()));
	return setVertices == obterFechoTransitivo(obterVerticeAleatorio());
}

template<class T>
bool Grafo<T>::ehArvore() {
	//T v = obterVerticeAleatorio();
	//set<T> visitados = *(new set<T>());
	//return ehConexo() && !haCicloCom(v, v, v, visitados);

	int numArestas = 0;
	for (typename map<T, list<T> >::iterator it = vertices.begin(); it
			!= vertices.end(); ++it) {
		numArestas += it->second.size();
	}
	numArestas /= 2;

	return ehConexo() && numArestas == obterOrdem() - 1;
}

//FIXME O Algoritmo não funciona ainda
template<class T>
bool Grafo<T>::haCicloCom(T const &v, T const &vAtual, T const &vAnterior, set<
		T> &visitados) {
	if (visitados.find(v) != visitados.end()) {
		return vAtual == v;
	}
	visitados.insert(vAtual);

	vector<T> adj = obterAdjacentes(v);
	int nAdj = adj.size();
	for (int i = 0; i < nAdj; i++) {
		T vAdj = adj[i];
		if (vAdj != vAnterior) {
			if (haCicloCom(v, vAdj, vAtual, visitados)) {
				return true;
			}
		}
	}
	visitados.erase(vAtual);
	return false;
}
