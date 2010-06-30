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

int main(int argc, char **argv){
	int tamanhoArquivo;

	Portaria **portarias = Indexador::importarArquivoDados("./portarias.dat", &tamanhoArquivo);

	cout << tamanhoArquivo << endl;
	for(int i = 0; i < tamanhoArquivo; i++){
		cout << "===================="  << endl;
		cout << portarias[i]->obterPosicaoArquivo()  << endl;
		cout << portarias[i]->obterNome() << endl;
		cout << portarias[i]->obterTexto() << endl;
	}
}

