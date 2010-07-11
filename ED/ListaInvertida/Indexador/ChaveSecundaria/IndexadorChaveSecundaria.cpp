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
	ofstream arquivoSaida, arquivoIndice;
	stringstream buffer;
	string palavraAtual;

	arquivoIndice.open((pasta + arquivoIndices).c_str(), ios::trunc | ios::out);
	for (int i = 0; i < numPalavras; i++) {
		palavraAtual = palavrasChave[i];
		arquivoIndice << palavraAtual << delimitador << palavraAtual
				<< extensao << endl;
		arquivoSaida.open((pasta + palavraAtual + extensao).c_str(), ios::trunc
				| ios::out);

		if (arquivoSaida.fail())
			cout << "Problema no arquivo de saída" << endl;
		int qtd = 0;
		for (int j = 0; j < numPortarias; j++) {
			Portaria *portariaAtual = portarias[j];
			if (portariaAtual->obterTexto().find(palavraAtual) != string::npos){
				buffer << portariaAtual->obterPosicaoArquivo() << delimitador;
				qtd++;
			}
		}
		arquivoSaida << qtd << endl << buffer.str();
		buffer.str("");
		arquivoSaida.close();
	}
	arquivoIndice.close();
}
