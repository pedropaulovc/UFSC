#include <gtest/gtest.h>
#include <iostream>
#include <fstream>

using namespace std;

string* lerCidade(std::string linha){
	size_t posicaoBarra, posicaoInicioCep;
	string cidade, cep;
	posicaoBarra = linha.find('|');
	if(posicaoBarra != string::npos){
		cidade = linha.substr(0,posicaoBarra);
		cep = linha.substr(posicaoBarra+1);
		posicaoInicioCep = cep.find_first_not_of("	");
		cep = cep.substr(posicaoInicioCep);
		cout << "cidade:" << cidade << endl << "cep:" << cep << endl;
	}
 }


void lerArquivo() {
	string line;
	ifstream myfile("dados.txt");
	if (myfile.is_open()) {
		while (!myfile.eof()) {
			getline(myfile, line);
			lerCidade(line);
		}
		myfile.close();
	}

	else
		std::cout << "Unable to open file";

}

int main(int argc, char **argv) {
	::testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();

//	lerArquivo();
	return 0;
}
