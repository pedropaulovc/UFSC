/**
 TÍTULO:        Implementação de árvores multivias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore B.

 FUNCIONAMENTO GERAL:
 Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
 de uma árvore multivias semibalanceada. A estrutura de dados aceita comandos de inserção, exclusão e
 percurso de maneira prefixada, infixada e posfixada. Como demonstração de funcionamento foi implementado
 um sistema que recebe um arquivo de CEPs fora de ordem e plota o gráfico com o tempo para operar
 nos nodos da árvore. Além disso, foram gerados testes unitários que garantem o funcionamento esperado
 da estrutura de dados.

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
