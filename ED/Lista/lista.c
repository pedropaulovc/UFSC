/**
ARQUIVO:       main.c
TÍTULO:        Implementação de Lista de Contatos com Vetores em "C"
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         30 de março de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados lista.


FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de listas, servindo como lista de contatos simplificada. Ele possui um menu simples que aceita
do usuário comandos para os principais usos da estrutura: adicionar, remover e obter contatos de
qualquer posição da lista além de exibir em ordem os dados armazenados e sua quantidade.
No mesmo enunciado, foi definido que seria criada uma variável global, aLista, inicializada
em lista.h, contendo uma lista de 100 estruturas contendo uma string de tamanho 30 correspondente
ao nome do contato e um número de telefone.

FUNÇÕES:

vagarPosicao
	responsável por realizar uma bateria de testes para saber se é possível mover outros contatos da
	lista de forma a desocupar a posição desejada, posteriormente realiza a operação propriamente dita
	retornando ao final o sucesso ou não da operação.

adiciona
	adiciona, se possível, um contato na última posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNoInicio
	adiciona, se possível, um contato na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNaPosicao
	adiciona, se possível, um contato em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaEmOrdem
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo contato na
	sua posição correspondente para manter a lista ordenada.

retira
	retira, se possível, um contato da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDoInicio
	retira, se possível, um contato na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDaPosicao
	retira, se possível, um contato em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

listaCheia
	retorna 1 caso a lista esteja cheia e 0 em caso contrário.

listaVazia
	retorna 1 caso a lista esteja vazia e 0 em caso contrario.

posicaoValida
	retorna 1 caso a posição informada esteja no intervalo [0, ultimo] e 0 em caso contrário.

posicao
	retorna a posição de um elemento fornecido e -1 em caso o elemento não exista na lista.

contem
	retorna 1 se a lista contém um elemento fornecido e 0 em caso contrário.
igual
	retorna 1 se dois contatos fornecidos são iguais nos seus nomes e 0 em caso contrário.

maior
	retorna 1 se o nome do primeiro contato fornecido procede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

menor
	retorna 1 se o nome do primeiro contato fornecido precede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

obter
	retorna o contato, se possível, localizado na última posição da lista.

obterDoInicio
	retorna o contato, se possível, localizado no início da lista.

obterDaPosicao
	retorna o contato, se possível, localizado em uma posição arbitrária da lista.

inicializaLista
	prepara a lista para ser utilizada ao definir que ela está vazia (ultimo = -1)

destroiLista
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1, tal como
	inicializaLista.

ARQUIVOS INCLUSOS:
   stdio.h
   stdlib.h
   string.h
   lista.h

ARQUIVOS DE DADOS:
   nenhum
*/
//TODO: Remover comentários e TODOs do código antes de enviar
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

/**
NOME DA FUNÇÃO: adiciona
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	adiciona, se possível, um contato na última posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado         tAgenda          valor              elemento a ser adicionado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema



*/
int adiciona(tAgenda dado) {
	if (aLista.ultimo == MAXELEMENTOS - 1)
		return ERRO_LISTA_CHEIA;

	aLista.ultimo++;
	aLista.elem[aLista.ultimo] = dado;

	return 0;
}

   /**
   NOME DA FUNÇÃO: adicionaNoInicio
   ALUNOS: Pedro Paulo e Felipe dos Santos
   PROPÓSITO:
   	adiciona, se possível, um contato na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

   PARÂMETROS:
   nome         tipo             valor/referência   descrição
   ---------------------------------------------------------------------
   dado         tAgenda          valor              elemento a ser adicionado

   VALOR DE RETORNO:
   nome           tipo  descrição
   ---------------------------------------------------------------------
   --             int   0 em caso de sucesso, código de erro em caso de problema




   */
int adicionaNoInicio(tAgenda dado) {
	return adicionaNaPosicao(dado, 0);
}

/**
NOME DA FUNÇÃO: adicionaNaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	adiciona, se possível, um contato em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado         tAgenda          valor              elemento a ser adicionado
posicao      int              valor              posição do elemento a ser adicionado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int adicionaNaPosicao(tAgenda dado, int posicao) {
	int resultado = vagarPosicao(posicao);

	if (resultado != 0)
		return resultado;

	aLista.elem[posicao] = dado;
	aLista.ultimo++;
	return 0;
}

/**
NOME DA FUNÇÃO: vagarPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	responsável por realizar uma bateria de testes para saber se é possível mover outros contatos da
	lista de forma a desocupar a posição desejada, posteriormente realiza a operação propriamente dita
	retornando ao final o sucesso ou não da operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
posicao      int              valor              posição da lista a ser vaga

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int vagarPosicao(int posicao) {
	//Caso a lista estiver cheia não tem como deslocar
	if (listaCheia() == 1)
		return ERRO_LISTA_CHEIA;

	//Numa lista vazia não é necessário fazer nada.
	//Além disso, a função falharia em vagar a posição 0 de uma lista vazia pois 0 > -1 (ultimo)
	if (listaVazia() == 1)
		return 0;

	if (posicao > aLista.ultimo + 1 || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	// Estava fazendo cópias do último elemento do vetor
	// elemento[i] recebia elemento[i+1], elemento[i-1] recebia elemento[i](elemento[i+1])
	int i;
	for (i = aLista.ultimo; i >= posicao; i--)
		aLista.elem[i + 1] = aLista.elem[i];
	return 0;
}

/**
NOME DA FUNÇÃO: adicionaEmOrdem
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo contato na
	sua posição correspondente para manter a lista ordenada.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado         tAgenda          valor              elemento a ser adicionado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int adicionaEmOrdem(tAgenda dado) {
	int pos = 0;
	while (pos <= aLista.ultimo && maior(dado, aLista.elem[pos]))
		pos++;

	// Estava sempre adicionando em uma posição a mais, e quando
	// posição era igual a último não fazia a comparação.
	return adicionaNaPosicao(dado, pos);
}

//TODO: Implementar
/**
NOME DA FUNÇÃO: obter
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o contato, se possível, localizado na última posição da lista.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tAgenda   contato localizado na última posição da lista,
						 ou um contato em branco em caso de erro.

*/
tAgenda obter() {
	tAgenda contato;
	return contato;
}

//TODO: Implementar
/**
NOME DA FUNÇÃO: obterDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o contato, se possível, localizado no início da lista.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             tAgenda   contato localizado na primeira posição da lista,
						 ou um contato em branco em caso de erro.

*/
tAgenda obterDoInicio() {
	tAgenda contato;
	return contato;
}

//TODO: Implementar
/**
NOME DA FUNÇÃO: obterDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o contato, se possível, localizado em uma posição arbitrária da lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
posicao      int              valor              posição do elemento a ser obtido

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tAgenda   contato localizado em uma posição arbitrária da lista,
						 ou um contato em branco em caso de erro.

*/
tAgenda obterDaPosicao(int posicao) {
	tAgenda contato;
	return contato;
}

/**
NOME DA FUNÇÃO: retira
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um contato da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retira() {
	return retiraDaPosicao(aLista.ultimo);
}

/**
NOME DA FUNÇÃO: retiraDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um contato na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retiraDoInicio() {
	return retiraDaPosicao(0);
}

/**
NOME DA FUNÇÃO: retiraDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um contato em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
posicao      int              valor              posição do elemento a ser removido

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retiraDaPosicao(int posicao) {
	if (posicao > aLista.ultimo || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	for (; posicao <= aLista.ultimo; posicao++)
		aLista.elem[posicao] = aLista.elem[posicao + 1];

	aLista.ultimo--;
	return 0;
}

/**
NOME DA FUNÇÃO: listaCheia
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 caso a lista esteja cheia e 0 em caso contrário.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a lista esteja cheia e 0 em caso contrário


*/
int listaCheia() {
	if (aLista.ultimo == MAXELEMENTOS - 1)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: listaVazia
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 caso a lista esteja vazia e 0 em caso contrario.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a lista esteja vazia e 0 em caso contrário

*/
int listaVazia() {
	if (aLista.ultimo == LISTAVAZIA)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: posicaoValida
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 caso a posição informada esteja no intervalo [0, ultimo] e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
posicao      int              valor              posição a ser testada

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a posição seja válida e 0 em caso contrário

*/
int posicaoValida(int posicao) {
	if (posicao <= aLista.ultimo && posicao >= 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: posicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna a posição de um elemento fornecido e -1 em caso o elemento não exista na lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado         tAgenda          valor              elemento a ser procurado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
i              int   posição do elemento fornecido

*/
int posicao(tAgenda dado) {
	int i;

	for (i = 0; i <= aLista.ultimo; i++)
		if (igual(dado, aLista.elem[i]))
			return i;
	return -1;
}

/**
NOME DA FUNÇÃO: contem
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
		retorna 1 se a lista contém um elemento fornecido e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado         tAgenda          valor              elemento a ser procurado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso o contato pertença à lista e 0 em caso contrário


*/
int contem(tAgenda dado) {
	int i;
	for (i = 0; i <= aLista.ultimo; i++)
		if (igual(dado, aLista.elem[i]))
			return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: igual
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se dois contatos fornecidos são iguais nos seus nomes e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tAgenda          valor              elemento a ser comparado
dado2         tAgenda          valor              elemento a ser comparado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso os nomes dos contatos sejam iguais e 0 em caso contrário.


*/
int igual(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) == 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: maior
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se o nome do primeiro contato fornecido procede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tAgenda          valor              elemento a ser comparado
dado2         tAgenda          valor              elemento a ser comparado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso seja obedecida a regra definida no propósito da função e 0 caso contrário


*/
int maior(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) > 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: menor
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se o nome do primeiro contato fornecido precede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tAgenda          valor              elemento a ser comparado
dado2         tAgenda          valor              elemento a ser comparado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso seja obedecida a regra definida no propósito da função e 0 caso contrário


*/
int menor(tAgenda dado1, tAgenda dado2) {
	if (strcmp(dado1.nome, dado2.nome) < 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: inicializaLista
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	prepara a lista para ser utilizada ao definir que ela está vazia (ultimo = -1)

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nenhum

*/
void inicializaLista() {
	aLista.ultimo = -1;
}

/**
NOME DA FUNÇÃO: destroiLista
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1, tal como
	inicializaLista.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nenhum

*/
void destroiLista() {
	aLista.ultimo = -1;
}
