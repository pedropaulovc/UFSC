# coding=utf-8
'''
Createdon15/05/2010

@author:PedroPaulo
'''
def f(func, x):
	return float(eval(func))

def df(func_derivada, x):
	return float(eval(func_derivada))

def newtonGeral(func, dfunc, xk):
	print "Newton Geral"
#	den = df(x)
#	if(den == 0)
#		print "Divisão por zero na iteração inicial"
#		return;
#
#	xkPost = xk - funcao.obterValor(xk) / den;
#	intnumIteracoes = 0;
#	doubleerroV = abs(xkPost - xk) / max(abs(xk), abs(xkPost));
#	xk = xkPost;
#	
#	booleanerroDiminuindo = true;
#	while(erroDiminuindo){
#	numIteracoes + +;
#	den = funcao.obterValorDerivada(xk);
#	if(den == 0){
#	System.out.println("Divis�oporzero");
#	return;
#	}
#	
#	xkPost = xk - funcao.obterValor(xk) / den;
#	erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost));
#	
#	if(erroN <= precisao){
#	System.out.println("Solu��oobtidacom" + numIteracoes
#	+ "itera��es:" + xkPost);
#	return;
#	}
#	
#	if(erroN >= erroV)
#	erroDiminuindo = false;
#	
#	xk = xkPost;
#	erroV = erroN;
#	}
#	System.out
#	.println("M�todopodeestardivergindo.N�merodeitera��es:"
#	+ numIteracoes);

def secante(func, xk, xkPost):
	print "Lorem"
	
def steffensen(func, xk):
	print "Ipsum"