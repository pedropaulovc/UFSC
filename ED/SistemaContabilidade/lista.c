/**
ARQUIVO:       lista.c
TÍTULO:        Implementação de num variável de Listas com Vetores alocadas dinamicamente usando TAD Lista com Vetor
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         15 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados lista,
aliada à compreenção de alocação dinâmica de memória.

FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de listas, servindo como sistema de contabilidade simplificado. Ele possui um menu simples que aceita
do usuário comandos para os principais usos da estrutura: adicionar, remover e obter lançamentos de
qualquer posição da lista além de exibir em ordem os dados armazenados e sua quantidade.

FUNÇÕES:

vagarPosicao
	responsável por realizar uma bateria de testes para saber se é possível mover outros lancamentos da
	lista de forma a desocupar a posição desejada, posteriormente realiza a operação propriamente dita
	retornando ao final o sucesso ou não da operação.

adiciona
	adiciona, se possível, um lancamento na última posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNoInicio
	adiciona, se possível, um lancamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNaPosicao
	adiciona, se possível, um lancamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaEmOrdem
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo lancamento na
	sua posição correspondente para manter a lista ordenada.

retira
	retira, se possível, um lancamento da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDoInicio
	retira, se possível, um lancamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDaPosicao
	retira, se possível, um lancamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

listaCheia
	retorna 1 caso a lista esteja cheia e 0 em caso contrário.

listaVazia
	retorna 1 caso a lista esteja vazia e 0 em caso contrario.

posicaoExistente
	retorna 1 caso a posição informada esteja no intervalo [0, ultimo] e 0 em caso contrário.

contem
	retorna 1 se a lista contém um elemento fornecido e 0 em caso contrário.
igual
	retorna 1 se dois lancamentos fornecidos são iguais nos seus nomes e 0 em caso contrário.

maior
	retorna 1 se o nome do primeiro lancamento fornecido procede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

menor
	retorna 1 se o nome do primeiro lancamento fornecido precede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

obter
	retorna o lancamento, se possível, localizado na última posição da lista.

obterDoInicio
	retorna o lancamento, se possível, localizado no início da lista.

obterDaPosicao
	retorna o lancamento, se possível, localizado em uma posição arbitrária da lista.

inicializaLista
	prepara a lista para ser utilizada ao definir que ela está vazia (ultimo = -1)

destroiLista
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1, tal como
	inicializaLista

ARQUIVOS INCLUSOS:
   stdio.h
   stdlib.h
   string.h
   lista.h

ARQUIVOS DE DADOS:
   nenhum
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

/**
NOME DA FUNÇÃO: adiciona
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	adiciona, se possível, um lancamento na última posição da lista. Ao final retorna o sucesso ou não da
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
int adiciona(tListaContabil *aLista, tLancamento dado) {
	if (aLista->ultimo == MAXELEMENTOS - 1)
		return ERRO_LISTA_CHEIA;

	aLista->ultimo++;
	aLista->elem[aLista->ultimo] = dado;

	return 0;
}

   /**
   NOME DA FUNÇÃO: adicionaNoInicio
   ALUNOS: Pedro Paulo e Felipe dos Santos
   PROPÓSITO:
   	adiciona, se possível, um lancamento na primeira posição da lista. Ao final retorna o sucesso ou não da
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
int adicionaNoInicio(tListaContabil *aLista, tLancamento dado) {
	return adicionaNaPosicao(aLista, dado, 0);
}

/**
NOME DA FUNÇÃO: adicionaNaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	adiciona, se possível, um lancamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
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
int adicionaNaPosicao(tListaContabil *aLista, tLancamento dado, int posicao) {
	int resultado = vagarPosicao(aLista, posicao);

	if (resultado != 0)
		return resultado;

	aLista->elem[posicao] = dado;
	aLista->ultimo++;
	return 0;
}

/**
NOME DA FUNÇÃO: vagarPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	responsável por realizar uma bateria de testes para saber se é possível mover outros lancamentos da
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
int vagarPosicao(tListaContabil *aLista, int posicao) {

	if (listaCheia(aLista) == 1)
		return ERRO_LISTA_CHEIA;

	if (listaVazia(aLista) == 1)
		return 0;

	if (posicao > aLista->ultimo + 1 || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	int i;
	for (i = aLista->ultimo; i >= posicao; i--)
		aLista->elem[i + 1] = aLista->elem[i];
	return 0;
}

/**
NOME DA FUNÇÃO: adicionaEmOrdem
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo lancamento na
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
int adicionaEmOrdem(tListaContabil *aLista, tLancamento dado) {
	int pos = 0;
	while (pos <= aLista->ultimo && maior(dado, aLista->elem[pos]))
		pos++;

	return adicionaNaPosicao(aLista, dado, pos);
}

/**
NOME DA FUNÇÃO: obter
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lancamento, se possível, localizado na última posição da lista.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tAgenda   lancamento localizado na última posição da lista,
						 ou um lancamento em branco em caso de erro.

*/
tLancamento obter(tListaContabil *aLista) {
	return obterDaPosicao(aLista, aLista->ultimo);
}

/**
NOME DA FUNÇÃO: obterDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lancamento, se possível, localizado no início da lista.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             tAgenda   lancamento localizado na primeira posição da lista,
						 ou um lancamento em branco em caso de erro.

*/
tLancamento obterDoInicio(tListaContabil *aLista) {
	return obterDaPosicao(aLista, 0);
}

/**
NOME DA FUNÇÃO: obterDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lancamento, se possível, localizado em uma posição arbitrária da lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
posicao      int              valor              posição do elemento a ser obtido

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tAgenda   lancamento localizado em uma posição arbitrária da lista,
						 ou um lancamento informando que a posicão é inválida em caso
						 de erro

*/
tLancamento obterDaPosicao(tListaContabil *aLista, int posicao) {
	tLancamento lancamento;
	if(posicaoExistente(aLista, posicao))
		return aLista->elem[posicao];

	strcpy(lancamento.nome, "Posicao inválida.");
	lancamento.valor = ERRO_POSICAO_INVALIDA;

	return lancamento;
}

/**
NOME DA FUNÇÃO: retira
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um lancamento da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retira(tListaContabil *aLista) {
	return retiraDaPosicao(aLista, aLista->ultimo);
}

/**
NOME DA FUNÇÃO: retiraDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um lancamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retiraDoInicio(tListaContabil *aLista) {
	return retiraDaPosicao(aLista, 0);
}

/**
NOME DA FUNÇÃO: retiraDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um lancamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
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
int retiraDaPosicao(tListaContabil *aLista, int posicao) {
	if (posicao > aLista->ultimo || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	for (; posicao <= aLista->ultimo; posicao++)
		aLista->elem[posicao] = aLista->elem[posicao + 1];

	aLista->ultimo--;
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
int listaCheia(tListaContabil *aLista) {
	if (aLista->ultimo == MAXELEMENTOS - 1)
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
int listaVazia(tListaContabil *aLista) {
	if (aLista->ultimo == LISTAVAZIA)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: posicaoExistente
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
int posicaoExistente(tListaContabil *aLista, int posicao) {
	if (posicao <= aLista->ultimo && posicao >= 0)
		return 1;
	return 0;
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
--             int   1 caso o lancamento pertença à lista e 0 em caso contrário


*/
int contem(tListaContabil *aLista, tLancamento dado) {
	int i;
	for (i = 0; i <= aLista->ultimo; i++)
		if (igual(dado, aLista->elem[i]))
			return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: igual
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se dois lancamentos fornecidos são iguais nos seus nomes e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tAgenda          valor              elemento a ser comparado
dado2         tAgenda          valor              elemento a ser comparado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso os nomes dos lancamentos sejam iguais e 0 em caso contrário.


*/
int igual(tLancamento dado1, tLancamento dado2) {
	if (strcmp(dado1.nome, dado2.nome) == 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: maior
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se o nome do primeiro lancamento fornecido procede o segundo em uma ordem alfabética de nomes
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
int maior(tLancamento dado1, tLancamento dado2) {
	if (strcmp(dado1.nome, dado2.nome) > 0)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: menor
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se o nome do primeiro lancamento fornecido precede o segundo em uma ordem alfabética de nomes
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
int menor(tLancamento dado1, tLancamento dado2) {
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
void inicializaLista(tListaContabil *aLista) {
	aLista->ultimo = -1;
}

/**
NOME DA FUNÇÃO: destroiLista
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1, tal como
	inicializaLista->

PARÂMETROS:
nenhum

VALOR DE RETORNO:
nenhum

*/
void destroiLista(tListaContabil *aLista) {
	int i;
	for(i = 0; i < aLista->ultimo; i++)
		free(aLista->elem[i].nome);
	aLista->ultimo = -1;
}
