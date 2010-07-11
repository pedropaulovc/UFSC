/*
 * InterfaceUsuario.cpp
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#include "InterfaceUsuario.h"
#include "../Indexador/Indexador.h"
#include "../Indexador/ChavePrimaria/IndexadorChavePrimaria.h"
#include "../Indexador/ChaveSecundaria/IndexadorChaveSecundaria.h"

InterfaceUsuario::InterfaceUsuario() {
}

InterfaceUsuario::~InterfaceUsuario() {
}

void InterfaceUsuario::iniciar() {
	int opcao;

	exibeIntroducao();
	gerarIndices();

	do {
		exibeMenu();
		cin >> opcao;

	} while (opcao != 0);
}

void InterfaceUsuario::gerarIndices() {
	char opcao;
	string caminho;
	do {
		cout << endl << "Deseja usar os arquivos de índice prontos? (S ou N)" << endl;
		cin >> opcao;
	} while (opcao != 'S' && opcao != 'N' && opcao != 's' && opcao != 'n');

	cout << "Importando arquivo de dados" << endl;
	Portaria **portarias = Indexador::importarArquivoDados(
			"./Indices/portarias.dat", &numPortarias);

	if (opcao == 'N' || opcao == 'n') {
		cout << "Gerando arquivo de chaves primárias" << endl;
		;
		IndexadorChavePrimaria::exportar("./Indices/portarias.ndx", portarias,
				numPortarias);

		string palavrasChave[] = { "REITOR", "VICE", "PROFESSOR", "CHEFE",
				"DEPARTAMENTO", "MECANICA", "ELETRICA", "QUIMICA", "LETRAS",
				"FILOSOFIA", "HUMANAS", "CIENCIAS", "COMPUTACAO", "SANITARIA",
				"MATERIAIS", "ENGENHARIA", "INGLES", "ALEMAO", "ITALIANO",
				"DIREITO" };
		cout << "Gerando arquivo de chaves secundárias" << endl;
		;
		IndexadorChaveSecundaria::exportar("./Indices/", palavrasChave, 20,
				portarias, numPortarias);
	}

	cout << "Importando arquivo de chaves primárias" << endl;
	arvore = IndexadorChavePrimaria::importar("./Indices/portarias.ndx");
}

void InterfaceUsuario::exibeMenu() {
	cout << "Escola a opção desejada: " << endl << "0 - Sair" << endl
			<< "1 - Buscar por chave primária " << endl
			<< "2 - Buscar por chave secundária" << endl;
}

void InterfaceUsuario::exibeIntroducao() {
	cout
			<< "PROJETO DE IMPLEMENTAÇÃO 2 - BUSCADOR TEXTUAL USANDO LISTAS INVERTIDAS\n"
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n";
}

