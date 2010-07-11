/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de um indexador de chave primária, contendo métodos e atributos necessários para
 a importação, uso e exportação de um índice de chaves primárias.
*/

#ifndef INDEXADORCHAVEPRIMARIA_H_
#define INDEXADORCHAVEPRIMARIA_H_

#include "../Indexador.h"
#include "../../Estruturas/ArvoreAVL/arvore_avl.h"
#include "../../Portarias/Portaria.h"
#include "../../Portarias/PortariaSerializada.h"
#include "../../Estruturas/ArvoreBinaria/NodoBinario.h"

class IndexadorChavePrimaria: public Indexador {
private:
	static int serializarArvore(NodoAVL<Portaria> *arvore,
			PortariaSerializada **lista, int* posicaoVaga);
	static NodoBinario<PortariaSerializada>* importarArvore(string *nodos, int nodoAtual = 0);

public:
	static NodoBinario<PortariaSerializada>* importar(string caminho);
	static void
	exportar(string caminho, Portaria **portarias, int numPortarias);
};

#endif /* INDEXADORCHAVEPRIMARIA_H_ */
