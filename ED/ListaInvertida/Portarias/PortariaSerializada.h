/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de uma portaria serializada, contendo os métodos e atributos necessários.
 Uma portaria serializada é composta por um nome único, uma posição no arquivo de dados e informações
 de localização no arquivo de chaves primárias
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
	PortariaSerializada(string nome, int posicaoArquivo = -1);
	virtual ~PortariaSerializada();

	void definirFilhoEsquerda(int filhoEsquerda);
	void definirFilhoDireita(int filhoDireita);
	void definirAltura(int altura);

	int obterFilhoEsquerda();
	int obterFilhoDireita();
	int obterAltura();
	string obterNome();
	int obterPosicaoArquivo();

	bool operator>(PortariaSerializada& outro) const;
	bool operator<=(PortariaSerializada& outro) const;
	bool operator<(PortariaSerializada& outro) const;
	bool operator!=(PortariaSerializada& outro) const;
	bool operator==(PortariaSerializada& outro) const;
};

#endif /* PORTARIASERIALIZADA_H_ */
