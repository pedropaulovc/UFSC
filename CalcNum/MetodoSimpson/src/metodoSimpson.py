#encoding=utf-8
'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from math import *

def f(func, x):
	'''Calcula o valor de func no ponto x'''
	return float(eval(func))

def buscarValorF(func, x, pontosF):
	''' 
	Caso o valor de func(x) já esteja armazenado em pontosF, reaproveitar,
	se não, calcular e salvar em pontosF
	'''
	if (x in pontosF):
		return pontosF[x]
	novoPonto = f(func, x)
	pontosF[x] = novoPonto
	return novoPonto


def integrarSimpson(func, inicio, fim, partes):
	''' 
	Integra 'func' de 'inicio' até 'fim', dividindo o intervalo em 'partes' partes.
	Instável.
	'''
	inicio = float(inicio)
	fim = float(fim)
	if(partes % 2 != 0):
		print 'Número de partes não é par'
		return
	
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

def integrarSimpsonModificado(func, inicio, fim, partes, pontosF):
	''' 
	Integra 'func' de 'inicio' até 'fim', dividindo o intervalo em 'partes' partes.
	Reaproveita pontos já calculados. Instável.
	'''
	if(partes % 2 != 0):
		print 'Número de partes não é par'
		return
		
	inicio = float(inicio)
	fim = float(fim)

	h = (fim - inicio) / partes
	extremos = buscarValorF(func, inicio, pontosF) + buscarValorF(func, fim, pontosF)

	partes2 = int(partes / 2)
	h2 = h + h
	c = inicio + h
	somaPares = buscarValorF(func, c, pontosF)
	for _ in range(1, partes2):
		c += h2
		somaPares += buscarValorF(func, c, pontosF)

	somaImpares = 0.0
	c = inicio
	for _ in range(1, partes2):
		c += h2
		somaImpares += buscarValorF(func, c, pontosF)

	return (h / 3) * (extremos + 4 * somaPares + 2 * somaImpares)

def simpsonComposto(func, inicio, fim, precisao, partes):
	''' 
	Integra usando o método de Simpson composto até 'precisao' desejada. 
	Estável.
	'''
	intAnterior = integrarSimpson(func, inicio, fim, partes)
	erro = 10 * precisao
	passo = (fim - inicio) / 2
	k = 2

	while(erro > precisao):
		c = inicio
		int = 0

		for _ in range(k):
			d = c + passo
			int += integrarSimpson(func, c, d, partes)
			c = d
			num = abs(int - intAnterior)
			if(num == 0):
				erro = 0
			else:
				erro = num / max(abs(int), abs(intAnterior))
		intAnterior = int
		passo /= 2
		k = k + k

	return int

def simpsonCompostoModificado(func, inicio, fim, precisao, partes):
	''' 
	Integra usando o método de Simpson composto até 'precisao' desejada. 
	Reaproveita pontos já calculados. Estável. Aproximadamente 2X mais rápido que simpsonComposto
	'''
	pontosF = dict()

	int = integrarSimpsonModificado(func, inicio, fim, partes, pontosF)
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
			intParcial = integrarSimpsonModificado(func, c, d, partes, pontosF)
			int += intParcial
			c = d
			num = abs(int - intAnterior)
			if(num == 0):
				erro = 0
			else:
				erro = num / max(abs(int), abs(intAnterior))
		intAnterior = int
		passo /= 2
		k = k + k
		numIteracoes += 1

	return int
