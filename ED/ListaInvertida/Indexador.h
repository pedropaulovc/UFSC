/*
 * Indexador.h
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#ifndef INDEXADOR_H_
#define INDEXADOR_H_

#include <string>
#include "Portaria.h"
#include "PortariaSerializada.h"
#include "Estruturas/ListaEncadeada/ListaEncadeada.h"
#include "Estruturas/ArvoreAVL/arvore_avl.h"

class Indexador {

private:
	static const char delimitador = '\\';
	static int exportar(NodoAVL<Portaria> *arvore, ListaEncadeada<PortariaSerializada> *lista);
	static int exportar2(NodoAVL<Portaria> *arvore, PortariaSerializada **lista, int* posicaoVaga);

public:
	Indexador();
	virtual ~Indexador();

	static Portaria** importarArquivoDados(string caminho, int *tamanhoArquivo);
	static ListaEncadeada<PortariaSerializada>* gerarArquivoChavesPrimarias(string caminho, Portaria **portarias, int numPortarias);

};

#endif /* INDEXADOR_H_ */
