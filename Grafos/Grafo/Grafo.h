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
using namespace std;
using namespace __gnu_cxx;

template <class T>
class Grafo {
private:
	map<T const, list<T> > vertices;

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
	bool obterFechoTransitivo(T const &v);
	bool ehConexo();
	bool ehArvore();

};

#include "Grafo.ipp"

#endif /* GRAFO_H_ */
