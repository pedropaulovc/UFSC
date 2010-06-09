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
	arvore_b = arvore_b->insere(4);
	arvore_b = arvore_b->insere(10);


	ASSERT_EQ(6, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0, arvore_b->retornaAltura());
	ASSERT_EQ("2 3 4 5 9 10", arvore_b->retornaInfixada());
}
