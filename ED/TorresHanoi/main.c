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

void exibePinos(tPilha* pinos[], int n);
void calculaTempoHanoi(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos);
void calculaNumMovimentacoes(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos);

int main(){
	tPilha *fonte, *meio, *destino;


	fonte = criaPilha();
	meio = criaPilha();
	destino = criaPilha();
	tPilha* pinos[3] = {fonte, meio, destino};
	int i,j;

	for(i = 0; i < 31; i++){
		populaPino(fonte, i);
		calculaNumMovimentacoes(fonte, meio, destino, i);
		for(j = 0; j < 3; j++)
			limparPilha(pinos[j]);
	}

	return 0;
}

void calculaTempoHanoi(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos){
	clock_t inicio, fim;
	double diff;

	inicio = clock();
	solveTorreHanoiIterativo(fonte, meio, destino, qtdDiscos);
	fim = clock();
	diff = ((double)( fim - inicio ) / (double)CLOCKS_PER_SEC );
	printf("%d\t%10.10lf\n", qtdDiscos, diff);
}

void calculaNumMovimentacoes(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos){
	limparNumMovimentacoes();
	solveTorreHanoiIterativo(fonte, meio, destino, qtdDiscos);
	printf("%d\t%d\n", qtdDiscos, obterNumMovimentacoes());
}

void exibePinos(tPilha* pinos[], int n){
	int i, j;
	for(i = 0; i < n; i++){
		printf("\n\nPino %d - Tamanho %d:\n\n", i + 1, pinos[i]->tamanho);
		for(j = 0; j < pinos[i]->tamanho; j++){
			printf("%d\n", obterElemento(pinos[i], j + 1)->tamanho);
		}
	}

}
