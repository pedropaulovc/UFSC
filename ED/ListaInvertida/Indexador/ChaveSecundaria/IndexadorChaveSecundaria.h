/*
 * IndexadorChaveSecundaria.h
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#ifndef INDEXADORCHAVESECUNDARIA_H_
#define INDEXADORCHAVESECUNDARIA_H_

#include "../Indexador.h"

class IndexadorChaveSecundaria: public Indexador {
public:
	static void exportar(string pasta, string *palavrasChave, int numPalavras,
			Portaria **portarias, int numPortarias);
};

#endif /* INDEXADORCHAVESECUNDARIA_H_ */
