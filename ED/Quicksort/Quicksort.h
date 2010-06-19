/*
 * Quicksort.h
 *
 *  Created on: Jun 19, 2010
 *      Author: pedropaulo
 */

#ifndef QUICKSORT_H_
#define QUICKSORT_H_

template<class T>
class Quicksort {
public:
	static void ordenar(T vetor[], int limInf, int limSup);

private:
	Quicksort();
	virtual ~Quicksort();
	static int particionar(T vetor[], int limInf, int limSup);
};

#include "Quicksort.ipp"

#endif /* QUICKSORT_H_ */
