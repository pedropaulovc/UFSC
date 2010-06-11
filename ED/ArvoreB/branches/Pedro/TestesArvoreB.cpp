#include <gtest/gtest.h>
#include "NodoB.h"

class TestesArvoreB: public ::testing::Test {

protected:

	NodoB<int>* arvore_b;

	void SetUp() {
		arvore_b = new NodoB<int> (3);
	}

	void TearDown() {
		delete arvore_b;
	}
};

TEST_F(TestesArvoreB, testeInsercaoFolhaVazia)
{
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(4);
	arvore_b = arvore_b->insere(11);

	ASSERT_EQ(6, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0, arvore_b->retornaAltura());
	ASSERT_EQ("2 3 4 5 9 11 ", arvore_b->retornaPrefixada());
	ASSERT_EQ("2 3 4 5 9 11 ", arvore_b->retornaInfixada());
	ASSERT_EQ("2 3 4 5 9 11 ", arvore_b->retornaPosfixada());
}

TEST_F(TestesArvoreB, testeDivisaoRaiz)
{
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(4);
	arvore_b = arvore_b->insere(11);
	arvore_b = arvore_b->insere(1);

	ASSERT_EQ(7, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1, arvore_b->retornaAltura());
	ASSERT_EQ("4 1 2 3 5 9 11 ", arvore_b->retornaPrefixada());
	ASSERT_EQ("1 2 3 4 5 9 11 ", arvore_b->retornaInfixada());
	ASSERT_EQ("1 2 3 5 9 11 4 ", arvore_b->retornaPosfixada());
}

TEST_F(TestesArvoreB, testeDivisaoNodoFilhoADireita)
{
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(4);
	arvore_b = arvore_b->insere(11);
	arvore_b = arvore_b->insere(1);
	arvore_b = arvore_b->insere(12);
	arvore_b = arvore_b->insere(13);
	arvore_b = arvore_b->insere(14);
	arvore_b = arvore_b->insere(15);

	ASSERT_EQ(11, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1, arvore_b->retornaAltura());
	ASSERT_EQ("4 1 2 3 5 9 11 12 13 14 15 ", arvore_b->retornaPrefixada());
	ASSERT_EQ("1 2 3 4 5 9 11 12 13 14 15 ", arvore_b->retornaInfixada());
	ASSERT_EQ("1 2 3 5 9 11 4 13 14 15 12 ", arvore_b->retornaPosfixada());
}

TEST_F(TestesArvoreB, testeDivisaoNodoFilhoAEsquerda)
{
	arvore_b = arvore_b->insere(15);
	arvore_b = arvore_b->insere(14);
	arvore_b = arvore_b->insere(13);
	arvore_b = arvore_b->insere(12);
	arvore_b = arvore_b->insere(11);
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(8);
	arvore_b = arvore_b->insere(7);
	arvore_b = arvore_b->insere(6);
	arvore_b = arvore_b->insere(5);

	ASSERT_EQ(11, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1, arvore_b->retornaAltura());
	ASSERT_EQ("8 5 6 7 9 10 11 12 13 14 15 ", arvore_b->retornaPrefixada());
	ASSERT_EQ("5 6 7 8 9 10 11 12 13 14 15 ", arvore_b->retornaInfixada());
	ASSERT_EQ("5 6 7 9 10 11 8 13 14 15 12 ", arvore_b->retornaPosfixada());
}

TEST_F(TestesArvoreB, testeDivisaoNodoInternoERaiz)
{
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(4);
	arvore_b = arvore_b->insere(11);
	arvore_b = arvore_b->insere(1);//Divisão na raiz, aumento altura
	arvore_b = arvore_b->insere(12);
	arvore_b = arvore_b->insere(13);
	arvore_b = arvore_b->insere(14);
	arvore_b = arvore_b->insere(15);//Divisão no filho da direita
	arvore_b = arvore_b->insere(16);
	arvore_b = arvore_b->insere(17);
	arvore_b = arvore_b->insere(18);
	arvore_b = arvore_b->insere(19);//Divisão no filho da direita
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(21);
	arvore_b = arvore_b->insere(22);
	arvore_b = arvore_b->insere(23);//Divisão no filho da direita
	arvore_b = arvore_b->insere(24);
	arvore_b = arvore_b->insere(25);
	arvore_b = arvore_b->insere(26);
	arvore_b = arvore_b->insere(27);//Divisão no filho da direita
	arvore_b = arvore_b->insere(28);
	arvore_b = arvore_b->insere(29);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(31);//Divisão no filho da direita
	arvore_b = arvore_b->insere(32);
	arvore_b = arvore_b->insere(33);
	arvore_b = arvore_b->insere(34);
	arvore_b = arvore_b->insere(35);//Divisão no filho da direita e raiz, aumento altura

	ASSERT_EQ(31, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(2, arvore_b->retornaAltura());
	ASSERT_EQ("20 4 1 2 3 5 9 11 12 13 14 15 16 17 18 19 24 21 22 23 25 26 27 28 29 30 31 32 33 34 35 ", arvore_b->retornaPrefixada());
	ASSERT_EQ("1 2 3 4 5 9 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 ", arvore_b->retornaInfixada());
	ASSERT_EQ("1 2 3 5 9 11 4 13 14 15 12 17 18 19 16 21 22 23 25 26 27 24 29 30 31 28 33 34 35 32 20 ", arvore_b->retornaPosfixada());
}
