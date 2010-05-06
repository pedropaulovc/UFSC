/*
 * hanoi.h
 *
 *  Created on: May 5, 2010
 *      Author: pedropaulovc
 */

#ifndef HANOI_H_
#define HANOI_H_

void solveTorreHanoiRecursivo(tPilha* fonte, tPilha* meio, tPilha* destino, int n);
void solveTorreHanoiIterativo(tPilha* fonte, tPilha* meio, tPilha* destino, int n);
void populaPino(tPilha* pino, int n);
int obterNumMovimentacoes();
void limparNumMovimentacoes();

#endif /* HANOI_H_ */
