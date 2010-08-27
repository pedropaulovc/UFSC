/*
 * Grafo.h
 *
 *  Created on: Aug 26, 2010
 *      Author: pedropaulovc
 */

#ifndef GRAFO_H_
#define GRAFO_H_

#include <hash_map>
#include <list>
using namespace std;
using namespace __gnu_cxx;
/*
	T é o tipo de aresta do grafo, eq é um objeto função
	que retorna se duas classes são iguais.
	Exemplo:
	struct eqstr{
	  bool operator()(const char* s1, const char* s2) const {
		return strcmp(s1,s2)==0;
	  }
	};
*/
template <class T, class eq>
class Grafo {
private:
	hash_map<T*, list<T*>, hash<T*>, eq> vertices;

public:
	Grafo();
	virtual ~Grafo();

	void adicionaVertice(T* v);
	void removeVertice(T* v);
	void conecta(T* v1, T* v2);
	void desconecta(T* v1, T* v2);

	int obterOrdem();
	T** obterVertices();
	T*  obterVerticeAleatorio();
	T** obterAdjacentes(T* v);
	int obterGrau(T* v);

	bool ehRegular();
	bool ehCompleto();
	bool obterFechoTransitivo(T* v);
	bool ehConexo();
	bool ehArvore();

};

#include "Grafo.ipp"

#endif /* GRAFO_H_ */
