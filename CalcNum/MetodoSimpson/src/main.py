#encoding=utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from metodoSimpson import *
from time import time

def main():
	tempo0 = time()
	
	int1 = integrarSimpson('sqrt(x) ', 1.0, 2.0, 4.0)
	print 'Com 4 partes: ', int1
	int2 = integrarSimpson('sqrt(x) ', 1.0, 2.0, 8.0)
	print 'Com 8 partes: ', int2
	
	erro = abs(int1 - int2)/max(abs(int1), abs(int2))
	i = 8.0
	while (erro > 10**-10):
		int1 = int2
		i *= 2
		int2 = integrarSimpson('sqrt(x) ', 1.0, 2.0, i)
		erro = abs(int1 - int2)/max(abs(int1), abs(int2))
	print int2, ' num partes: ', i
	
	tempo1 = time()
	print '\n', simpsonComposto('sqrt(x) ', 1.0, 2.0, 10**-10 , 4.0)
	tempo2 = time()
	print simpsonCompostoModificado('sqrt(x)', 1.0, 2.0, 10**-10 , 8.0)
	tempo3 = time()
	
	print 'Tempo simples = ', tempo1 - tempo0
	print 'Tempo composto normal = ', tempo2 - tempo1
	print 'Tempo composto modificado = ', tempo3 - tempo2


def precisaoMaquina():
	a = 1.0
	b = 1.0

	while (a + b != a):
		b = b / 2

	return b

if __name__ == '__main__':
	main()
