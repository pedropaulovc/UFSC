/*
 * Portaria.h
 *
 *  Created on: Jun 29, 2010
 *      Author: pedropaulovc
 */

#ifndef PORTARIA_H_
#define PORTARIA_H_

#include <string>

using namespace std;

class Portaria {
private:
	string nome;
	string texto;
	int posicaoArquivo;

public:
	Portaria(string nome, string texto, int posicaoArquivo);
	virtual ~Portaria();

	string obterNome() const;
	string obterTexto() const;
	int obterPosicaoArquivo() const;

	bool operator>(Portaria& outro) const;
	bool operator<=(Portaria& outro) const;
	bool operator<(Portaria& outro) const;
	bool operator!=(Portaria& outro) const;
	bool operator==(Portaria& outro) const;

};

#endif /* PORTARIA_H_ */
