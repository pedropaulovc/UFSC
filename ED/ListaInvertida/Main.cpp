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

	Portaria **portarias = Indexador::importarArquivoDados("./PadraoPortarias.dat",
			&tamanhoArquivo);

	cout << tamanhoArquivo << endl;
	for (int i = 0; i < tamanhoArquivo; i++) {
		cout << "====================" << endl;
		cout << portarias[i]->obterPosicaoArquivo() << endl;
		cout << portarias[i]->obterNome() << endl;
	}

	cout << "+++++++++++++++++++" << endl;

	ListaEncadeada<PortariaSerializada>* portariasSerializadas =
			Indexador::gerarArquivoChavesPrimarias("./havesPrimarias.dat",
					portarias, tamanhoArquivo);
//	cout << portariasSerializadas->obterTamanho() << endl;
//
//	for (int i = 1; i <= portariasSerializadas->obterTamanho(); i++) {
//		PortariaSerializada* atual = portariasSerializadas->obterDaPosicao(i);
//		cout << atual->obterNome() << " | " << atual->obterPosicaoArquivo()
//				<< " | " << atual->obterFilhoEsquerda() << " | "
//				<< atual->obterFilhoDireita() << " | " << atual->obterAltura()
//				<< endl;
//	}
}

