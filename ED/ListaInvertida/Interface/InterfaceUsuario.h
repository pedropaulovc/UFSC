/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição do interfaceamento com o usuário, contendo métodos e atributos necessários.
*/

#ifndef INTERFACEUSUARIO_H_
#define INTERFACEUSUARIO_H_

#include <iostream>
#include "../Portarias/Portaria.h"
#include "../Portarias/PortariaSerial.h"
#include "../Estruturas/ArvoreBinaria/NodoBinario.h"

using namespace std;

class InterfaceUsuario {
private:
	string caminhoDados;
	string caminhoChavesPrimarias;
	string pastaChavesSecundarias;

	NodoBinario<PortariaSerial> *arvore;
	int numPortarias;

public:
	InterfaceUsuario();
	virtual ~InterfaceUsuario();

	void iniciar();

private:
	void exibeIntroducao();
	void exibeMenu();
	void gerarIndices();
	void buscarChavePrimaria();
	void buscarChaveSecundaria();
	ListaEncadeada<Portaria>* obterBuscaSecundaria();
};

#endif /* INTERFACEUSUARIO_H_ */
