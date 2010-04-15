/*
 * tInfo.c
 *
 *  Created on: 15/04/2010
 *      Author: aluno
 */
#include <stdlib.h>
#include "tInfo.h"

void destruirInfo(tInfo* info){
	free(info->modeloComputador);
	free(info->nomeSolicitante);
	free(info);
}
