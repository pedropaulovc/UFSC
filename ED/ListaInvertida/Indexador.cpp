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

using namespace std;

Indexador::Indexador() {
}

Indexador::~Indexador() {
}

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

	arquivo << numPortarias << endl;

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
	const Portaria* portaria = arvore->retornaInfo();
	PortariaSerializada* serializada = new PortariaSerializada(
			portaria->obterNome(), portaria->obterPosicaoArquivo());
	serializada->definirAltura(arvore->retornaAltura());

	lista[*posicaoVaga] = serializada;
	int posicaoInserido = *posicaoVaga;

	if (arvore->retornaEsquerda() != NULL) {
		(*posicaoVaga)++;
		serializada->definirFilhoEsquerda(serializarArvore(
				arvore->retornaEsquerda(), lista, posicaoVaga));
	}
	if (arvore->retornaDireita() != NULL) {
		(*posicaoVaga)++;
		serializada->definirFilhoDireita(serializarArvore(
				arvore->retornaDireita(), lista, posicaoVaga));
	}

	return posicaoInserido;
}

NodoBinario<PortariaSerializada>* Indexador::importarChavesPrimarias(
		string caminhoArquivoChaves) {
	ifstream arquivo(caminhoArquivoChaves.c_str());
	string linha;

	if (arquivo.fail())
		return NULL;

	getline(arquivo, linha);
	int tamanhoArquivo = atoi(linha.c_str());
	string *nodosSerializados = new string[tamanhoArquivo];

	for (int i = 0; i < tamanhoArquivo; i++)
		getline(arquivo, nodosSerializados[i]);

	return importarArvore(nodosSerializados, tamanhoArquivo);
}

NodoBinario<PortariaSerializada>* Indexador::importarArvore(string *nodos,
		int numNodos, int nodoAtual) {
	string nodo = nodos[nodoAtual];
	ListaEncadeada<string> *dados = tokenizar(nodo);

	string chave = *dados->obterDoInicio();
	int posicaoArquivo = atoi(dados->obterDaPosicao(2)->c_str());
	PortariaSerializada *novaPortaria = new PortariaSerializada(chave,
			posicaoArquivo);
	NodoBinario<PortariaSerializada> *novoNodo = new NodoBinario<
			PortariaSerializada> (novaPortaria);

	int filhoEsquerda = atoi(dados->obterDaPosicao(3)->c_str());
	int filhoDireita = atoi(dados->obterDaPosicao(4)->c_str());
	if(filhoEsquerda != -1)
		novoNodo->alterarFilhoEsquerda(importarArvore(nodos, numNodos, filhoEsquerda));
	if(filhoDireita != -1)
		novoNodo->alterarFilhoDireita(importarArvore(nodos, numNodos, filhoDireita));

	delete dados;
	return novoNodo;
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
