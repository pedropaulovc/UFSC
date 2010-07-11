/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação dos métodos descritos em InterfaceUsuario.h referentes ao interfaceamento com o usuário.
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

	//Obtendo a portaria buscada ou NULL caso não seja encontrada
	resultado = arvore->buscar(new PortariaSerial(portaria));

	//Exibindo o resultado ao usuário
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

	//Obtendo a lista de portarias contendo o termo buscado
	lista1 = obterBuscaSecundaria();

	//Caso não seja feita busca conjuntiva, o resultado está pronto
	if (opcao == 'N' || opcao == 'n') {
		resultado = lista1;
	} else {
		//Em caso de busca conjuntiva, obter a próxima expressão a ser buscada
		lista2 = obterBuscaSecundaria();

		//Realizar a intersecção entre as listas segundo algoritmo fornecido
		if (lista1->obterTamanho() > lista2->obterTamanho())
			resultado = lista1->intersecao(lista2);
		else
			resultado = lista2->intersecao(lista1);
	}

	//Exibindo o resultado encontrado ao usuário
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
	//Enquanto não seja fornecido um termo válido, repita a operação.
	do {
		cout << "Forneça o termo a ser buscado: ";
		cin >> termo;

		//Transformando a palavra buscada para caixa alta
		transform(termo.begin(), termo.end(), termo.begin(), ::toupper);
		//Carregar a lista invertida e gerar uma lista de portarias que contêm a palavra
		lista = IndexadorChaveSecundaria::importar(pastaChavesSecundarias,
				termo, caminhoDados);
		//Se a busca não teve sucesso, informe ao usuário.
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

	cout << " - Importando arquivo de dados... ";
	Portaria **portarias = Indexador::importarArquivoDados(caminhoDados,
			&numPortarias);
	cout << "Pronto." << endl;

	if (opcao == 'N' || opcao == 'n') {
		cout << " - Gerando arquivo de chaves primárias... ";
		IndexadorChavePrimaria::exportar(caminhoChavesPrimarias, portarias,
				numPortarias);
		cout << "Pronto." << endl;

		string palavrasChave[] = { "REITOR", "VICE", "PROFESSOR", "CHEFE",
				"DEPARTAMENTO", "MECANICA", "ELETRICA", "QUIMICA", "LETRAS",
				"FILOSOFIA", "HUMANAS", "CIENCIAS", "COMPUTACAO", "SANITARIA",
				"MATERIAIS", "ENGENHARIA", "INGLES", "ALEMAO", "ITALIANO",
				"DIREITO" };

		cout << " - Gerando arquivo de chaves secundárias... ";
		IndexadorChaveSecundaria::exportar(pastaChavesSecundarias,
				palavrasChave, 20, portarias, numPortarias);
		cout << "Pronto." << endl;
	}

	cout << " - Importando arquivo de chaves primárias... ";
	arvore = IndexadorChavePrimaria::importar(caminhoChavesPrimarias);
	cout << "Pronto." << endl << endl;
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

