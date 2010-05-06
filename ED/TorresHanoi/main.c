/*
 * main.c
 *
 *  Created on: May 5, 2010
 *      Author: pedropaulovc
 */
#include <stdio.h>
#include <time.h>
#include <sys/timeb.h>
#include "PilhaEncadeada.h"
#include "tInfo.h"
#include "hanoi.h"


void exibePinos(tPilha* pinos[], int n){
	int i, j;
	for(i = 0; i < n; i++){
		printf("\n\nPino %d - Tamanho %d:\n\n", i + 1, pinos[i]->tamanho);
		for(j = 0; j < pinos[i]->tamanho; j++){
			printf("%d\n", obterElemento(pinos[i], j + 1)->tamanho);
		}
	}

}

int main(){
	tPilha *fonte, *meio, *destino;
	struct timeb tempoInicial, tempoFinal;

	fonte = criaPilha();
	meio = criaPilha();
	destino = criaPilha();
	tPilha* pinos[3] = {fonte, meio, destino};
	int i,j;
	for(i = 0; i < 10; i++){
		populaPino(fonte, i);
		ftime( &tempoInicial );
		solveTorreHanoiIterativo(fonte, meio, destino, i);
		ftime( &tempoFinal );
		printf("%d\n", tempoFinal.time - tempoInicial.time);
		for(j = 0; j < 3; j++)
			limparPilha(pinos[j]);
	}

	return 0;
}
