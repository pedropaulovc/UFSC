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
	char *argCurtos = "haet:v";
	struct option argLongos[] = { { "help", 0, NULL, 'h' }, { "arguments", 0,
			NULL, 'a' }, { "environment", 0, NULL, 'e' }, {
			"environment-variable", 1, NULL, 't' },
			{ "verbose", 0, NULL, 'v' }, { NULL, 0, NULL, 0 } };

	if (argc == 1) {
		exibirAjuda();
		return 1;
	}

	do {
		arg = getopt_long(argc, argv, argCurtos, argLongos, NULL);
		if (verbose)
			printf("Analisando argumento \"%c\"\n", arg);
		switch (arg) {
		case 'h':
			exibirAjuda();
			break;
		case 'a':
			exibirArgumentos(argc, argv);
			break;
		case 'e':
			exibirVariaveisAmbiente(envp);
			break;
		case 't':
			exibirVariavelAmbiente(optarg);
			break;
		case 'v':
			puts("Modo verboso ativado\n");
			verbose = 1;
			break;
		case '?':
			puts("Argumento inválido.");
			exibirAjuda();
			return 1;
		case -1:
			if (verbose)
				puts("Detectado fim dos argumentos. Encerrando.");
			break;
		default:
			abort();
			break;
		}
	} while (arg != -1);

	return 0;
}

void exibirAjuda() {
	puts("INE5412 - SISTEMAS OPERACIONAIS I");
	puts("LABORATÓRIO 1 - PASSAGEM DE ARGUMENTOS EM C");
	puts(
			"ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E TARCÍSIO EDUARDO MOREIRA CROCOMO\n");
	puts("Uso: programa [ARGUMENTOS]");
	puts("-h, --help                         exibir esta ajuda.");
	puts(
			"-a, --arguments                    exibir os parâmetros passados ao programa.");
	puts(
			"-e, --environment                  exibir todas as variáveis de ambiente.");
	puts(
			"-t, --environment-variable=VAR     exibir o valor da variável de ambiente VAR.");
	puts(
			"-v, --verbose                      ativar modo verboso no programa.\n");
}

void exibirArgumentos(int argc, char **argv) {
	if (verbose)
		puts("Exibindo argumentos enviados ao programa: ");
	int i;
	for (i = 0; i < argc; i++) {
		printf("argv[%d] = %s\n", i, argv[i]);
	}
	puts("");
}

void exibirVariaveisAmbiente(char **envp) {
	if (verbose)
		puts("Exibindo todas as variáveis de ambiente: ");
	int i = 0;
	while (envp[i] != NULL) {
		printf("envp[%d] = '%s'\n",i , envp[i]);
		i++;
	}
	puts("");
}

void exibirVariavelAmbiente(char *var) {
	if (verbose)
		puts("Exibindo variável específica de ambiente: ");
	printf("%s = '%s'\n", var, getenv(var));
	puts("");
}
