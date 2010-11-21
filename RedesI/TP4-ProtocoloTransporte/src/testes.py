#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''
import unittest
from camadaRede import CamadaRede
from camadaTransporte import CamadaTransporte
from camadaAplicacao import CamadaAplicacao


class Test(unittest.TestCase):


    def setUp(self):
        self.camRede = CamadaRede()
        self.camTransOrigem = CamadaTransporte(1, self.camRede)
        self.camTransDestino = CamadaTransporte(2, self.camRede)
        self.camRede.origem = self.camTransOrigem
        self.camRede.destino = self.camTransDestino
        self.camAplicOrigem = CamadaAplicacao(1, self.camTransOrigem)
        self.camAplicDestino = CamadaAplicacao(2, self.camTransDestino)
        self.camTransOrigem.camadaAplicacao = self.camAplicOrigem
        self.camTransDestino.camadaAplicacao = self.camAplicDestino
        self.camAplicDestino.start()
        self.camAplicOrigem.start()
        

    def tearDown(self):
        self.camRede = None
        self.camTransOrigem = None
        self.camTransDestino = None
        self.camAplicOrigem = None
        self.camAplicDestino = None


    def testName(self):
        pass

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()