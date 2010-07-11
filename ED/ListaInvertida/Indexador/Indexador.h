/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de um indexador genérico, contendo métodos e atributos úteis a classes filhas.
*/

#ifndef INDEXADOR_H_
#define INDEXADOR_H_

#include <string>
#include "../Portarias/Portaria.h"
#include "../Estruturas/ListaEncadeada/ListaEncadeada.h"

class Indexador {
public:
	static Portaria** importarArquivoDados(string caminho, int *tamanhoArquivo);
	static ListaEncadeada<string>* tokenizar(string linha);

};
static const string arquivoIndices = "ChavesSecundarias.ndx";
static const string extensao = ".ndx";
static const char delimitador = '|';
#endif /* INDEXADOR_H_ */
