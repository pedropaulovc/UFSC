/*
 * main.c
 *
 *  Created on: May 5, 2010
 *      Author: pedropaulovc
 */
#include <stdio.h>
#include "PilhaEncadeada.h"
#include "tInfo.h"
#include "hanoi.h"

void exibePinos(tPilha* pinos[], int n){
	int i, j;
	for(i = 0; i < n; i++){
		printf("\n\nPino %d - Tamanho %d:\n\n", i, pinos[i]->tamanho);
		for(j = 0; j < pinos[i]->tamanho; j++){
			printf("%d\n", obterElemento(pinos[i], j + 1)->tamanho);
		}
	}

}

int main(){
	tPilha *fonte, *meio, *destino;
	int nDiscos = 4;

	fonte = criaPilha();
	meio = criaPilha();
	destino = criaPilha();
	tPilha* pinos[3] = {fonte, meio, destino};

	populaPino(fonte, nDiscos);
	exibePinos(pinos, 3);
	solveTorreHanoiIterativo(fonte, meio, destino, nDiscos);
	exibePinos(pinos, 3);


	return 0;
}
