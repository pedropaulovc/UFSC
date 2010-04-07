/**
ARQUIVO:       lista.h
TÍTULO:        Implementação de Lista de Contatos com Vetores em "C"
ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
MATÉRIA:       INE5408
PRAZO:         30 de março de 2010

PROPÓSITO:
Este programa é uma implementação dos conceitos vistos em sala de aula sobre a estrutura de dados lista.

SOBRE O ARQUIVO:
Neste arquivo estão definidos os protótipos a serem implementados em lista.c referentes à estrutura de
dados lista, além de definições de constantes usadas ao longo do programa.

DEFINIÇÕES:
MAXELEMENTOS
	Tamanho máximo da lista, por padrão definido no enunciado, 100

MAXNOME
	Tamanho máximo de cada string correspondente ao nome do contato, valor padrão: 31

ERRO_FILA_CHEIA
	Código de erro retornado pela lista em caso de uma operação inválida de adicionar um contato em uma
	lista cheia. Valor padrão -1

ERRO_LISTA_VAZIA
	Código de erro retornado pela lista em caso de uma operação inválida de remover um contato de uma fila vazia.
	Valor padrão: -2

ERRO_POSICAO_INVALIDA
	Código de erro retornado pela lista em caso de uma operação inválida de adicionar, obter ou remover
	um contato de uma posição inválida da lista.
	Valor padrão: -3

TIPOS:
tAgenda
	Definição de um contato da lista, como pedido, um vetor de string para o nome com tamanho 30
	(Mais 1 para o caractere nulo) mais um inteiro que contém o número de telefone do contato.
tLista
	Definição de uma lista, contendo um vetor que armazena 100 dados do tipo tAgenda, além de um inteiro
	que indica a posição do último elemento na lista.

*/
#ifndef LISTA_H_
#define LISTA_H_

#define MAXELEMENTOS 100
#define MAXNOME 31
#define LISTAVAZIA -1
#define ERRO_LISTA_CHEIA -1
#define ERRO_LISTA_VAZIA -2
#define ERRO_POSICAO_INVALIDA -3

typedef struct {
	char *nome;
	double valor;
} tLancamento;

typedef struct {
	tLancamento elem[MAXELEMENTOS];
	int ultimo;
} tListaContabil;

tListaContabil debitos, creditos;
char buffer[10000];

int vagarPosicao(tListaContabil *lista, int posicao);
int adiciona(tListaContabil *lista, tLancamento dado);
int adicionaNoInicio(tListaContabil *lista, tLancamento dado);
int adicionaNaPosicao(tListaContabil *lista, tLancamento dado, int posicao);
int adicionaEmOrdem(tListaContabil *lista, tLancamento dado);
int retira(tListaContabil *lista);
int retiraDoInicio(tListaContabil *lista);
int retiraDaPosicao(tListaContabil *lista, int posicao);
int listaCheia(tListaContabil *lista);
int listaVazia(tListaContabil *lista);
int posicaoExistente(tListaContabil *lista, int posicao);
int contem(tListaContabil *lista, tLancamento dado);
int igual(tLancamento dado1, tLancamento dado2);
int maior(tLancamento dado1, tLancamento dado2);
int menor(tLancamento dado1, tLancamento dado2);
tLancamento obter(tListaContabil *lista);
tLancamento obterDoInicio(tListaContabil *lista);
tLancamento obterDaPosicao(tListaContabil *lista, int posicao);
tLancamento obterLancamentoPeloNome(tListaContabil *lista, char* nome);
void inicializlista(tListaContabil *lista);
void destroiLista(tListaContabil *lista);

#endif /* LISTA_H_ */
