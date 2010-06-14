/**
 TÍTULO:        Implementação de árvores binárias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore semibalanceada (AVL).

 SOBRE O ARQUIVO:
 Implementação do tipo de dados Cep, composto de um número de cep e nome do logradouro.

*/

#include "Cep.h"
#include "Estruturas/ListaEncadeada.h"
#include <string>
#include <sstream>
#include <fstream>

using namespace std;

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Construtor principal do tipo Cep.

PARÂMETROS:
	O número do CEP e o nome do logradouro.

VALOR DE RETORNO:
	ponteiro para o objeto criado.

*/
Cep::Cep(string cep, string nome) {
	istringstream buffer(cep);
	buffer >> this->cep;
	this->nome = nome;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Construtor sem parâmetros para satisfazer necessidade de compilação.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	ponteiro para o objeto criado.

*/
Cep::Cep() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Destrutor do objeto

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
Cep::~Cep() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o número de cep armazenado no objeto.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o número de cep

*/
int Cep::obterCep() {
	return cep;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o nome do logradouro armazenado no objeto.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	 o nome do logradouro

*/
string Cep::obterNome() {
	return nome;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador para comparação entre dois CEPs diferentes

PARÂMETROS:
	o outro cep a ser comparado.

VALOR DE RETORNO:
	valor booleano da operação

*/
bool Cep::operator>(Cep& outro) const {
	return (nome.compare(outro.nome) > 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador para comparação entre dois CEPs diferentes

PARÂMETROS:
	o outro cep a ser comparado.

VALOR DE RETORNO:
	valor booleano da operação

*/
bool Cep::operator<(Cep& outro) const {
	return (nome.compare(outro.nome) < 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador para comparação entre dois CEPs diferentes

PARÂMETROS:
	o outro cep a ser comparado.

VALOR DE RETORNO:
	valor booleano da operação

*/
bool Cep::operator<=(Cep& outro) const {
	return (nome.compare(outro.nome) <= 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador para comparação entre dois CEPs diferentes

PARÂMETROS:
	o outro cep a ser comparado.

VALOR DE RETORNO:
	valor booleano da operação

*/
bool Cep::operator==(Cep& outro) const {
	return (nome.compare(outro.nome) == 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador para comparação entre dois CEPs diferentes

PARÂMETROS:
	o outro cep a ser comparado.

VALOR DE RETORNO:
	valor booleano da operação

*/
bool Cep::operator!=(Cep& outro) const {
	return (nome.compare(outro.nome) != 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	dada uma linha formatada contendo logradouro e cep, retorna um novo objeto cep com os dados fornecidos.

PARÂMETROS:
	a linha a ser lida

VALOR DE RETORNO:
	o objeto gerado ou NULL em caso de erro.

*/
Cep* Cep::lerCep(string linha) {
	size_t posicaoBarra, posicaoInicioCep;
	string cidade, cep;
	posicaoBarra = linha.find('|');
	if (posicaoBarra != string::npos) {
		cidade = linha.substr(0, posicaoBarra);
		cep = linha.substr(posicaoBarra + 1);
		posicaoInicioCep = cep.find_first_not_of("	");
		cep = cep.substr(posicaoInicioCep);
		return new Cep(cep, cidade);
	}
	return NULL;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Itera um arquivo de CEPs e retorna uma lista encadeada contendo todos os CEPs do arquivo.

PARÂMETROS:
	o caminho para o arquivo a ser lido.

VALOR DE RETORNO:
	a lista de CEPs

*/
ListaEncadeada<Cep>* Cep::lerArquivoCeps(string caminhoArquivo) {
	string line;
	Cep* cep;
	ifstream myfile(caminhoArquivo.c_str());
	ListaEncadeada<Cep>* lista = new ListaEncadeada<Cep> ();

	if (myfile.is_open()) {
		while (!myfile.eof()) {
			getline(myfile, line);
			cep = lerCep(line);
			if(cep != NULL)
				lista->adicionarNoInicio(cep);
		}
		myfile.close();
		return lista;
	}
	return NULL;
}
