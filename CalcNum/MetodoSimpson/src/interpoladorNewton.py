#encoding = utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''

def difDiv(n, X, Y):
	D = n * [None]
	dd = n * [None]
	for i in range(n):
		dd[i] = (Y[i + 1] - Y[i]) / (X[i + 1] - X[i])
	D[0] = dd[0]

	for k in range(1, n):
		for i in range(n - k):
			dd[i] = (dd[i + 1] - dd[i]) / (X[i + k + 1] - X[i])
		D[k] = dd[0]
	return D

def newtonDifDiv(n, ponto, X, Y):
	D = difDiv(n, X, Y)
	
	s = Y[0]
	p = 1
	
	for k in range(n):
		p *= (ponto - X[k])
		s += D[k] * p;
	
	return s




