#encoding=utf-8
'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from math import *

def f(func, x):
	return float(eval(func))


def integrarSimpson(func, inicio, fim, partes):
	inicio = float(inicio)
	fim = float(fim)


	h = (fim - inicio) / partes
	extremos = f(func, inicio) + f(func, fim)


	partes2 = int(partes / 2)
	h2 = h + h
	c = inicio + h
	somaPares = f(func, c)
	for _ in range(1, partes2):
		c += h2
		somaPares += f(func, c)

	somaImpares = 0.0
	c = inicio
	for _ in range(1, partes2):
		c += h2
		somaImpares += f(func, c)

	return (h / 3) * (extremos + 4 * somaPares + 2 * somaImpares)

def simpsonComposto(func, inicio, fim, precisao, partes):
	int = integrarSimpson(func, inicio, fim, partes)
	intAnterior = int
	erro = 10 * precisao
	passo = (fim - inicio) / 2
	k = 2

	numIteracoes = 1
	while(erro > precisao):
		c = inicio
		int = 0

		for _ in range(k):
			d = c + passo
			intParcial = integrarSimpson(func, c, d, partes)
			int += intParcial
			c = d
		erro = abs(int - intAnterior) / max(abs(int), abs(intAnterior))
		intAnterior = int
		passo /= 2
		k = k + k
		numIteracoes += 1

	return int
