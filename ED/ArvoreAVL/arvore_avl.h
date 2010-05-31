#ifndef ARVORE_AVL_H
#define ARVORE_AVL_H

#include <string>

template<class TipoInfo>
class NodoAVL {

private:

	TipoInfo info;
	NodoAVL *nodoEsquerda;
	NodoAVL *nodoDireita;
	int altura;
	int numElementos;

public:

	NodoAVL();
	~NodoAVL();

	void insere(const TipoInfo& tipo);
	void remove(const TipoInfo& tipo);

	std::string retornaPrefixada();
	std::string retornaPosfixada();
	std::string retornaInfixada();

	int retornaAltura();
	int retornaNumeroDeElementos();
	int retornaFatorDesbalanceamento();

	NodoAVL<TipoInfo>* rotacaoDireita(NodoAVL<TipoInfo>* raiz);
	NodoAVL<TipoInfo>* rotacaoEsquerda(NodoAVL<TipoInfo>* raiz);
	void rotacaoDuplaDireita();
	void rotacaoDuplaEsquerda();

	NodoAVL<TipoInfo>* obterEsquerda();
	NodoAVL<TipoInfo>* obterDireita();

	void alterarEsquerda(NodoAVL<TipoInfo>* nodo);
	void alterarDireita(NodoAVL<TipoInfo>* nodo);
	void alterarAltura(int altura);

private:
	void verificaCondicaoAVL();
};

#include "arvore_avl.ipp"

#endif
