/*
 * tInfo.c
 *
 *  Created on: Apr 27, 2010
 *      Author: pedropaulo
 */
#include <stdlib.h>
#include "tInfo.h"

void destruirInfo(tInfo* info) {
	free(info);
}
