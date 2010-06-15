#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>

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

template<class T> NodoB<T>::~NodoB() {
}

template<class T> NodoB<T>* NodoB<T>::insere(T const &tipo) {
	NodoB<T>* filho = NULL;
	NodoB<T>* novaRaiz = this;

	if (folha) {
		insereFolha(tipo);
	} else {
		filho = selecionaRamoDescida(tipo);
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



template<class T> void NodoB<T>::insereFolha(T const &tipo) {
	if (nodoCheio() || !folha)
		return;

	infos->adicionarEmOrdem(&tipo);

	numChavesNodo++;
	totalChaves++;
}

template<class T> NodoB<T>* NodoB<T>::selecionaRamoDescida(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;

		infoAtual = infos->obterDaPosicao(i);
	}

	return filhos->obterDaPosicao(i);
}

template<class T> int NodoB<T>::posicaoRamoDescida(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int posicao = 1;

	while (posicao <= numChavesNodo && tipo > *infoAtual) {
		posicao++;

		infoAtual = infos->obterDaPosicao(posicao);
	}

	return posicao;
}

template<class T> void NodoB<T>::moverChavesMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int & limite) {
	ListaEncadeada<const T> *chavesOrigem = origem->infos;
	ListaEncadeada<const T> *chavesDestino = destino->infos;
	const T *chaveAtual = chavesOrigem->obterDoInicio();
	int i = 1;
	while (i < limite) {
		chavesOrigem->removerDoInicio();
		chavesDestino->adicionarEmOrdem(chaveAtual);
		i++;
		chaveAtual = chavesOrigem->obterDoInicio();
	}
}

template<class T> void NodoB<T>::moverRamosMenores(NodoB<T> *& origem,
		NodoB<T> *& destino, int limite) {
	ListaEncadeada<NodoB<T> > *ramosOrigem = origem->filhos;
	ListaEncadeada<NodoB<T> > *ramosDestino = destino->filhos;
	NodoB<T> *ramoAtual = ramosOrigem->obterDoInicio();
	int i = 1;
	while (i <= limite && ramoAtual != NULL) {
		ramosOrigem->removerDoInicio();
		ramosDestino->adicionarNaPosicao(ramoAtual, i);
		i++;
		ramoAtual = ramosOrigem->obterDoInicio();
	}
}

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

	int posicaoNovoFilho = raiz->encontrarPosicaoNovoNodo(*infoSobe);
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

template<class T> int NodoB<T>::encontrarPosicaoNovoNodo(T const &tipo) {
	const T* infoAtual = infos->obterDaPosicao(1);
	int i = 1;

	while (i <= numChavesNodo && tipo > *infoAtual) {
		i++;
		infoAtual = infos->obterDaPosicao(i);
	}

	return i;
}

template<class T> NodoB<T>* NodoB<T>::remove(T const &tipo) {
	NodoB<T>* possivelNovaRaiz = this;
	if (infos->contem(&tipo)) {
		removeDoNodo(tipo);
	} else {
		NodoB<T> *nodoSelecionado = selecionaRamoDescida(tipo);
		nodoSelecionado->remove(tipo);

		possivelNovaRaiz = ajustaFilhoAposRemocao(tipo, nodoSelecionado);
	}

	atualizaAltura();
	atualizaQtdElementos();
	return possivelNovaRaiz;
}

template<class T> void NodoB<T>::removeDoNodo(const T & tipo) {
	if (folha) {
		infos->removerDaPosicao(infos->posicao(&tipo));
	} else {
		removeDoNodoInterno(tipo);
	}
}

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

	//TODO ajustar para os elementos do canto
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

template<class T> bool NodoB<T>::nodoCheio() {
	return numChavesNodo == 2 * ordem + 1;
}

template<class T> bool NodoB<T>::nodoVazio() {
	return numChavesNodo == 0;
}

template<class T> int NodoB<T>::retornaNumeroDeElementos() {
	return totalChaves;
}

template<class T> int NodoB<T>::retornaNumeroDeChaves() {
	return numChavesNodo;
}

template<class T> int NodoB<T>::retornaAltura() {
	return altura;
}

template<class T> int NodoB<T>::retornaNumeroDeFilhos() {
	return filhos->obterTamanho();
}

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

template<class T> std::string NodoB<T>::retornaPrefixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPrefixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

template<class T> std::string NodoB<T>::retornaInfixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaInfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}

template<class T> std::string NodoB<T>::retornaPosfixada() {
	ListaEncadeada<const T>* lista = new ListaEncadeada<const T> ();
	retornaPosfixada(lista);

	std::stringstream saida;

	for (int i = 1; i <= lista->obterTamanho(); i++) {
		saida << *(lista->obterDaPosicao(i)) << " ";
	}

	return saida.str();
}
