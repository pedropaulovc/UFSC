/**
ARQUIVO:       tInfo.c
TÍTULO:        Implementação da filas encadeadas
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         27 de abril de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados fila encadeada.


FUNCIONAMENTO GERAL:
Como informado no enunciado do trabalho, este programa é um exemplo prático da implementação
de filas. Ele possui um menu simples que aceita do usuário comandos para os principais
usos da estrutura: "enfileirar, desenfileirar, limpar, mostrar fila, sair do programa" em um programa
de exemplo que funciona como sistema de controle de ordem de serviços de uma empresa de manutenção
de computadores.


FUNÇÕES:
destruirInfo
	responsável por liberar a memória antes reservada a um TAD tInfo dado.

ARQUIVOS INCLUSOS:
   stdlib.h
   tInfo.h

ARQUIVOS DE DADOS:
   nenhum

*/
#include <stdlib.h>
#include "tInfo.h"


/**
NOME DA FUNÇÃO: destruirInfo
ALUNOS: Pedro Paulo e Felipe dos Santos
PROPÓSITO:
	Essa função é responsável por liberar a memória antes reservada a um TAD tInfo dado.

PARÂMETROS:
	nenhum

VALOR DE RETORNO:
	nenhum

CHAMA: nada

CHAMADA DE: main
*/
void destruirInfo(tInfo* info){
	free(info->modeloComputador);
	free(info->nomeSolicitante);
	free(info);
}
