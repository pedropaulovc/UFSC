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
	Portaria **portarias;
	NodoBinario<PortariaSerial> *arvore;
	int numPortarias;

public:
	InterfaceUsuario();
	virtual ~InterfaceUsuario();

	void iniciar();
	void exibeIntroducao();
	void exibeMenu();
	void gerarIndices();

};

#endif /* INTERFACEUSUARIO_H_ */
