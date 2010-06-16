/**
 TÍTULO:        Implementação de lista encadeada
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         15 de junho de 2010

 PROPÓSITO:
 Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados
 lista encadeada.

 SOBRE O ARQUIVO:
 Elemento "container" de um dado a ser armazenado em uma lista encadeada.

 */

#ifndef ELEMENTO_H_
#define ELEMENTO_H_

template<class T> class Elemento {
	Elemento<T>* proximo;
	T* info;

public:
	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 construtor do objeto Elemento

	 PARÂMETROS:
	 ponteiro para o dado a ser armazenado e ponteiro para o próximo elemento da lista.

	 VALOR DE RETORNO:
	 ponteiro para o objeto criado.

	 */
	Elemento(T* infoElemento, Elemento<T>* proximoElemento) {
		proximo = proximoElemento;
		info = infoElemento;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 Destrutor do objeto

	 PARÂMETROS:
	 nenhum

	 VALOR DE RETORNO:
	 nenhum

	 */
	virtual ~Elemento() {
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 retorna ponteiro para o dado armazenado na posição

	 PARÂMETROS:
	 nenhum

	 VALOR DE RETORNO:
	 ponteiro para o dado armazenado

	 */
	T *getInfo() {
		return info;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 retorna ponteiro para o próximo elemento da lista encadeada

	 PARÂMETROS:
	 nenhum

	 VALOR DE RETORNO:
	 ponteiro para o próximo elemento da lista encadeada

	 */
	Elemento<T>* getProximo() {
		return proximo;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 altera o próximo elemento do objeto

	 PARÂMETROS:
	 ponteiro para o próximo elemento

	 VALOR DE RETORNO:
	 nenhum

	 */
	void setProximo(Elemento<T>* proximo) {
		this->proximo = proximo;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 retorna verdadeiro se o elemento é maior que o passado via parâmetro.

	 PARÂMETROS:
	 outro elemento a ser comparado.

	 VALOR DE RETORNO:
	 valor booleano da comparação.

	 */
	bool maior(Elemento<T>* elemento) {
		return *info > *elemento;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 retorna verdadeiro se o elemento é menor que o passado via parâmetro.

	 PARÂMETROS:
	 outro elemento a ser comparado.

	 VALOR DE RETORNO:
	 valor booleano da comparação.

	 */
	bool menor(Elemento<T>* elemento) {
		return *info < *elemento;
	}

	/**
	 ALUNOS: Pedro Paulo e Felipe dos Santos
	 PROPÓSITO:
	 retorna verdadeiro se o elemento é igual que o passado via parâmetro.

	 PARÂMETROS:
	 outro elemento a ser comparado.

	 VALOR DE RETORNO:
	 valor booleano da comparação.

	 */
	bool igual(Elemento<T>* elemento) {
		return *info == *elemento;
	}
};

#endif /* ELEMENTO_H_ */
