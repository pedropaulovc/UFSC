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
#include "Estruturas/ArvoreBinaria/NodoBinario.h"

class Indexador {

private:
	static const char delimitador = '|';
	static int serializarArvore(NodoAVL<Portaria> *arvore,
			PortariaSerializada **lista, int* posicaoVaga);
	static Portaria* gerarPortaria(string linha, int posicaoArquivoDados);

public:
	Indexador();
	virtual ~Indexador();

	static Portaria** importarArquivoDados(string caminho, int *tamanhoArquivo);
	static NodoBinario<Portaria> importarChavesPrimarias(string caminho);
	static void exportarChavesPrimarias(string caminho, Portaria **portarias,
			int numPortarias);
	static void exportarChavesSecundarias(string pasta, string *palavrasChave,
			int numPalavras, Portaria **portarias, int numPortarias);

};
static const string arquivoIndices = "ChavesSecundarias.ndx";
static const string extensao = ".ndx";
#endif /* INDEXADOR_H_ */
