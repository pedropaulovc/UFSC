#include "NodoBinario.h"
#include <iostream>
#include <string>


int main() {
	NodoBinario<string>* arvore = new NodoBinario<string>(NULL, NULL, NULL);
	NodoBinario<string>* arvore2;
	//Tá bugando ainda. Não consigo obter o info. Aparentemente agora está percorrendo a árvore como deve.
	int i = 0;
	arvore2 = arvore->criaArvore("-+/846*2-98", &i);

	std::cout << "Lorem " << *(arvore2->obterInfo()) << " Ipsum";

	return 0;
}
