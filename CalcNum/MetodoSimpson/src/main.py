#encoding = utf-8

'''
Created on Jun 9, 2010

@author: pedropaulo
'''
from metodoSimpson import *

def main():
	print integrarSimpson('sqrt(x)', 1.0, 2.0, 8.0)


if __name__ == '__main__':
	main()