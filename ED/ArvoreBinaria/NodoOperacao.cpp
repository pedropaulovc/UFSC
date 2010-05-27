/*
 * NodoOperacao.cpp
 *
 *  Created on: May 26, 2010
 *      Author: pedropaulovc
 */

#include <string>
#include <cstdlib>
#include "NodoOperacao.h"


NodoOperacao::NodoOperacao(string expressao, int *i):NodoBinario<char>(NULL, NULL, NULL){
	criaArvore(expressao, i);
}

NodoOperacao::~NodoOperacao(){
}

NodoOperacao* NodoOperacao::criaArvore(string expressao, int *i) {
	char t = expressao[*i];
	(*i)++;

	alterarInfo(new char(t));

	if (t == '+' || t == '-' || t == '*' || t == '/') {
		alterarFilhoEsquerda(new NodoOperacao(expressao, i));
		alterarFilhoDireita(new NodoOperacao(expressao, i));
	}

	return this;
}
