//Autor: Thiago Coelho Prado / coeio@inf.ufsc.br
//Data: 20/05/2010
//Testes baseado usando applet interativo do http://www.site.uottawa.ca/~stan/csi2514/applets/avl/BT.html
//Dependencias: googletest -> http://code.google.com/p/googletest/
//Compila��o: g++ arvore_avl_teste.cpp -lgtest -lpthread

#include "arvore_avl.h"
#include <gtest/gtest.h>

class ArvoreAVLTest : public ::testing::Test {

protected:
	NodoAVL<int> *arvore_avl;

	ArvoreAVLTest() {
	}

	~ArvoreAVLTest() {
	}

	void SetUp() {
		arvore_avl = new NodoAVL<int>();
		arvore_avl = arvore_avl->insere(9);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(19);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(40);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(18);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(63);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(12);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(85);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(96);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(1);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(68);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(54);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(58);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(17);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(87);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(70);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(44);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(99);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(34);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(88);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(76);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(7);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(37);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(45);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(3);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
		arvore_avl = arvore_avl->insere(61);
		//std::cout << arvore_avl->retornaAltura() << std::endl;
	}

	void TearDown() {
		delete arvore_avl;
	}
};

// Saida Prefixada
TEST_F(ArvoreAVLTest, testaSaidaPrefixada) {
	std::string prefixado("63 19 12 7 1 3 9 18 17 40 34 37 54 44 45 58 61 85 70 68 76 96 87 88 99 ");
	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(prefixado,arvore_avl->retornaPrefixada());
}

/*
// Saida Prefixada Apos Remocao Cinco Elementos
TEST_F(ArvoreAVLTest, testaSaidaPrefixadaAposRemoverElementos) {
	std::string prefixado("61 19 9 3 1 7 17 44 37 34 54 45 58 85 70 68 76 96 88 99");
	ASSERT_EQ(6,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl->remove(40);
	arvore_avl->remove(12);
	arvore_avl->remove(63);
	arvore_avl->remove(87);
	arvore_avl->remove(18);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(20,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(prefixado,arvore_avl->retornaPrefixada());
}*/

// Saida Prefixada Apos Inserir Alguns Elementos
TEST_F(ArvoreAVLTest, testaSaidaPrefixadaAposInserirNovosElementos) {
	std::string prefixado("54 19 12 7 1 3 9 18 17 40 34 37 45 44 53 50 63 61 58 57 59 62 85 70 68 76 96 87 88 99 ");
	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl = arvore_avl->insere(62);
	arvore_avl = arvore_avl->insere(53);
	arvore_avl = arvore_avl->insere(57);
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(59);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(30,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(prefixado,arvore_avl->retornaPrefixada());
}

// Saida Posfixada
TEST_F(ArvoreAVLTest, testaSaidaPosfixada) {
	std::string posfixado("3 1 9 7 17 18 12 37 34 45 44 61 58 54 40 19 68 76 70 88 87 99 96 85 63 ");
	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(posfixado,arvore_avl->retornaPosfixada());
}

/*// Saida Posfixada Apos Remocao de Alguns Elementos
TEST_F(ArvoreAVLTest, testaSaidaPosfixadaAposRemoverElementos) {
	std::string posfixado("1 7 3 17 9 34 37 45 58 54 44 19 68 76 70 88 99 96 85 61");
	ASSERT_EQ(6,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl->remove(40);
	arvore_avl->remove(12);
	arvore_avl->remove(63);
	arvore_avl->remove(87);
	arvore_avl->remove(18);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(20,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(posfixado,arvore_avl->retornaPosfixada());
}*/

// Saida Posfixada Apos Inserir Alguns Elementos
TEST_F(ArvoreAVLTest, testaSaidaPosfixadaAposInserirNovosElementos) {
	//FIXME erro de digitação: o 96 estava como 86
	std::string posfixado("3 1 9 7 17 18 12 37 34 44 50 53 45 40 19 57 59 58 62 61 68 76 70 88 87 99 96 85 63 54 ");
	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl = arvore_avl->insere(62);
	arvore_avl = arvore_avl->insere(53);
	arvore_avl = arvore_avl->insere(57);
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(59);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(30,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(posfixado,arvore_avl->retornaPosfixada());
}

// Saida Infixada
TEST_F(ArvoreAVLTest, testaSaidaInfixada) {
	std::string infixado("1 3 7 9 12 17 18 19 34 37 40 44 45 54 58 61 63 68 70 76 85 87 88 96 99 ");
	//TODO: Executei testes e obtive que as inserções geram uma árvore de altura 5
	// Um nodo sem filhos tem altura zero?
	ASSERT_EQ(5,arvore_avl->retornaAltura()); //Mudei o teste para 5
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(infixado,arvore_avl->retornaInfixada());
}

/*// Saida Infixada Apos Remocao de Cinco Elementos
TEST_F(ArvoreAVLTest, testaSaidaInfixadaAposRemoverElementos) {
	std::string infixado("1 3 7 9 17 19 34 37 44 45 54 58 61 68 70 76 85 88 96 99");

	ASSERT_EQ(6,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl->remove(40);
	arvore_avl->remove(12);
	arvore_avl->remove(63);
	arvore_avl->remove(87);
	arvore_avl->remove(18);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(20,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(infixado,arvore_avl->retornaInfixada());
}*/

// Saida Infixada Apos Inserir Alguns Elementos
TEST_F(ArvoreAVLTest, testaSaidaInfixadaAposInserirNovosElementos) {
	//TODO mesma coisa que o teste anterior
	std::string infixado("1 3 7 9 12 17 18 19 34 37 40 44 45 50 53 54 57 58 59 61 62 63 68 70 76 85 87 88 96 99 ");
	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(25,arvore_avl->retornaNumeroDeElementos());

	arvore_avl = arvore_avl->insere(62);
	arvore_avl = arvore_avl->insere(53);
	arvore_avl = arvore_avl->insere(57);
	arvore_avl = arvore_avl->insere(50);
	arvore_avl = arvore_avl->insere(59);

	ASSERT_EQ(5,arvore_avl->retornaAltura());
	ASSERT_EQ(30,arvore_avl->retornaNumeroDeElementos());
	ASSERT_EQ(infixado,arvore_avl->retornaInfixada());
}
