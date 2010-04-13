#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "FilaEncadeada.h"
#include "tInfo.h"

void exibeIntroducao();
void exibeMenuPrincipal();
void exibeMenuSecundario(char* opcao);
void exibirMensagemErro(int resultado);
void adicionarOrdemServico();
void concluirServico();
void mostrarSaldo();
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
			mostrarSaldo();
			break;
		case 4:
			printf("Atualmente há %d serviços pendentes.\n", filaConserto->tamanho);
			break;
		case 5:
			limpar(filaConserto);
			printf("Fila limpa.\n");
			break;
		default:
			puts("Opção inválida");
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
	puts("1 - Adicionar novo lançamento");
	puts("2 - Remover lançamento");
	puts("3 - Mostrar saldo atual");
	puts("4 - Ver toda a movimentação financeira");
	puts("5 - Exibir a quantidade de lançamentos armazenados");
	puts("6 - Limpar os lançamentos");
}

void exibeMenuSecundario(char* opcao) {
	puts("\nEscolha uma opção: \n");
	printf("0 - %s final\n", opcao);
	printf("1 - %s início\n", opcao);
	printf("2 - %s local específico\n", opcao);
}

void exibeMenuLancamentos(char* opcao){
	puts("\nEscolha uma opção: \n");
	printf("0 - %s débitos\n", opcao);
	printf("1 - %s créditos\n", opcao);
}

void exibirMensagemErro(int resultado) {
	switch (resultado) {
	case ERROFILACHEIA:
		puts("Erro: A fila está cheia.");
		break;
	default :
		break;
	}
}

void exibirInfo(tInfo* info) {
	printf("Solicitante: %s\n", info->nomeSolicitante);
	strftime("Data de entrega: %.2f\n", info->dataEntrega);
}

void adicionarOrdemServico() {
	int opcao, resultado;
	tInfo *elemento;

	elemento = (tInfo *)malloc(sizeof(tInfo));

	puts("Forneça o nome do lançamento: ");
	getchar();
	scanf("%[^\n]", &buffer);
	elemento->nome = (char *)malloc(strlen(buffer) + 1);
	strcpy(elemento->nome, buffer);
	puts("Forneça o valor do lançamento: ");
	scanf("%f", &elemento->valor);

	exibeMenuLancamentos("Adicionar como");
	scanf("%d", &opcao);

	switch (opcao) {
	case 0:
		resultado = adicionaNoFim(debitos, elemento);
		break;
	case 1:
		resultado = adicionaNoFim(creditos, elemento);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado != 1)
		exibirMensagemErro(resultado);
}

void concluirServico() {
	int opcao, posicao;
	tInfo *resultado;

	exibeMenuLancamentos("Remover dos");
	scanf("%d", &opcao);
	puts("Forneça a posição a ser removida");
	scanf("%d", &posicao);

	switch (opcao) {
	case 0:
		resultado = retiraDaPosicao(debitos, posicao);
		break;
	case 1:
		resultado = retiraDaPosicao(creditos, posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	if (resultado == NULL){
		exibirMensagemErro(ERRO_POSICAO_INVALIDA);
		return;
	}

	puts("Lançamento retirado:");
	exibirInfo(resultado);
	destroi(resultado);
}

void mostrarSaldo() {
	float credito = 0.0;
	float debito = 0.0;
	tElemento *elemento;
	tInfo *info;

	elemento = creditos->dados;
	while (elemento != NULL){
		info = elemento->info;
		credito += info->valor;
		elemento = elemento->proximo;
	}
	elemento = debitos->dados;
	while (elemento != NULL){
		info = elemento->info;
		debito += info->valor;
		elemento = elemento->proximo;
	}

	printf("Crédito: %.2f\n", credito);
	printf("Débito: %.2f\n", debito);
	printf("Total: %.2f\n", credito - debito);
}
void eliminarInfo(){
	int opcao, posicao;
	int resultado;

	exibeMenuLancamentos("Eliminar dos");
	scanf("%d", &opcao);
	puts("Forneça a posição a ser eliminada");
	scanf("%d", &posicao);

	switch (opcao) {
	case 0:
		resultado = eliminaDaPosicao(debitos, posicao);
		break;
	case 1:
		resultado = eliminaDaPosicao(creditos, posicao);
		break;
	default:
		puts("Opção Inválida");
		break;
	}

	exibirMensagemErro(resultado);
}

void exibirInfos(tFila *lista){
	tElemento *elemento;
	elemento = lista->dados;
	while(elemento != NULL){
		exibirInfo(elemento->info);
		elemento = elemento->proximo;
	}
}
