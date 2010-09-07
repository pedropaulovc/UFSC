/*
 * TestesDigrafo.cpp
 *
 *  Created on: Sep 3, 2010
 *      Author: pedropaulo
 */

#include <gtest/gtest.h>
#include "Digrafo.h"
#include <cstdlib>
#include <string>
#include <list>
#include <iostream>

using namespace std;

class TestesDigrafo: public ::testing::Test {

protected:
	Digrafo<string> *digrafo;

	TestesDigrafo() {
	}

	~TestesDigrafo() {
	}

	void SetUp() {
		digrafo = new Digrafo<string> ();
	}

	void TearDown() {
		delete digrafo;
	}
};

TEST_F(TestesDigrafo, testaDigrafoVazio)
{
	vector<string> vertices = digrafo->obterVertices();
	ASSERT_EQ(0, digrafo->obterOrdem());
	ASSERT_EQ(0, vertices.size());
}

TEST_F(TestesDigrafo, testaInsercaoVertice)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");

	vector<string> v = digrafo->obterVertices();
	ASSERT_EQ(3, v.size());
	ASSERT_EQ("A", v[0]);
	ASSERT_EQ("B", v[1]);
	ASSERT_EQ("C", v[2]);

	ASSERT_EQ(0, digrafo->obterGrauEmissao("A"));
	ASSERT_EQ(0, digrafo->obterGrauEmissao("B"));
	ASSERT_EQ(0, digrafo->obterGrauEmissao("C"));

	ASSERT_EQ(0, digrafo->obterGrauRecepcao("A"));
	ASSERT_EQ(0, digrafo->obterGrauRecepcao("B"));
	ASSERT_EQ(0, digrafo->obterGrauRecepcao("C"));

	ASSERT_EQ(0, digrafo->obterAntecessores("A").size());
	ASSERT_EQ(0, digrafo->obterAntecessores("B").size());
	ASSERT_EQ(0, digrafo->obterAntecessores("C").size());
	ASSERT_EQ(0, digrafo->obterAntecessores("D").size());

	ASSERT_EQ(0, digrafo->obterSucessores("A").size());
	ASSERT_EQ(0, digrafo->obterSucessores("B").size());
	ASSERT_EQ(0, digrafo->obterSucessores("C").size());
	ASSERT_EQ(0, digrafo->obterSucessores("D").size());
}

TEST_F(TestesDigrafo, testaRemocaoVertice)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");

	ASSERT_EQ(3, digrafo->obterVertices().size());

	digrafo->removeVertice("A");
	ASSERT_EQ(2, digrafo->obterVertices().size());
	digrafo->removeVertice("A");
	ASSERT_EQ(2, digrafo->obterVertices().size());
	digrafo->removeVertice("B");
	ASSERT_EQ(1, digrafo->obterVertices().size());
	digrafo->removeVertice("C");
	ASSERT_EQ(0, digrafo->obterVertices().size());
}

TEST_F(TestesDigrafo, testaSucessores)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");
	digrafo->adicionaVertice("D");

	digrafo->conecta("A", "B");
	digrafo->conecta("B", "C");
	digrafo->conecta("A", "D");

	ASSERT_EQ(2, digrafo->obterGrauEmissao("A"));
	ASSERT_EQ("B", digrafo->obterSucessores("A")[0]);
	ASSERT_EQ("D", digrafo->obterSucessores("A")[1]);

	ASSERT_EQ(1, digrafo->obterGrauEmissao("B"));
	ASSERT_EQ("C", digrafo->obterSucessores("B")[0]);

	ASSERT_EQ(0, digrafo->obterGrauEmissao("C"));
	ASSERT_EQ(0, digrafo->obterSucessores("C").size());

	ASSERT_EQ(0, digrafo->obterGrauEmissao("D"));
	ASSERT_EQ(0, digrafo->obterSucessores("D").size());
}

TEST_F(TestesDigrafo, testaAntecessores)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");
	digrafo->adicionaVertice("D");

	digrafo->conecta("A", "B");
	digrafo->conecta("B", "C");
	digrafo->conecta("A", "D");
	digrafo->conecta("B", "D");


	ASSERT_EQ(0, digrafo->obterGrauRecepcao("A"));
	ASSERT_EQ(0, digrafo->obterAntecessores("A").size());

	ASSERT_EQ(1, digrafo->obterGrauRecepcao("B"));
	ASSERT_EQ(1, digrafo->obterAntecessores("B").size());
	ASSERT_EQ("A", digrafo->obterAntecessores("B")[0]);

	ASSERT_EQ(1, digrafo->obterGrauRecepcao("C"));
	ASSERT_EQ(1, digrafo->obterAntecessores("C").size());
	ASSERT_EQ("B", digrafo->obterAntecessores("C")[0]);

	ASSERT_EQ(2, digrafo->obterGrauRecepcao("D"));
	ASSERT_EQ(2, digrafo->obterAntecessores("D").size());
	ASSERT_EQ("A", digrafo->obterAntecessores("D")[0]);
	ASSERT_EQ("B", digrafo->obterAntecessores("D")[1]);
}

TEST_F(TestesDigrafo, testaDesconectar)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");
	digrafo->adicionaVertice("D");

	digrafo->conecta("A", "B");
	digrafo->conecta("A", "D");
	digrafo->conecta("D", "A");
	digrafo->desconecta("A", "D");

	ASSERT_EQ(1, digrafo->obterSucessores("A").size());
	ASSERT_EQ("B", digrafo->obterSucessores("A")[0]);
	ASSERT_EQ(1, digrafo->obterGrauEmissao("A"));
	ASSERT_EQ(1, digrafo->obterAntecessores("A").size());
	ASSERT_EQ("D", digrafo->obterAntecessores("A")[0]);
	ASSERT_EQ(1, digrafo->obterGrauRecepcao("A"));

	ASSERT_EQ(0, digrafo->obterSucessores("B").size());
	ASSERT_EQ(0, digrafo->obterGrauEmissao("B"));
	ASSERT_EQ(1, digrafo->obterAntecessores("B").size());
	ASSERT_EQ("A", digrafo->obterAntecessores("B")[0]);
	ASSERT_EQ(1, digrafo->obterGrauRecepcao("B"));

	ASSERT_EQ(0, digrafo->obterSucessores("C").size());
	ASSERT_EQ(0, digrafo->obterGrauEmissao("C"));
	ASSERT_EQ(0, digrafo->obterAntecessores("C").size());
	ASSERT_EQ(0, digrafo->obterGrauRecepcao("C"));

	ASSERT_EQ(1, digrafo->obterSucessores("D").size());
	ASSERT_EQ("A", digrafo->obterSucessores("D")[0]);
	ASSERT_EQ(1, digrafo->obterGrauEmissao("D"));
	ASSERT_EQ(0, digrafo->obterAntecessores("D").size());
	ASSERT_EQ(0, digrafo->obterGrauRecepcao("D"));
}

TEST_F(TestesDigrafo, testaVerticeAleatorio)
{
	digrafo->adicionaVertice("A");
	digrafo->adicionaVertice("B");
	digrafo->adicionaVertice("C");
	digrafo->adicionaVertice("D");
	digrafo->adicionaVertice("E");
	digrafo->adicionaVertice("F");
	digrafo->adicionaVertice("G");
	digrafo->adicionaVertice("H");
	digrafo->adicionaVertice("I");
	digrafo->adicionaVertice("J");
	digrafo->adicionaVertice("K");
	digrafo->adicionaVertice("L");

	ASSERT_NE(digrafo->obterVerticeAleatorio(), digrafo->obterVerticeAleatorio());
}
