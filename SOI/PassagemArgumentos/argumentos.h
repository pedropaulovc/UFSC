/*
 * argumentos.h
 *
 *  Created on: Aug 19, 2010
 *      Author: pedropaulovc
 */

#ifndef ARGUMENTOS_H_
#define ARGUMENTOS_H_

int verbose = 0;

void exibirAjuda();
void exibirVariaveisAmbiente(char **envp);
void exibirArgumentos(int argc, char **argv);
void exibirVariavelAmbiente(char *var);


#endif /* ARGUMENTOS_H_ */
