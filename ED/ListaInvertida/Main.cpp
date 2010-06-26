/*
 * Main.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */
#include "Indexador.h"
#include <iostream>

int main(int argc, char **argv){
	//Indexador::gerarArquivoDados("/home/pedropaulo/Downloads/Portarias_txt", "./Indices/portarias.dat");
	std::string antes = "Lorem Ipsum\nDolor Sit Amet";
	std::cout << antes << std::endl;
	std::string depois = Indexador::codificarString(antes);
	std::cout << depois << std::endl;
}
