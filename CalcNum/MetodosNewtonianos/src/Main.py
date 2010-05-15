# coding=utf-8
'''
Created on 15/05/2010

@author: PedroPaulo
'''
from newtonianos import newtonGeral, secante, steffensen
from testes import funcoes
from test.test_iterlen import len

def main():
	metodo = 0
	metodos = ['Newton Geral', 'Secante', 'Steffensen', 'Todos']
	while(metodo not in range(len(metodos))):
		print 'Escolha o método que deseja utilizar'
		for i, m in enumerate(metodos):
			print "{0} - {1}".format(i + 1, m)
		metodo = int(raw_input())
		if(metodo not in range(len(metodos))):
			print 'Opção inválida'

	escolhida = -1
	while(escolhida not in range(0, len(funcoes) + 1)):
		print 'Qual função deseja utilizar?'
		print '0 - Função arbitrária'
		for i, func in enumerate(funcoes):
			print '{0} - {1}'.format(i + 1, func[0])
		escolhida = int(raw_input())
		if(escolhida not in range(0, len(funcoes) + 1)):
			print 'Opção inválida'

	if(escolhida == 0):
		func = raw_input('Forneça a função desejada: ')
	else:
		func = funcoes[escolhida - 1][0]

	xk = float(raw_input('Forneça o primeiro valor: '))

	precisao = float('1e-' + raw_input('Forneça a precisão em casas decimais: '));
	if(metodo == 0):
		if(escolhida == 0):
			dfunc = raw_input('Forneça a derivada da função anterior: ')
		else:
			dfunc = funcoes[escolhida - 1][1]

		newtonGeral(func, dfunc, precisao, xk)
	elif(metodo == 1):
		xkAnt = int(raw_input('Forneça o segundo valor: '))
		secante(func, precisao, xk, xkAnt)
	elif(metodo == 2):
		steffensen(func, precisao, xk)
	else:
		print 'Gerar método geral'


if __name__ == '__main__':
	main()
