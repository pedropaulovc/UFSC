/*
 * hanoi.c
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */
#include <stdio.h>
#include <stdlib.h>
#include "PilhaEncadeada.h"
#include "hanoi.h"

tInfo* encontraMenorDisco(tPilha* pilhas[], int qtdPilhas);
int moveDisco(tPilha* fonte, tPilha* destino);
void populaPino(tPilha* pino, int n);
int moveDisco(tPilha* fonte, tPilha* destino);

void solveTorreHanoiRecursivo(tPilha* fonte, tPilha* meio, tPilha* destino, int n) {
	if (fonte == NULL || meio == NULL || destino == NULL || n <= 0)
		return;

	tInfo* umDisco;
	if (n == 1) {
		umDisco = desempilha(fonte);
		empilha(destino, umDisco);
	} else {
		solveTorreHanoiRecursivo(fonte, meio, destino, n - 1);
		umDisco = desempilha(fonte);
		empilha(destino, umDisco);
		solveTorreHanoiRecursivo(meio, destino, fonte, n - 1);
	}
}

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
			if(menor->pilhaAnterior == fonte && menor->pilhaAtual == destino)
				moveDisco(destino, meio);
			if(menor->pilhaAnterior == meio && menor->pilhaAtual == fonte)
				moveDisco(fonte, destino);
			if(menor->pilhaAnterior == meio && menor->pilhaAtual == destino)
				moveDisco(destino, fonte);
			if(menor->pilhaAnterior == destino && menor->pilhaAtual == fonte)
				moveDisco(fonte, meio);
			if(menor->pilhaAnterior == destino && menor->pilhaAtual == meio)
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
			}

			if(menor->pilhaAtual == meio){
				pilhasSegundaJogada[0] = fonte;
				pilhasSegundaJogada[1] = destino;
			}

			if(menor->pilhaAtual == destino){
				pilhasSegundaJogada[0] = fonte;
				pilhasSegundaJogada[1] = meio;
			}

			outro= encontraMenorDisco(pilhasSegundaJogada, 2);

			if(outro->pilhaAtual == pilhasSegundaJogada[0])
				moveDisco(outro->pilhaAtual, pilhasSegundaJogada[1]);
			else
				moveDisco(outro->pilhaAtual, pilhasSegundaJogada[0]);
		}
		i++;
	} while(destino->tamanho != n);

}

void populaPino(tPilha* pino, int n){
	if(pino == NULL)
		return;
	int i;
	tInfo* info;
	for(i = 0; i < n; i++){
		info = (tInfo*) malloc(sizeof(tInfo));
		if(info == NULL)
			return;
		info->tamanho = i;
		info->pilhaAtual = pino;
		info->pilhaAnterior = NULL;
		empilha(pino, info);
	}
}

tInfo* encontraMenorDisco(tPilha* pilhas[], int qtdPilhas){
	if(pilhas == NULL || qtdPilhas <= 0)
		return NULL;
	int i;
	tInfo* menor = obterTopo(pilhas[0]);
	tInfo* atual;
	for(i = 1; i < qtdPilhas; i++){
		atual = obterTopo(pilhas[i]);
		if(atual != NULL)
			if(atual->tamanho < menor->tamanho)
				menor = atual;
	}
	return menor;
}

int moveDisco(tPilha* fonte, tPilha* destino){
	tInfo* disco = desempilha(fonte);
	if(disco == NULL)
		return ERRO_DADOS_INVALIDOS;
	disco->pilhaAnterior = fonte;
	disco->pilhaAtual = destino;
	return empilha(destino, disco);
}
