/*
 * Digrafo.h
 *
 *  Created on: Sep 4, 2010
 *      Author: pedropaulo
 */

#ifndef DIGRAFO_H_
#define DIGRAFO_H_

#include <map>
#include <list>
using namespace std;

template <class T>
class Digrafo {
private:
	map<T*, list<T*>*> vertices;

public:
	Digrafo();
	virtual ~Digrafo();

	void adicionaVertice(T* v);
	void removeVertice(T* v);
	void conecta(T* v1, T* v2);
	void desconecta(T* v1, T* v2);

	int obterOrdem();
	list<T*> obterVertices();
	list<T*> obterAdjacentes(T* v);
	T*  obterVerticeAleatorio();
	int obterGrau(T* v);

	bool ehRegular();
	bool ehCompleto();
	bool obterFechoTransitivo(T* v);
	bool ehConexo();
	bool ehArvore();

};

#include "Digrafo.ipp"

#endif /* DIGRAFO_H_ */
