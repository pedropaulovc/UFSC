/**
ARQUIVO:       main.c
TÍTULO:        Implementação da filas encadeadas
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         27 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila encadeada.

FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de filas. Ele possui um menu simples que aceita do usuário comandos para os principais
usos da estrutura: "enfileirar, desenfileirar, limpar, mostrar fila, sair do programa" em um programa
de exemplo que funciona como sistema de controle de ordem de serviços de uma empresa de manutenção
de computadores.


FUNÇÕES:

main
	fica responsável por receber o comando do usário e delegar o trabalho a uma das funções
	de FilaEncadeada.c que executará o comando pedido.

exibeIntroducao
	apenas introduz o usuário ao programa.

exibeMenuPrincipal
	apresenta as opções principais disponíveis ao usuário.

exibeMenuSecundario
	apresenta sub-opções dentro de uma opção escolhida no menu principal.

exibirMensagemErro
	responsável por informar ao usuário de possíveis erros que ele venha a enfrentar durante a execução do programa.

adicionarOrdemServico
	recebe os dados referentes a uma ordem de serviço e os fornece à fila que se e encarrega de armazená-los

concluirServico
	desenfileira o primeiro elemento e informa ao usuário qual serviço foi concluído.

mostrarServicosPendentes
	apresenta a fila de ordens de serviço pendentes ao usuário.

exibirInfo
	exibe os dados de uma ordem de serviço dada.

exibirInfos
	itera a lista exibindo todas as ordens de serviços pendentes.

ARQUIVOS INCLUSOS:
   stdio.h
   string.h
   stdlib.h
   fila.h

ARQUIVOS DE DADOS:
   nenhum

*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "FilaEncadeada.h"
#include "tInfo.h"

#define SEMANA 604800

void exibeIntroducao();
void exibeMenuPrincipal();
void exibeMenuSecundario(char* opcao);
void exibirMensagemErro(int resultado);
void adicionarOrdemServico();
void concluirServico();
void mostrarServicosPendentes();
void exibirInfo();
void exibirInfos();

tFila* filaConserto;

char buffer[10000];

int main() {
	int opcao;

	exibeIntroducao();
	filaConserto = inicializar();

	while (1) {
		exibeMenuPrincipal();
		scanf("%d", &opcao);

		switch (opcao) {
		case 0:
			return EXIT_SUCCESS;
			break;
		case 1:
			adicionarOrdemServico();
			break;
		case 2:
			concluirServico();
			break;
		case 3:
			mostrarServicosPendentes();
			break;
		case 4:
			printf("Atualmente há %d serviços pendentes.\n",
					filaConserto->tamanho);
			break;
		case 5:
			limpar(filaConserto);
			printf("Fila limpa.\n");
			break;
		default:
			puts("Opção inválida\n");
			break;
		}
	}
}

void exibeIntroducao() {
	puts("INE5408 - ESTRUTURAS DE DADOS");
	puts("EXERCÍCIO 6 - FILA ENCADEADA");
	puts("ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n");
}

void exibeMenuPrincipal() {
	puts("\nEscolha uma opção:");
	puts("0 - Sair do programa");
	puts("1 - Adicionar nova ordem de serviço");
	puts("2 - Concluir serviço");
	puts("3 - Visualizar todos os serviços pendentes");
	puts("4 - Ver quantidade de serviços pendentes");
	puts("5 - Limpar a fila de servços");
}

void exibirMensagemErro(int resultado) {
	switch (resultado) {
	case ERROFILACHEIA:
		puts("Erro: A fila está cheia.");
		break;
	default:
		break;
	}
}

void exibirInfo(tInfo* info) {
	if (info == NULL) {
		puts("Elemento inválido");
		return;
	}

	printf("Solicitante: %s\n", info->nomeSolicitante);
	printf("Telefone: %d\n", info->telefone);
	printf("Modelo: %s\n", info->modeloComputador);
	printf("Valor: %.2f\n", info->valorConserto);
	strftime(buffer, 10000, "Data de entrega: %d-%m-%y\n", localtime(
			&info->dataEntrega));
	puts(buffer);
}

void mostrarServicosPendentes() {
	tElemento* atual = filaConserto->inicio;
	if(atual != NULL)
		puts("Serviços pendentes: \n");
	else
		puts("Não há serviços pendentes.\n");
	while (atual != NULL) {
		exibirInfo(atual->info);
		atual = atual->proximo;
	}
}

void adicionarOrdemServico() {
	int resultado;
	tInfo *elemento;

	elemento = (tInfo *) malloc(sizeof(tInfo));
	tInfo* ultimo = obterFimDaFila(filaConserto);

	puts("Forneça o nome do solicitante: ");
	getchar();
	scanf("%[^\n]", buffer);
	elemento->nomeSolicitante = (char *) malloc(strlen(buffer) + 1);
	strcpy(elemento->nomeSolicitante, buffer);

	puts("Forneça o valor do conserto: ");
	scanf("%f", &elemento->valorConserto);

	puts("Forneça o telefone do solicitante: ");
	scanf("%d", &elemento->telefone);

	puts("Forneça o modelo do computador");
	getchar();
	scanf("%[^\n]", buffer);
	elemento->modeloComputador = (char *) malloc(strlen(buffer) + 1);
	strcpy(elemento->modeloComputador, buffer);

	if (ultimo != NULL)
		elemento->dataEntrega = ultimo->dataEntrega + 2 * SEMANA;
	else
		elemento->dataEntrega = time(NULL) + 2 * SEMANA;

	resultado = enfileirar(filaConserto, elemento);

	if (resultado < 0)
		exibirMensagemErro(resultado);
}

void concluirServico() {
	tInfo* info = desenfileirar(filaConserto);
	if (info != NULL) {
		puts("Concluído serviço abaixo:");
		exibirInfo(info);
		destruirInfo(info);
	} else {
		puts("Não há serviços pendentes");
	}
}


void exibirInfos(tFila *fila) {
	tElemento *elemento;
	elemento = fila->inicio;
	while (elemento != NULL) {
		exibirInfo(elemento->info);
		elemento = elemento->proximo;
	}
}
