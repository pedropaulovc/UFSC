/*
 * meus_testes_cep.cpp
 *
 *  Created on: Jun 4, 2010
 *      Author: pedropaulo
 */

#include <gtest/gtest.h>
#include <iostream>
#include "Cep.h"
#include "Estruturas/ListaEncadeada.h"

class TestesCep : public ::testing::Test {
protected:

	Cep cep1, cep2, cep3;

	void SetUp(){
		cep1 = *(new Cep("00000000", "Rua A"));
		cep2 = *(new Cep("98239858", "Rua B"));
		cep3 = *(new Cep("98239858", "Rua B"));
	}

	void TearDown(){
	}
};


TEST_F(TestesCep, testeComparadores){
	ASSERT_TRUE(cep2 > cep1);
	ASSERT_FALSE(cep2 < cep1);
	ASSERT_TRUE(cep1 < cep2);
	ASSERT_FALSE(cep1 > cep2);
	ASSERT_TRUE(cep1 != cep2);
	ASSERT_FALSE(cep1 == cep2);
	ASSERT_TRUE(cep3 == cep2);
	ASSERT_TRUE(cep2 == cep3);
	ASSERT_FALSE(cep3 != cep2);
	ASSERT_FALSE(cep2 != cep3);
}


TEST_F(TestesCep, testeArquivoCeps){
	ListaEncadeada<Cep>* ceps = Cep::lerArquivoCeps("dados.txt");

	ASSERT_EQ(3, ceps->obterTamanho());
	ASSERT_TRUE(*(new Cep("09238123", "asddom")) == *(ceps->obterDaPosicao(1)));
	ASSERT_TRUE(*(new Cep("1413412", "sdad")) == *(ceps->obterDaPosicao(2)));
	ASSERT_TRUE(*(new Cep("123", "cidade")) == *(ceps->obterDaPosicao(3)));
}
