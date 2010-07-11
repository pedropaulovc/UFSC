/*
 * PortariaSerializada.cpp
 *
 *  Created on: Jul 2, 2010
 *      Author: pedropaulovc
 */

#include "PortariaSerializada.h"

PortariaSerializada::PortariaSerializada(string nome, int posicaoArquivo) {
	this->nome = nome;
	this->posicaoArquivo = posicaoArquivo;
	filhoDireita = -1;
	filhoEsquerda = -1;
}

PortariaSerializada::~PortariaSerializada() {
}

void PortariaSerializada::definirFilhoEsquerda(int filhoEsquerda) {
	this->filhoEsquerda = filhoEsquerda;
}

void PortariaSerializada::definirFilhoDireita(int filhoDireita) {
	this->filhoDireita = filhoDireita;
}

void PortariaSerializada::definirAltura(int altura) {
	this->altura = altura;
}

int PortariaSerializada::obterFilhoDireita() {
	return filhoDireita;
}

int PortariaSerializada::obterFilhoEsquerda() {
	return filhoEsquerda;
}

int PortariaSerializada::obterAltura() {
	return altura;
}

string PortariaSerializada::obterNome() {
	return nome;
}

int PortariaSerializada::obterPosicaoArquivo() {
	return posicaoArquivo;
}
