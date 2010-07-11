/**
 TÍTULO:        Implementação buscador textual usando listas invertidas
 ALUNOS:        Pedro Paulo Vezzá Campos - 09132033 e Felipe dos Santos Silveira - 09132014
 MATÉRIA:       INE5408
 PRAZO:         12 de julho de 2010

 PROPÓSITO:
 Este programa é uma implementação do enunciado do projeto de implementação II, um buscador textual
 utilizando arquivos invertidos.

 SOBRE ESSE ARQUIVO:
 Descrição da interface de uma portaria, contendo os métodos e atributos necessários. Uma portaria é
 composta de um nome único, uma localização no arquivo de dados e seu texto completo.
*/
#ifndef PORTARIA_H_
#define PORTARIA_H_

#include <string>

using namespace std;

class Portaria {
private:
	string nome;
	string texto;
	int posicaoArquivo;

public:
	Portaria(string nome, string texto, int posicaoArquivo);
	Portaria();
	virtual ~Portaria();

	string obterNome() const;
	string obterTexto() const;
	int obterPosicaoArquivo() const;

	bool operator>(Portaria& outro) const;
	bool operator<=(Portaria& outro) const;
	bool operator<(Portaria& outro) const;
	bool operator!=(Portaria& outro) const;
	bool operator==(Portaria& outro) const;

};

#endif /* PORTARIA_H_ */
