/*
 * Indexador.h
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#ifndef INDEXADOR_H_
#define INDEXADOR_H_

#include <string>
#include "Estruturas/ListaEncadeada.h"

class Indexador {

public:
	Indexador();
	virtual ~Indexador();
	static void gerarArquivoDados(std::string diretorioBase,
			std::string arquivoDados);

//private:
	static ListaEncadeada<std::string> abrirDiretorio(std::string diretorioBase);
	static std::string codificarString(std::string string);
	static std::string decodificarString(std::string string);
};

#endif /* INDEXADOR_H_ */
