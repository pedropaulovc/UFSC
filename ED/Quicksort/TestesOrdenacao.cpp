#include "Quicksort.h"
#include <gtest/gtest.h>
#include <iostream>

class TestesOrdenacao: public ::testing::Test {

protected:

	int vetor[20];

	void SetUp() {
	}

	void TearDown() {
	}
};

TEST_F(TestesOrdenacao, testeVetorOrdenado)
{
	for(int i = 0; i < 20; i++)
		vetor[i] = i;
	Quicksort<int>::ordenar(vetor, 0, 19);
	for(int i = 0; i < 20; i++)
		ASSERT_EQ(i, vetor[i]);
}
TEST_F(TestesOrdenacao, testeVetorOrdenadoReverso)
{
	for(int i = 0; i < 20; i++)
		vetor[i] = 19 - i;
	Quicksort<int>::ordenar(vetor, 0, 19);
	for(int i = 0; i < 20; i++)
		ASSERT_EQ(i, vetor[i]);
}
TEST_F(TestesOrdenacao, testeVetorAleatorio)
{
	int vetor[20] = {57, 99, 100, 40, 16, 85, 66, 56, 65, 70, 72, 82, 23, 5, 80, 41, 95, 48, 43, 15};
	Quicksort<int>::ordenar(vetor, 0, 19);
	int vetorOrdenado[20] = {5, 15, 16, 23, 40, 41, 43, 48, 56, 57, 65, 66, 70, 72, 80, 82, 85, 95, 99, 100};
	for(int i = 0; i < 20; i++)
		ASSERT_EQ(vetorOrdenado[i], vetor[i]);
}
