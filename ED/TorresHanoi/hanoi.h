/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em hanoi.c referentes ao programa que solve
os problemas de Torres de Hanoi.

*/

#ifndef HANOI_H_
#define HANOI_H_

void solveTorreHanoiIterativo(tPilha* fonte, tPilha* meio, tPilha* destino, int n);
void populaPino(tPilha* pino, int n);
int obterNumMovimentacoes();
void limparNumMovimentacoes();

#endif /* HANOI_H_ */
