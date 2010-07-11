/*
 * InterfaceUsuario.cpp
 *
 *  Created on: Jul 11, 2010
 *      Author: pedropaulo
 */

#include <cstdlib>
#include <iostream>
#include <algorithm>
#include "InterfaceUsuario.h"
#include "../Indexador/Indexador.h"
#include "../Indexador/ChavePrimaria/IndexadorChavePrimaria.h"
#include "../Indexador/ChaveSecundaria/IndexadorChaveSecundaria.h"
#include "../Portarias/Portaria.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Constrói uma interface para interagir com o usuário

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
InterfaceUsuario::InterfaceUsuario() {
	caminhoDados = "./Indices/portarias.dat";
	caminhoChavesPrimarias = "./Indices/portarias.ndx";
	pastaChavesSecundarias = "./Indices/";
}

InterfaceUsuario::~InterfaceUsuario() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	loop principal da interface.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::iniciar() {
	int opcao;

	exibeIntroducao();
	gerarIndices();

	do {
		exibeMenu();
		cin >> opcao;

		if (opcao == 1)
			buscarChavePrimaria();
		if (opcao == 2)
			buscarChaveSecundaria();
	} while (opcao != 0);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Interface para fazer pesquisas por chaves primárias.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::buscarChavePrimaria() {
	string portaria;
	PortariaSerial *resultado;

	cout << "Forneça o nome da portaria a ser buscada: ";
	cin >> portaria;

	resultado = arvore->buscar(new PortariaSerial(portaria));

	if (resultado == NULL)
		cout << "Portaria não encontrada." << endl;
	else
		cout << Indexador::lerEntrada(caminhoDados,
				resultado->obterPosicaoArquivo())->obterTexto();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Interface para fazer pesquisas por chaves
	secundárias. Incluindo buscas conjuntivas.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::buscarChaveSecundaria() {
	char opcao;
	string termo1, termo2;
	ListaEncadeada<Portaria> *lista1, *lista2, *resultado;
	Portaria *atual;
	do {
		cout << "Deseja realizar busca conjuntiva? (S ou N): ";
		cin >> opcao;
	} while (opcao != 'S' && opcao != 'N' && opcao != 's' && opcao != 'n');

	lista1 = obterBuscaSecundaria();

	if (opcao == 'N' || opcao == 'n') {
		resultado = lista1;
	} else {
		lista2 = obterBuscaSecundaria();

		if (lista1->obterTamanho() > lista2->obterTamanho())
			resultado = lista1->intersecao(lista2);
		else
			resultado = lista2->intersecao(lista1);
	}

	int numPortarias = resultado->obterTamanho();
	cout << numPortarias << " portarias encontradas: " << endl;
	for (int i = 1; i <= numPortarias; i++) {
		atual = resultado->obterDaPosicao(i);
		cout << "Portaria " << atual->obterNome() << endl;
		cout << atual->obterTexto() << endl;
	}
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Interface para obter uma lista invertida específica.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	Um ponteiro para a lista de portarias referentes
	a palavra chave informada.

*/
ListaEncadeada<Portaria>* InterfaceUsuario::obterBuscaSecundaria() {
	ListaEncadeada<Portaria> *lista;
	string termo;
	do {
		cout << "Forneça o termo a ser buscado: ";
		cin >> termo;

		transform(termo.begin(), termo.end(), termo.begin(), ::toupper);
		lista = IndexadorChaveSecundaria::importar(pastaChavesSecundarias,
				termo, caminhoDados);
		if (lista == NULL)
			cout << "Termo não indexado." << endl;
	} while (lista == NULL);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	gera os arquivos de índice ou carrega os já prontos,
	dependendo da escolha do usuário.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::gerarIndices() {
	char opcao;
	string caminho;
	do {
		cout << endl << "Deseja usar os arquivos de índice prontos? (S ou N): ";
		cin >> opcao;
	} while (opcao != 'S' && opcao != 'N' && opcao != 's' && opcao != 'n');

	cout << " - Importando arquivo de dados" << endl;
	Portaria **portarias = Indexador::importarArquivoDados(caminhoDados,
			&numPortarias);

	if (opcao == 'N' || opcao == 'n') {
		cout << " - Gerando arquivo de chaves primárias" << endl;
		IndexadorChavePrimaria::exportar(caminhoChavesPrimarias, portarias,
				numPortarias);

		string palavrasChave[] = { "REITOR", "VICE", "PROFESSOR", "CHEFE",
				"DEPARTAMENTO", "MECANICA", "ELETRICA", "QUIMICA", "LETRAS",
				"FILOSOFIA", "HUMANAS", "CIENCIAS", "COMPUTACAO", "SANITARIA",
				"MATERIAIS", "ENGENHARIA", "INGLES", "ALEMAO", "ITALIANO",
				"DIREITO" };

		cout << " - Gerando arquivo de chaves secundárias" << endl;
		IndexadorChaveSecundaria::exportar(pastaChavesSecundarias,
				palavrasChave, 20, portarias, numPortarias);
	}

	cout << " - Importando arquivo de chaves primárias" << endl << endl;
	arvore = IndexadorChavePrimaria::importar(caminhoChavesPrimarias);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	mostra o menu de pesquisas.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::exibeMenu() {
	cout << "Escola a opção desejada: " << endl << "0 - Sair" << endl
			<< "1 - Buscar por chave primária " << endl
			<< "2 - Buscar por chave secundária" << endl;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	mostra o menu inicial.

PARÂMETROS:
	o caminho do arquivo de chaves primárias, o array de portarias e seu tamanho.

VALOR DE RETORNO:
	nenhum

*/
void InterfaceUsuario::exibeIntroducao() {
	cout
			<< "PROJETO DE IMPLEMENTAÇÃO 2 - BUSCADOR TEXTUAL USANDO LISTAS INVERTIDAS\n"
			<< "ALUNOS: PEDRO PAULO VEZZÁ CAMPOS E FELIPE DOS SANTOS SILVEIRA\n";
}

