#include <gtest/gtest.h>
#include <iostream>
#include <fstream>
#include <string>
#include <sys/time.h>
#include <cmath>
#include "Estruturas/ListaEncadeada.h"
#include "Cep.h"
#include "arvore_avl.h"

using namespace std;

class Main {
public:
	int iniciar(int argc, char **argv);
	void exibeIntroducao();
	void exibeMenu();
	void executaLeituraCep();
	int executaTestes(int argc, char **argv);
	inline double calculaDiferencaTempo(timeval antes, timeval depois);
};

int main(int argc, char **argv) {
	Main* main = new Main();
	return main->iniciar(argc, argv);
}

int Main::iniciar(int argc, char **argv) {
	int opcao;

	exibeIntroducao();

	do {
		exibeMenu();
		cin >> opcao;

		if (opcao == 1) {
			executaLeituraCep();
		} else if (opcao == 2) {
			return executaTestes(argc, argv);
		} else if (opcao != 0) {
			cout << "Opção inválida";
		}

	} while (opcao != 0);

	return 0;
}

void Main::exibeIntroducao() {
	cout << "TRABALHO 9 - ÁRVORE BINÁRIA DE BUSCA SEMIBALANCEADA\n"
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n";
}

void Main::exibeMenu() {
	cout << "Escola a opção desejada: \n" << "0 - Sair\n"
			<< "1 - Executar leitura de arquivo de CEPs\n"
			<< "2 - Executar testes de validação\n";
}

void Main::executaLeituraCep() {
	string arquivoCeps;
	Cep* cepAtual;
	timeval antes, depois;

	NodoAVL<Cep>* raiz = new NodoAVL<Cep> ();

	cout << "Forneça o caminho do arquivo de CEPs: ";
	cin >> arquivoCeps;

	ofstream out;
	out.open("analise/out.txt", ios::trunc | ios::out);

	if (out.bad()) {
		cout << "Problema no arquivo de saída\n";
		return;
	}

	ListaEncadeada<Cep>* ceps = Cep::lerArquivoCeps(arquivoCeps);

	if (ceps == NULL) {
		cout << "Problema na leitura do arquivo.\n";
		return;
	}

	for (int i = 1; i < ceps->obterTamanho(); i++) {
		cepAtual = ceps->obterDaPosicao(i);
		cout << "Logradouro: " << cepAtual->obterNome() << " CEP: "
				<< cepAtual->obterCep() << "\n";
		gettimeofday(&antes, NULL);
		raiz = raiz->insere(*cepAtual);
		gettimeofday(&depois, NULL);
		out << i << "\t" << depois.tv_usec - antes.tv_usec << "\n";
	}
	out.close();

	system("gnuplot analise/gnuplot.gnu");
}

inline double Main::calculaDiferencaTempo(timeval antes, timeval depois){
	return depois.tv_sec - antes.tv_sec + pow10(-6) * (depois.tv_usec - antes.tv_usec);
}

int Main::executaTestes(int argc, char **argv) {
	::testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}
