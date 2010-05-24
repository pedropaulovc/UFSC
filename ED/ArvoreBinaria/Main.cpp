#include "NodoBinario.h"
#include <iostream>
#include <string>
#include <list>


int main() {
	//Tá bugando ainda. Não consigo obter o info. Aparentemente agora está percorrendo a árvore como deve.
	NodoBinario<char>* arvore = new NodoBinario<char>("-+/846*2-98");

	std::list<char>* lista = new list<char>();
	arvore->percorreEmOrdemRecursivo(lista);
	return 0;
}
