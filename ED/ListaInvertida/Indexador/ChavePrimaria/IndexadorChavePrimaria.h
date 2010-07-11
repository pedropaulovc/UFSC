/*
 * IndexadorChavePrimaria.h
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#ifndef INDEXADORCHAVEPRIMARIA_H_
#define INDEXADORCHAVEPRIMARIA_H_

#include "../Indexador.h"
#include "../../Estruturas/ArvoreAVL/arvore_avl.h"
#include "../../Portarias/Portaria.h"
#include "../../Portarias/PortariaSerializada.h"
#include "../../Estruturas/ArvoreBinaria/NodoBinario.h"

class IndexadorChavePrimaria: public Indexador {
private:
	static int serializarArvore(NodoAVL<Portaria> *arvore,
			PortariaSerializada **lista, int* posicaoVaga);
	static NodoBinario<PortariaSerializada>* importarArvore(string *nodos,
			int numNodos, int nodoAtual = 0);

public:
	static NodoBinario<PortariaSerializada>* importar(string caminho);
	static void
	exportar(string caminho, Portaria **portarias, int numPortarias);
};

#endif /* INDEXADORCHAVEPRIMARIA_H_ */
