/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação dos métodos descritos em Indexador.h referentes a um Indexador Genérico.
 */

#include <string>
#include <sstream>
#include <fstream>
#include <cstdlib>

#include "Indexador.h"

using namespace std;

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 ler o arquivo de dados fornecido, parseá-lo e gerar um array de portarias para uso posterior.

 PARÂMETROS:
 caminho do arquivo a ser lido e ponteiro para campo onde será escrito o tamanho do array gerado

 VALOR DE RETORNO:
 array contendo as portarias geradas.

 */
Portaria** Indexador::importarArquivoDados(string caminho, int *tamanhoArquivo) {
	string linha;
	Portaria **portarias;
	ListaEncadeada<string> *dados;

	ifstream myfile(caminho.c_str());

	if (myfile.is_open()) {
		getline(myfile, linha);
		*tamanhoArquivo = atoi(linha.c_str());
		portarias = new Portaria*[*tamanhoArquivo];

		for (int i = 0; i < *tamanhoArquivo; i++) {
			getline(myfile, linha);
			dados = tokenizar(linha);
			portarias[i] = new Portaria(*(dados->obterDoInicio()),
					*(dados->obterDaPosicao(2)), i);
			delete dados;
		}

		myfile.close();
		return portarias;
	}
	*tamanhoArquivo = 0;
	return NULL;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 ler uma string formatada contendo diversos campos divididos por um delimitador e dividí-la,
 gerando uma lista contendo os campos divididos.

 PARÂMETROS:
 a string a ser lida

 VALOR DE RETORNO:
 lista contendo os campos lidos da string

 */
ListaEncadeada<string>* Indexador::tokenizar(string linha) {
	ListaEncadeada<string> *dados = new ListaEncadeada<string> ();

	string::size_type inicio = linha.find_first_not_of(delimitador, 0);
	string::size_type fim = linha.find_first_of(delimitador, inicio);

	while (fim != string::npos || inicio != string::npos) {
		dados->adicionarNoFim(new string(linha.substr(inicio, fim - inicio)));
		inicio = linha.find_first_not_of(delimitador, fim);
		fim = linha.find_first_of(delimitador, inicio);
	}

	return dados;
}
/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 obter uma portaria a partir de um número de entrada no arquivo .dat.
 essencial para não trabalhar com todas as portarias em memória.

 PARÂMETROS:
 O caminho do arquivo .dat
 O número da entrada que será lida

 VALOR DE RETORNO:
 Um ponteiro para uma portaria presente na
 posição referente a entrada recebida

 */
 Portaria* Indexador::lerEntrada(string caminho, int numeroEntrada) {
	string linha;
	ListaEncadeada<string> *dados;
	Portaria* portaria;
	int i;

	ifstream myfile(caminho.c_str());

	if (myfile.is_open()) {
		getline(myfile, linha);

		int tamanhoArquivo = atoi(linha.c_str());

		if (numeroEntrada > tamanhoArquivo) {
			return NULL;
		}

		for(i = 0 ; i < numeroEntrada; i++)
			getline(myfile, linha);

		getline(myfile, linha);
		dados = tokenizar(linha);
		portaria = new Portaria(*(dados->obterDoInicio()),
				*(dados->obterDaPosicao(2)), i);
		delete dados;
		myfile.close();
		return portaria;
	}

	return NULL;
}

