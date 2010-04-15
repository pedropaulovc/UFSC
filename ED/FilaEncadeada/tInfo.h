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
