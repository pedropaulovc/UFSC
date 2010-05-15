# coding=utf-8
'''
Createdon15/05/2010

@author:PedroPaulo
'''
def f(func, x):
	return float(eval(func))

def newtonGeral(func, dfunc, precisao, xk):
	den = f(dfunc, xk)

	if(den == 0):
		print 'Divisão por zero na iteração inicial'
		return

	xkPost = xk - f(func, xk) / den
	numIteracoes = 0
	erroV = abs(xkPost - xk) / max(abs(xk), abs(xkPost))
	xk = xkPost

	erroDiminuindo = True
	while(erroDiminuindo):
		numIteracoes += 1
		den = f(dfunc, xk);
		if(den == 0):
			print 'Divisão por zero'
			return


		xkPost = xk - f(func, xk) / den
		erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost))

		if(erroN <= precisao):
			print 'Solução obtida com {0} iterações: {1}'.format(numIteracoes, xkPost)
			return

		if(erroN >= erroV):
			erroDiminuindo = False

		xk = xkPost
		erroV = erroN

	print 'Método pode estar divergindo. Iterações: {0}'.format(numIteracoes)

def secante(func, precisao, xk, xkAnt):
		numIteracoes = 0
		erroV = abs(xk - xkAnt) / max(abs(xk), abs(xkAnt))

		erroDiminuindo = True
		while (erroDiminuindo):
			numIteracoes += 1
			den = f(func, xk) - f(func, xkAnt)
			if (den == 0):
				print 'Divisão por zero'
				return

			xkPost = xk - f(func, xk) * (xk - xkAnt) / den
			erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost))

			if (erroN <= precisao):
				print 'Solução obtida com {0} iterações: {1}'.format(numIteracoes, xkPost)
				return

			if (erroN >= erroV):
				erroDiminuindo = False

			xkAnt = xk
			xk = xkPost
			erroV = erroN

		print 'Método pode estar divergindo. Número de iterações: {0}'.format(numIteracoes)

def steffensen(func, precisao, xk):
		numIteracoes = 0
		aux = f(func, xk)
		den = f(func, (xk + aux)) - aux
		xkPost = (aux * aux) / den

		erroV = abs(xkPost - xk) / max(abs(xk), abs(xkPost))
		xk = xkPost

		erroDiminuindo = True
		while(erroDiminuindo):
			numIteracoes += 1
			aux = f(func, xk)
			den = f(func, (xk + aux)) - aux
			
			if(den == 0):
				print 'Divisão por zero'
				return
			
			xkPost = (aux * aux) / den

			erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost))

			if(erroN <= precisao):
				print 'Solução obtida com {0} iterações: {1}'.format(numIteracoes, xkPost)
				return

			if(erroN >= erroV):
				erroDiminuindo = False

			xk = xkPost
			erroV = erroN
		print 'Método pode estar divergindo. Número de iterações: {0}'.format(numIteracoes)
