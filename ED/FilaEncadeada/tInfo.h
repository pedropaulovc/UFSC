/**
ARQUIVO:       tInfo.c
TÍTULO:        Implementação da filas encadeadas
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         27 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila encadeada.

TIPOS:
tInfo
	este TAD contém os dados referentes a cada elemento da estrutura de dados.

*/

#ifndef INFO_H_
#define INFO_H_

#include <time.h>

typedef struct{
	char* nomeSolicitante;
	int telefone;
	time_t dataEntrega;
	char* modeloComputador;
	float valorConserto;
}tInfo;

void destruirInfo(tInfo* info);

#endif
