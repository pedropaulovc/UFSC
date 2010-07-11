/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de um nodo binário, que é composto por um ponteiro para o campo de informações,
 e dois ponteiros para dois filhos distintos. Esses métodos são implementados em NodoBinario.ipp.
*/

#ifndef NODOBINARIO_H_
#define NODOBINARIO_H_

#include <cstdlib>
#include "../ListaEncadeada/ListaEncadeada.h"

using namespace std;

template<class T>
class NodoBinario {
private:
	NodoBinario<T>* filhoEsquerda;
	NodoBinario<T>* filhoDireita;
	T* info;

public:
	NodoBinario(T* info, NodoBinario<T>* filhoEsquerda = NULL,
			NodoBinario<T>* filhoDireita = NULL);
	virtual ~NodoBinario();

	void alterarFilhoEsquerda(NodoBinario<T>* filho);
	void alterarFilhoDireita(NodoBinario<T>* filho);
	void alterarInfo(T* info);

	NodoBinario<T>* obterFilhoEsquerda();
	NodoBinario<T>* obterFilhoDireita();
	T* obterInfo();

	T* buscar(T* outro);

	ListaEncadeada<T>* percorrePreOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
	ListaEncadeada<T>* percorreEmOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
	ListaEncadeada<T>* percorrePosOrdemRecursivo(ListaEncadeada<T>* lista = NULL);
};

#include "NodoBinario.ipp"

#endif /* NODOBINARIO_H_ */
