#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaRede import CamadaRede
from time import sleep


if __name__ == '__main__':
    end1 = ('localhost', 55003)
    end2 = ('localhost', 55004)
    c1 = CamadaRede(end1)
    c2 = CamadaRede(end2)
    c1.start()
    c2.start()
    
    sleep(1)
    
    c1.conectar(end2)
    sleep(1)
    print "Remotos c1:", c1.obterRemotos()
    sleep(1)
    print "Remotos c2:", c2.obterRemotos()
    sleep(1)
    c1.enviarRede(end2, "Lorem Ipsum")
    sleep(1)
    recebido = c2.receberRede(c2.obterRemotos().keys()[0])
    print recebido
    sleep(1)
    c1.desconectar(end2)
    sleep(1)
    c2.enviarRede(c2.obterRemotos().keys()[0], "Dolor Sit")
    print "Remotos c1:", c1.obterRemotos()
    sleep(1)
    print "Remotos c2:", c2.obterRemotos()
    print "Terminou"