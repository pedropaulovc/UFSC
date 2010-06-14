/**
 TÍTULO:        Implementação de árvores binárias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore semibalanceada (AVL).

 SOBRE O ARQUIVO:
 Interface principal com o usuário.

*/

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
	static void exibeIntroducao();
	static void exibeMenu();
	static void executaLeituraCep();
	static int executaTestes(int argc, char **argv);
	static inline double calculaDiferencaTempo(timeval antes, timeval depois);
};

int main(int argc, char **argv) {
	int opcao;

	Main::exibeIntroducao();

	do {
		Main::exibeMenu();
		cin >> opcao;

		if (opcao == 1) {
			Main::executaLeituraCep();
		} else if (opcao == 2) {
			return Main::executaTestes(argc, argv);
		} else if (opcao != 0) {
			cout << "Opção inválida";
		}

	} while (opcao != 0);

	return 0;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	exibe introdução ao programa

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void Main::exibeIntroducao() {
	cout << "TRABALHO 9 - ÁRVORE BINÁRIA DE BUSCA SEMIBALANCEADA\n"
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n";
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	exibe um menu simples com as opções de execução

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void Main::exibeMenu() {
	cout << "Escola a opção desejada: \n" << "0 - Sair\n"
			<< "1 - Executar leitura de arquivo de CEPs\n"
			<< "2 - Executar testes de validação\n";
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	interface para a criação de uma árvore de CEPs. Delega as tarefas às classes competentes.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void Main::executaLeituraCep() {
	string arquivoCeps;
	Cep* cepAtual;
	timeval antes, depois;
	NodoAVL<Cep>* raiz = new NodoAVL<Cep> ();

	cout << "Forneça o caminho do arquivo de CEPs: ";
	cin >> arquivoCeps;

	ofstream out;
	out.open("analise/out.txt", ios::trunc | ios::out);
	out.setf(ios::fixed, ios::floatfield);
	out.precision(6);

	ListaEncadeada<Cep>* ceps = Cep::lerArquivoCeps(arquivoCeps);

	if (out.bad()) {
		cout << "Problema no arquivo de saída\n";
		return;
	}

	if (ceps == NULL) {
		cout << "Problema na leitura do arquivo.\n";
		return;
	}

	for (int i = 1; i < ceps->obterTamanho(); i++) {
		cepAtual = ceps->obterDaPosicao(i);
		gettimeofday(&antes, NULL);
		raiz = raiz->insere(*cepAtual);
		gettimeofday(&depois, NULL);
		out << i << "\t" << calculaDiferencaTempo(antes, depois) << "\n";
	}
	out.close();

	ListaEncadeada<Cep>* cepsEmOrdem = raiz->retornaListaInfixada();
	for(int i = 1; i < cepsEmOrdem->obterTamanho(); i++){
		cepAtual = cepsEmOrdem->obterDaPosicao(i);
		cout << "Logradouro: " << cepAtual->obterNome() << " CEP: "
				<< cepAtual->obterCep() << "\n";
	}

	system("gnuplot analise/gnuplot.gnu");
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	calcula com precisão de microsegundos o tempo para executar uma operação.

PARÂMETROS:
	os instantes antes e depois da execução/

VALOR DE RETORNO:
	um valor com precisão dupla com a diferença de tempo.

*/
inline double Main::calculaDiferencaTempo(timeval antes, timeval depois) {
	return depois.tv_sec - antes.tv_sec + 0.000001 * (depois.tv_usec
			- antes.tv_usec);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	aciona o sistema de testes unitários

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o resultado numérico da execução.

*/
int Main::executaTestes(int argc, char **argv) {
	::testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}
