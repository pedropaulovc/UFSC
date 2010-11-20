#include <stdio.h>
#include <stdlib.h>
#include "desvio_padrao.h"

int main(){
	puts("INE5416 - PARADIGMAS DE PROGRAMACAO");
	puts("ALUNO: PEDRO PAULO VEZZA CAMPOS");
	puts("EXERCÍCIO: MÓDULOS");
	
	int num_valores = 0;
	double *valores;
		
	puts("Insira o tamanho da base de dados: ");
	scanf("%d", &num_valores);
	
	valores = (double*) malloc(sizeof(double) * num_valores);
	
	int i;
	for (i = 0; i < num_valores; i++){
		printf("Forneca o numero %d: ", i + 1);
		scanf("%lf", &valores[i]);
	}
	
	int opcao = -1;
	while(opcao != 0){
		puts("Escolha uma opcao: ");
		puts("0 - Sair do programa");
		puts("1 - Calcular a média aritmética");
		puts("2 - Calcular a variância");
		puts("3 - Calcular o desvio padrão");
		scanf("%d", &opcao);
		
		switch(opcao){
			case 0:
				return 0;
				break;
			
			case 1:
				printf("%lf\n", media_aritmetica(valores, num_valores));
				break;
			
			case 2:
				printf("%lf\n",variancia(valores, num_valores));
				break;
			
			case 3:
				printf("%lf\n",desvio_padrao(valores, num_valores));
				break;
			
			default:
				puts("Opcao invalida");
				break;
		}
	}
}
