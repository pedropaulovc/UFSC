/*
 * Main.cpp
 *
 *	INE5413 - Grafos
 *  Alunos: Pedro Paulo Vezzá Campos e Tarcisio Eduardo Moreira Crocomo
 *
 *  Sobre a classe: Exibe a apresentação do programa e invoca a rotina
 *  de execução dos testes unitários.
 *
 *  Dependências do programa: Bibliotecas "gtest" e "pthread".
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
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E TARCISIO EDUARDO MOREIRA CROCOMO"
			<< endl;
}
