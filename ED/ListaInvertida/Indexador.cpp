/*
 * Indexador.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#include "Indexador.h"
#include <string>
#include <sstream>
#include <fstream>
#include <cstdlib>

using namespace std;

Indexador::Indexador() {
}

Indexador::~Indexador() {
}

Portaria** Indexador::importarArquivoDados(string caminho, int *tamanhoArquivo) {
	string chave, texto;
	Portaria **portarias;

	ifstream myfile(caminho.c_str());

	if (myfile.is_open()) {
		getline(myfile, chave);
		*tamanhoArquivo = atoi(chave.c_str());
		portarias = new Portaria*[*tamanhoArquivo];

		for (int i = 0; i < *tamanhoArquivo; i++) {
			getline(myfile, chave, delimitador);
			getline(myfile, texto, delimitador);
			portarias[i] = new Portaria(chave, texto, i);
		}

		myfile.close();
		return portarias;
	}
	*tamanhoArquivo = 0;
	return NULL;
}

