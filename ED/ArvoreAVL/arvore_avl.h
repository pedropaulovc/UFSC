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

 FUNÇÕES

 verificaCondicaoAVL();
 Analisa o fator de desbalanceamento entre os dois nodos filhos e se necessário invoca um dos métodos
 para rebalancear a árvore.

 rotacaoDireita();
 Realiza uma rotação simples à direita.

 rotacaoEsquerda();
 Realiza uma rotação simples à esquerda.
 rotacaoDuplaDireita();
 Realiza uma rotação dupla à direita.

 rotacaoDuplaEsquerda();
 Realiza uma rotação dupla à esquerda.

 insere(const TipoInfo& tipo);
 Método principal para a inserção de um novo nodo na árvore.

 remove(const TipoInfo& tipo);
 Método principal para a remoção de um nodo na árvore.

 retornaPrefixada(std::string string);
 Retorna uma string contendo todos os elementos da árvore usando o percurso em preordem.

 retornaPosfixada(std::string string);
 Retorna uma string contendo todos os elementos da árvore usando o percurso emordem.

 retornaInfixada(std::string string);
 Retorna uma string contendo todos os elementos da árvore usando o percurso em posordem.

 retornaListaPrefixada(ListaEncadeada<TipoInfo>* lista);
 Retorna uma lista contendo todos os elementos da árvore usando o percurso em preordem.

 retornaListaPosfixada(ListaEncadeada<TipoInfo>* lista);
 Retorna uma lista contendo todos os elementos da árvore usando o percurso emordem.

 retornaListaInfixada(ListaEncadeada<TipoInfo>* lista);
 Retorna uma lista contendo todos os elementos da árvore usando o percurso em posordem.

 retornaAltura();
 Retorna a altura de um nodo específico.

 retornaAlturaDireita();
 Retorna a altura da direita de um nodo específico.

 retornaAlturaEsquerda();
 Retorna a altura da esquerda de um nodo específico.

 retornaNumeroDeElementos();
 Retorna o número de elementos armazenados na subárvore.

 retornaNumeroDeElementosDireita();
 Retorna o número de elementos armazenados na direita da subárvore.

 retornaNumeroDeElementosEsquerda();
 Retorna o número de elementos armazenados na esquerda da subárvore.

 retornaFatorDesbalanceamento();
 Retorna o fator de desbalanceamento, composto pela diferença entre as alturas direita e esquerda da
 subárvore.

 atualizaAltura();
 Atualiza a altura de uma subárvore segundo as convenções vistas em aula.

 retornaEsquerda();
 Retorna o nodo da esquerda.

 retornaDireita();
 Retorna o nodo da direita.

 alterarEsquerda(NodoAVL<TipoInfo>* nodo);
 Altera o nodo da esquerda do nodo chamado.

 alterarDireita(NodoAVL<TipoInfo>* nodo);
 Altera o nodo da direita do nodo chamado.

 alterarAltura(int altura);
 Altera a altura do nodo vhamado.

 menor();
 Retorna o menor nodo da subárvore.

 maior();
 Retorna o maior nodo da subárvore.
 */
#ifndef ARVORE_AVL_H
#define ARVORE_AVL_H

#include <string>
#include "Estruturas/ListaEncadeada.h"

template<class TipoInfo>
class NodoAVL {

private:

	TipoInfo info;
	NodoAVL *nodoEsquerda;
	NodoAVL *nodoDireita;
	int altura;
	int numElementos;
	bool utilizado;

	NodoAVL<TipoInfo>* verificaCondicaoAVL();

	NodoAVL<TipoInfo>* rotacaoDireita();
	NodoAVL<TipoInfo>* rotacaoEsquerda();
	NodoAVL<TipoInfo>* rotacaoDuplaDireita();
	NodoAVL<TipoInfo>* rotacaoDuplaEsquerda();

public:

	NodoAVL();
	~NodoAVL();

	NodoAVL<TipoInfo>* insere(const TipoInfo& tipo);
	NodoAVL<TipoInfo>* remove(const TipoInfo& tipo);

	std::string retornaPrefixada(std::string string);
	std::string retornaPosfixada(std::string string);
	std::string retornaInfixada(std::string string);

	ListaEncadeada<TipoInfo>* retornaListaPrefixada(
			ListaEncadeada<TipoInfo>* lista);
	ListaEncadeada<TipoInfo>* retornaListaPosfixada(
			ListaEncadeada<TipoInfo>* lista);
	ListaEncadeada<TipoInfo>* retornaListaInfixada(
			ListaEncadeada<TipoInfo>* lista);

	int retornaAltura();
	int retornaAlturaDireita();
	int retornaAlturaEsquerda();

	int retornaNumeroDeElementos();
	int retornaNumeroDeElementosDireita();
	int retornaNumeroDeElementosEsquerda();

	int retornaFatorDesbalanceamento();
	void atualizaAltura();

	NodoAVL<TipoInfo>* retornaEsquerda();
	NodoAVL<TipoInfo>* retornaDireita();

	void alterarEsquerda(NodoAVL<TipoInfo>* nodo);
	void alterarDireita(NodoAVL<TipoInfo>* nodo);
	void alterarAltura(int altura);

	NodoAVL<TipoInfo>* menor();
	NodoAVL<TipoInfo>* maior();
};

#include "arvore_avl.ipp"

#endif
