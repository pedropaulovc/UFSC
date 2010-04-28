/*
 * hanoi.c
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */
#include <stdio.h>
#include <stdlib.h>
#include "PilhaEncadeada.h"

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
	tInfo* menor, outra;
	int i = 0;

	do {
		/*Na primeira jogada apenas, o disco do topo do pino fonte vai:
		 * para o pino destino SE o número de discos for ímpar
		 * para o pino do meio SE o numero de discos for par.*/
		if(i == 0){
			if(n % 2 == 0)
				empilha(meio, desempilha(fonte));
			else
				empilha(destino, desempilha(fonte));
		/*Nas outras jogadas mova o menor disco ocupando algum topo
		 *  para o pino de onde ele não veio em uma jogada anterior;*/
		} else {
			menor = obterTopo(fonte);
			if(obterTopo(meio)->tamanho < menor->tamanho)
				menor = obterTopo(meio);
			if(obterTopo(destino)->tamanho < menor->tamanho)
				menor = obterTopo(destino);

		}

		/*Se houver peça fora do destino, Mova a única outra peça possível
		 *  de ser movida (só haverá um lugar possível para colocá-la).*/
		if(destino->tamanho != n){
			if(menor->pilhaOrigem == fonte){

			}
		}
		i++;
	} while(destino->tamanho == n);
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
		empilha(pino, info);
	}
}
