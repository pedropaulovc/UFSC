//Arquivo: main.c
//Nome: Trabalho de implementação: Pilha.
//Alunos: Felipe dos Santos Silveira 09132014 e Pedro Paulo Vezzá Campos 09132033
//Data de Criação: 13/03/2010
//Disciplina: INE5408 - Estruturas de Dados
//Data de Entrega: 15/03/2010
//Função: Interface para acesso as funções da pilha

#import <stdio.h>
#import "pilha.h"

// Função principal, pede a opção desejada do usuário e
// a executa.
// Sai do programa quando for digitada a tecla "s".
int main(){
	char tecla = 'a';
	int numero;

	limparPilha();

	while(tecla != 's'){

		printf("m: mostra a pilha \n");
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
