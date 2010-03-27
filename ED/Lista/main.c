/*
 * main.c
 *
 *  Created on: Mar 21, 2010
 *      Author: pedropaulo
 */

#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

void exibeIntroducao();
void exibeMenuPrincipal();
void exibeMenuSecundario(char* opcao);
void exibirMensagemErro(int resultado);
void adicionarContato();
void retirarContato();
void obterContato();
void exibirContatosEmOrdem();
void exibirContato();

int main() {
	int opcao;

	exibeIntroducao();
	inicializaLista();

	while (1) {
		exibeMenuPrincipal();
		scanf("%d", &opcao);

		switch (opcao) {
		case 0:
			return EXIT_SUCCESS;
			break;
		case 1:
			adicionarContato();
			break;
		case 2:
			retirarContato();
			break;
		case 3:
			obterContato();
			break;
		case 4:
			exibirContatosEmOrdem();
			break;
		case 5:
			printf("Contatos armazenados: %d", aLista.ultimo + 1);
			break;
		case 6:
			destroiLista();
			puts("Lista limpa.");
			break;
		default:
			puts("Opção inválida");
			break;
		}
	}
}

/**
 NOME DA FUNÇÃO: exibeIntroducao
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Esta função possui o objetivo de introduzir o programa ao usuário, exibindo
 na saída padrão informações básicas sobre o programa.
 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: main
 */
void exibeIntroducao() {
	puts("INE5408 - ESTRUTURAS DE DADOS");
	puts("EXERCÍCIO 3 - LISTAS USANDO VETORES");
	puts("ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n");
}

/**
 NOME DA FUNÇÃO: exibeMenu
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Exibe na saída padrão as opções disponíveis ao usuário para manipular o programa.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: main
 */
void exibeMenuPrincipal() {
	puts("\nEscolha uma opção:");
	puts("0 - Sair do programa");
	puts("1 - Adicionar contato");
	puts("2 - Retirar contato");
	puts("3 - Obter contato");
	puts("4 - Mostrar todos os contatos em ordem");
	puts("5 - Exibir a quantidade de contatos armazenados");
	puts("6 - Limpar a lista de contatos");
}

void exibeMenuSecundario(char* opcao) {
	puts("\nEscolha uma opção: ");
	printf("0 - %s contato final", opcao);
	printf("1 - %s contato inicial", opcao);
	printf("2 - %s contato de uma posição específica", opcao);
}

void exibirMensagemErro(int resultado) {
	switch (resultado) {
	case ERRO_LISTA_CHEIA:
		puts("Erro: A lista está cheia.");
		break;
	case ERRO_LISTA_VAZIA:
		puts("Erro: A lista está vazia.");
		break;
	case ERRO_POSICAO_INVALIDA:
		puts("Erro: Posição inválida fornecida.");
		break;
	}
}

void exibirContato(tAgenda contato) {
	printf("Nome: %s", contato.nome);
	printf("Telefone: %d", contato.numero);
}

void adicionarContato() {
	int opcao, posicao, resultado;
	tAgenda elemento;

	puts("Forneça o nome do contato: ");
	getchar();
	gets(elemento.nome);
	puts("Forneça o número de telefone: ");
	scanf("%d", &elemento.numero);

	exibeMenuSecundario("Adicionar");
	scanf("%d", &opcao);

	switch (opcao) {
	case 0:
		resultado = adiciona(elemento);
		break;
	case 1:
		resultado = adicionaNoInicio(elemento);
		break;
	case 2:
		puts("Forneça a posição a ser adicionada");
		scanf("%d", &posicao);
		resultado = adicionaNaPosicao(elemento, posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0)
		exibirMensagemErro(resultado);
}

void retirarContato() {
	int opcao, posicao, resultado;

	exibeMenuSecundario("Remover");
	scanf("%d", &opcao);

	switch (opcao) {
	case 0:
		resultado = retira();
		break;
	case 1:
		resultado = retiraDoInicio();
		break;
	case 2:
		puts("Forneça a posição a ser removida");
		scanf("%d", &posicao);
		resultado = retiraDaPosicao(posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0)
		exibirMensagemErro(resultado);
}

void obterContato() {
	int opcao, posicao;
	int resultado = 0;
	tAgenda contato;

	exibeMenuSecundario("Obter");
	scanf("%d", &opcao);

	if (listaVazia())
		resultado = ERRO_LISTA_VAZIA;

	switch (opcao) {
	case 0:
		contato = obter();
		break;
	case 1:
		contato = obterDoInicio();
		break;
	case 2:
		puts("Forneça a posição a ser obtida");
		scanf("%d", &posicao);
		if (!posicaoValida(posicao))
			resultado = ERRO_POSICAO_INVALIDA;

		contato = obterDaPosicao(posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0) {
		exibirMensagemErro(resultado);
		return;
	}

	exibirContato(contato);
}

//TODO: Por agora essa função não exibe em ordem.
//Decisão de projeto, armazenar em ordem ou ordenar depois?
void exibirContatosEmOrdem() {
	int i;
	for(i = 0; i < aLista.ultimo; i++)
		exibirContato(aLista.elem[i]);
}

