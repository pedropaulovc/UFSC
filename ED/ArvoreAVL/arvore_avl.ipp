#include <cstdlib>
#include <string>
#include <sstream>

template<class TipoInfo> NodoAVL<TipoInfo>::NodoAVL() {
	this->altura = 0;
	this->numElementos = 0;
}

template<class TipoInfo> NodoAVL<TipoInfo>::~NodoAVL() {
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::insere(
		const TipoInfo& tipo) {
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
			novaRaiz = rotacaoDuplaEsquerda(this);
	}
//Provavelmente as rotações não precisam receber as raízes como paramentros
	if (fator == 2) {
		fatorEsquerda = nodoEsquerda->retornaFatorDesbalanceamento();
		if (fatorEsquerda <= 0)
			novaRaiz = rotacaoDireita(this);
		if (fatorEsquerda == 1)
			novaRaiz = rotacaoDuplaDireita(this);
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

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDireita(
		NodoAVL<TipoInfo>* raiz) {
	NodoAVL<TipoInfo>* pivo = raiz->obterEsquerda();
	NodoAVL<TipoInfo>* filhoDireitaPivo = pivo->obterDireita();

	raiz->alterarEsquerda(filhoDireitaPivo);
	pivo->alterarDireita(raiz);

	raiz->alterarAltura(std::max(raiz->obterDireita()->retornaAltura(),
			raiz->obterEsquerda()->retornaAltura()) + 1);
	pivo->alterarAltura(std::max(pivo->obterDireita()->retornaAltura(),
			pivo->obterEsquerda()->retornaAltura()) + 1);

	return pivo;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaDireita(
		NodoAVL<TipoInfo>* nodo) {
	NodoAVL<TipoInfo>* raiz = nodo->obterEsquerda();

	nodo = rotacaoEsquerda(raiz);

	return rotacaoDireita(nodo);

}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::rotacaoDuplaEsquerda(
		NodoAVL<TipoInfo>* nodo) {
	NodoAVL<TipoInfo>* raiz = nodo->obterDireita();

	nodo = rotacaoDireita(raiz);

	return rotacaoEsquerda(nodo);
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

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPrefixada(std::string string = "") {
	std::stringstream saida;

	saida << info << " ";
	string.append(saida.str());
	if (nodoEsquerda != NULL)
		nodoEsquerda->retornaPrefixada(string);

	if (nodoDireita != NULL)
		nodoDireita->retornaPrefixada(string);
	return string;
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaPosfixada(std::string string = "") {
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> std::string NodoAVL<TipoInfo>::retornaInfixada(std::string string = "") {
	//TODO: implementar
	return std::string();
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaAltura() {
	return altura;
}

template<class TipoInfo> int NodoAVL<TipoInfo>::retornaNumeroDeElementos() {
	return 0;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::menor(){
	NodoAVL<TipoInfo>* atual;

	if(this == 0)
		return 0;

	atual = this;
	while(atual->nodoEsquerda != 0)
		atual = atual->nodoEsquerda;
	return atual;
}

template<class TipoInfo> NodoAVL<TipoInfo>* NodoAVL<TipoInfo>::maior(){
	NodoAVL<TipoInfo>* atual;

	if(this == 0)
		return 0;

	atual = this;
	while(atual->nodoDireita!= 0)
		atual = atual->nodoDireita;
	return atual;
}
