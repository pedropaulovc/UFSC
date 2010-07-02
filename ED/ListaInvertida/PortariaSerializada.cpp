/*
 * PortariaSerializada.cpp
 *
 *  Created on: Jul 2, 2010
 *      Author: pedropaulovc
 */

#include "PortariaSerializada.h"

PortariaSerializada::PortariaSerializada(const Portaria* portaria) :
	Portaria(portaria->obterNome(), portaria->obterTexto(),
			portaria->obterPosicaoArquivo()) {
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

void PortariaSerializada::definirAltura(int altura){
	this->altura = altura;
}

int PortariaSerializada::obterFilhoDireita(){
	return filhoDireita;
}

int PortariaSerializada::obterFilhoEsquerda(){
	return filhoEsquerda;
}

int PortariaSerializada::obterAltura(){
	return altura;
}
