/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação dos métodos descritos em IndexadorChaveSecundaria.h referentes a um indexador de chaves
 secundárias.
 */

#include "IndexadorChaveSecundaria.h"
#include <fstream>
#include <iostream>
#include <sstream>

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 para cada palavra chave a ser indexada, varrer o array contendo todas as portarias em busca dela,
 em caso de sucesso armazenar uma referência em arquivo invertido para a palavra chave. Gera ainda, um
 arquivo mestre que referencia todos os arquivos.

 PARÂMETROS:
 a pasta a ser utilizada para armazenar os índices, um array contendo as palavras chave a serem buscadas,
 o número de palavras chave contidas no array, um array de portarias a serem lidas e o número de portarias

 VALOR DE RETORNO:
 nenhum

 */
void IndexadorChaveSecundaria::exportar(string pasta, string *palavrasChave,
		int numPalavras, Portaria **portarias, int numPortarias) {
	ofstream arquivoSaida;
	stringstream buffer;
	string palavraAtual;

	//Para cada palavra chave a ser buscada, faça:
	for (int i = 0; i < numPalavras; i++) {
		//Obter a palavra chave atual e abrir o arquivo coorrespondente
		palavraAtual = palavrasChave[i];
		arquivoSaida.open((pasta + palavraAtual + extensao).c_str(), ios::trunc
				| ios::out);

		if (arquivoSaida.fail())
			cout << "Problema no arquivo de saída" << endl;
		int qtd = 0;
		//Para cada portaria, faça:
		for (int j = 0; j < numPortarias; j++) {
			//Se a portaria contém a palavra buscada, armazenar em
			//um buffer uma referência a essa portaria
			Portaria *portariaAtual = portarias[j];
			if (portariaAtual->obterTexto().find(palavraAtual) != string::npos) {
				buffer << portariaAtual->obterPosicaoArquivo() << delimitador;
				qtd++;
			}
		}
		//Gravar o tamanho da lista invertida e as referências armazenadas
		arquivoSaida << qtd << endl << buffer.str();
		//Limpando o buffer
		buffer.str("");
		//Fechando o arquivo da palavra chave atual
		arquivoSaida.close();
	}
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Lê o arquivo referente a sua palavra chave e cria uma
 lista com as portarias em que a palavra está presente.

 PARÂMETROS:
 A pasta onde estão os arquivos de índice
 A palavra chave que será lida
 O caminho para o arquivo .dat de onde será lida a lista

 VALOR DE RETORNO:
 Um ponteiro para uma lista de portarias.

 */
ListaEncadeada<Portaria>* IndexadorChaveSecundaria::importar(string pasta,
		string palavraChave, string arquivoDados) {

	string linha;
	int posicao;
	ListaEncadeada<Portaria>* portarias = new ListaEncadeada<Portaria> ();
	ListaEncadeada<string>* dados;
	Portaria* portariaAtual;
	int numeroChaves;

	ifstream arquivoListaInvertida((pasta + palavraChave + extensao).c_str());

	if (arquivoListaInvertida.is_open()) {
		//Obtendo o tamanho da lista invertida
		getline(arquivoListaInvertida, linha);
		numeroChaves = atoi(linha.c_str());

		//Parseando a lista invertida
		getline(arquivoListaInvertida, linha);
		dados = tokenizar(linha);

		//Para cada referência armazenada, obter a portaria correspondente do arquivo de dados
		//e armazenar na lista a ser retornada
		for(int i = 1; i <= dados->obterTamanho(); i++){
			posicao = atoi(dados->obterDaPosicao(i)->c_str());
			portariaAtual = Indexador::lerEntrada(arquivoDados, posicao);
			portarias->adicionarNoFim(portariaAtual);
		}

		arquivoListaInvertida.close();
		delete dados;

		return portarias;
	}
	return NULL;
}
