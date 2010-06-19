/*
 * Quicksort.cpp
 *
 *  Created on: Jun 19, 2010
 *      Author: pedropaulo
 */

#include "Quicksort.h"

template<class T> Quicksort<T>::Quicksort() {
}

template<class T> Quicksort<T>::~Quicksort() {
}

template<class T> void Quicksort<T>::ordenar(T vetor[], int limInf, int limSup){
	int i;
	if(limInf >= limSup)
		return;
	i = particionar(vetor, limInf, limSup);
	ordenar(vetor, limInf, i - 1);
	ordenar(vetor, i + 1, limSup);
}

template<class T> int Quicksort<T>::particionar(T vetor[], int limInf, int limSup){
	T pivo = vetor[limSup];
	T temp;
	int baixo = limInf - 1;

	for(int i = limInf; i < limSup; i++){
		if(vetor[i] <= pivo){
			baixo++;
			temp = vetor[baixo];
			vetor[baixo] = vetor[i];
			vetor[i] = temp;
		}
	}
	vetor[limSup] = vetor[baixo + 1];
	vetor[baixo + 1] = pivo;
	return baixo + 1;
}
