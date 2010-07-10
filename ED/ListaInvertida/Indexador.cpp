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
#include <algorithm>
#include <iterator>
#include <iostream>

#include "Indexador.h"
#include "Portaria.h"
#include "PortariaSerializada.h"
#include "Estruturas/ArvoreAVL/arvore_avl.h"
#include "Estruturas/ArvoreAVL/arvore_avl.h"


using namespace std;

Indexador::Indexador() {
}

Indexador::~Indexador() {
}

Portaria** Indexador::importarArquivoDados(string caminho, int *tamanhoArquivo) {
	string chave, texto, linha;
	Portaria **portarias;

	ifstream myfile(caminho.c_str());

	if (myfile.is_open()) {
		getline(myfile, linha);
		*tamanhoArquivo = atoi(linha.c_str());
		portarias = new Portaria*[*tamanhoArquivo];

		for (int i = 0; i < *tamanhoArquivo; i++) {
			getline(myfile, linha);
			portarias[i] = gerarPortaria(linha, i);
		}

		myfile.close();
		return portarias;
	}
	*tamanhoArquivo = 0;
	return NULL;
}

Portaria* Indexador::gerarPortaria(string linha, int posicaoArquivoDados){
	string *dados = new string[2];

	int i = 0;
	string::size_type inicio = linha.find_first_not_of(delimitador, 0);
	string::size_type fim = linha.find_first_of(delimitador, inicio);

	while (fim != string::npos || inicio != string::npos) {
		dados[i] = linha.substr(inicio, fim - inicio);
		inicio = linha.find_first_not_of(delimitador, fim);
		fim = linha.find_first_of(delimitador, inicio);
		i++;
	}

	return new Portaria(dados[0], dados[1], posicaoArquivoDados);
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
	arquivo.open(caminho.c_str(), ios::trunc | ios::out);

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
