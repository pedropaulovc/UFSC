#include "Estruturas/ListaEncadeada.h"
#include <cstdlib>
#include <sstream>
#include <iostream>

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

template<class T> NodoB<T>* NodoB<T>::remove(T const &tipo) {
	//	NodoB<T> *nodo, *nodoRemovido;
	//	ListaEncadeada<NodoB<T> >* nodos = new ListaEncadeada<NodoB<T> >();
	//
	//	nodo = this;
	//	nodos->adicionarNoFim(nodo);
	//
	//	while(nodo != NULL && !nodo->infos->contem(&tipo)){
	//		nodo = nodo->selecionaRamoDescida(tipo);
	//		nodos->adicionarNoFim(nodo);
	//	}
	//
	//	if(nodo == NULL)
	//		return this;
	//
	//	if(nodo->folha){
	//		nodo->infos->removerDaPosicao(nodo->infos->posicao(&tipo));
	//		int tamanho = nodos->obterTamanho();
	//		for(int i = 0; i < tamanho; i++){
	//			nodoRemovido = nodos->removerDoFim();
	//			nodoRemovido->atualizaQtdElementos();
	//			nodoRemovido->atualizaAltura();
	//		}
	//		return this;
	//	}
	//
	//	ListaEncadeada<const T>* infosDoNodo = nodo->infos;
	//	int posicaoInfoNodo = infosDoNodo->posicao(&tipo);
	//	int posicaoNodoPredecessor = nodo->infos->posicao(&tipo);
	//	posicaoNodoPredecessor != 1 ? posicaoNodoPredecessor++ : posicaoNodoPredecessor;
	//	int posicaoNodoSucessor = posicaoNodoPredecessor + 1;
	//
	//	NodoB<T>* nodoPredecessor = nodo->filhos->obterDaPosicao(posicaoNodoPredecessor);
	//	ListaEncadeada<const T>* infosDoPredecessor = nodoPredecessor->infos;
	//	NodoB<T>* nodoSucessor = nodo->filhos->obterDaPosicao(posicaoNodoSucessor);
	//	ListaEncadeada<const T>* infosDoSucessor = nodoSucessor->infos;
	//
	//	if(nodoPredecessor->retornaNumeroDeChaves() >= ordem + 1){
	//		const T* elementoPredecessor = infosDoPredecessor->removerDoFim();
	//		const T* elementoARemover = infosDoNodo->removerDaPosicao(posicaoInfoNodo);
	//		infosDoPredecessor->adicionarEmOrdem(elementoARemover);
	//		infosDoNodo->adicionarEmOrdem(elementoPredecessor);
	//
	//		nodoPredecessor->remove(tipo);
	//
	//		int tamanho = nodos->obterTamanho();
	//		for(int i = 0; i < tamanho; i++){
	//			nodoRemovido = nodos->removerDoFim();
	//			nodoRemovido->atualizaQtdElementos();
	//			nodoRemovido->atualizaAltura();
	//		}
	//		return this;
	//	}
	//
	//	if(nodoSucessor->retornaNumeroDeChaves() >= ordem + 1){
	//		const T* elementoSucessor = infosDoSucessor->removerDoInicio();
	//		const T* elementoARemover = infosDoNodo->removerDaPosicao(posicaoInfoNodo);
	//		infosDoSucessor->adicionarEmOrdem(elementoARemover);
	//		infosDoNodo->adicionarEmOrdem(elementoSucessor);
	//
	//		nodoSucessor->remove(tipo);
	//
	//		int tamanho = nodos->obterTamanho();
	//		for(int i = 0; i < tamanho; i++){
	//			nodoRemovido = nodos->removerDoFim();
	//			nodoRemovido->atualizaQtdElementos();
	//			nodoRemovido->atualizaAltura();
	//		}
	//		return this;
	//	}
	//
	//	ListaEncadeada<NodoB<T> >* filhosDoNodo = nodo->filhos;
	//
	//	if(nodoPredecessor->numChavesNodo > 0){
	//		for(int i = 0; i < nodoSucessor->retornaNumeroDeChaves(); i++)
	//			infosDoPredecessor->adicionarEmOrdem(infosDoSucessor->removerDoFim());
	//
	//		filhosDoNodo->removerDaPosicao(posicaoNodoSucessor);
	//		int tamanho = filhosDoNodo->obterTamanho();
	//		for(int i = 0; i < tamanho; i++){
	//			nodoRemovido = filhosDoNodo->removerDoFim();
	//			nodoRemovido->atualizaQtdElementos();
	//			nodoRemovido->atualizaAltura();
	//		}
	//
	//		if(nodo->raiz && nodo->retornaNumeroDeChaves() == 1){
	//			nodoPredecessor->raiz = true;
	//			return nodoPredecessor;
	//		}
	//
	//		nodoPredecessor->insere(tipo);
	//		nodoPredecessor->remove(tipo);
	//
	//		infosDoNodo->removerDaPosicao(infosDoNodo->posicao(&tipo));
	//
	//		//TODO fazer teste
	//
	//		return this;
	//	}


	if (infos->contem(&tipo)) {
		if (folha) {
			infos->removerDaPosicao(infos->posicao(&tipo));
			std::cout << tipo << " e nodo folha, caso simples\n";
		} else {
			int posicaoNodoPredecessor = infos->posicao(&tipo);
			NodoB<T>* nodoPredecessor = filhos->obterDaPosicao(
					posicaoNodoPredecessor);
			int posicaoElementoRemovido = infos->posicao(&tipo);

			if (nodoPredecessor->retornaNumeroDeChaves() >= ordem + 1) {
				ListaEncadeada<const T>* infosDoPredecessor =
						nodoPredecessor->infos;

				const T* predecessorInordem =
						infosDoPredecessor->removerDoFim();
				infosDoPredecessor->adicionarNoFim(infos->removerDaPosicao(
						posicaoElementoRemovido));
				infos->adicionarNaPosicao(predecessorInordem,
						posicaoElementoRemovido);

				nodoPredecessor->remove(tipo);

				std::cout << tipo << " não é folha, mas o nodo da esquerda tem elementos sobrando\n";
			} else {
				int posicaoNodoSucessor = posicaoNodoPredecessor + 1;
				NodoB<T>* nodoSucessor = filhos->obterDaPosicao(
						posicaoNodoSucessor);

				if (nodoSucessor->retornaNumeroDeChaves() >= ordem + 1) {
					ListaEncadeada<const T>* infosDoSucessor =
							nodoSucessor->infos;

					const T* sucessorInordem =
							infosDoSucessor->removerDoInicio();
					infosDoSucessor->adicionarNoInicio(infos->removerDaPosicao(
							posicaoElementoRemovido));
					infos->adicionarNaPosicao(sucessorInordem,
							posicaoElementoRemovido);

					nodoSucessor->remove(tipo);
					std::cout << tipo << " não é folha, mas o nodo da direita tem elementos sobrando\n";
				} else {

					//TODO ajustar para os elementos do canto

					ListaEncadeada<const T>* infosDoPredecessor =
							nodoPredecessor->infos;
					ListaEncadeada<const T>* infosDoSucessor =
							nodoSucessor->infos;

					infosDoPredecessor->adicionarNoFim(infos->removerDaPosicao(
							posicaoElementoRemovido));
					for (int i = 0; i < ordem; i++) {
						infosDoPredecessor->adicionarEmOrdem(
								infosDoSucessor->removerDoFim());
					}

					filhos->removerDaPosicao(posicaoNodoSucessor);

					nodoPredecessor->remove(tipo);
				}
			}
		}
	}

	else {
		NodoB<T>* nodoSelecionado = selecionaRamoDescida(tipo);
		ListaEncadeada<const T>* infosNodoSelecionado = nodoSelecionado->infos;
		nodoSelecionado->remove(tipo);

		if (nodoSelecionado->retornaNumeroDeChaves() == ordem - 1) {
			int posicaoNodoSelecionado = posicaoRamoDescida(tipo);
			NodoB<T>* nodoEsquerdaDoSelecionado = filhos->obterDaPosicao(
					posicaoNodoSelecionado - 1);
			NodoB<T>* nodoDireitaDoSelecionado = filhos->obterDaPosicao(posicaoNodoSelecionado
					+ 1);

			if (nodoEsquerdaDoSelecionado != NULL
					&& nodoEsquerdaDoSelecionado->retornaNumeroDeChaves()
							>= ordem + 1) {
				ListaEncadeada<const T>* infosIrmaoEsquerda =
						nodoEsquerdaDoSelecionado->infos;
				const T* maiorElemento = infosIrmaoEsquerda->removerDoFim();

				infos->adicionarEmOrdem(maiorElemento);

				infosNodoSelecionado->adicionarEmOrdem(infos->removerDaPosicao(posicaoNodoSelecionado));

				nodoSelecionado->atualizaQtdElementos();
				nodoEsquerdaDoSelecionado->atualizaQtdElementos();
			} else {
				if (nodoDireitaDoSelecionado != NULL
						&& nodoDireitaDoSelecionado->retornaNumeroDeChaves()
								>= ordem + 1) {
					ListaEncadeada<const T>* infosIrmaoDireita =
							nodoDireitaDoSelecionado->infos;
					const T* menorElemento =
							infosIrmaoDireita->removerDoInicio();

					infos->adicionarEmOrdem(menorElemento);

					infosNodoSelecionado->adicionarEmOrdem(
							infos->removerDaPosicao(posicaoNodoSelecionado));

					nodoSelecionado->atualizaQtdElementos();
					nodoDireitaDoSelecionado->atualizaQtdElementos();
				} else {
					NodoB<T>* possivelNovaRaiz;

					if(nodoEsquerdaDoSelecionado != NULL){
						ListaEncadeada<const T>* infosIrmaoEsquerda =
								nodoEsquerdaDoSelecionado->infos;

						int posicaoParaAdicionar = posicaoNodoSelecionado - 1;
						infosIrmaoEsquerda->adicionarEmOrdem(infos->removerDaPosicao(posicaoParaAdicionar));
						for(int i = 0; i < ordem - 1; i++){
							infosIrmaoEsquerda->adicionarEmOrdem(infosNodoSelecionado->removerDoFim());
						}

						filhos->removerDaPosicao(posicaoNodoSelecionado);

						nodoEsquerdaDoSelecionado->atualizaQtdElementos();
						possivelNovaRaiz = nodoEsquerdaDoSelecionado;

					}
					else{
						if(nodoDireitaDoSelecionado != NULL){
							ListaEncadeada<const T>* infosIrmaoDireita =
									nodoDireitaDoSelecionado->infos;

							int posicaoParaAdicionar = posicaoNodoSelecionado + 1;
							infosIrmaoDireita->adicionarEmOrdem(infos->removerDaPosicao(posicaoNodoSelecionado));
							for(int i = 0; i < ordem - 1; i++){
								infosIrmaoDireita->adicionarEmOrdem(infosNodoSelecionado->removerDoInicio());
							}

							filhos->removerDaPosicao(posicaoNodoSelecionado);

							nodoDireitaDoSelecionado->atualizaQtdElementos();
							possivelNovaRaiz = nodoDireitaDoSelecionado;
						}
					}

					if(raiz){
						atualizaAltura();
						atualizaQtdElementos();
						if(numChavesNodo == 0)
							return possivelNovaRaiz;
					}
				}
			}
		}
	}

	atualizaAltura();
	atualizaQtdElementos();
	return this;
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
