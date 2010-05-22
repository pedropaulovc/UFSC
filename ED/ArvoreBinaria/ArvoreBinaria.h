/*
 * ArvoreBinaria.h
 *
 *  Created on: May 22, 2010
 *      Author: pedropaulo
 */

#ifndef ARVOREBINARIA_H_
#define ARVOREBINARIA_H_

#include "NodoBinario.h"
#include <string>

using namespace std;

template<class T>
class ArvoreBinaria {
	NodoBinario<T>* raiz;


public:
	ArvoreBinaria();
	virtual ~ArvoreBinaria();

	void percorrePreOrdemRecursivo();
	void percorreEmOrdemRecursivo();
	void percorrePosOrdemRecursivo();

	void percorrePreOrdemIterativo();
	void percorreEmOrdemIterativo();
	void percorrePosOrdemIterativo();

	NodoBinario<T>* criaArvore(String expressao);
};

template <class T>
ArvoreBinaria<T> :: ArvoreBinaria() {
	this->raiz = new NodoBinario<T>(NULL, NULL);
}

/*
 * tNodo* FUNÇÃO criaÁrvore(expressão)
// Operando / operador atual na expressão.
caracter t;
// Novo nodo da árvore.
tNodo *novoNodo;

início
t <- expressão[i];
i <- i + 1;
novoNodo <- aloque(tNodo);
novoNodo->info <- t;
Se (t = '+' OU t = '-' OU t = '*' OU t = '/') Então
novoNodo->filhoÀEsquerda <- criaÁrvore(expressão);
novoNodo->filhoÀDireita <- criaÁrvore(expressão);
Senão
novoNodo->filhoÀEsquerda <- NULO;
novoNodo->filhoÀDireita <- NULO;
Fim Se
retorna novoNodo;
fim
 */

template <class T>
NodoBinario<T>* ArvoreBinaria<T> :: criaArvore(std::String expressao){
	ǸodoBinario<T>* novoNodo;



}

#endif /* ARVOREBINARIA_H_ */
