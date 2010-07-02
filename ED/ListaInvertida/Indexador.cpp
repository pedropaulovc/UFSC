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
#include "Portaria.h"
#include "PortariaSerializada.h"
#include "Estruturas/ArvoreAVL/arvore_avl.h"
#include "Estruturas/ArvoreAVL/arvore_avl.h"
#include <iostream>

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

void Indexador::exportarChavesPrimarias(string caminho, Portaria **portarias,
		int numPortarias) {
	NodoAVL<Portaria> *arvore = new NodoAVL<Portaria> ();

	for (int i = 0; i < numPortarias; i++)
		arvore = arvore->insere(*portarias[i]);

	PortariaSerializada **serializadas = new PortariaSerializada*[numPortarias];

	int posicaoVaga = 0;
	serializarArvore(arvore, serializadas, &posicaoVaga);

	ofstream arquivo;
	arquivo.open(caminho.c_str(), ios::app | ios::out);

	if (arquivo.fail())
		return;

	for (int i = 0; i < numPortarias; i++) {
		PortariaSerializada *atual = serializadas[i];
		arquivo << atual->obterNome() << delimitador
				<< atual->obterPosicaoArquivo() << delimitador
				<< atual->obterFilhoEsquerda() << delimitador
				<< atual->obterFilhoDireita() << delimitador
				<< atual->obterAltura() << endl;
	}
	arquivo.close();

}

int Indexador::serializarArvore(NodoAVL<Portaria> *arvore,
		PortariaSerializada **lista, int *posicaoVaga) {
	if (lista == NULL)
		return 0;
	PortariaSerializada* portaria = new PortariaSerializada(
			arvore->retornaInfo());
	portaria->definirAltura(arvore->retornaAltura());

	lista[*posicaoVaga] = portaria;
	int posicaoInserido = *posicaoVaga;

	if (arvore->retornaEsquerda() != NULL) {
		(*posicaoVaga)++;
		portaria->definirFilhoEsquerda(serializarArvore(
				arvore->retornaEsquerda(), lista, posicaoVaga));
	}
	if (arvore->retornaDireita() != NULL) {
		(*posicaoVaga)++;
		portaria->definirFilhoDireita(serializarArvore(
				arvore->retornaDireita(), lista, posicaoVaga));
	}

	return posicaoInserido;
}

void Indexador::exportarChavesSecundarias(string pasta, string *palavrasChave,
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
