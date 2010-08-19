/*
 * argumentos.c
 *
 *  Created on: Aug 19, 2010
 *      Author: pedropaulovc
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <getopt.h>
#include "argumentos.h"

int main(int argc, char **argv, char **envp) {
	int arg;
	int verbose = 0;
	char *argCurtos = "haet:v";
	struct option argLongos[] = { { "help", 0, NULL, 'h' }, { "arguments", 0,
			NULL, 'a' }, { "environment", 0, NULL, 'e' }, {
			"environment-variable", 1, NULL, 't' },
			{ "verbose", 0, NULL, 'v' }, { NULL, 0, NULL, 0 } };

	do {
		arg = getopt_long(argc, argv, argCurtos, argLongos, NULL);
		switch (arg) {
		case 'h':
			exibirAjuda();
			break;
		case 'a':
			exibirArgumentos(argc, argv);
			break;
		case 'e':
			exibirVariaveis(envp);
			break;
		case 't':
			exibirVariavel(optarg);
			break;
		case 'v':
			verbose = 1;
			break;
		case '?':
			puts("Argumento inválido.");
			exibirAjuda();
			return 1;
		default:
			break;
		}
	} while (arg != -1);

	return 0;
}

void exibirAjuda() {
	puts("uso: programa1 [-h] [-a] [-e] [-p] [-v]");
}

void exibirArgumentos(int argc, char **argv) {
	puts("Exibindo argumentos enviados ao programa: ");
	int i;
	for (i = 0; i < argc; i++) {
		printf("argv[%d] = %s\n", i, argv[i]);
	}
}

void exibirVariaveis(char **envp) {
	puts("Exibindo todas as variáveis de ambiente: ");
	int i = 0;
	while (envp[i] != NULL) {
		printf("%s\n", envp[i]);
		i++;
	}
}

void exibirVariavel(char *var) {
	puts("Exibindo variável específica de ambiente: ");
	printf("%s = %s\n", var, getenv(var));
}
