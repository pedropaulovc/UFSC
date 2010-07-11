/*
 * Main.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */
#include <iostream>
#include "Indexador/Indexador.h"
#include "Indexador/ChavePrimaria/IndexadorChavePrimaria.h"
#include "Indexador/ChaveSecundaria/IndexadorChaveSecundaria.h"
#include "Portarias/Portaria.h"
#include "Portarias/PortariaSerializada.h"
#include "Estruturas/ArvoreBinaria/NodoBinario.h"

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
	IndexadorChaveSecundaria::exportar("./Indices/", palavrasChave, 20,
			portarias, tamanhoArquivo);

	IndexadorChavePrimaria::exportar("./Indices/portarias.ndx", portarias, tamanhoArquivo);

	PortariaSerializada *aBuscar = new PortariaSerializada("281_GR_2006");
	NodoBinario<PortariaSerializada> *arvore = IndexadorChavePrimaria::importar("./Indices/portarias.ndx");
	cout << arvore->buscar(aBuscar)->obterPosicaoArquivo();
}

