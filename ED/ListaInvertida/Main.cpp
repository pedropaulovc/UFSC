/*
 * Main.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */
#include "Interface/InterfaceUsuario.h"

using namespace std;

int main(int argc, char **argv) {
	InterfaceUsuario *iu = new InterfaceUsuario();
	iu->iniciar();

	return 0;
}

