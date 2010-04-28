/*
 * tInfo.h
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */

#ifndef TINFO_H_
#define TINFO_H_
#include "PilhaEncadeada.h"

typedef struct tInfo{
	int tamanho;
	struct tPilha* pilhaOrigem;
} tInfo;

void destruirInfo(tInfo* info);

#endif /* TINFO_H_ */
