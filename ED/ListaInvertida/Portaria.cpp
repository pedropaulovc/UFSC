/*
 * Portaria.cpp
 *
 *  Created on: Jun 29, 2010
 *      Author: pedropaulovc
 */

#include "Portaria.h"

Portaria::Portaria(string nome, string texto, int posicaoArquivo) {
	this->nome = nome;
	this->posicaoArquivo = posicaoArquivo;
	this->texto = texto;
}

Portaria::~Portaria() {
}

string Portaria::obterNome() const {
	return nome;
}

string Portaria::obterTexto() const {
	return texto;
}

int Portaria::obterPosicaoArquivo() const {
	return posicaoArquivo;
}

bool Portaria::operator>(Portaria& outro) const {
	return (nome.compare(outro.nome) > 0);
}

bool Portaria::operator<=(Portaria& outro) const {
	return (nome.compare(outro.nome) <= 0);
}

bool Portaria::operator<(Portaria& outro) const {
	return (nome.compare(outro.nome) < 0);
}

bool Portaria::operator!=(Portaria& outro) const {
	return (nome.compare(outro.nome) != 0);
}

bool Portaria::operator==(Portaria& outro) const {
	return (nome.compare(outro.nome) == 0);
}
