# coding=utf-8
'''
Created on 15/05/2010

@author: PedroPaulo
'''
from newtonianos import *

def main():
	metodo = 0
	while(metodo > 3 or metodo < 1):
		print "Escolha o método que deseja utilizar"
		print "1 - Newton Geral"
		print "2 - Secante"
		print "3 - Steffensen"
		metodo = int(raw_input())
		if(metodo > 3 or metodo < 1):
			print "Opção inválida"

	func = raw_input("Forneça a função desejada: ")

	xk = int(raw_input("Forneça o primeiro valor"))

	if(metodo == 1):
		dfunc = raw_input("Forneça a derivada da função anterior: ")
		newtonGeral(func, dfunc, xk)
	elif(metodo == 2):
		xkPost = int(raw_input("Forneça o segundo valor"))
		secante(func, xk, xkPost)
	else:
		steffensen(func, xk)


if __name__ == "__main__":
	main()
