/*
 * Cep.h
 *
 *  Created on: Jun 4, 2010
 *      Author: pedropaulo
 */

#ifndef CEP_H_
#define CEP_H_

#include <string>
#include "Estruturas/ListaEncadeada.h"
using namespace std;

class Cep {
private:
	int cep;
	string nome;

public:
	Cep(string cep, string nome);
	Cep();
	virtual ~Cep();
	int obterCep() const;
	string obterNome() const;
	bool operator>(const Cep& outro) const;
	bool operator<=(const Cep& outro) const;
	bool operator<(const Cep& outro) const;
	bool operator!=(const Cep& outro) const;
	bool operator==(const Cep& outro) const;
	static ListaEncadeada<Cep>* lerArquivoCeps(string caminhoArquivo);
	static Cep* lerCep(string linha);

};

#endif /* CEP_H_ */
