#include "NodoBinario.h"
#include <iostream>
#include <string>


int main() {
	NodoBinario<string>* arvore = new NodoBinario<string>(NULL, NULL, NULL);
	//Tá bugando ainda. Ele não volta corretamente na árvore.
	arvore = arvore->criaArvore("-+/846*2-98");

	std::cout << "Lorem " << *(arvore->obterInfo()) << " Ipsum";

	return 0;
}
