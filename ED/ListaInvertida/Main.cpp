/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Arquivo main, responsável por instanciar a interface com usuário e delegá-la o trabalho de comunicação
 com o usuário e manipulação do modelo lógico.
*/
#include "Interface/InterfaceUsuario.h"

using namespace std;

int main(int argc, char **argv) {
	InterfaceUsuario *iu = new InterfaceUsuario();
	iu->iniciar();

	return 0;
}

