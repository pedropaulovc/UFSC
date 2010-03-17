//Arquivo: pilha.c
//Nome: Trabalho de implementação: Pilha.
//Alunos: Felipe dos Santos Silveira 09132014 e Pedro Paulo Vezzá Campos 09132033
//Data de Criação: 13/03/2010
//Disciplina: INE5408 - Estruturas de Dados
//Data de Entrega: 15/03/2010
//Função: Declaração das assinaturas das funções,
//		  do tipo Pilha e das constantes

//Constantes:
// ERRO_PILHA_CHEIA é retornado caso é tentado adicionar um elemento quando a pilha já estiver cheia
// ERRO_PILHA_VAZIA é retornado caso é tentado remover um elemento quando a pilha já estiver vazia
// MAXPILHA é o número máximo de elementos na pilha. O índice do último elemento é MAXPILHA - 1
#define ERRO_PILHA_CHEIA -1
#define ERRO_PILHA_VAZIA -2
#define MAXPILHA 30

// Tipo Pilha
// dados é um array com os inteiros que estão na pilha
// topo representa o endereço do último valor da pilha
// topo + 1 é o número total de elementos na pilha
typedef struct {
	int dados[MAXPILHA];
	int topo;
} Pilha;


//Método para iniciar ou limpar a pilha.
//A pilha é iniciada com topo -1 para dizer que
//está vazia.
void limparPilha();

//Retira o elemento do fim da pilha.
//Essa função retira o último elemento que foi
//adicionado na pilha e o retorna.
//Se a pilha estiver vazia, é retornado -1
int desempilha();

//Insere um elemento no fim da pilha.
//Recebe um elemento e o coloca no fim da pilha.
//Se a pilha estiver cheia, retorna -2
int empilha(int dado);

//Mostra os elementos da pilha na forma: Elemento,Posição.
//Se a pilha estiver vazia, informa que está vazia.
void mostraPilha();

