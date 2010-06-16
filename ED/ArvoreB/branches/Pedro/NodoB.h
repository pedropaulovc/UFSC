/**
 TÍTULO:        Implementação de árvores multivias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore B.

 FUNCIONAMENTO GERAL:
 Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
 de uma árvore multivias semibalanceada. A estrutura de dados aceita comandos de inserção, exclusão e
 percurso de maneira prefixada, infixada e posfixada. Como demonstração de funcionamento foi implementado
 um sistema que recebe um arquivo de CEPs fora de ordem e plota o gráfico com o tempo para operar
 nos nodos da árvore. Além disso, foram gerados testes unitários que garantem o funcionamento esperado
 da estrutura de dados.

 SOBRE ESSE ARQUIVO:
 Declaração dos métodos públicos e privados além dos atributos de um NodoB a serem implementados
 em NodoB.ipp.
*/

#ifndef NODOB_H_
#define NODOB_H_

#include <string>
#include "Estruturas/ListaEncadeada.h"

template<class T>
class NodoB {

private:
	ListaEncadeada<const T>* infos;
	ListaEncadeada<NodoB<T> >* filhos;
	int numChavesNodo;
	int totalChaves;
	int altura;
	int ordem;
	bool folha;
	bool raiz;

	void divideNodo(NodoB<T>* raiz, NodoB<T>* filho);
	int posicaoRamoDescida(T const &tipo);

	void atualizaAltura();
	void atualizaQtdElementos();
	void atualizaElemento();

	void insereFolha(const T & tipo);

	void moverChavesMenores(NodoB<T> *& origem, NodoB<T> *& destino, int & numChaves);
	void moverRamosMenores(NodoB<T> *& origem, NodoB<T> *& destino, int numRamos);

	void removeDoNodo(const T & tipo);
	void removeDoNodoInterno(const T & tipo);
	NodoB<T>* ajustaFilhoAposRemocao(const T & tipo, NodoB<T> *filho);
	NodoB<T>* fundirNodosParaEsquerda(NodoB<T> *destino, NodoB<T>* origem, int & posicao);
	NodoB<T>* fundirNodosParaDireita(NodoB<T> *destino, NodoB<T>* origem, int posicao);

public:
	NodoB(int ordem);
	virtual ~NodoB();

	NodoB<T>* insere(T const &tipo);
	NodoB<T>* remove(T const &tipo);

	int retornaAltura();
	int retornaNumeroDeElementos();
	int retornaNumeroDeChaves();
	int retornaNumeroDeFilhos();

	void retornaPrefixada(ListaEncadeada<const T>* lista);
	void retornaPosfixada(ListaEncadeada<const T>* lista);
	void retornaInfixada(ListaEncadeada<const T>* lista);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	bool nodoCheio();
	bool nodoVazio();

};

#include "NodoB.ipp"

#endif /* NODOB_H_ */
