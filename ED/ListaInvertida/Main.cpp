/*
 * Main.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */
#include "Indexador.h"
#include <iostream>
#include "Interface.h"

using namespace std;

int main(int argc, char **argv){
	return Interface::executar(argc - 1, &argv[1]);
}

