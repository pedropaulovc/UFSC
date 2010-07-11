/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação da interface descrita em PortariaSerial.h.
*/

#include "PortariaSerial.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	construtor do tipo portaria serializada

PARÂMETROS:
	o nome (único) da portaria e a sua posição no arquivo de dados.

VALOR DE RETORNO:
	ponteiro para a instância criada.

*/
PortariaSerial::PortariaSerial(string nome, int posicaoArquivo) {
	this->nome = nome;
	this->posicaoArquivo = posicaoArquivo;
	filhoDireita = -1;
	filhoEsquerda = -1;
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
PortariaSerial::~PortariaSerial() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	definir referência para o filho da esquerda

PARÂMETROS:
	a posição do filho da esquerda

VALOR DE RETORNO:
	nenhum

*/
void PortariaSerial::definirFilhoEsquerda(int filhoEsquerda) {
	this->filhoEsquerda = filhoEsquerda;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	definir referência para o filho da direita

PARÂMETROS:
	a posição do filho da direita

VALOR DE RETORNO:
	nenhum

*/
void PortariaSerial::definirFilhoDireita(int filhoDireita) {
	this->filhoDireita = filhoDireita;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	definir a altura no arquivo de chaves primárias

PARÂMETROS:
	a nova altura

VALOR DE RETORNO:
	nenhum

*/
void PortariaSerial::definirAltura(int altura) {
	this->altura = altura;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	obter referência para o filho da esquerda

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a posição do filho da esquerda

*/
int PortariaSerial::obterFilhoDireita() {
	return filhoDireita;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	obter referência para o filho da direita

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a posição do filho da direita

*/
int PortariaSerial::obterFilhoEsquerda() {
	return filhoEsquerda;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	obter altura no arquivo de chaves primárias

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a altura no arquivo de chaves primárias

*/
int PortariaSerial::obterAltura() {
	return altura;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	obter o nome da portaria

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nome da portaria

*/
string PortariaSerial::obterNome() {
	return nome;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	obter a posição da portaria no arquivo de dados

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a posição da portaria no arquivo de dados

*/
int PortariaSerial::obterPosicaoArquivo() {
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
bool PortariaSerial::operator>(PortariaSerial& outro) const {
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
bool PortariaSerial::operator<=(PortariaSerial& outro) const {
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
bool PortariaSerial::operator<(PortariaSerial& outro) const {
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
bool PortariaSerial::operator!=(PortariaSerial& outro) const {
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
bool PortariaSerial::operator==(PortariaSerial& outro) const {
	return (nome.compare(outro.nome) == 0);
}
