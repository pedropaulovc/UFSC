/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é uma implementação do algoritmo para solver o problema
das Torres de Hanoi de maneira iterativa além de conter extensões que permitem ao usuário verificar sua complexidade.

FUNÇÕES
solveTorreHanoiIterativo
	é o algoritmo principal que solve o problema das Torres de Hanoi.

populaPino
	empilha um número de discos determinado pelo usuário em ordem decrescente de tamanho.

encontraMenorDisco
	dado um vetor contendo um número determinado de pinos, a função retorna um ponteiro para o menor dos discos.

moveDisco
	dados dois pinos, essa função desempilha um disco da fonte e reempilha-o no destino, atualizando as informações
	inerentes ao disco.

obterNumMovimentacoes
	retorna o número de movimentações de discos acumuladas até o momento.

limparNumMovimentacoes
	limpa o número de movimentaçõs de discos.

*/
#include <stdio.h>
#include <stdlib.h>
#include "PilhaEncadeada.h"
#include "hanoi.h"

tInfo* encontraMenorDisco(tPilha* pilhas[], int qtdPilhas);
int moveDisco(tPilha* fonte, tPilha* destino);
void populaPino(tPilha* pino, int n);
int moveDisco(tPilha* fonte, tPilha* destino);

int numMovimentacoes = 0;

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	é o algoritmo principal que solve o problema das Torres de Hanoi.

PARÂMETROS:
	as pilhas de fonte, meio e destino e a quantidade e discos contidos na fonte.

VALOR DE RETORNO:
	nenhum

*/
void solveTorreHanoiIterativo(tPilha* fonte, tPilha* meio, tPilha* destino, int n){
	if (fonte == NULL || meio == NULL || destino == NULL || n <= 0)
		return;
	tInfo *menor, *outro;
	tPilha* pilhas[3] = {fonte, meio, destino};

	int i = 0;

	do {
		/*Na primeira jogada apenas, o disco do topo do pino fonte vai:
		 * para o pino destino SE o número de discos for ímpar
		 * para o pino do meio SE o numero de discos for par.*/
		menor = obterTopo(fonte);
		if(i == 0){
			if(n % 2 == 0)
				moveDisco(fonte, meio);
			else
				moveDisco(fonte, destino);
		/*Nas outras jogadas mova o menor disco ocupando algum topo
		 *  para o pino de onde ele não veio em uma jogada anterior;*/
		} else {
			menor = encontraMenorDisco(pilhas, 3);

			if(menor->pilhaAnterior == fonte && menor->pilhaAtual == meio)
				moveDisco(meio, destino);
			else if(menor->pilhaAnterior == fonte && menor->pilhaAtual == destino)
				moveDisco(destino, meio);
			else if(menor->pilhaAnterior == meio && menor->pilhaAtual == fonte)
				moveDisco(fonte, destino);
			else if(menor->pilhaAnterior == meio && menor->pilhaAtual == destino)
				moveDisco(destino, fonte);
			else if(menor->pilhaAnterior == destino && menor->pilhaAtual == fonte)
				moveDisco(fonte, meio);
			else if(menor->pilhaAnterior == destino && menor->pilhaAtual == meio)
				moveDisco(meio, fonte);
		}

		/*Se houver peça fora do destino, Mova a única outra peça possível
		 *  de ser movida (só haverá um lugar possível para colocá-la).
		 *
		 *  (Conclusão que cheguei: Nesse momento só há dois pinos importantes,
		 *  os que não contem o menor disco. Descobertos quais são esses dois pinos
		 *  deve-se mover o menor dentre esses dois de um pino a outro)*/
		if(destino->tamanho != n){
			tPilha* pilhasSegundaJogada[2];
			if(menor->pilhaAtual == fonte){
				pilhasSegundaJogada[0] = meio;
				pilhasSegundaJogada[1] = destino;
			} else if(menor->pilhaAtual == meio){
				pilhasSegundaJogada[0] = fonte;
				pilhasSegundaJogada[1] = destino;
			} else if(menor->pilhaAtual == destino){
				pilhasSegundaJogada[0] = fonte;
				pilhasSegundaJogada[1] = meio;
			}

			outro = encontraMenorDisco(pilhasSegundaJogada, 2);

			if(outro->pilhaAtual == pilhasSegundaJogada[0])
				moveDisco(outro->pilhaAtual, pilhasSegundaJogada[1]);
			else
				moveDisco(outro->pilhaAtual, pilhasSegundaJogada[0]);
		}
		i++;
	} while(destino->tamanho != n);

}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	empilha um número de discos determinado pelo usuário em ordem decrescente de tamanho.

PARÂMETROS:
	o pino a ser populado e a quantidade de discos a serem inseridos.

VALOR DE RETORNO:
	nenhum

*/
void populaPino(tPilha* pino, int n){
	if(pino == NULL)
		return;
	int i;
	tInfo* info;
	for(i = 0; i < n; i++){
		info = (tInfo*) malloc(sizeof(tInfo));
		if(info == NULL)
			return;
		info->tamanho = n - i;
		info->pilhaAtual = pino;
		info->pilhaAnterior = NULL;
		empilha(pino, info);
	}
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	dado um vetor contendo um número determinado de pinos, a função retorna um ponteiro para o menor dos discos.

PARÂMETROS:
	o vetor de pilhas a serem analisados e a o seu tamanho.

VALOR DE RETORNO:
	ponteiro para o menor dos discos dentre os pinos analisados.

*/
tInfo* encontraMenorDisco(tPilha* pilhas[], int qtdPilhas){
	if(pilhas == NULL || qtdPilhas <= 0)
		return NULL;
	int i = 0;
	tInfo* menor;
	/* Esse laço encontra o primeiro pino não vazio */
	do{
		menor = obterTopo(pilhas[i]);
		i++;
	} while (menor == NULL && i < qtdPilhas);

	if(menor == NULL)
		return NULL;

	tInfo* atual;
	for(; i < qtdPilhas; i++){
		atual = obterTopo(pilhas[i]);
		if(atual != NULL)
			if(atual->tamanho < menor->tamanho)
				menor = atual;
	}
	return menor;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	dados dois pinos, essa função desempilha um disco da fonte e reempilha-o no destino, atualizando as informações
	inerentes ao disco.

PARÂMETROS:
	as pilhas fonte e destino.

VALOR DE RETORNO:
	o tamanho da pilha de destino ou um código de erro.

*/
int moveDisco(tPilha* fonte, tPilha* destino){
	tInfo* disco = desempilha(fonte);
	if(disco == NULL)
		return ERRO_DADOS_INVALIDOS;
	disco->pilhaAnterior = fonte;
	disco->pilhaAtual = destino;
	numMovimentacoes++;
	return empilha(destino, disco);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o número de movimentações de discos acumuladas até o momento.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o número de movimentações acumulado.

*/
int obterNumMovimentacoes(){
	return numMovimentacoes;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	limpa o número de movimentaçõs de discos.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void limparNumMovimentacoes(){
	numMovimentacoes = 0;
}
