/*
 * TestesGrafo.cpp
 *
 *  Created on: Sep 3, 2010
 *      Author: pedropaulo
 */

#include <gtest/gtest.h>
#include "Grafo.h"
#include <cstdlib>
#include <string>
#include <list>
#include <iostream>

using namespace std;

class TestesGrafo: public ::testing::Test {

protected:
	Grafo<string> *grafo;

	TestesGrafo() {
	}

	~TestesGrafo() {
	}

	void SetUp() {
		grafo = new Grafo<string> ();
	}

	void TearDown() {
		delete grafo;
	}
};

TEST_F(TestesGrafo, testaGrafoVazio)
{
	vector<string> vertices = grafo->obterVertices();
	ASSERT_EQ(0, grafo->obterOrdem());
	ASSERT_EQ(0, vertices.size());
}

TEST_F(TestesGrafo, testaInsercaoVertice)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");

	vector<string> v = grafo->obterVertices();
	ASSERT_EQ(3, v.size());
	ASSERT_EQ("A", v[0]);
	ASSERT_EQ("B", v[1]);
	ASSERT_EQ("C", v[2]);

	ASSERT_EQ(0, grafo->obterGrau("A"));
	ASSERT_EQ(0, grafo->obterGrau("B"));
	ASSERT_EQ(0, grafo->obterGrau("C"));

	ASSERT_EQ(0, grafo->obterAdjacentes("A").size());
	ASSERT_EQ(0, grafo->obterAdjacentes("B").size());
	ASSERT_EQ(0, grafo->obterAdjacentes("C").size());
	ASSERT_EQ(0, grafo->obterAdjacentes("D").size());
}

TEST_F(TestesGrafo, testaRemocaoVertice)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");

	ASSERT_EQ(3, grafo->obterVertices().size());

	grafo->removeVertice("A");
	ASSERT_EQ(2, grafo->obterVertices().size());
	grafo->removeVertice("A");
	ASSERT_EQ(2, grafo->obterVertices().size());
	grafo->removeVertice("B");
	ASSERT_EQ(1, grafo->obterVertices().size());
	grafo->removeVertice("C");
	ASSERT_EQ(0, grafo->obterVertices().size());
}

TEST_F(TestesGrafo, testaConexao)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");

	grafo->conecta("A", "B");
	grafo->conecta("A", "D");

	ASSERT_EQ(2, grafo->obterGrau("A"));
	ASSERT_EQ("B", grafo->obterAdjacentes("A")[0]);
	ASSERT_EQ("D", grafo->obterAdjacentes("A")[1]);

	ASSERT_EQ(1, grafo->obterGrau("B"));
	ASSERT_EQ("A", grafo->obterAdjacentes("B")[0]);

	ASSERT_EQ(0, grafo->obterGrau("C"));

	ASSERT_EQ(1, grafo->obterGrau("D"));
	ASSERT_EQ("A", grafo->obterAdjacentes("D")[0]);
}

TEST_F(TestesGrafo, testaDesconectar)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");

	grafo->conecta("A", "B");
	grafo->conecta("A", "D");
	grafo->desconecta("A", "D");

	ASSERT_EQ(1, grafo->obterAdjacentes("A").size());
	ASSERT_EQ("B", grafo->obterAdjacentes("A")[0]);

	ASSERT_EQ(1, grafo->obterAdjacentes("B").size());
	ASSERT_EQ("A", grafo->obterAdjacentes("B")[0]);

	ASSERT_EQ(0, grafo->obterAdjacentes("C").size());

	ASSERT_EQ(0, grafo->obterAdjacentes("D").size());
}

TEST_F(TestesGrafo, testaVerticeAleatorio)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");
	grafo->adicionaVertice("E");
	grafo->adicionaVertice("F");
	grafo->adicionaVertice("G");
	grafo->adicionaVertice("H");
	grafo->adicionaVertice("I");
	grafo->adicionaVertice("J");
	grafo->adicionaVertice("K");
	grafo->adicionaVertice("L");

	ASSERT_NE(grafo->obterVerticeAleatorio(), grafo->obterVerticeAleatorio());
}

TEST_F(TestesGrafo, testaRegular)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");
	grafo->adicionaVertice("E");

	grafo->conecta("A", "B");
	ASSERT_FALSE(grafo->ehRegular());
	grafo->conecta("B", "C");
	ASSERT_FALSE(grafo->ehRegular());
	grafo->conecta("D", "C");
	ASSERT_FALSE(grafo->ehRegular());
	grafo->conecta("D", "E");
	ASSERT_FALSE(grafo->ehRegular());
	grafo->conecta("E", "A");
	ASSERT_TRUE(grafo->ehRegular());
}

TEST_F(TestesGrafo, testaCompleto)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");

	grafo->conecta("A", "B");
	ASSERT_FALSE(grafo->ehCompleto());
	grafo->conecta("A", "C");
	ASSERT_FALSE(grafo->ehCompleto());
	grafo->conecta("A", "D");
	ASSERT_FALSE(grafo->ehCompleto());
	grafo->conecta("B", "C");
	ASSERT_FALSE(grafo->ehCompleto());
	grafo->conecta("B", "D");
	ASSERT_FALSE(grafo->ehCompleto());
	grafo->conecta("C", "D");
	ASSERT_TRUE(grafo->ehCompleto());
}

TEST_F(TestesGrafo, testaFechoTransitivo)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");
	grafo->adicionaVertice("E");
	grafo->adicionaVertice("F");
	grafo->adicionaVertice("G");
	grafo->adicionaVertice("H");

	grafo->conecta("A", "B");
	grafo->conecta("A", "C");
	grafo->conecta("C", "D");
	grafo->conecta("D", "E");
	grafo->conecta("F", "G");

	set<string> fecho = grafo->obterFechoTransitivo("A");
	ASSERT_EQ(5, fecho.size());
	ASSERT_TRUE(fecho.end() != fecho.find("A"));
	ASSERT_TRUE(fecho.end() != fecho.find("B"));
	ASSERT_TRUE(fecho.end() != fecho.find("C"));
	ASSERT_TRUE(fecho.end() != fecho.find("D"));
	ASSERT_TRUE(fecho.end() != fecho.find("E"));
}


TEST_F(TestesGrafo, testaConexo)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");
	grafo->adicionaVertice("E");

	grafo->conecta("A", "B");
	ASSERT_FALSE(grafo->ehConexo());
	grafo->conecta("A", "C");
	ASSERT_FALSE(grafo->ehConexo());
	grafo->conecta("C", "D");
	ASSERT_FALSE(grafo->ehConexo());
	grafo->conecta("C", "E");
	ASSERT_TRUE(grafo->ehConexo());
}

TEST_F(TestesGrafo, testaArvore)
{
	grafo->adicionaVertice("A");
	grafo->adicionaVertice("B");
	grafo->adicionaVertice("C");
	grafo->adicionaVertice("D");
	grafo->adicionaVertice("E");

	grafo->conecta("A", "B");
	ASSERT_FALSE(grafo->ehArvore());
	grafo->conecta("A", "C");
	ASSERT_FALSE(grafo->ehArvore());
	grafo->conecta("C", "D");
	ASSERT_FALSE(grafo->ehArvore());
	grafo->conecta("C", "E");
	ASSERT_TRUE(grafo->ehArvore());
	grafo->conecta("E", "A");
	ASSERT_FALSE(grafo->ehArvore());
}
