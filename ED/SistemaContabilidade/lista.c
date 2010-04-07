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
No mesmo enunciado, foi definido que seria criada uma variável global, lista, inicializada
em lista.h, contendo uma lista de 100 estruturas contendo uma string de tamanho 30 correspondente
ao nome do contato e um número de telefone.

FUNÇÕES:

vagarPosicao
	responsável por realizar uma bateria de testes para saber se é possível mover outros lançamentos da
	lista de forma a desocupar a posição desejada, posteriormente realiza a operação propriamente dita
	retornando ao final o sucesso ou não da operação.

adiciona
	adiciona, se possível, um lançamento na última posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNoInicio
	adiciona, se possível, um lançamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaNaPosicao
	adiciona, se possível, um lançamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

adicionaEmOrdem
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo lançamento na
	sua posição correspondente para manter a lista ordenada.

retira
	retira, se possível, um lançamento da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDoInicio
	retira, se possível, um lançamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

retiraDaPosicao
	retira, se possível, um lançamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
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
	retorna 1 se dois lançamentos fornecidos são iguais nos seus nomes e 0 em caso contrário.

maior
	retorna 1 se o nome do primeiro lançamento fornecido procede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

menor
	retorna 1 se o nome do primeiro lançamento fornecido precede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

obter
	retorna o lançamento, se possível, localizado na última posição da lista.

obterDoInicio
	retorna o lançamento, se possível, localizado no início da lista.

obterDaPosicao
	retorna o lançamento, se possível, localizado em uma posição arbitrária da lista.

obterlançamentoPeloNome
	retorna um lançamento armazenado que coincida com o nome fornecido, ou um lançamento
	que informa que a posicão é inválida em caso de erro.

inicializlista
	prepara a lista para ser utilizada ao definir que ela está vazia (ultimo = -1)

destroiLista
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1, tal como
	inicializlista->

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
	adiciona, se possível, um lançamento na última posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil em que o elemento será adicionado
dado         tAgenda          valor              elemento a ser adicionado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int 0 em caso de sucesso, código de erro em caso de problema
*/
int adiciona(tListaContabil *lista, tLancamento dado) {
	if (lista->ultimo == MAXELEMENTOS - 1)
		return ERRO_LISTA_CHEIA;

	lista->ultimo++;
	lista->elem[lista->ultimo] = dado;

	return 0;
}

   /**
   NOME DA FUNÇÃO: adicionaNoInicio
   ALUNOS: Pedro Paulo e Felipe dos Santos
   PROPÓSITO:
   	adiciona, se possível, um lançamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

   PARÂMETROS:
   nome         tipo             valor/referência   descrição
   ---------------------------------------------------------------------
   lista        tListaContabil   referência         lista contábil em que o elemento será adicionado
   dado         tAgenda          valor              elemento a ser adicionado

   VALOR DE RETORNO:
   nome           tipo  descrição
   ---------------------------------------------------------------------
   --             int   0 em caso de sucesso, código de erro em caso de problema
   */
int adicionaNoInicio(tListaContabil *lista, tLancamento dado) {
	return adicionaNaPosicao(lista, dado, 0);
}

/**
NOME DA FUNÇÃO: adicionaNaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	adiciona, se possível, um lançamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil em que o elemento será adicionado
dado         tAgenda          valor              elemento a ser adicionado
posicao      int              valor              posição para adicionar o elemento

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int adicionaNaPosicao(tListaContabil *lista, tLancamento dado, int posicao) {
	int resultado = vagarPosicao(lista, posicao);

	if (resultado != 0)
		return resultado;

	lista->elem[posicao] = dado;
	lista->ultimo++;
	return 0;
}

/**
NOME DA FUNÇÃO: vagarPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	responsável por realizar uma bateria de testes para saber se é possível mover outros lançamentos da
	lista de forma a desocupar a posição desejada, posteriormente realiza a operação propriamente dita
	retornando ao final o sucesso ou não da operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil a ser modificada
posicao      int              valor              posição da lista a ser vaga

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int vagarPosicao(tListaContabil *lista, int posicao) {

	if (listaCheia(lista) == 1)
		return ERRO_LISTA_CHEIA;

	if (listaVazia(lista) == 1)
		return 0;

	if (posicao > lista->ultimo + 1 || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	int i;
	for (i = lista->ultimo; i >= posicao; i--)
		lista->elem[i + 1] = lista->elem[i];
	return 0;
}

/**
NOME DA FUNÇÃO: adicionaEmOrdem
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	partindo do pressuposto que a lista está previamente ordenada, adiciona, se possível, um novo lançamento na
	sua posição correspondente para manter a lista ordenada.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil em que o elemento será adicionado
dado         tAgenda          valor              elemento a ser adicionado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema


*/
int adicionaEmOrdem(tListaContabil *lista, tLancamento dado) {
	int pos = 0;
	while (pos <= lista->ultimo && maior(dado, lista->elem[pos]))
		pos++;

	return adicionaNaPosicao(lista, dado, pos);
}

/**
NOME DA FUNÇÃO: obter
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lançamento, se possível, localizado na última posição da lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil em que o elemento está inserido

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tLancamento   lançamento localizado na última posição da lista,
						     ou em caso de erro, o nome do lançamento será o erro
						     e o valor será o código do erro.

*/
tLancamento obter(tListaContabil *lista) {
	return obterDaPosicao(lista, lista->ultimo);
}

/**
NOME DA FUNÇÃO: obterDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lançamento, se possível, localizado no início da lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista contábil em que o elemento está inserido

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             tLancamento   lançamento localizado na primeira posição da lista,
						     ou em caso de erro, o nome do lançamento será o erro
						     e o valor será o código do erro.

*/
tLancamento obterDoInicio(tListaContabil *lista) {
	return obterDaPosicao(lista, 0);
}

/**
NOME DA FUNÇÃO: obterDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o lançamento, se possível, localizado em uma posição arbitrária da lista.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         lista em que o elemento será procurado
posicao      int              valor              posição do elemento a ser obtido

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
--             tLancamento   lançamento localizado em uma posição arbitrária da lista,
						     ou em caso de erro, um lançamento informando que a posicão é inválida
						     e o valor será o código do erro.

*/
tLancamento obterDaPosicao(tListaContabil *lista, int posicao) {
	tLancamento lancamento;
	if(posicaoExistente(lista, posicao))
		return lista->elem[posicao];

	strcpy(lancamento.nome, "Posicao inválida.");
	lancamento.valor = ERRO_POSICAO_INVALIDA;

	return lancamento;
}

/**
NOME DA FUNÇÃO: obterlançamentoPeloNome
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna um lançamento armazenado que coincida com o nome fornecido.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista em que o lançamento será procurado
nome         char*            referência         nome a ser procurado

VALOR DE RETORNO:
nome           tipo      descrição
---------------------------------------------------------------------
lancamento     tAgenda   o lançamento buscado ou um lançamento que informa
                         que a posicão é inválida em caso de erro.

*/
tLancamento obterLancamentoPeloNome(tListaContabil *lista, char* nome) {
	int i;
	tLancamento lancamento;
	strcpy(lancamento.nome, nome);

	for (i = 0; i <= lista->ultimo; i++)
		if (igual(lancamento, lista->elem[i]))
			return lista->elem[i];

	strcpy(lancamento.nome, "Nome não consta na lista.");
	lancamento.valor = ERRO_POSICAO_INVALIDA;

	return lancamento;
}

/**
NOME DA FUNÇÃO: retira
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, o lançamento da última posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo                valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil      referência         a lista de que o lançamento será retirado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retira(tListaContabil *lista) {
	return retiraDaPosicao(lista, lista->ultimo);
}

/**
NOME DA FUNÇÃO: retiraDoInicio
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, o lançamento na primeira posição da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo                valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil      referência         a lista de que o lançamento será retirado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retiraDoInicio(tListaContabil *lista) {
	return retiraDaPosicao(lista, 0);
}

/**
NOME DA FUNÇÃO: retiraDaPosicao
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retira, se possível, um lançamento em uma posição arbitrária da lista. Ao final retorna o sucesso ou não da
	operação.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista de que o lançamento será retirado
posicao      int              valor              posição do elemento a ser removido

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   0 em caso de sucesso, código de erro em caso de problema

*/
int retiraDaPosicao(tListaContabil *lista, int posicao) {
	if (posicao > lista->ultimo || posicao < 0)
		return ERRO_POSICAO_INVALIDA;

	for (; posicao <= lista->ultimo; posicao++)
		lista->elem[posicao] = lista->elem[posicao + 1];

	lista->ultimo--;
	return 0;
}

/**
NOME DA FUNÇÃO: listaCheia
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 caso a lista esteja cheia e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista a ser verificada

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a lista esteja cheia e 0 em caso contrário


*/
int listaCheia(tListaContabil *lista) {
	if (lista->ultimo == MAXELEMENTOS - 1)
		return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: listaVazia
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 caso a lista esteja vazia e 0 em caso contrario.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista a ser verificada

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a lista esteja vazia e 0 em caso contrário

*/
int listaVazia(tListaContabil *lista) {
	if (lista->ultimo == LISTAVAZIA)
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
lista        tListaContabil   referência         a lista a ser verificada
posicao      int              valor              posição a ser testada

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso a posição seja válida e 0 em caso contrário

*/
int posicaoExistente(tListaContabil *lista, int posicao) {
	if (posicao <= lista->ultimo && posicao >= 0)
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
lista        tListaContabil   referência         a lista a ser verificada
dado         tLancamento      valor              elemento a ser procurado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso o lançamento pertença à lista e 0 em caso contrário


*/
int contem(tListaContabil *lista, tLancamento dado) {
	int i;
	for (i = 0; i <= lista->ultimo; i++)
		if (igual(dado, lista->elem[i]))
			return 1;
	return 0;
}

/**
NOME DA FUNÇÃO: igual
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna 1 se dois lançamentos fornecidos são iguais nos seus nomes e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tLancamento     valor              elemento a ser comparado
dado2         tLancamento     valor              elemento a ser comparado

VALOR DE RETORNO:
nome           tipo  descrição
---------------------------------------------------------------------
--             int   1 caso os nomes dos lançamentos sejam iguais e 0 em caso contrário.


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
	retorna 1 se o nome do primeiro lançamento fornecido procede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tLancamento      valor              elemento a ser comparado
dado2         tLancamento      valor              elemento a ser comparado

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
	retorna 1 se o nome do primeiro lançamento fornecido precede o segundo em uma ordem alfabética de nomes
	e 0 em caso contrário.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
dado1         tLancamento      valor              elemento a ser comparado
dado2         tLancamento      valor              elemento a ser comparado

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
NOME DA FUNÇÃO: inicializlista
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	prepara a lista para ser utilizada ao definir que ela está vazia (ultimo = -1)

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista a ser iniciada

VALOR DE RETORNO:
nenhum

*/
void inicializaLista(tListaContabil *lista) {
	lista->ultimo = -1;
}

/**
NOME DA FUNÇÃO: destroiLista
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	limpa a lista para ser novamente repopulada ao definir a posição do último elemento como -1 e
	libera os espaços de memória reservado para os elementos.

PARÂMETROS:
nome         tipo             valor/referência   descrição
---------------------------------------------------------------------
lista        tListaContabil   referência         a lista a ser destruída

VALOR DE RETORNO:
nenhum

*/
void destroiLista(tListaContabil *lista) {
	int i;
	for(i = 0; i < lista->ultimo; i++)
		free(lista->elem[i].nome);
	lista->ultimo = -1;
}
