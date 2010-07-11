/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de um indexador de chave secundária, contendo métodos e atributos necessários para
 a importação, uso e exportação de um índice de chaves secundárias.
*/

#ifndef INDEXADORCHAVESECUNDARIA_H_
#define INDEXADORCHAVESECUNDARIA_H_

#include "../Indexador.h"
#include "../../Portarias/Portaria.h"

class IndexadorChaveSecundaria: public Indexador {
public:
	static void exportar(string pasta, string *palavrasChave, int numPalavras,
			Portaria **portarias, int numPortarias);
	static ListaEncadeada<Portaria>* importar(string pasta, string palavraChave, string arquivoDados);
};

#endif /* INDEXADORCHAVESECUNDARIA_H_ */
