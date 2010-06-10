#include <gtest/gtest.h>
#include "NodoB.h"

class TestesArvoreB : public ::testing::Test {

protected:

	NodoB<int>* arvore_b;

	void SetUp(){
		arvore_b = new NodoB<int>(3);
	}

	void TearDown(){
		delete arvore_b;
	}
};

TEST_F(TestesArvoreB, testeInsercaoFolhaVazia){
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);

	ASSERT_EQ(4, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0, arvore_b->retornaAltura());
	ASSERT_EQ("2 3 5 9 ", arvore_b->retornaPrefixada());
}

TEST_F(TestesArvoreB, testeInsercaoComDivisaoSimples){
	arvore_b = arvore_b->insere(3);
	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(4);

	ASSERT_EQ(5, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1, arvore_b->retornaAltura());
	ASSERT_EQ("2 3 4 5 9 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeInsercaoComDivisaoDeRamo){
	arvore_b = arvore_b->insere(2);
	arvore_b = arvore_b->insere(3);

	arvore_b = arvore_b->insere(4);

	arvore_b = arvore_b->insere(5);
	arvore_b = arvore_b->insere(9);
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(11);
	arvore_b = arvore_b->insere(12);

//	ASSERT_EQ(8, arvore_b->retornaNumeroDeElementos());
//	ASSERT_EQ(1, arvore_b->retornaAltura());
	ASSERT_EQ("2 3 4 5 9 10 11 12", arvore_b->retornaInfixada());
}
