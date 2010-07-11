/*
 * InterfaceUsuario.h
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#ifndef INTERFACEUSUARIO_H_
#define INTERFACEUSUARIO_H_

#include <iostream>
#include "../Portarias/Portaria.h"
#include "../Portarias/PortariaSerial.h"
#include "../Estruturas/ArvoreBinaria/NodoBinario.h"

using namespace std;

class InterfaceUsuario {
private:
	string caminhoDados;
	string caminhoChavesPrimarias;
	string pastaChavesSecundarias;

	Portaria **portarias;
	NodoBinario<PortariaSerial> *arvore;
	int numPortarias;

public:
	InterfaceUsuario();
	virtual ~InterfaceUsuario();

	void iniciar();

private:
	void exibeIntroducao();
	void exibeMenu();
	void gerarIndices();
	void buscarChavePrimaria();
	void buscarChaveSecundaria();
	ListaEncadeada<Portaria>* obterBuscaSecundaria();
};

#endif /* INTERFACEUSUARIO_H_ */
