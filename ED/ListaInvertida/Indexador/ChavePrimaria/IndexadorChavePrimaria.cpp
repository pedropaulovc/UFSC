/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação dos métodos descritos em IndexadorChavePrimaria.h referentes a um indexador de chaves
 primárias.
*/


#include "IndexadorChavePrimaria.h"
#include <fstream>

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	ler um array de portarias, gerar uma árvore AVL contendo referências a todos os elementos dados e
	por fim serializar essa árvore em um caminho fornecido.

PARÂMETROS:
	o caminho do arquivo de chaves primárias, o array de portarias e seu tamanho.

VALOR DE RETORNO:
	nenhum

*/
void IndexadorChavePrimaria::exportar(string caminho, Portaria **portarias,
		int numPortarias) {
	NodoAVL<Portaria> *arvore = new NodoAVL<Portaria> ();

	for (int i = 0; i < numPortarias; i++)
		arvore = arvore->insere(*portarias[i]);

	PortariaSerializada **serializadas = new PortariaSerializada*[numPortarias];

	int posicaoVaga = 0;
	serializarArvore(arvore, serializadas, &posicaoVaga);

	ofstream arquivo;
	arquivo.open(caminho.c_str(), ios::trunc | ios::out);

	if (arquivo.fail())
		return;

	arquivo << numPortarias << endl;

	for (int i = 0; i < numPortarias; i++) {
		PortariaSerializada *atual = serializadas[i];
		arquivo << atual->obterNome() << delimitador
				<< atual->obterPosicaoArquivo() << delimitador
				<< atual->obterFilhoEsquerda() << delimitador
				<< atual->obterFilhoDireita() << delimitador
				<< atual->obterAltura() << endl;
	}
	arquivo.close();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Função auxiliar de exportar. Funciona de maneira recursiva armazenando em um array fornecido
	uma portaria serializada por chamada segundo o percurso PreOrdem.

PARÂMETROS:
	a árvore a ser serializada, o array onde serão armazenadas as portarias serializadas e um
	ponteiro apontando para a primeira posição vaga do array, por padrão, 0.

VALOR DE RETORNO:
	posição onde foi inserida a portaria atual.

*/
int IndexadorChavePrimaria::serializarArvore(NodoAVL<Portaria> *arvore,
		PortariaSerializada **lista, int *posicaoVaga) {
	if (lista == NULL)
		return 0;
	const Portaria* portaria = arvore->retornaInfo();
	PortariaSerializada* serializada = new PortariaSerializada(
			portaria->obterNome(), portaria->obterPosicaoArquivo());
	serializada->definirAltura(arvore->retornaAltura());

	lista[*posicaoVaga] = serializada;
	int posicaoInserido = *posicaoVaga;

	if (arvore->retornaEsquerda() != NULL) {
		(*posicaoVaga)++;
		serializada->definirFilhoEsquerda(serializarArvore(
				arvore->retornaEsquerda(), lista, posicaoVaga));
	}
	if (arvore->retornaDireita() != NULL) {
		(*posicaoVaga)++;
		serializada->definirFilhoDireita(serializarArvore(
				arvore->retornaDireita(), lista, posicaoVaga));
	}

	return posicaoInserido;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	ler um arquivo de chaves primárias gerado previamente e retornando a árvore reconstituída

PARÂMETROS:
	o caminho do arquivo de chaves primárias

VALOR DE RETORNO:
	a árvore gerada

*/
NodoBinario<PortariaSerializada>* IndexadorChavePrimaria::importar(
		string caminhoArquivoChaves) {
	ifstream arquivo(caminhoArquivoChaves.c_str());
	string linha;

	if (arquivo.fail())
		return NULL;

	getline(arquivo, linha);
	int tamanhoArquivo = atoi(linha.c_str());
	string *nodosSerializados = new string[tamanhoArquivo];

	for (int i = 0; i < tamanhoArquivo; i++)
		getline(arquivo, nodosSerializados[i]);

	return importarArvore(nodosSerializados);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	função auxiliar de importar. Funciona recursivamente gerando um novo nodo binário por chamada
	contendo no campo de informações um ponteiro para a portaria reconstituída.

PARÂMETROS:
	um array contendo todos os nodos a serem importados e a posição a ser lida do array, por padrão, 0.

VALOR DE RETORNO:
	a árvore gerada

*/
NodoBinario<PortariaSerializada>* IndexadorChavePrimaria::importarArvore(string *nodos, int nodoAtual) {
	string nodo = nodos[nodoAtual];
	ListaEncadeada<string> *dados = tokenizar(nodo);

	string chave = *dados->obterDoInicio();
	int posicaoArquivo = atoi(dados->obterDaPosicao(2)->c_str());
	PortariaSerializada *novaPortaria = new PortariaSerializada(chave,
			posicaoArquivo);
	NodoBinario<PortariaSerializada> *novoNodo = new NodoBinario<
			PortariaSerializada> (novaPortaria);

	int filhoEsquerda = atoi(dados->obterDaPosicao(3)->c_str());
	int filhoDireita = atoi(dados->obterDaPosicao(4)->c_str());
	if(filhoEsquerda != -1)
		novoNodo->alterarFilhoEsquerda(importarArvore(nodos, filhoEsquerda));
	if(filhoDireita != -1)
		novoNodo->alterarFilhoDireita(importarArvore(nodos, filhoDireita));

	delete dados;
	return novoNodo;
}
