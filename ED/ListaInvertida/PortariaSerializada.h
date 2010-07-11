/*
 * PortariaSerializada.h
 *
 *  Created on: Jul 2, 2010
 *      Author: pedropaulovc
 */

#ifndef PORTARIASERIALIZADA_H_
#define PORTARIASERIALIZADA_H_

#include <string>
using namespace std;

class PortariaSerializada {
private:
	string nome;
	int posicaoArquivo;
	int filhoEsquerda;
	int filhoDireita;
	int altura;

public:
	PortariaSerializada(string nome, int posicaoArquivo);
	virtual ~PortariaSerializada();

	void definirFilhoEsquerda(int filhoEsquerda);
	void definirFilhoDireita(int filhoDireita);
	void definirAltura(int altura);

	int obterFilhoEsquerda();
	int obterFilhoDireita();
	int obterAltura();
	string obterNome();
	int obterPosicaoArquivo();
};

#endif /* PORTARIASERIALIZADA_H_ */
