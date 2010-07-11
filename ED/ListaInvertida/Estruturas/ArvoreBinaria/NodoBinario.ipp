/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Implementação dos métodos descritos em NodoBinario.h referentes à estrutura de dados Nodo Binário.
*/

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	construtor da classe NodoBinario.

PARÂMETROS:
	Ponteiros para o campo de informações do nodo (obrigatório) e dois ponteiros para os filhos
	desse nodo (opcionais)

VALOR DE RETORNO:
	ponteiro para o objeto criado

*/
template<class T>
NodoBinario<T>::NodoBinario(T* info, NodoBinario<T>* filhoEsquerda,
		NodoBinario<T>* filhoDireita) {
	this->info = info;
	this->filhoEsquerda = filhoEsquerda;
	this->filhoDireita = filhoDireita;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	destrutor do objeto

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

*/
template<class T>
NodoBinario<T>::~NodoBinario() {
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para definir um novo filho à esquerda para o nodo

PARÂMETROS:
	ponteiro para o novo filho

VALOR DE RETORNO:
	nenhum

*/
template<class T>
void NodoBinario<T>::alterarFilhoEsquerda(NodoBinario<T>* filho) {
	this->filhoEsquerda = filho;
}
/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para definir um novo filho à direita para o nodo

PARÂMETROS:
	ponteiro para o novo filho

VALOR DE RETORNO:
	nenhum

*/
template<class T>
void NodoBinario<T>::alterarFilhoDireita(NodoBinario<T>* filho) {
	this->filhoDireita = filho;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para definir um novo campo de informações para o nodo

PARÂMETROS:
	ponteiro o novo campo de informações

VALOR DE RETORNO:
	nenhum

*/
template<class T>
void NodoBinario<T>::alterarInfo(T* info) {
	this->info = info;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para obter o filho da esquerda do nodo

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	ponteiro para o filho da esquerda

*/
template<class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoEsquerda() {
	return this->filhoEsquerda;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para obter o filho da direita do nodo

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	ponteiro para o filho da direita

*/
template<class T>
NodoBinario<T>* NodoBinario<T>::obterFilhoDireita() {
	return this->filhoDireita;
}


/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método para obter o campo de informações do nodo

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	ponteiro para o campo de informações

*/
template<class T>
T* NodoBinario<T>::obterInfo() {
	return this->info;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	método que percorre a árvore em busca de uma nodo cuja campo de informações seja igual ao
	fornecido via parâmetro segundo o operador ==. Retorna NULL em caso de fracasso.

PARÂMETROS:
	Ponteiro contendo a chave buscada

VALOR DE RETORNO:
	Ponteiro para o objeto que tem sua chave idêntica à buscada ou NULL em caso de fracasso.

*/
template<class T>
T* NodoBinario<T>::buscar(T* outro){
	NodoBinario<T>* atual = this;

	while(atual != NULL){
		T *infoAtual = atual->obterInfo();
		if(*infoAtual == *outro)
			return infoAtual;
		else if(*outro > *infoAtual)
			atual = atual->obterFilhoDireita();
		else if(*outro < *infoAtual)
			atual = atual->obterFilhoEsquerda();
		else
			atual = NULL;
	}
	return NULL;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Algoritmo recursivo para o percurso PreOrdem na árvore.

PARÂMETROS:
	Lista a serem inseridos os elementos (opcional)

VALOR DE RETORNO:
	Lista contendo os elementos da árvore.

*/
template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorrePreOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	lista->adicionarNoFim(this->info);
	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePreOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePreOrdemRecursivo(lista);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Algoritmo recursivo para o percurso EmOrdem na árvore.

PARÂMETROS:
	Lista a serem inseridos os elementos (opcional)

VALOR DE RETORNO:
	Lista contendo os elementos da árvore.

*/
template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorreEmOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorreEmOrdemRecursivo(lista);
	lista->adicionarNoFim(this->info);
	if (filhoDireita != NULL)
		filhoDireita->percorreEmOrdemRecursivo(lista);
	return lista;
}

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Algoritmo recursivo para o percurso PosOrdem na árvore.

PARÂMETROS:
	Lista a serem inseridos os elementos (opcional)

VALOR DE RETORNO:
	Lista contendo os elementos da árvore.

*/
template<class T>
ListaEncadeada<T>* NodoBinario<T>::percorrePosOrdemRecursivo(ListaEncadeada<T>* lista) {
	if (lista == NULL)
		lista = new ListaEncadeada<T> ();

	if (filhoEsquerda != NULL)
		filhoEsquerda->percorrePosOrdemRecursivo(lista);
	if (filhoDireita != NULL)
		filhoDireita->percorrePosOrdemRecursivo(lista);
	lista->adicionarNoFim(this->info);
}
