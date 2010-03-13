/*
 * main.c
 *
 *  Created on: 13/03/2010
 *      Author: berr
 */

#import <stdio.h>
#import "pilha.h"

int main(){
	char tecla = 'a';
	int numero;

	limparPilha();

	while(tecla != 's'){

		printf("m: mostra a pilha \n");
		printf("t: topo\n");
		printf("e: empilha\n");
		printf("d: desempilha\n");
		printf("l: limpar a pilha\n");
		printf("s: sair\n");
		printf("Insira a opcao: ");
		scanf(" %c",&tecla);
		printf("\n");
		switch(tecla){
			case 'm':
				mostraPilha();
				break;
			case 't':
				topo();
				break;
			case 'e':
				printf("Insira o numero a adicionar:");
				scanf("%d",&numero);
				empilha(numero);
				break;
			case 'd':
				desempilha();
				break;
			case 'l':
				limparPilha();
			case 's':
				break;
		}
		printf("\n");
	}
	return 0;
}
