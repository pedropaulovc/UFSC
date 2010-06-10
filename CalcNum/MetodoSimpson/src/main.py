#encoding=utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from metodoSimpson import *

def main():
	precisao = precisaoMaquina()

	print simpsonComposto('sqrt(x)', 1.0, 2.0, precisao, 2.0)


def precisaoMaquina():
	a = 1.0
	b = 1.0

	while (a + b != a):
		b = b / 2

	return b

if __name__ == '__main__':
	main()
