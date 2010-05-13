/**
TÍTULO:        Implementação do algoritmo para solver o problema das Torres de Hanoi
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         13 de maio de 2010

PROPÓSITO:
Este programa é uma implementação do algoritmo para solver o problema das Torres de Hanoi que permite
evidenciar sua complexidade.

FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é uma implementação do algoritmo para solver o problema
das Torres de Hanoi de maneira iterativa além de conter extensões que permitem ao usuário verificar sua complexidade.

FUNÇÕES
destruirInfo
	remove da memória a informação de elemento fornecida.

*/

#include <stdlib.h>
#include "tInfo.h"

/**
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	remove da memória a informação de elemento fornecida.

PARÂMETROS:
	a informação a ser removida.

VALOR DE RETORNO:
	nenhum

*/
void destruirInfo(tInfo* info) {
	free(info);
}
