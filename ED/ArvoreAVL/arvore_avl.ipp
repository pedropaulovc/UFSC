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
	std::cout << "inserindo " << tipo << "\n";
	if (this->info == 0) {
		info = tipo;
		altura = 0;
		numElementos = 0;
	} else if (tipo < info) {
		if (nodoEsquerda != NULL)
			nodoEsquerda->insere(tipo);
		else {
			nodoEsquerda = new NodoAVL<TipoInfo> ();
			nodoEsquerda->insere(tipo);
		}
	} else {
		if (nodoDireita != NULL)
			nodoDireita->insere(tipo);
		else {
			nodoDireita = new NodoAVL<TipoInfo> ();
			nodoDireita->insere(tipo);
		}
	}
	altura++;
	numElementos++;

	return verificaCondicaoAVL();
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::verificaCondicaoAVL() {
	int fator = retornaFatorDesbalanceamento();
	int fatorDireita, fatorEsquerda;
	NodoAVL<TipoInfo>* novaRaiz;

	if (fator <= 1 && fator >= -1)
		return this;

	if (fator == -2) {
		fatorDireita = nodoDireita->retornaFatorDesbalanceamento();
		if (fatorDireita <= 0)
			novaRaiz = rotacaoEsquerda();
		if (fatorDireita == 1)
			novaRaiz = rotacaoDuplaEsquerda();
	}

	if (fator == 2) {
		fatorEsquerda = nodoEsquerda->retornaFatorDesbalanceamento();
		if (fatorEsquerda <= 0)
			novaRaiz = rotacaoDireita();
		if (fatorEsquerda == 1)
			novaRaiz = rotacaoDuplaDireita();
	}

	return novaRaiz;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoEsquerda() {
	std::cout << "fazendo rotação à esquerda " << this->info << "\n";
	NodoAVL<TipoInfo>* pivo = obterDireita();
	NodoAVL<TipoInfo>* filhoEsquerdaPivo = pivo->obterEsquerda();

	alterarDireita(filhoEsquerdaPivo);
	pivo->alterarEsquerda(this);

	alterarAltura(std::max(retornaAlturaDireita(), retornaAlturaEsquerda()) + 1);
	pivo->alterarAltura(std::max(pivo->retornaAlturaDireita(),
			pivo->retornaAlturaEsquerda()) + 1);

	return pivo;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDireita() {
	std::cout << "fazendo rotação à direita " << this->info << "\n";
	NodoAVL<TipoInfo>* pivo = obterEsquerda();
	NodoAVL<TipoInfo>* filhoDireitaPivo = pivo->obterDireita();

	alterarEsquerda(filhoDireitaPivo);
	pivo->alterarDireita(this);

	alterarAltura(std::max(retornaAlturaDireita(), retornaAlturaEsquerda()) + 1);
	pivo->alterarAltura(std::max(pivo->retornaAlturaEsquerda(),
			pivo->retornaAlturaDireita()) + 1);

	return pivo;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaDireita() {
	std::cout << "fazendo rotação dupla à direita " << this->info << "\n";
	NodoAVL<TipoInfo>* raiz = obterEsquerda();

	alterarEsquerda(raiz->rotacaoEsquerda());

	return rotacaoDireita();

}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaEsquerda() {
	std::cout << "fazendo rotação dupla à esquerda " << this->info << "\n";
	NodoAVL<TipoInfo>* raiz = obterDireita();

	alterarDireita(raiz->rotacaoDireita());

	return rotacaoEsquerda();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaFatorDesbalanceamento() {
	return retornaAlturaEsquerda() - retornaAlturaDireita();
}

template<class TipoInfo> void NodoAVL<TipoInfo>::remove(const TipoInfo& tipo) {
	//TODO: implementar
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::obterDireita() {
	return nodoDireita;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::obterEsquerda() {
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
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPosfixada(
		std::string string = "") {
	//TODO: implementar
	return std::string();
}

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

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAltura() {
	return altura;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaDireita() {
	if (nodoDireita == 0)
		return 0;
	return nodoDireita->retornaAltura();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAlturaEsquerda() {
	if (nodoEsquerda == 0)
		return 0;
	return nodoEsquerda->retornaAltura();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaNumeroDeElementos() {
	return 0;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::menor() {
	NodoAVL<TipoInfo>* atual;

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
