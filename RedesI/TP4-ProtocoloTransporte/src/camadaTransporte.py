#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaRede import CamadaRede

class CamadaTransporte(object):
    '''
    classdocs
    '''

    def __init__(self):
        CamadaRede(('localhost', 2233))
        
