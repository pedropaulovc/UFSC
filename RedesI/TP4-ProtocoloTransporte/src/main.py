#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaRede import CamadaRede


if __name__ == '__main__':
    c1 = CamadaRede(('localhost', 55001))
    c2 = CamadaRede(('localhost', 55002))
    
    for i in xrange(500):
        pass
    c1.conectar(('localhost', 55002))
    c1.desconectar(('localhost', 55002))
    