#include "arvore_avl.h"
#include <gtest/gtest.h>
#include <iostream>

class TestesRotacaoAVL : public ::testing::Test {

protected:

	NodoAVL<int>* arvore_avl;

	void SetUp(){
		arvore_avl = new NodoAVL<int>();
	}

	void TearDown(){
		delete arvore_avl;
	}
};


TEST_F(TestesRotacaoAVL, testeInsercoesDireita){
	arvore_avl = arvore_avl->insere(10);
	arvore_avl = arvore_avl->insere(20);
	ASSERT_EQ(std::string("10 20 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(2,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeInsercoesEsquerda){
	arvore_avl = arvore_avl->insere(20);
	arvore_avl = arvore_avl->insere(10);
	ASSERT_EQ(std::string("10 20 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(2,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeInsercoesAmbosLados){
	arvore_avl = arvore_avl->insere(20);
	arvore_avl = arvore_avl->insere(30);
	arvore_avl = arvore_avl->insere(10);
	ASSERT_EQ(std::string("10 20 30 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(3,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeRotacaoEsquerda){
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(40);
	arvore_avl = arvore_avl->insere(30);
	ASSERT_EQ(std::string("30 40 50 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(3,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeRotacaoDireita){
	arvore_avl = arvore_avl->insere(30);
	arvore_avl = arvore_avl->insere(40);
	arvore_avl = arvore_avl->insere(50);
	ASSERT_EQ(std::string("30 40 50 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(3,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeRotacaoDuplaEsquerda){
	arvore_avl = arvore_avl->insere(40);
	arvore_avl = arvore_avl->insere(30);
	arvore_avl = arvore_avl->insere(35);
	ASSERT_EQ(std::string("30 35 40 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(3,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeRotacaoDuplaDireita){
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(60);
	arvore_avl = arvore_avl->insere(55);
	ASSERT_EQ(std::string("50 55 60 "), arvore_avl->retornaInfixada());
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	ASSERT_EQ(3,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeAlturaGrande){
	arvore_avl = arvore_avl->insere(50);
	ASSERT_EQ(0,arvore_avl->retornaAltura());
	arvore_avl = arvore_avl->insere(60);
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	arvore_avl = arvore_avl->insere(40);
	ASSERT_EQ(1,arvore_avl->retornaAltura());
	arvore_avl = arvore_avl->insere(30);
	ASSERT_EQ(2,arvore_avl->retornaAltura());
	ASSERT_EQ(4,arvore_avl->retornaNumeroDeElementos());
}

TEST_F(TestesRotacaoAVL, testeRotacaoEsquerdaArvoreCheia){
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(30);
	arvore_avl = arvore_avl->insere(60);
	arvore_avl = arvore_avl->insere(20);
	arvore_avl = arvore_avl->insere(35);
	arvore_avl = arvore_avl->insere(34);
	ASSERT_EQ(2,arvore_avl->retornaAltura());
	ASSERT_EQ(6,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(std::string("20 30 34 35 50 60 "), arvore_avl->retornaInfixada());
}
