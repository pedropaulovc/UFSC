/**
 TÍTULO:        Implementação de árvores multivias semibalanceadas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 árvore B.

 FUNCIONAMENTO GERAL:
 Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
 de uma árvore multivias semibalanceada. A estrutura de dados aceita comandos de inserção, exclusão e
 percurso de maneira prefixada, infixada e posfixada. Como demonstração de funcionamento foi implementado
 um sistema que recebe um arquivo de CEPs fora de ordem e plota o gráfico com o tempo para operar
 nos nodos da árvore. Além disso, foram gerados testes unitários que garantem o funcionamento esperado
 da estrutura de dados.

 SOBRE ESSE ARQUIVO:
 Declaração dos métodos públicos e privados além dos atributos de um NodoB a serem implementados
 em NodoB.ipp.
 */

#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Construtor principal da árvore B.

 PARÂMETROS:
 A ordem (>= 1) da árvore

 VALOR DE RETORNO:
 ponteiro para o objeto criado.

 */
template<class T> NodoB<T>::NodoB(int ordem) {
	this->ordem = ordem;
	numChavesNodo = 0;
	totalChaves = 0;
	altura = 0;
	folha = true;
	raiz = true;
	infos = new ListaEncadeada<const T> ();
	filhos = new ListaEncadeada<NodoB<T> > ();
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Destrutor principal da árvore B.

 PARÂMETROS:
 nenhum

 VALOR DE RETORNO:
 nenhum

 */
template<class T> NodoB<T>::~NodoB() {
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método principal de inserção na árvore B.

 PARÂMETROS:
 O dado a ser inserido

 VALOR DE RETORNO:
 A nova raíz da árvore.

 */
template<class T> NodoB<T>* NodoB<T>::insere(T const &tipo) {
	NodoB<T>* filho = NULL;
	NodoB<T>* novaRaiz = this;

	if (folha) {
		insereFolha(tipo);
	} else {
		filho = filhos->obterDaPosicao(posicaoRamoDescida(tipo));

		filho->insere(tipo);

		if (filho->nodoCheio())
			divideNodo(this, filho);
	}

	if (raiz && nodoCheio()) {
		novaRaiz = new NodoB<T> (ordem);
		divideNodo(novaRaiz, this);
	}

	novaRaiz->atualizaAltura();
	novaRaiz->atualizaQtdElementos();

	return novaRaiz;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método auxiliar de inserção na árvore B, inserção em nodo folha.

 PARÂMETROS:
 O dado a ser inserido

 VALOR DE RETORNO:
 nenhum

 */
template<class T> void NodoB<T>::insereFolha(T const &tipo) {
	if (nodoCheio() || !folha)
		return;

	infos->adicionarEmOrdem(&tipo);

	numChavesNodo++;
	totalChaves++;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método para decisão do ramo a ser seguido para adicionar ou remover um dado.

 PARÂMETROS:
 O dado a ser inserido ou removido

 VALOR DE RETORNO:
 A posição do ramo de descida na árvore dentro da lista de ramos existentes.

 */
template<class T> int NodoB<T>::posicaoRamoDescida(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int posicao = 1;

	while (posicao <= numChavesNodo && tipo > *infoAtual) {
		posicao++;

		infoAtual = infos->obterDaPosicao(posicao);
	}

	return posicao;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método para a moção de 'numChaves' chaves de 'origem' para 'destino'

 PARÂMETROS:
 A origem das chaves, o destino e o o número de chaves

 VALOR DE RETORNO:
 nenhum

 */
template<class T> void NodoB<T>::moverChavesMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int & numChaves) {
	ListaEncadeada<const T> *chavesOrigem = origem->infos;
	ListaEncadeada<const T> *chavesDestino = destino->infos;
	const T *chaveAtual = chavesOrigem->obterDoInicio();
	int i = 1;
	while (i < numChaves) {
		chavesOrigem->removerDoInicio();
		chavesDestino->adicionarEmOrdem(chaveAtual);
		i++;
		chaveAtual = chavesOrigem->obterDoInicio();
	}
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método para a divisão de um nodo cheio em dois nodos.

 PARÂMETROS:
 A raiz do nodo cheio e 'filho', o nodo cheio

 VALOR DE RETORNO:
 nenhum

 */
template<class T> void NodoB<T>::divideNodo(NodoB<T>* raiz, NodoB<T>* filho) {
	if (!filho->nodoCheio())
		return;

	int nodoMeio = ordem + 1;
	const T* infoSobe = filho->infos->removerDaPosicao(nodoMeio);
	NodoB<T>* outroFilho = new NodoB<T> (ordem);

	moverChavesMenores(filho, outroFilho, nodoMeio);

	moverRamosMenores(filho, outroFilho, nodoMeio);

	filho->atualizaQtdElementos();
	filho->atualizaAltura();
	filho->raiz = false;
	outroFilho->atualizaQtdElementos();
	outroFilho->atualizaAltura();
	outroFilho->raiz = false;

	int posicaoNovoFilho = raiz->posicaoRamoDescida(*infoSobe);
	raiz->infos->adicionarEmOrdem(infoSobe);
	raiz->numChavesNodo++;
	raiz->filhos->adicionarNaPosicao(outroFilho, posicaoNovoFilho);

	if (raiz->filhos->obterDaPosicao(posicaoNovoFilho + 1) != filho) {
		raiz->filhos->adicionarNaPosicao(filho, posicaoNovoFilho + 1);
		raiz->numChavesNodo++;
	}

	raiz->folha = false;
	raiz->atualizaAltura();
	raiz->atualizaQtdElementos();
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método para a moção de 'numRamos' ramos de 'origem' para 'destino'

 PARÂMETROS:
 A origem das chaves, o destino e o o número de ramos

 VALOR DE RETORNO:
 nenhum

 */
template<class T> void NodoB<T>::moverRamosMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int numRamos) {
	ListaEncadeada<NodoB<T> > *ramosOrigem = origem->filhos;
	ListaEncadeada<NodoB<T> > *ramosDestino = destino->filhos;
	NodoB<T> *ramoAtual = ramosOrigem->obterDoInicio();
	int i = 1;
	while (i <= numRamos && ramoAtual != NULL) {
		ramosOrigem->removerDoInicio();
		ramosDestino->adicionarNaPosicao(ramoAtual, i);
		i++;
		ramoAtual = ramosOrigem->obterDoInicio();
	}
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método principal para a remoção de uma chave da árvore.

 PARÂMETROS:
 O valor a ser removido.

 VALOR DE RETORNO:
 A nova raíz da árvore.

 */
template<class T> NodoB<T>* NodoB<T>::remove(T const &tipo) {
	NodoB<T>* possivelNovaRaiz = this;
	if (infos->contem(&tipo)) {
		removeDoNodo(tipo);
	} else {
		NodoB<T> *nodoSelecionado = filhos->obterDaPosicao(posicaoRamoDescida(
				tipo));
		nodoSelecionado->remove(tipo);

		possivelNovaRaiz = ajustaFilhoAposRemocao(tipo, nodoSelecionado);
	}

	atualizaAltura();
	atualizaQtdElementos();
	return possivelNovaRaiz;
}

/**
 ALUNOS: Pedro Paulo e Felipe dos Santos
 PROPÓSITO:
 Método auxiliar para a remoção de uma chave da árvore. Caso especial, remoção de chave no próprio nodo.

 PARÂMETROS:
 O valor a ser removido.

 VALOR DE RETORNO:
 nenhum

 */
template<class T> void NodoB<T>::removeDoNodo(const T & tipo) {
	if (folha) {
		infos->removerDaPosicao(infos->posicao(&tipo));
	} else {
		removeDoNodoInterno(tipo);
	}
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método auxiliar para a remoção de uma chave da árvore. Caso especial, remoção
	de chave no próprio nodo, sendo esse um nodo interno.

PARÂMETROS:
	O valor a ser removido.

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::removeDoNodoInterno(const T & tipo) {
	int posicaoNodoPredecessor = infos->posicao(&tipo);
	NodoB<T> *nodoPredecessor = filhos->obterDaPosicao(posicaoNodoPredecessor);
	int posicaoElementoRemovido = infos->posicao(&tipo);

	if (nodoPredecessor->retornaNumeroDeChaves() >= ordem + 1) {
		ListaEncadeada<const T> *infosDoPredecessor = nodoPredecessor->infos;
		const T *predecessorInordem = infosDoPredecessor->removerDoFim();
		infosDoPredecessor->adicionarNoFim(infos->removerDaPosicao(
				posicaoElementoRemovido));
		infos->adicionarNaPosicao(predecessorInordem, posicaoElementoRemovido);
		nodoPredecessor->remove(tipo);
		return;
	}

	int posicaoNodoSucessor = posicaoNodoPredecessor + 1;
	NodoB<T> *nodoSucessor = filhos->obterDaPosicao(posicaoNodoSucessor);

	if (nodoSucessor->retornaNumeroDeChaves() >= ordem + 1) {
		ListaEncadeada<const T> *infosDoSucessor = nodoSucessor->infos;
		const T *sucessorInordem = infosDoSucessor->removerDoInicio();
		infosDoSucessor->adicionarNoInicio(infos->removerDaPosicao(
				posicaoElementoRemovido));
		infos->adicionarNaPosicao(sucessorInordem, posicaoElementoRemovido);
		nodoSucessor->remove(tipo);
		return;
	}

	ListaEncadeada<const T> *infosDoPredecessor = nodoPredecessor->infos;
	ListaEncadeada<const T> *infosDoSucessor = nodoSucessor->infos;
	infosDoPredecessor->adicionarNoFim(infos->removerDaPosicao(
			posicaoElementoRemovido));
	for (int i = 0; i < ordem; i++) {
		infosDoPredecessor->adicionarEmOrdem(infosDoSucessor->removerDoFim());
	}
	filhos->removerDaPosicao(posicaoNodoSucessor);
	nodoPredecessor->remove(tipo);

}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método para a fusão de dois nodos movendo os conteúdos do nodo da direita ('origem') para
	a esquerda ('destino'). Remove o nodo antigo, localizado em 'posicao'

PARÂMETROS:
	A origem dos dados, o destino e a posição do nodo a ser removido.

VALOR DE RETORNO:
	'destino'

*/
template<class T> NodoB<T>* NodoB<T>::fundirNodosParaEsquerda(
		NodoB<T> *destino, NodoB<T>* origem, int & posicao) {

	ListaEncadeada<const T> *infosOrigem = origem->infos;
	ListaEncadeada<NodoB<T> > *filhosOrigem = origem->filhos;
	ListaEncadeada<const T> *infosDestino = destino->infos;
	ListaEncadeada<NodoB<T> > *filhosDestino = destino->filhos;

	int posicaoParaAdicionar = posicao - 1;
	infosDestino->adicionarEmOrdem(
			infos->removerDaPosicao(posicaoParaAdicionar));
	for (int i = 0; i < ordem - 1; i++) {
		infosDestino->adicionarEmOrdem(infosOrigem->removerDoFim());
	}

	int qtdFilhosOrigem = filhosOrigem->obterTamanho();
	for (int i = 1; i <= qtdFilhosOrigem; i++) {
		filhosDestino->adicionarNoFim(filhosOrigem->removerDoInicio());
	}

	filhos->removerDaPosicao(posicao);
	destino->atualizaQtdElementos();
	return destino;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método para a fusão de dois nodos movendo os conteúdos do nodo da esquerda ('origem') para
	a esquerda ('destino'). Remove o nodo antigo, localizado em 'posicao'

PARÂMETROS:
	A origem dos dados, o destino e a posição do nodo a ser removido.

VALOR DE RETORNO:
	'destino'

*/
template<class T> NodoB<T>* NodoB<T>::fundirNodosParaDireita(NodoB<T> *destino,
		NodoB<T>* origem, int posicao) {

	ListaEncadeada<const T> *infosOrigem = origem->infos;
	ListaEncadeada<NodoB<T> > *filhosOrigem = origem->filhos;
	ListaEncadeada<const T> *infosDestino = destino->infos;
	ListaEncadeada<NodoB<T> > *filhosDestino = destino->filhos;

	infosDestino->adicionarEmOrdem(infos->removerDaPosicao(posicao));
	for (int i = 0; i < ordem - 1; i++) {
		infosDestino->adicionarEmOrdem(infosOrigem->removerDoInicio());
	}

	int qtdFilhosOrigem = filhosOrigem->obterTamanho();
	for (int i = 1; i <= qtdFilhosOrigem; i++) {
		filhosDestino->adicionarNoFim(filhosOrigem->removerDoInicio());
	}

	filhos->removerDaPosicao(posicao);
	destino->atualizaQtdElementos();
	return destino;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método para o ajuste de nodo filho que venha a entrar em underflow após remoção de chave.

PARÂMETROS:
	O dado removido e o filho em potencial underflow

VALOR DE RETORNO:
	A nova raíz da subárvore.

*/
template<class T> NodoB<T>* NodoB<T>::ajustaFilhoAposRemocao(const T & tipo,
		NodoB<T> *filho) {

	ListaEncadeada<const T> *infosNodoSelecionado = filho->infos;

	if (filho->retornaNumeroDeChaves() != ordem - 1) {
		return this;
	}

	int posicaoNodoSelecionado = posicaoRamoDescida(tipo);
	NodoB<T>* nodoEsquerdaDoSelecionado = filhos->obterDaPosicao(
			posicaoNodoSelecionado - 1);
	NodoB<T>* nodoDireitaDoSelecionado = filhos->obterDaPosicao(
			posicaoNodoSelecionado + 1);

	if (nodoEsquerdaDoSelecionado != NULL
			&& nodoEsquerdaDoSelecionado->retornaNumeroDeChaves() >= ordem + 1) {
		ListaEncadeada<const T>* infosIrmaoEsquerda =
				nodoEsquerdaDoSelecionado->infos;
		const T* maiorElemento = infosIrmaoEsquerda->removerDoFim();

		infos->adicionarEmOrdem(maiorElemento);

		infosNodoSelecionado->adicionarEmOrdem(infos->removerDaPosicao(
				posicaoNodoSelecionado));

		filho->atualizaQtdElementos();
		nodoEsquerdaDoSelecionado->atualizaQtdElementos();
		return this;
	}

	if (nodoDireitaDoSelecionado != NULL
			&& nodoDireitaDoSelecionado->retornaNumeroDeChaves() >= ordem + 1) {
		ListaEncadeada<const T>* infosIrmaoDireita =
				nodoDireitaDoSelecionado->infos;
		const T* menorElemento = infosIrmaoDireita->removerDoInicio();

		infos->adicionarEmOrdem(menorElemento);

		infosNodoSelecionado->adicionarEmOrdem(infos->removerDaPosicao(
				posicaoNodoSelecionado));

		filho->atualizaQtdElementos();
		nodoDireitaDoSelecionado->atualizaQtdElementos();
		return this;
	}

	NodoB<T>* possivelNovaRaiz;

	if (nodoEsquerdaDoSelecionado != NULL) {
		possivelNovaRaiz = fundirNodosParaEsquerda(nodoEsquerdaDoSelecionado,
				filho, posicaoNodoSelecionado);
	}

	if (nodoDireitaDoSelecionado != NULL) {
		possivelNovaRaiz = fundirNodosParaDireita(nodoDireitaDoSelecionado,
				filho, posicaoNodoSelecionado);
	}

	if (raiz) {
		atualizaAltura();
		atualizaQtdElementos();
		if (numChavesNodo == 0)
			return possivelNovaRaiz;
	}

	return this;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método para o ajuste da altura de um nodo após operação de inserção ou remoção.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::atualizaAltura() {
	int i = 1;
	int maxAltura = -1;
	int alturaFilho;
	while (i <= filhos->obterTamanho()) {
		alturaFilho = filhos->obterDaPosicao(i)->retornaAltura();
		if (alturaFilho > maxAltura)
			maxAltura = alturaFilho;
		i++;
	}

	if (maxAltura == -1)
		altura = 0;
	else
		altura = maxAltura + 1;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Método para o ajuste da quantidade de elementos de um nodo após operação de
	inserção ou remoção.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::atualizaQtdElementos() {
	int totalSubarvores = 0;
	NodoB<T>* filho;

	for (int i = 1; i <= filhos->obterTamanho(); i++) {
		filho = filhos->obterDaPosicao(i);
		totalSubarvores += filho->retornaNumeroDeElementos();
	}

	numChavesNodo = infos->obterTamanho();
	totalChaves = totalSubarvores + numChavesNodo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna valor booleano verdadeiro se o nodo está com mais que 2*ordem + 1 chaves armazenadas nele.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	verdadeiro se o nodo está cheio ou falso em caso contrário.

*/
template<class T> bool NodoB<T>::nodoCheio() {
	return numChavesNodo == 2 * ordem + 1;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna valor booleano verdadeiro se o nodo está com 0 chaves armazenadas nele.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	verdadeiro se o nodo está vazio ou falso em caso contrário.

*/
template<class T> bool NodoB<T>::nodoVazio() {
	return numChavesNodo == 0;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna a quantidade de chaves armazenadas no nodo e em todos seus ramos.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	O total de elementos armazenados na subárvore.

*/
template<class T> int NodoB<T>::retornaNumeroDeElementos() {
	return totalChaves;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna quantidade de chaves armazenadas somente no nodo.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a quantidade de chaves armazenadas no nodo.

*/
template<class T> int NodoB<T>::retornaNumeroDeChaves() {
	return numChavesNodo;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna a altura de um nodo

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a altura de um nodo.

*/
template<class T> int NodoB<T>::retornaAltura() {
	return altura;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Retorna o número de ramos que o nodo possui referência.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	o número de filhos que o nodo possui.

*/
template<class T> int NodoB<T>::retornaNumeroDeFilhos() {
	return filhos->obterTamanho();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso prefixado na árvore gravando as referências em uma lista encadeada passada por
	parâmetro.

PARÂMETROS:
	a lista a ser gravada com os elementos em preordem.

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::retornaPrefixada(
		ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	const T* infoAtual = infos->obterDoInicio();

	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);
	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaPrefixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaPrefixada(lista);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaPrefixada(lista);
		i++;
	}

}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso infixado na árvore gravando as referências em uma lista encadeada passada por
	parâmetro.

PARÂMETROS:
	a lista a ser gravada com os elementos em inordem.

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::retornaInfixada(ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	const T* infoAtual = infos->obterDoInicio();

	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaInfixada(lista);
	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaInfixada(lista);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaInfixada(lista);
		i++;
	}
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso posfixado na árvore gravando as referências em uma lista encadeada passada por
	parâmetro.

PARÂMETROS:
	a lista a ser gravada com os elementos em posordem.

VALOR DE RETORNO:
	nenhum

*/
template<class T> void NodoB<T>::retornaPosfixada(
		ListaEncadeada<const T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<const T> ();

	const T* infoAtual = infos->obterDoInicio();

	if (filhos->obterDoInicio() != NULL)
		filhos->obterDoInicio()->retornaPosfixada(lista);
	if (filhos->obterDaPosicao(2) != NULL)
		filhos->obterDaPosicao(2)->retornaPosfixada(lista);
	if (infoAtual != NULL)
		lista->adicionarNoFim(infoAtual);

	int i = 2;
	while (i <= infos->obterTamanho()) {
		if (filhos->obterDaPosicao(i + 1) != NULL)
			filhos->obterDaPosicao(i + 1)->retornaPosfixada(lista);
		infoAtual = infos->obterDaPosicao(i);
		if (infoAtual != NULL)
			lista->adicionarNoFim(infoAtual);
		i++;
	}
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso prefixado na árvore gerando uma string contendo todos os elementos armazenados na
	árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a string contendo todos os elementos da subárvore separados por espaço.

*/
template<class T> std::string NodoB<T>::retornaPrefixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPrefixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso infixado na árvore gerando uma string contendo todos os elementos armazenados na
	árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a string contendo todos os elementos da subárvore separados por espaço.

*/
template<class T> std::string NodoB<T>::retornaInfixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaInfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Realiza o percurso posfixado na árvore gerando uma string contendo todos os elementos armazenados na
	árvore.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	a string contendo todos os elementos da subárvore separados por espaço.

*/
template<class T> std::string NodoB<T>::retornaPosfixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPosfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}
