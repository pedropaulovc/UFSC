/*
 * NodoOperacao.h
 *
 *  Created on: May 26, 2010
 *      Author: pedropaulovc
 */

#ifndef NODOOPERACAO_H_
#define NODOOPERACAO_H_

#include <string>
#include "NodoBinario.h"

class NodoOperacao : public NodoBinario<char> {
public:
	NodoOperacao(string expressao, int *i);
	virtual ~NodoOperacao();

private:
	NodoOperacao* criaArvore(string expressao, int *i);

};

#endif /* NODOOPERACAO_H_ */
