/*
 * PortariaSerializada.h
 *
 *  Created on: Jul 2, 2010
 *      Author: pedropaulovc
 */

#ifndef PORTARIASERIALIZADA_H_
#define PORTARIASERIALIZADA_H_

#include <string>
#include "Portaria.h"
using namespace std;

class PortariaSerializada : public Portaria {
private:
	int filhoEsquerda;
	int filhoDireita;
	int altura;

public:
	PortariaSerializada(const Portaria* portaria);
	virtual ~PortariaSerializada();

	void definirFilhoEsquerda(int filhoEsquerda);
	void definirFilhoDireita(int filhoDireita);
	void definirAltura(int altura);

	int obterFilhoEsquerda();
	int obterFilhoDireita();
	int obterAltura();
};

#endif /* PORTARIASERIALIZADA_H_ */
