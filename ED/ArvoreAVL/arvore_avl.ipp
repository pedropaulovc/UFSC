#include <cstdlib>

template<class TipoInfo> NodoAVL<TipoInfo>::NodoAVL() {
	this->altura = 0;
	this->numElementos = 0;
}

template<class TipoInfo> NodoAVL<TipoInfo>::~NodoAVL() {
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::insere(const TipoInfo& tipo) {
	if (this->info == 0) {
		info = tipo;
		altura = 0;
		numElementos = 0;
		return this;
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
			novaRaiz = rotacaoEsquerda(this);
		if (fatorDireita == 1)
			novaRaiz = rotacaoDuplaEsquerda();
	}

	if (fator == 2) {
		fatorEsquerda = nodoEsquerda->retornaFatorDesbalanceamento();
		if (fatorEsquerda <= 0)
			novaRaiz = rotacaoDireita(this);
		if (fatorEsquerda == 1)
			novaRaiz = rotacaoDuplaDireita();
	}

	return novaRaiz;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoEsquerda(
		NodoAVL<TipoInfo>* raiz) {
	NodoAVL<TipoInfo>* pivo = raiz->obterDireita();
	NodoAVL<TipoInfo>* filhoEsquerdaPivo = pivo->obterEsquerda();

	raiz->alterarDireita(filhoEsquerdaPivo);
	pivo->alterarEsquerda(raiz);

	raiz->alterarAltura(std::max(raiz->obterDireita()->retornaAltura(),
			raiz->obterEsquerda()->retornaAltura()) + 1);
	pivo->alterarAltura(std::max(pivo->obterDireita()->retornaAltura(),
				pivo->obterEsquerda()->retornaAltura()) + 1);

	return pivo;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaFatorDesbalanceamento() {
	int alturaDireita, alturaEsquerda;

	if (nodoEsquerda != NULL)
		alturaEsquerda = nodoEsquerda->retornaAltura();
	else
		alturaEsquerda = 0;

	if (nodoDireita != NULL)
		alturaDireita = nodoDireita->retornaAltura();
	else
		alturaDireita = 0;

	return alturaEsquerda - alturaDireita;
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

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPrefixada() {
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPosfixada() {
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaInfixada() {
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAltura() {
	return altura;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaNumeroDeElementos() {
	return 0;
}
