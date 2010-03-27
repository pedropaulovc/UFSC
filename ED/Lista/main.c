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

int main(){
	int opcao;
	elementoDaFila elemento;

	exibeIntroducao();
	inicializar();

	while(1){
		exibeMenuPrincipal();
		scanf("%d",&opcao);

		switch(opcao){
		case 0:
			return EXIT_SUCCESS;
			break;
		case 1:
			puts("Forneça o elemento (No máximo 30 caracteres): ");
			getchar();
			gets(elemento.texto);
			if(enfileirar(elemento) == ERRO_FILA_CHEIA)
				puts("A fila está cheia");
			break;
		case 2:
			if(verPosicaoFinal() == -1){
				puts("A fila está vazia.");
				break;
			}
			elemento = obterPrimeiroElemento();
			desenfileirar();
			printf("Elemento desenfileirado: %s\n", elemento.texto);
			break;
		case 3:
			limpar();
			break;
		case 4:
			mostrarFila();
			break;
		case 5:
			printf("%d\n", verPosicaoFinal());
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
void exibeIntroducao(){
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
void exibeMenuPrincipal(){
	puts("\nEscolha uma opção:");
	puts("0 - Sair do programa");
	puts("1 - Adicionar contato");
	puts("2 - Retirar contato");
	puts("3 - Obter contato");
	puts("4 - Mostrar todos os contatos");
	puts("5 - Exibir a quantidade de contatos armazenados");
	puts("6 - Limpar a lista de contatos");
}

int vagarPosicao(int posicao);
int adiciona(tAgenda dado);
int adicionaNoInicio(tAgenda dado);
int adicionaNaPosicao(tAgenda dado, int posicao);
int adicionaEmOrdem(tAgenda dado);
int retira();
int retiraDoInicio();
int retiraDaPosicao(int posicao);
int listaCheia();
int listaVazia();
int posicao(tAgenda dado);
int contem(tAgenda dado);
int igual(tAgenda dado1, tAgenda dado2);
int maior(tAgenda dado1, tAgenda dado2);
int menor(tAgenda dado1, tAgenda dado2);
tAgenda obter(int posicao);
tAgenda obterElemento(int posicao);
tAgenda obterPosicao(int posicao);
