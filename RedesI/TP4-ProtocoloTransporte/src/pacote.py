#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''

class Pacote(object):

    def __init__(self, cid, q, m, pt, p, bytes):
        '''
        Definicao de um pacote utilizada por essa implementacao de
        camada de transporte. 
        '''
        self.cid = cid;
        self.q = q;
        self.m = m;
        self.pt = pt;
        self.p = p;
        self.bytes = bytes;