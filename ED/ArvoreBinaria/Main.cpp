#include "NodoBinario.h"
#include <iostream>
#include <string>
#include <list>


int main() {
	//Tá bugando ainda. Não consigo obter o info. Aparentemente agora está percorrendo a árvore como deve.
	int i = 0;
	NodoBinario<char>* arvore = new NodoBinario<char>("-+/846*2-98", &i);

	std::list<char*>* lista = arvore->percorreEmOrdemRecursivo();

	for(list<char*>::const_iterator it = lista->begin(); it != lista->end(); ++it){
		std::cout << *it << " teste ";
	}

	return 0;
}
