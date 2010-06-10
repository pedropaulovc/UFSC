#encoding=utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from metodoSimpson import *
from time import time

def main():

	print integrarSimpson('sqrt(x) ', 1.0, 2.0, 8.0)
	print integrarSimpson('sqrt(x) ', 2.0, 1.0, 8.0)

	tempo1 = time()
	simpsonComposto('sqrt(x) ', 1.0, 2.0, 10**-10 , 2.0)
	tempo2 = time()
	simpsonCompostoModificado('sqrt(x)', 1.0, 2.0, 10**-10 , 2.0)
	tempo3 = time()
	
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
