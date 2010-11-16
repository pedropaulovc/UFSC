'''
Created on Nov 16, 2010

@author: pedropaulovc
'''

class Pacote(object):
    '''
    classdocs
    '''
    def __init__(self, cid, q, m, pt, p, bytes):
        self.cid = cid;
        self.q = q;
        self.m = m;
        self.pt = pt;
        self.p = p;
        self.bytes = bytes;