#include "desvio_padrao.h"

double media_aritmetica(double valores[], int num_valores){
	int i;
	double media = 0.0;
	for(i = 0; i < num_valores; i++)
		media += valores[i];
	return media/num_valores;
}

double desvio_padrao(double valores[], int num_valores){
	return sqrt(variancia(valores, num_valores));	
}

double variancia(double valores[], int num_valores){
	double media = media_aritmetica(valores, num_valores);
	double variancia = 0.0;
	double desvio;
	
	int i;
	for(i = 0; i < num_valores; i++){
		desvio = (valores[i] - media);
		variancia += (desvio * desvio);
	}
	
	return variancia/(num_valores - 1);
}
