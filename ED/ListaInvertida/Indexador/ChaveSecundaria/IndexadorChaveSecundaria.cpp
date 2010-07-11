/*
 * IndexadorChaveSecundaria.cpp
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#include "IndexadorChaveSecundaria.h"
#include <fstream>

void IndexadorChaveSecundaria::exportar(string pasta, string *palavrasChave,
		int numPalavras, Portaria **portarias, int numPortarias) {
	ofstream arquivo, arquivoIndice;
	string palavraAtual;

	arquivoIndice.open((pasta + arquivoIndices).c_str(), ios::trunc | ios::out);
	for (int i = 0; i < numPalavras; i++) {
		palavraAtual = palavrasChave[i];
		arquivoIndice << palavraAtual << delimitador << palavraAtual
				<< extensao << endl;
		arquivo.open((pasta + palavraAtual + extensao).c_str(), ios::trunc
				| ios::out);

		if (arquivo.fail())
			return;

		for (int i = 0; i < numPortarias; i++) {
			Portaria *portariaAtual = portarias[i];
			if (portariaAtual->obterTexto().find(palavraAtual) != string::npos)
				arquivo << portariaAtual->obterPosicaoArquivo() << delimitador;
		}
		arquivo.close();
	}
	arquivoIndice.close();
}
