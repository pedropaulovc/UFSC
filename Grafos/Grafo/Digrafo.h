/*
 * Digrafo.h
 *
 *	INE5413 - Grafos
 *  Alunos: Pedro Paulo Vezzá Campos e Tarcisio Eduardo Moreira Crocomo
 *
 *  Sobre a classe: Contém as assinaturas dos métodos da estrutura básica
 *  de um digrafo.
 */

#ifndef DIGRAFO_H_
#define DIGRAFO_H_

#include <map>
#include <list>
#include <vector>
#include <algorithm>
using namespace std;
using namespace __gnu_cxx;

template <class T>
class Digrafo {
private:
	map<T const, list<T> > vertices;

public:
	Digrafo();
	virtual ~Digrafo();

	void adicionaVertice(T const &v);
	void removeVertice(T const &v);
	void conecta(T const &v1, T const &v2);
	void desconecta(T const &v1, T const &v2);

	int obterOrdem();
	vector<T> obterVertices();
	vector<T> obterSucessores(T const &v);
	vector<T> obterAntecessores(T const &v);
	T  obterVerticeAleatorio();

	int obterGrauEmissao(T const &v);
	int obterGrauRecepcao(T const &v);

};

#include "Digrafo.ipp"

#endif /* DIGRAFO_H_ */
