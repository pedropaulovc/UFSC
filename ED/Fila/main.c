/**
ARQUIVO:       main.c
TÍTULO:        Implementação da Filas de Strings com Vetores em "C"
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         18 de março de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila.


FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de filas. Ele possui um menu simples que aceita do usuário comandos para os principais
usos da estrutura: "enfileirar, desenfileirar, limpar, mostrar fila, sair do programa".
No mesmo enunciado, foi definido que seria criada uma variável global, aFila, inicializada
em fila.h, contendo uma fila de 100 vetores de strings de comprimento 30.

FUNÇÕES:

main
	fica responsável por receber o comando do usário e delegar o trabalho a uma das funções
	de fila.c que executará o comando pedido.

exibeIntroducao
	apenas introduz o usuário ao programa.

exibeMenu
	apresenta as opções disponíveis ao usuário.

ARQUIVOS INCLUSOS:
   stdio.h
   string.h
   stdlib.h
   fila.h

ARQUIVOS DE DADOS:
   nenhum

*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "fila.h"

void exibeIntroducao();
void exibeMenu();

int main(){
	int opcao;
	elementoDaFila elemento;

	exibeIntroducao();
	inicializar();

	while(1){
		exibeMenu();
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
	puts("EXERCÍCIO 2 - FILAS USANDO VETORES");
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
void exibeMenu(){
	puts("\nEscolha uma opção:");
	puts("0 - Sair do programa");
	puts("1 - Enfileirar elemento");
	puts("2 - Desenfileirar elemento");
	puts("3 - Limpar fila");
	puts("4 - Mostrar a fila");
	puts("5 - Exibir posição do último elemento");
}
