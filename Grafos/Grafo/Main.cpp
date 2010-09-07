/*
 * Main.cpp
 *
 *  Created on: Aug 26, 2010
 *      Author: pedropaulovc
 */

#include <iostream>
#include <gtest/gtest.h>
#include "Grafo.h"

void exibirIntroducao();

int main(int argc, char **argv) {
	exibirIntroducao();

	::testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}

void exibirIntroducao() {
	cout << "INE5413 - GRAFOS" << endl;
	cout << "IMPLEMENTAÇÃO DE ESTRUTURA BÁSICA DE GRAFOS" << endl;
	cout
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E TARCÍSIO EDUARDO MOREIRA CROCOMO"
			<< endl;
}
