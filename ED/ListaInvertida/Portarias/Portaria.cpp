/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação da interface descrita em Portaria.h.
*/

#include "Portaria.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	construtor do tipo portaria

PARÂMETROS:
	o nome (único) da portaria, o texto completo e a sua posição no arquivo de dados.

VALOR DE RETORNO:
	ponteiro para a instância criada.

*/
Portaria::Portaria(string nome, string texto, int posicaoArquivo) {
	this->nome = nome;
	this->posicaoArquivo = posicaoArquivo;
	this->texto = texto;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	destrutor construtor do tipo portaria

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
Portaria::~Portaria() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	construtor vazio do tipo portaria para satisfazer necessidade do compilador

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
Portaria::Portaria(){
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o nome da portaria

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nome da portaria

*/
string Portaria::obterNome() const {
	return nome;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o texto da portaria

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o texto da portaria

*/
string Portaria::obterTexto() const {
	return texto;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna a posição no arquivo de dados da portaria

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a posição no arquivo de dados.

*/
int Portaria::obterPosicaoArquivo() const {
	return posicaoArquivo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador de comparação entre duas portarias

PARÂMETROS:
	portaria a ser comparada

VALOR DE RETORNO:
	se a comparação é verdadeira ou não

*/
bool Portaria::operator>(Portaria& outro) const {
	return (nome.compare(outro.nome) > 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador de comparação entre duas portarias

PARÂMETROS:
	portaria a ser comparada

VALOR DE RETORNO:
	se a comparação é verdadeira ou não

*/
bool Portaria::operator<=(Portaria& outro) const {
	return (nome.compare(outro.nome) <= 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador de comparação entre duas portarias

PARÂMETROS:
	portaria a ser comparada

VALOR DE RETORNO:
	se a comparação é verdadeira ou não

*/
bool Portaria::operator<(Portaria& outro) const {
	return (nome.compare(outro.nome) < 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador de comparação entre duas portarias

PARÂMETROS:
	portaria a ser comparada

VALOR DE RETORNO:
	se a comparação é verdadeira ou não

*/
bool Portaria::operator!=(Portaria& outro) const {
	return (nome.compare(outro.nome) != 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	operador de comparação entre duas portarias

PARÂMETROS:
	portaria a ser comparada

VALOR DE RETORNO:
	se a comparação é verdadeira ou não

*/
bool Portaria::operator==(Portaria& outro) const {
	return (nome.compare(outro.nome) == 0);
}
