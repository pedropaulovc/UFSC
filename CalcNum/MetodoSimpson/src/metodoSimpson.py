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
	print 'h = ', h
	extremos = f(func, inicio) + f(func, fim)


	partes2 = int(partes / 2)
	h2 = h + h
	c = inicio + h
	print 'Range par ', 1, partes2 - 1
	print 'Ponto soma par ', inicio + h
	print 'Valor ', f(func, c)
	sp = f(func, c)
	for _ in range(1, partes2):
		c += h2
		sp += f(func, c)
		print 'Ponto soma par ', c
		print 'Valor ', f(func, c)

	si = 0.0
	c = inicio
	print 'Range impar ', 1, partes2 - 1
	for _ in range(1, partes2):
		c += h2
		si += f(func, c)
		print 'Ponto soma impar ', c
		print 'Valor ', f(func, c)

	return (h / 3) * (extremos + 4 * sp + 2 * si)



