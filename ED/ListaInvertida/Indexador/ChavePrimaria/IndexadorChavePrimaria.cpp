/*
 * IndexadorChavePrimaria.cpp
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#include "IndexadorChavePrimaria.h"
#include <fstream>

void IndexadorChavePrimaria::exportar(string caminho, Portaria **portarias,
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

int IndexadorChavePrimaria::serializarArvore(NodoAVL<Portaria> *arvore,
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

NodoBinario<PortariaSerializada>* IndexadorChavePrimaria::importar(
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

NodoBinario<PortariaSerializada>* IndexadorChavePrimaria::importarArvore(string *nodos,
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
