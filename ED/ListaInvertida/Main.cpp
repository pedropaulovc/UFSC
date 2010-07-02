/*
 * Main.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */
#include <iostream>
#include "Indexador.h"
#include "Portaria.h"

using namespace std;

int main(int argc, char **argv) {
	int tamanhoArquivo;

	Portaria **portarias = Indexador::importarArquivoDados("./Indices/PadraoPortarias.dat",
			&tamanhoArquivo);

	string palavrasChave[] =  {"Lorem", "Quisque", "elit"};
	Indexador::exportarChavesSecundarias("./Indices/" ,palavrasChave , 3, portarias, tamanhoArquivo);
}

