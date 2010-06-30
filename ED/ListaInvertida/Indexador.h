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

class Indexador {

private:
	static const char delimitador = '\\';

public:
	Indexador();
	virtual ~Indexador();

	static Portaria** importarArquivoDados(string caminho, int *tamanhoArquivo);
	static void gerarArquivoChavesPrimarias(string caminho, Portaria **portarias, int numPortarias);
};

#endif /* INDEXADOR_H_ */
