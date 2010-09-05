/*
 * Grafo.h
 *
 *  Created on: Aug 26, 2010
 *      Author: pedropaulovc
 */

#ifndef GRAFO_H_
#define GRAFO_H_

#include <map>
#include <list>
#include <vector>
#include <set>
using namespace std;
using namespace __gnu_cxx;

template <class T>
class Grafo {
private:
	map<T const, list<T> > vertices;

	set<T> procuraFechoTransitivo(T const &v, set<T> &visitados);
	bool haCicloCom(T const &v, T const &vAtual, T const &vAnterior, set<T> &visitados);

public:
	Grafo();
	virtual ~Grafo();

	void adicionaVertice(T const &v);
	void removeVertice(T const &v);
	void conecta(T const &v1, T const &v2);
	void desconecta(T const &v1, T const &v2);

	int obterOrdem();
	vector<T> obterVertices();
	vector<T> obterAdjacentes(T const &v);
	T  obterVerticeAleatorio();
	int obterGrau(T const &v);

	bool ehRegular();
	bool ehCompleto();
	set<T> obterFechoTransitivo(T const &v);
	bool ehConexo();
	bool ehArvore();

};

#include "Grafo.ipp"

#endif /* GRAFO_H_ */
