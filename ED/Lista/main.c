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

main
	fica responsável por receber o comando do usário e delegar o trabalho a uma das funções
	de lista.c que executará o comando pedido.

exibeIntroducao
	apenas introduz o usuário ao programa.

exibeMenuPrincipal
	apresenta as opções disponíveis ao usuário.

exibeMenuSecundario
	apresenta ao usuário as subopções disponíveis nas operações de adição, remoção e obtenção de contatos,
	por exemplo, adicionar um contato no início da lista ou remover o último contato ou ainda obter o 5o
	contato armazenado.

exibirMensagemErro
	caso o usuário realize alguma operação inválida na lista esta função é a responsável por avisá-lo de
	tal comportamento inexperado. Erros possíveis incluem remover elementos de uma lista vazia, adicionar
	mais contatos que o máximo permitido ou ainda tentar acessar um elemento em uma posição fora dos limites
	da lista.

adicionarContato
	responsável por obter o contato a ser armazenado e encaminhá-lo à lista de maneira apropriada e por fim
	informar se tudo aconteceu de maneira correta.

retirarContato
	responsável por gerenciar as operações de remoção de contatos e delegá-las apropriadamente à lista e
	informar se tudo aconteceu de maneira correta.

obterContato
	responsável por gerenciar as operações de obtenção de contatos e delegá-las apropriadamente à lista e
	informar se tudo aconteceu de maneira correta.

exibirContato
	exibe um único contato ao usuário.

exibirContatosEmOrdem
	exibe ao usuário a lista armazenada em ordem alfabética de nomes dos contatos.


ARQUIVOS INCLUSOS:
   stdio.h
   stdlib.h
   lista.h

ARQUIVOS DE DADOS:
   nenhum

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
void exibirContato();
void exibirContatosEmOrdem();

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
	puts("1 - Adicionar contato");
	puts("2 - Retirar contato");
	puts("3 - Obter contato");
	puts("4 - Mostrar todos os contatos");
	puts("5 - Exibir a quantidade de contatos armazenados");
	puts("6 - Limpar a lista de contatos");
}


/**
NOME DA FUNÇÃO: exibeMenuSecundario
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	apresenta ao usuário as subopções disponíveis nas operações de adição,
	remoção e obtenção de contatos, por exemplo, adicionar um contato no
	início da lista ou remover o último contato ou ainda obter o 5o
	contato armazenado.

PARÂMETROS:
nome         tipo             valor/referência   descrição
--------------------------------------------------------------------------
opcao        char*            valor              nome da opção, "adicionar",
												 "remover" ou "obter"

VALOR DE RETORNO:
nenhum

CHAMA: nada

CHAMADA DE: adicionarContato, retirarContato, obterContato
*/
void exibeMenuSecundario(char* opcao) {
	puts("\nEscolha uma opção: \n");
	printf("0 - %s final\n", opcao);
	printf("1 - %s início\n", opcao);
	printf("2 - %s local específico\n", opcao);
}

/**
 NOME DA FUNÇÃO: exibirMensagemErro
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	Exibe caso o usuário realize alguma operação inválida na lista esta função é a responsável por avisá-lo de
	tal comportamento inexperado. Erros possíveis incluem remover elementos de uma lista vazia, adicionar
	mais contatos que o máximo permitido ou ainda tentar acessar um elemento em uma posição fora dos limites
	da lista.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: adicionarContato, retirarContato, obterContato
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
 NOME DA FUNÇÃO: exibirContato
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	É responsável por exibir um único contato ao usuário.

 PARÂMETROS:
 nome         tipo             valor/referência   descrição
 --------------------------------------------------------------------------
 contato      tAgenda          valor              o contato a ser exibido

 VALOR DE RETORNO:
 nenhum

 CHAMA: nada

 CHAMADA DE: exibirContatosEmOrdem, obterContato
 */
void exibirContato(tAgenda contato) {
	printf("Nome: %s\n", contato.nome);
	printf("Telefone: %d\n", contato.numero);
}

/**
 NOME DA FUNÇÃO: adicionarContato
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	É responsável por obter o contato a ser armazenado e encaminhá-lo à lista de maneira apropriada e por fim
	informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, adiciona, adicionaNoInicio, adicionaNaPosicao, exibirMensagemErro

 CHAMADA DE: main
 */
void adicionarContato() {
	int opcao, posicao, resultado;
	tAgenda elemento;

	puts("Forneça o nome do contato: ");
	getchar();
	scanf("%[^\n]", &elemento.nome);
	puts("Forneça o número de telefone: ");
	scanf("%d", &elemento.numero);

	exibeMenuSecundario("Adicionar no");
	puts("3 - Adicionar em ordem");
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
	case 3:
		resultado = adicionaEmOrdem(elemento);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 0)
		exibirMensagemErro(resultado);
}

/**
 NOME DA FUNÇÃO: retirarContato
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	É responsável por gerenciar as operações de remoção de contatos e delegá-las apropriadamente à lista e
	informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, retira, retiraDoInicio, retiraDaPosicao, exibirMensagemErro

 CHAMADA DE: main
 */
void retirarContato() {
	int opcao, posicao, resultado;

	exibeMenuSecundario("Remover do");
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

/**
 NOME DA FUNÇÃO: obterContato
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	É responsável por gerenciar as operações de obtenção de contatos e delegá-las apropriadamente à lista e
	informar se tudo aconteceu de maneira correta.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibeMenuSecundario, listaVazia, obter, obterDoInicio, posicaoValida, obterDaPosicao
		exibirMensagemErro, exibirContato

 CHAMADA DE: main
 */
void obterContato() {
	int opcao, posicao;
	int resultado = 0;
	tAgenda contato;

	exibeMenuSecundario("Obter do");
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

/**
 NOME DA FUNÇÃO: exibirContatosEmOrdem
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
	Exibe ao usuário a lista armazenada em ordem alfabética de nomes dos contatos.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 CHAMA: exibirContato

 CHAMADA DE: main
 */
void exibirContatosEmOrdem() {
	int i;
	for(i = 0; i <= aLista.ultimo; i++)
		exibirContato(aLista.elem[i]);
}

