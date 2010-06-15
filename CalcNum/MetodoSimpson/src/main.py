#encoding=utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from metodoSimpson import *
from time import time
from testes import funcoes

def main():
	while(True):
		metodo = -1
		metodos = ['Simpson simples', 'Simpson composto', 'Todos']
		while(metodo not in range(len(metodos))):
			print 'Escolha o método que deseja utilizar'
			for i, m in enumerate(metodos):
				print "{0} - {1}".format(i + 1, m)
			metodo = int(raw_input()) - 1
			if(metodo not in range(len(metodos))):
				print 'Opção inválida'

		escolhida = -1
		while(escolhida not in range(0, len(funcoes) + 1)):
			print 'Qual função deseja utilizar?'
			print '0 - Função arbitrária'
			for i, func in enumerate(funcoes):
				print '{0} - {1}'.format(i + 1, func)
			escolhida = int(raw_input())
			if(escolhida not in range(0, len(funcoes) + 1)):
				print 'Opção inválida'

		if(escolhida == 0):
			func = raw_input('Forneça a função desejada: ')
		else:
			func = funcoes[escolhida - 1]

		inicio = float(raw_input('Forneça limite inferior de integração: '))
		fim = float(raw_input('Forneça limite superior de integração: '))

		if(metodo == 0):
			partes = float(raw_input('Forneça o número (par) de quebras: '))

			print 'Integral = ', integrarSimpson(func, inicio, fim, partes)
		elif(metodo == 1):
			precisao = float('1e-' + raw_input('Forneça a precisão em casas decimais: '));

			print 'Integral = ', simpsonComposto(func, inicio, fim, precisao, 4.0)
		else:
			partes = float(raw_input('Forneça o número (par) de quebras: '))
			precisao = float('1e-' + raw_input('Forneça a precisão em casas decimais: '));

			print 'IntegralSimples = ', integrarSimpson(func, inicio, fim, partes)
			print 'IntegralComposta = ', simpsonComposto(func, inicio, fim, precisao, 4.0)

if __name__ == '__main__':
	main()
