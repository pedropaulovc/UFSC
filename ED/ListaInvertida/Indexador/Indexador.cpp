/*
 * Indexador.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#include <string>
#include <sstream>
#include <fstream>
#include <cstdlib>

#include "Indexador.h"


using namespace std;

Portaria** Indexador::importarArquivoDados(string caminho, int *tamanhoArquivo) {
	string linha;
	Portaria **portarias;
	ListaEncadeada<string> *dados;

	ifstream myfile(caminho.c_str());

	if (myfile.is_open()) {
		getline(myfile, linha);
		*tamanhoArquivo = atoi(linha.c_str());
		portarias = new Portaria*[*tamanhoArquivo];

		for (int i = 0; i < *tamanhoArquivo; i++) {
			getline(myfile, linha);
			dados = tokenizar(linha);
			portarias[i] = new Portaria(*(dados->obterDoInicio()),
					*(dados->obterDaPosicao(2)), i);
			delete dados;
		}

		myfile.close();
		return portarias;
	}
	*tamanhoArquivo = 0;
	return NULL;
}

ListaEncadeada<string>* Indexador::tokenizar(string linha) {
	ListaEncadeada<string> *dados = new ListaEncadeada<string> ();

	string::size_type inicio = linha.find_first_not_of(delimitador, 0);
	string::size_type fim = linha.find_first_of(delimitador, inicio);

	while (fim != string::npos || inicio != string::npos) {
		dados->adicionarNoFim(new string(linha.substr(inicio, fim - inicio)));
		inicio = linha.find_first_not_of(delimitador, fim);
		fim = linha.find_first_of(delimitador, inicio);
	}

	return dados;
}

