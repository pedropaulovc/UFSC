/*
 * Indexador.h
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#ifndef INDEXADOR_H_
#define INDEXADOR_H_

#include <string>
#include "../Portarias/Portaria.h"
#include "../Estruturas/ListaEncadeada/ListaEncadeada.h"

class Indexador {
public:
	static Portaria** importarArquivoDados(string caminho, int *tamanhoArquivo);
	static ListaEncadeada<string>* tokenizar(string linha);

};
static const string arquivoIndices = "ChavesSecundarias.ndx";
static const string extensao = ".ndx";
static const char delimitador = '|';
#endif /* INDEXADOR_H_ */
