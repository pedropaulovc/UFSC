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

	Portaria **portarias = Indexador::importarArquivoDados(
			"./Indices/portarias.dat", &tamanhoArquivo);

	string palavrasChave[] = { "REITOR", "VICE", "PROFESSOR", "CHEFE",
			"DEPARTAMENTO", "MECANICA", "ELETRICA", "QUIMICA", "LETRAS",
			"FILOSOFIA", "HUMANAS", "CIENCIAS", "COMPUTACAO", "SANITARIA",
			"MATERIAIS", "ENGENHARIA", "INGLES", "ALEMAO", "ITALIANO",
			"DIREITO" };
	Indexador::exportarChavesSecundarias("./Indices/", palavrasChave, 20,
			portarias, tamanhoArquivo);

	Indexador::exportarChavesPrimarias("./Indices/portarias.ndx", portarias, tamanhoArquivo);
}

