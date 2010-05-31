#ifndef ARVORE_AVL_H
#define ARVORE_AVL_H

#include <string>
#include "../ArvoreBinaria/NodoBinario.h"

template<class TipoInfo>
class NodoAVL : public NodoBinario<TipoInfo> {

private:

	int altura;

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
};

#include "arvore_avl.ipp"

#endif
