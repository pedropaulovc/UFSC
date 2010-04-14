/**
 ARQUIVO:       main.c
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

 main
 fica responsável por receber o comando do usário e delegar o trabalho a uma das funções
 de lista.c que executará o comando pedido.

 exibeIntroducao
 apenas introduz o usuário ao programa.

 exibeMenuPrincipal
 apresenta as opções disponíveis ao usuário.

 exibeMenuLancamentos
 permite ao usuário definir se a operação escolhida deve ser feita para a lista de créditos ou débitos

 exibirMensagemErro
 caso o usuário realize alguma operação inválida na lista esta função é a responsável por avisá-lo de
 tal comportamento inexperado. Erros possíveis incluem remover elementos de uma lista vazia, adicionar
 mais lançamentos que o máximo permitido ou ainda tentar acessar um elemento em uma posição fora dos limites
 da lista.

 adicionarLancamento
 responsável por obter o lançamento a ser armazenado e encaminhá-lo à lista de maneira apropriada e por fim
 informar se tudo aconteceu de maneira correta.

 retirarLancamento
 responsável por gerenciar as operações de remoção de lançamentos e delegá-las apropriadamente à lista e
 informar se tudo aconteceu de maneira correta.

 obterLancamento
 responsável por gerenciar as operações de obtenção de lançamentos e delegá-las apropriadamente à lista e
 informar se tudo aconteceu de maneira correta.

 exibirLancamento
 exibe um único lançamento ao usuário.

 exibirLancamentos
 exibe ao usuário uma lista com todos os lançamentos armazenados até o momento.


 ARQUIVOS INCLUSOS:
 stdio.h
 stdlib.h
 lista.h
 string.h

 ARQUIVOS DE DADOS:
 nenhum

 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

void exibeIntroducao();
void exibeMenuPrincipal();
void exibirMensagemErro(int resultado);
void adicionarLancamento();
void retirarLancamento();
void obterLancamento();
void exibirLancamento();
void exibirLancamentos();

int main() {
	int opcao;

	exibeIntroducao();
	inicializaLista(&debitos);
	inicializaLista(&creditos);

	while (1) {
		exibeMenuPrincipal();
		scanf("%d", &opcao);

		switch (opcao) {
		case 0:
			return EXIT_SUCCESS;
			break;
		case 1:
			adicionarLancamento();
			break;
		case 2:
			retirarLancamento();
			break;
		case 3:
			obterLancamento();
			break;
		case 4:
			if(listaVazia(&debitos) == 0){
				puts("Débitos: ");
				exibirLancamentos(&debitos);
			} else
				puts("Sem débitos.");

			if (listaVazia(&creditos) == 0){
				puts("Créditos: ");
				exibirLancamentos(&creditos);
			} else
				puts("Sem créditos.");
			break;
		case 5:
			puts("Lançamentos armazenados:");
			printf("Débitos: %d\n", debitos.ultimo + 1);
			printf("Céditos: %d\n", creditos.ultimo + 1);
			break;
		case 6:
			destroiLista(&debitos);
			destroiLista(&creditos);
			puts("Lançamentos limpos.");
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
	puts("EXERCÍCIO 4 - PASSAGEM DE PARÂMETROS");
	puts("ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n");
}

/**
 NOME DA FUNÇÃO: exibeMenuPrincipal
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
	puts("1 - Adicionar novo lançamento");
	puts("2 - Remover lançamento");
	puts("3 - Mostrar saldo atual");
	puts("4 - Ver toda a movimentação financeira");
	puts("5 - Exibir a quantidade de lançamentos armazenados");
	puts("6 - Limpar os lançamentos");
}

void exibeMenuLancamentos(char* opcao){
	puts("\nEscolha uma opção: \n");
	printf("0 - %s débitos\n", opcao);
	printf("1 - %s créditos\n", opcao);
}

/**
 NOME DA FUNÇÃO: exibirMensagemErro
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Exibe caso o usuário realize alguma operação inválida na lista esta função é a responsável por avisá-lo de
 tal comportamento inexperado. Erros possíveis incluem remover elementos de uma lista vazia, adicionar
 mais lançamentos que o máximo permitido ou ainda tentar acessar um elemento em uma posição fora dos limites
 da lista.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: adicionarLançamento, retirarLançamento, obterLançamento
 */
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

/**
 NOME DA FUNÇÃO: exibirLancamento
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 É responsável por exibir um único lançamento ao usuário.

 PARÂMETROS:
 nome         tipo             valor/referência   descrição
 --------------------------------------------------------------------------
 lançamento      tAgenda          valor              o lançamento a ser exibido

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: exibirLançamentosEmOrdem, obterLançamento
 */
void exibirLancamento(tLancamento lancamento) {
	printf("Nome: %s\n", lancamento.nome);
	printf("Valor: %f\n", lancamento.valor);
}

/**
 NOME DA FUNÇÃO: adicionarLançamento
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 É responsável por obter o lançamento a ser armazenado e encaminhá-lo à lista de maneira apropriada e por fim
 informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, adiciona, adicionaNoInicio, adicionaNaPosicao, exibirMensagemErro

 CHAMADA DE: main
 */
void adicionarLancamento() {
	int opcao, resultado;
	tLancamento elemento;

	puts("Forneça o nome do lançamento: ");
	getchar();
	scanf("%[^\n]", &buffer);
	elemento.nome = malloc(strlen(buffer) + 1);
	strcpy(elemento.nome, buffer);
	puts("Forneça o valor do lançamento: ");
	scanf("%lf", &elemento.valor);

	exibeMenuLancamentos("Adicionar como");
	scanf("%d", &opcao);

	switch (opcao) {
	case 0:
		resultado = adicionaEmOrdem(&debitos, elemento);
		break;
	case 1:
		resultado = adicionaEmOrdem(&creditos, elemento);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0)
		exibirMensagemErro(resultado);
}

/**
 NOME DA FUNÇÃO: retirarLançamento
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 É responsável por gerenciar as operações de remoção de lançamentos e delegá-las apropriadamente à lista e
 informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, retira, retiraDoInicio, retiraDaPosicao, exibirMensagemErro

 CHAMADA DE: main
 */
void retirarLancamento() {
	int opcao, posicao, resultado;

	exibeMenuLancamentos("Remover dos");
	scanf("%d", &opcao);
	puts("Forneça a posição a ser removida");
	scanf("%d", &posicao);

	switch (opcao) {
	case 0:
		resultado = retiraDaPosicao(&debitos, posicao);
		break;
	case 1:
		resultado = retiraDaPosicao(&creditos, posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0)
		exibirMensagemErro(resultado);
}

/**
 NOME DA FUNÇÃO: obterLançamento
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 É responsável por gerenciar as operações de obtenção de lançamentos e delegá-las apropriadamente à lista e
 informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, listaVazia, obter, obterDoInicio, posicaoValida, obterDaPosicao
 exibirMensagemErro, exibirLançamento

 CHAMADA DE: main
 */
void obterLancamento() {
	int opcao, aPosicao;
	tLancamento lancamento;

	exibeMenuLancamentos("Obter dos");
	scanf("%d", &opcao);
	puts("Forneça a posição a ser obtida");
	scanf("%d", &aPosicao);

	switch (opcao) {
	case 0:
		lancamento = obterDaPosicao(&debitos, aPosicao);
		break;
	case 1:
		lancamento = obterDaPosicao(&creditos, aPosicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (lancamento.valor == ERRO_POSICAO_INVALIDA)
		puts(lancamento.nome);
	else
		exibirLancamento(lancamento);
}

/**
 NOME DA FUNÇÃO: exibirLançamentos
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Exibe ao usuário a lista armazenada em ordem alfabética de nomes dos lançamentos.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibirLançamento

 CHAMADA DE: main
 */
void exibirLancamentos(tListaContabil *aLista) {
	int i;
	for (i = 0; i <= aLista->ultimo; i++)
		exibirLancamento(aLista->elem[i]);
}

