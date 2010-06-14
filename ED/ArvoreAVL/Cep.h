/**
 TÍTULO:        Implementação de árvores binárias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore semibalanceada (AVL).

 SOBRE O ARQUIVO:
 Declaração dos métodos do tipo de dados Cep, composto de um número de cep e nome do logradouro.

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
	int obterCep();
	string obterNome();
	bool operator>(Cep& outro) const;
	bool operator<=(Cep& outro) const;
	bool operator<(Cep& outro) const;
	bool operator!=(Cep& outro) const;
	bool operator==(Cep& outro) const;
	static ListaEncadeada<Cep>* lerArquivoCeps(string caminhoArquivo);
	static Cep* lerCep(string linha);

};

#endif /* CEP_H_ */
