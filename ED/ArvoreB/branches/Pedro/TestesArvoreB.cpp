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
	ASSERT_EQ(6, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ(0, arvore_b->retornaNumeroDeFilhos());
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
	ASSERT_EQ(1, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ(2, arvore_b->retornaNumeroDeFilhos());
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
	ASSERT_EQ(3, arvore_b->retornaNumeroDeFilhos());
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
	ASSERT_EQ(3, arvore_b->retornaNumeroDeFilhos());
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


TEST_F(TestesArvoreB, testeRemocaoEmNodoRaiz){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);

	ASSERT_EQ(3,arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0,arvore_b->retornaAltura());
	ASSERT_EQ("10 20 30 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(20);
	ASSERT_EQ(2,arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0,arvore_b->retornaAltura());
	ASSERT_EQ("10 30 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeMudancaDeRaiz){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);

	arvore_b = arvore_b->remove(30);

	ASSERT_EQ(6, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0, arvore_b->retornaAltura());
	ASSERT_EQ("10 20 40 50 60 70 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoEmNodoFolhaNaoRaiz){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);
	arvore_b = arvore_b->insere(80);

	ASSERT_EQ(8,arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("10 20 30 40 50 60 70 80 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(80);
	ASSERT_EQ(7,arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("10 20 30 40 50 60 70 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoNodoRamoPredecessorEmCondicoes){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);
	arvore_b = arvore_b->insere(5);

	ASSERT_EQ(8, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("5 10 20 30 40 50 60 70 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(40);

	ASSERT_EQ(7, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("5 10 20 30 50 60 70 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoNodoRamoSucessorEmCondicoes){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);
	arvore_b = arvore_b->insere(80);

	ASSERT_EQ(8, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("10 20 30 40 50 60 70 80 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(40);

	ASSERT_EQ(7, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ("10 20 30 50 60 70 80 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoComUnderflowAEsquerda){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);

	ASSERT_EQ(7, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ(1, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ("10 20 30 40 50 60 70 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(30);

	ASSERT_EQ(6, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0,arvore_b->retornaAltura());
	ASSERT_EQ(6, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ("10 20 40 50 60 70 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoComUnderflowADireita){
	arvore_b = arvore_b->insere(10);
	arvore_b = arvore_b->insere(20);
	arvore_b = arvore_b->insere(30);
	arvore_b = arvore_b->insere(40);
	arvore_b = arvore_b->insere(50);
	arvore_b = arvore_b->insere(60);
	arvore_b = arvore_b->insere(70);

	ASSERT_EQ(7, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(1,arvore_b->retornaAltura());
	ASSERT_EQ(1, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ("10 20 30 40 50 60 70 ", arvore_b->retornaInfixada());

	arvore_b = arvore_b->remove(70);

	ASSERT_EQ(6, arvore_b->retornaNumeroDeElementos());
	ASSERT_EQ(0,arvore_b->retornaAltura());
	ASSERT_EQ(6, arvore_b->retornaNumeroDeChaves());
	ASSERT_EQ("10 20 30 40 50 60 ", arvore_b->retornaInfixada());
}

TEST_F(TestesArvoreB, testeRemocaoComUnderflowSeguido){

}
