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

 calculaTempoHanoi
	executa o algoritmo principal e calcula o tempo de execução para cada quantidade de discos.

 calculaNumMovimentacoes
	executa o algoritmo principal e calcula o número de movimentações necessárias para cada quantidade de discos.

 */
#include <stdio.h>
#include <time.h>
#include <sys/timeb.h>
#include "PilhaEncadeada.h"
#include "tInfo.h"
#include "hanoi.h"

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

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	executa o algoritmo principal e calcula o tempo de execução para cada quantidade de discos.

PARÂMETROS:
	as pilhas de fonte, meio e destino e a quantidade e discos contidos na fonte.

VALOR DE RETORNO:
	nenhum

*/
void calculaTempoHanoi(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos){
	clock_t inicio, fim;
	double diff;

	inicio = clock();
	solveTorreHanoiIterativo(fonte, meio, destino, qtdDiscos);
	fim = clock();
	diff = ((double)( fim - inicio ) / (double)CLOCKS_PER_SEC );
	printf("%d\t%10.10lf\n", qtdDiscos, diff);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	executa o algoritmo principal e calcula o número de movimentações necessárias para cada quantidade de discos.

PARÂMETROS:
	as pilhas de fonte, meio e destino e a quantidade e discos contidos na fonte.

VALOR DE RETORNO:
	nenhum

*/
void calculaNumMovimentacoes(tPilha* fonte, tPilha* meio, tPilha* destino, int qtdDiscos){
	limparNumMovimentacoes();
	solveTorreHanoiIterativo(fonte, meio, destino, qtdDiscos);
	printf("%d\t%d\n", qtdDiscos, obterNumMovimentacoes());
}

