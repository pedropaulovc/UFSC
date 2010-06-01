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

	NodoAVL<TipoInfo>* insere(const TipoInfo& tipo);
	NodoAVL<TipoInfo>* remove(const TipoInfo& tipo);

	std::string retornaPrefixada(std::string string);
	std::string retornaPosfixada(std::string string);
	std::string retornaInfixada(std::string string);

	int retornaAltura();
	int retornaAlturaDireita();
	int retornaAlturaEsquerda();

	int retornaNumeroDeElementos();
	int retornaNumeroDeElementosDireita();
	int retornaNumeroDeElementosEsquerda();

	int retornaFatorDesbalanceamento();
	void atualizaAltura();

	NodoAVL<TipoInfo>* rotacaoDireita();
	NodoAVL<TipoInfo>* rotacaoEsquerda();
	NodoAVL<TipoInfo>* rotacaoDuplaDireita();
	NodoAVL<TipoInfo>* rotacaoDuplaEsquerda();

	NodoAVL<TipoInfo>* obterEsquerda();
	NodoAVL<TipoInfo>* obterDireita();

	void alterarEsquerda(NodoAVL<TipoInfo>* nodo);
	void alterarDireita(NodoAVL<TipoInfo>* nodo);
	void alterarAltura(int altura);

	NodoAVL<TipoInfo>* menor();
	NodoAVL<TipoInfo>* maior();

private:
	NodoAVL<TipoInfo>* verificaCondicaoAVL();
};

#include "arvore_avl.ipp"

#endif
