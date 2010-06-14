/**
 TÍTULO:        Implementação de árvores binárias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore semibalanceada (AVL).

 FUNCIONAMENTO GERAL:
 Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
 de uma árvore binária semibalanceada. A estrutura de dados aceita comandos de inserção, exclusão e
 percurso de maneira prefixada, infixada e posfixada.

*/

#include <cstdlib>
#include <string>
#include <sstream>
#include "Estruturas/ListaEncadeada.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Construtor de um novo nodo AVL.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	ponteiro para o novo nodo.

*/
template<class TipoInfo> NodoAVL<TipoInfo>::NodoAVL() {
	this->nodoEsquerda = NULL;
	this->nodoDireita = NULL;
	this->utilizado = false;
	this->altura = 0;
	this->numElementos = 0;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Destrutor de um nodo AVL.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
template<class TipoInfo> NodoAVL<TipoInfo>::~NodoAVL() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método principal para a inserção de um novo nodo na árvore.

PARÂMETROS:
	O dado a ser inserido.

VALOR DE RETORNO:
	nova raíz da árvore.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::insere(
		const TipoInfo& tipo) {
	if (this->utilizado == false) {
		info = tipo;
		utilizado = true;
		return this;
	}

	if (tipo <= info) {
		if (nodoEsquerda == NULL)
			nodoEsquerda = new NodoAVL<TipoInfo> ();
		nodoEsquerda = nodoEsquerda->insere(tipo);
	} else {
		if (nodoDireita == NULL)
			nodoDireita = new NodoAVL<TipoInfo> ();
		nodoDireita = nodoDireita->insere(tipo);
	}

	atualizaAltura();

	return verificaCondicaoAVL();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Analisa o fator de desbalanceamento entre os dois nodos filhos e se necessário invoca um dos métodos
 para rebalancear a árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a nova raíz da árvore.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::verificaCondicaoAVL() {
	int fator = retornaFatorDesbalanceamento();
	int fatorDireita, fatorEsquerda;
	NodoAVL<TipoInfo>* novaRaiz;

	if (fator == 2) {
		fatorEsquerda = nodoEsquerda->retornaFatorDesbalanceamento();
		if (fatorEsquerda == 1)
			novaRaiz = rotacaoEsquerda();
		if (fatorEsquerda <= 0)
			novaRaiz = rotacaoDuplaEsquerda();
	}

	if (fator == -2) {
		fatorDireita = nodoDireita->retornaFatorDesbalanceamento();
		if (fatorDireita <= 0)
			novaRaiz = rotacaoDireita();
		if (fatorDireita == 1)
			novaRaiz = rotacaoDuplaDireita();
	}

	if (fator >= -1 && fator <= 1)
		return this;

	novaRaiz->atualizaAltura();

	return novaRaiz;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Atualiza a altura de um nodo específico. Usado após inserção ou deleção de um nodo.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum.

*/
template<class TipoInfo> void NodoAVL<TipoInfo>::atualizaAltura() {
	//Se o nodo atual tiver algum filho, incrementar um na altura
	//os métodos de retornarAltura retornam -1 caso não exista o nodo

	int maxSubArvore =
			std::max(retornaAlturaEsquerda(), retornaAlturaDireita());
	if (maxSubArvore >= -1)
		alterarAltura(maxSubArvore + 1);
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza uma rotação simples à esquerda.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nodo raíz da subárvore após a rotação.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoEsquerda() {
	NodoAVL<TipoInfo>* pivo = retornaEsquerda();
	NodoAVL<TipoInfo>* filhoDireitaPivo = pivo->retornaDireita();

	this->alterarEsquerda(filhoDireitaPivo);
	pivo->alterarDireita(this);

	this->alterarAltura(std::max(retornaAlturaDireita(),
			retornaAlturaEsquerda()) + 1);
	pivo->alterarAltura(std::max(pivo->retornaAlturaDireita(),
			pivo->retornaAlturaEsquerda()) + 1);

	return pivo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza uma rotação simples à direita.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nodo raíz da subárvore após a rotação.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDireita() {
	NodoAVL<TipoInfo>* pivo = retornaDireita();
	NodoAVL<TipoInfo>* filhoEsquerdaPivo = pivo->retornaEsquerda();

	this->alterarDireita(filhoEsquerdaPivo);
	pivo->alterarEsquerda(this);

	this->alterarAltura(std::max(retornaAlturaDireita(),
			retornaAlturaEsquerda()) + 1);
	pivo->alterarAltura(std::max(pivo->retornaAlturaEsquerda(),
			pivo->retornaAlturaDireita()) + 1);

	return pivo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza uma rotação dupla à direita.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nodo raíz da subárvore após a rotação.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaDireita() {
	NodoAVL<TipoInfo>* k1;
	k1 = retornaDireita();
	alterarDireita(k1->rotacaoEsquerda());

	return rotacaoDireita();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza uma rotação dupla à direita.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o nodo raíz da subárvore após a rotação.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaEsquerda() {
	NodoAVL<TipoInfo>* k1;
	k1 = retornaEsquerda();
	alterarEsquerda(k1->rotacaoDireita());

	return rotacaoEsquerda();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Gera o fator de desbalanceamento em um nodo AVL, que será depois analisado pelo verificaCondicaoAVL.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o fator de desbalanceamento.

*/
template<class TipoInfo> int NodoAVL<TipoInfo>::retornaFatorDesbalanceamento() {
	return retornaAlturaEsquerda() - retornaAlturaDireita();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método principal para a remoção de um nodo de uma árvore AVL.

PARÂMETROS:
	O dado a ser removido.

VALOR DE RETORNO:
	a nova raíz da árvore.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::remove(
		const TipoInfo& tipo) {
	NodoAVL<TipoInfo> *temp, *novaRaiz;

	if (tipo == info && nodoEsquerda == NULL && nodoDireita == NULL) {
		delete this;
		return NULL;
	}

	if (tipo < info && nodoEsquerda != NULL) {
		nodoEsquerda = nodoEsquerda->remove(tipo);
		atualizaAltura();
		return verificaCondicaoAVL();
	}

	if (tipo > info && nodoDireita != NULL) {
		nodoDireita = nodoDireita->remove(tipo);
		atualizaAltura();
		return verificaCondicaoAVL();
	}

	if (tipo != info)
		return this;

	if (nodoEsquerda != NULL) {
		temp = nodoEsquerda->maior();
		info = temp->info;
		nodoEsquerda = nodoEsquerda->remove(temp->info);
	} else {
		temp = nodoDireita->menor();
		info = temp->info;
		nodoDireita = nodoDireita->remove(temp->info);
	}

	novaRaiz = verificaCondicaoAVL();
	atualizaAltura();
	return novaRaiz;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o nodo filho à direita de um nodo dado.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o filho à direita.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::retornaDireita() {
	return nodoDireita;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o nodo filho à esquerda de um nodo dado.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o filho à esquerda.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::retornaEsquerda() {
	return nodoEsquerda;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Subtitui o nodo da direita de um nodo AVL pelo nodo dado.

PARÂMETROS:
	o novo filho à direita.

VALOR DE RETORNO:
	nenhum

*/
template<class TipoInfo> void NodoAVL<TipoInfo>::alterarDireita(NodoAVL<
		TipoInfo>* nodo) {
	nodoDireita = nodo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Substitui a altura de um nodo AVL pelo valor fornecido como parâmetro.

PARÂMETROS:
	a altura nova.

VALOR DE RETORNO:
	nenhum

*/
template<class TipoInfo> void NodoAVL<TipoInfo>::alterarAltura(int altura) {
	this->altura = altura;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Subtitui o nodo da esquerda de um nodo AVL pelo nodo dado.

PARÂMETROS:
	o novo filho à esquerda.

VALOR DE RETORNO:
	nenhum

*/
template<class TipoInfo> void NodoAVL<TipoInfo>::alterarEsquerda(NodoAVL<
		TipoInfo>* nodo) {
	nodoEsquerda = nodo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma string com os dados armazenados na árvore seguindo o percurso prefixado.

PARÂMETROS:
	a string em que serão incluídos os dados.

VALOR DE RETORNO:
	a string com os dados na ordem determinada.

*/
template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPrefixada(
		std::string string = "") {

	std::stringstream saida;
	saida << info << " ";
	string.append(saida.str());
	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaPrefixada(string);
	if (nodoDireita != NULL)
		string = nodoDireita->retornaPrefixada(string);
	return string;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma string com os dados armazenados na árvore seguindo o percurso posfixado.

PARÂMETROS:
	a string em que serão incluídos os dados.

VALOR DE RETORNO:
	a string com os dados na ordem determinada.

*/
template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPosfixada(
		std::string string = "") {

	std::stringstream saida;
	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaPosfixada(string);
	if (nodoDireita != NULL)
		string = nodoDireita->retornaPosfixada(string);
	saida << info << " ";
	string.append(saida.str());
	return string;

}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma string com os dados armazenados na árvore seguindo o percurso infixado.

PARÂMETROS:
	a string em que serão incluídos os dados.

VALOR DE RETORNO:
	a string com os dados na ordem determinada.

*/
template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaInfixada(
		std::string string = "") {
	std::stringstream saida;

	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaInfixada(string);
	saida << info << " ";
	string.append(saida.str());
	if (nodoDireita != NULL)
		string = nodoDireita->retornaInfixada(string);
	return string;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma lista encadeada com os dados armazenados na árvore seguindo o percurso prefixado.

PARÂMETROS:
	a lista em que serão incluídos os dados.

VALOR DE RETORNO:
	a lista com os dados na ordem determinada.

*/
template<class TipoInfo> ListaEncadeada<TipoInfo>* NodoAVL<TipoInfo>::retornaListaPrefixada(
		ListaEncadeada<TipoInfo>* lista = NULL) {
	if(lista == NULL)
		lista = new ListaEncadeada<TipoInfo>();

	lista->adicionarNoFim(&info);
	if (nodoEsquerda != NULL)
		nodoEsquerda->retornaListaPrefixada(lista);
	if (nodoDireita != NULL)
		nodoDireita->retornaListaPrefixada(lista);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma lista encadeada com os dados armazenados na árvore seguindo o percurso infixado.

PARÂMETROS:
	a lista em que serão incluídos os dados.

VALOR DE RETORNO:
	a lista com os dados na ordem determinada.

*/
template<class TipoInfo> ListaEncadeada<TipoInfo>* NodoAVL<TipoInfo>::retornaListaInfixada(
		ListaEncadeada<TipoInfo>* lista = NULL) {
	if(lista == NULL)
		lista = new ListaEncadeada<TipoInfo>();

	if (nodoEsquerda != NULL)
		nodoEsquerda->retornaListaInfixada(lista);
	lista->adicionarNoFim(&info);
	if (nodoDireita != NULL)
		nodoDireita->retornaListaInfixada(lista);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna uma lista encadeada com os dados armazenados na árvore seguindo o percurso posfixado.

PARÂMETROS:
	a lista em que serão incluídos os dados.

VALOR DE RETORNO:
	a lista com os dados na ordem determinada.

*/
template<class TipoInfo> ListaEncadeada<TipoInfo>* NodoAVL<TipoInfo>::retornaListaPosfixada(
		ListaEncadeada<TipoInfo>* lista = NULL) {
	if(lista == NULL)
		lista = new ListaEncadeada<TipoInfo>();

	if (nodoEsquerda != NULL)
		nodoEsquerda->retornaListaPosfixada(lista);
	if (nodoDireita != NULL)
		nodoDireita->retornaListaPosfixada(lista);
	lista->adicionarNoFim(&info);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna a altura do nodo.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a altura do nodo.

*/
template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAltura() {
	return altura;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna a altura da subárvore direita.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a altura do nodo.

*/
template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaDireita() {
	if (nodoDireita == 0)
		return -1;
	return nodoDireita->retornaAltura();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna a altura da subárvore esquerda.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a altura do nodo.

*/
template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaEsquerda() {
	if (nodoEsquerda == 0)
		return -1;
	return nodoEsquerda->retornaAltura();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o número de nodos da árvore dada.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o número de elementos.

*/
template<class TipoInfo> int NodoAVL<TipoInfo>::retornaNumeroDeElementos() {
	int numeroElementos = 0;
	if (retornaEsquerda() != 0)
		numeroElementos += retornaEsquerda()->retornaNumeroDeElementos();
	if (retornaDireita() != 0)
		numeroElementos += retornaDireita()->retornaNumeroDeElementos();
	return numeroElementos + 1;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o menor nodo da árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o menor nodo da árvore.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::menor() {
	NodoAVL<TipoInfo>* atual;

	//Não seria this->info?
	if (this == 0)
		return 0;

	atual = this;
	while (atual->nodoEsquerda != 0)
		atual = atual->nodoEsquerda;
	return atual;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	retorna o maior nodo da árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o maior nodo da árvore.

*/
template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::maior() {
	NodoAVL<TipoInfo>* atual;

	if (this == 0)
		return 0;

	atual = this;
	while (atual->nodoDireita != 0)
		atual = atual->nodoDireita;
	return atual;
}
