#include <cstdlib>
#include <string>
#include <sstream>

//TODO: Remover couts
#include <iostream>

template<class TipoInfo> NodoAVL<TipoInfo>::NodoAVL() {
	this->nodoEsquerda = NULL;
	this->nodoDireita = NULL;
	this->info = NULL;
	this->altura = 0;
	this->numElementos = 0;
}

template<class TipoInfo> NodoAVL<TipoInfo>::~NodoAVL() {
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::insere(
		const TipoInfo& tipo) {
	//	std::cout << "inserindo " << tipo << "\n";

	//FIXME: Há alguma maneira mais bonita de fazer isso?
	if (this->info == NULL) {
		info = new TipoInfo(tipo);
		return this;
	}

	if (tipo < *info) {
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

template<class TipoInfo> void NodoAVL<TipoInfo>::atualizaAltura() {
	//Se o nodo atual tiver algum filho, incrementar um na altura
	//os métodos de retornarAltura retornam -1 caso não exista o nodo

	int maxSubArvore =
			std::max(retornaAlturaEsquerda(), retornaAlturaDireita());
	if (maxSubArvore >= -1)
		alterarAltura(maxSubArvore + 1);
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoEsquerda() {
	//	std::cout << "fazendo rotação à esquerda " << this->info << "\n";

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

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDireita() {
	//	std::cout << "fazendo rotação à direita " << this->info << "\n";
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

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaDireita() {
	//	std::cout << "fazendo rotação dupla à direita " << this->info << "\n";
	NodoAVL<TipoInfo>* k1;
	k1 = retornaDireita();
	alterarDireita(k1->rotacaoEsquerda());

	return rotacaoDireita();
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaEsquerda() {
	//	std::cout << "fazendo rotação dupla à esquerda " << this->info << "\n";
	NodoAVL<TipoInfo>* k1;
	k1 = retornaEsquerda();
	alterarEsquerda(k1->rotacaoDireita());

	return rotacaoEsquerda();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaFatorDesbalanceamento() {
/*	int alturaEsquerda, alturaDireita;
	//Cara, o que é isso? O que você tá fazendo?
	alturaEsquerda = alturaEsquerda < 0 ? 0 : alturaEsquerda;
	alturaDireita = alturaDireita < 0 ? 0 : alturaDireita;*/
	return retornaAlturaEsquerda() - retornaAlturaDireita();
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::remove(
		const TipoInfo& tipo) {
	NodoAVL<TipoInfo> *temp, *novaRaiz;

	if (tipo == *info && nodoEsquerda == NULL && nodoDireita == NULL) {
		delete this;
		return NULL;
	}

	if (tipo < *info && nodoEsquerda != NULL) {
		nodoEsquerda = nodoEsquerda->remove(tipo);
		atualizaAltura();
		return verificaCondicaoAVL();
	}

	if (tipo > *info && nodoDireita != NULL) {
		nodoDireita = nodoDireita->remove(tipo);
		atualizaAltura();
		return verificaCondicaoAVL();
	}

	if (tipo != *info)
		return this;

	if (nodoEsquerda != NULL) {
		temp = nodoEsquerda->maior();
		info = temp->info;
		nodoEsquerda = nodoEsquerda->remove(*(temp->info));
	} else {
		temp = nodoDireita->menor();
		info = temp->info;
		nodoDireita = nodoDireita->remove(*(temp->info));
	}

	novaRaiz = verificaCondicaoAVL();
	atualizaAltura();
	return novaRaiz;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::retornaDireita() {
	return nodoDireita;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::retornaEsquerda() {
	return nodoEsquerda;
}

template<class TipoInfo> void NodoAVL<TipoInfo>::alterarDireita(NodoAVL<
		TipoInfo>* nodo) {
	nodoDireita = nodo;
}

template<class TipoInfo> void NodoAVL<TipoInfo>::alterarAltura(int altura) {
	this->altura = altura;
}

template<class TipoInfo> void NodoAVL<TipoInfo>::alterarEsquerda(NodoAVL<
		TipoInfo>* nodo) {
	nodoEsquerda = nodo;
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPrefixada(
		std::string string = "") {

	std::stringstream saida;
	saida << *info << " ";
	string.append(saida.str());
	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaPrefixada(string);
	if (nodoDireita != NULL)
		string = nodoDireita->retornaPrefixada(string);
	return string;
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPosfixada(
		std::string string = "") {

	std::stringstream saida;
	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaPosfixada(string);
	if (nodoDireita != NULL)
		string = nodoDireita->retornaPosfixada(string);
	saida << *info << " ";
	string.append(saida.str());
	return string;

}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaInfixada(
		std::string string = "") {
	std::stringstream saida;

	if (nodoEsquerda != NULL)
		string = nodoEsquerda->retornaInfixada(string);
	saida << *info << " ";
	string.append(saida.str());
	if (nodoDireita != NULL)
		string = nodoDireita->retornaInfixada(string);
	return string;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAltura() {
	return altura;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaDireita() {
	if (nodoDireita == 0)
		return -1;
	return nodoDireita->retornaAltura();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaEsquerda() {
	if (nodoEsquerda == 0)
		return -1;
	return nodoEsquerda->retornaAltura();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaNumeroDeElementos() {
	int numeroElementos = 0;
	if (retornaEsquerda() != 0)
		numeroElementos += retornaEsquerda()->retornaNumeroDeElementos();
	if (retornaDireita() != 0)
		numeroElementos += retornaDireita()->retornaNumeroDeElementos();
	return numeroElementos + 1;
}

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

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::maior() {
	NodoAVL<TipoInfo>* atual;

	if (this == 0)
		return 0;

	atual = this;
	while (atual->nodoDireita != 0)
		atual = atual->nodoDireita;
	return atual;
}
