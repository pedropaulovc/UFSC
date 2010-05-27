#include "NodoOperacao.h"
#include <iostream>
#include <string>
#include <list>


int main() {
	int i = 0;
	NodoOperacao* arvore = new NodoOperacao("-+/846*2-98", &i);

	list<char*>* lista = new list<char*>();
	arvore->percorreEmOrdemRecursivo(lista);

	for(list<char*>::const_iterator it = lista->begin(); it != lista->end(); ++it)
		std::cout << " " << *it << " ";

	return 0;
}
