/*
 * Cep.cpp
 *
 *  Created on: Jun 4, 2010
 *      Author: pedropaulo
 */

#include "Cep.h"
#include "Estruturas/ListaEncadeada.h"
#include <string>
#include <sstream>
#include <fstream>

using namespace std;

Cep::Cep(string cep, string nome) {
	istringstream buffer(cep);
	buffer >> this->cep;
	this->nome = nome;
}

Cep::Cep() {
}

Cep::~Cep() {
}

int Cep::obterCep() {
	return cep;
}

string Cep::obterNome() {
	return nome;
}

bool Cep::operator>(Cep& outro) const {
	return (nome.compare(outro.nome) > 0);
}

bool Cep::operator<(Cep& outro) const {
	return (nome.compare(outro.nome) < 0);
}

bool Cep::operator<=(Cep& outro) const {
	return (nome.compare(outro.nome) <= 0);
}

bool Cep::operator==(Cep& outro) const {
	return (nome.compare(outro.nome) == 0);
}

bool Cep::operator!=(Cep& outro) const {
	return (nome.compare(outro.nome) != 0);
}

Cep* Cep::lerCep(string linha) {
	size_t posicaoBarra, posicaoInicioCep;
	string cidade, cep;
	posicaoBarra = linha.find('|');
	if (posicaoBarra != string::npos) {
		cidade = linha.substr(0, posicaoBarra);
		cep = linha.substr(posicaoBarra + 1);
		posicaoInicioCep = cep.find_first_not_of("	");
		cep = cep.substr(posicaoInicioCep);
		return new Cep(cep, cidade);
	}
	return NULL;
}

ListaEncadeada<Cep>* Cep::lerArquivoCeps(string caminhoArquivo) {
	string line;
	Cep* cep;
	ifstream myfile(caminhoArquivo.c_str());
	ListaEncadeada<Cep>* lista = new ListaEncadeada<Cep> ();

	if (myfile.is_open()) {
		while (!myfile.eof()) {
			getline(myfile, line);
			cep = lerCep(line);
			if(cep != NULL)
				lista->adicionarNoInicio(cep);
		}
		myfile.close();
		return lista;
	}
	return NULL;
}
