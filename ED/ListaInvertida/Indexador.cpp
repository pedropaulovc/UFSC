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

ListaEncadeada<PortariaSerializada>* Indexador::gerarArquivoChavesPrimarias(string caminho, Portaria **portarias, int numPortarias){
	NodoAVL<Portaria> *arvore = new NodoAVL<Portaria>();
	for(int i = 0; i < numPortarias; i++)
		arvore = arvore->insere(*portarias[i]);


	PortariaSerializada **portariasSerializadas = new PortariaSerializada*[numPortarias];
	ListaEncadeada<PortariaSerializada> *lista = new ListaEncadeada<PortariaSerializada>();
	int posicaoVaga = 0;
	exportar2(arvore, portariasSerializadas, &posicaoVaga);

	for (int i = 0; i < numPortarias; i++) {
			PortariaSerializada* atual = portariasSerializadas[i];
			cout << atual->obterNome() << " | " << atual->obterPosicaoArquivo()
					<< " | " << atual->obterFilhoEsquerda() << " | "
					<< atual->obterFilhoDireita() << " | " << atual->obterAltura()
					<< endl;
		}

	return lista;
}

int Indexador::exportar(NodoAVL<Portaria> *arvore, ListaEncadeada<PortariaSerializada> *lista){
	if(lista == NULL)
		return 0;

	PortariaSerializada* portariaAtual = new PortariaSerializada(arvore->retornaInfo());

	portariaAtual->definirAltura(arvore->retornaAltura());

	lista->adicionarNoFim(portariaAtual);
	int posicaoInserido = lista->obterTamanho() - 1;

	if(arvore->retornaEsquerda() != NULL)
		portariaAtual->definirFilhoEsquerda(exportar(arvore->retornaEsquerda(), lista));
	if(arvore->retornaDireita() != NULL)
			portariaAtual->definirFilhoDireita(exportar(arvore->retornaDireita(), lista));
	return posicaoInserido;
}

int Indexador::exportar2(NodoAVL<Portaria> *arvore, PortariaSerializada **lista, int *posicaoVaga){
	if(lista == NULL)
		return 0;
	PortariaSerializada* portariaAtual = new PortariaSerializada(arvore->retornaInfo());
	portariaAtual->definirAltura(arvore->retornaAltura());

	lista[*posicaoVaga] = portariaAtual;
	int posicaoInserido = *posicaoVaga;
	if(arvore->retornaEsquerda() != NULL){
		(*posicaoVaga)++;
		portariaAtual->definirFilhoEsquerda(exportar2(arvore->retornaEsquerda(), lista, posicaoVaga));
	}
	if(arvore->retornaDireita() != NULL){
		(*posicaoVaga)++;
		portariaAtual->definirFilhoDireita(exportar2(arvore->retornaDireita(), lista, posicaoVaga));
	}

	return posicaoInserido;

}

