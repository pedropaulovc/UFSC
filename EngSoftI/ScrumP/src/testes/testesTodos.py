#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
from testes.testeCriarProjeto import TestProjeto
from testes.testeCriarUsuario import TestCriarUsuario
from testes.testeObterInfoProjeto import TestObterInfoProjeto
import unittest


if __name__ == "__main__":
    suite1 = unittest.TestLoader().loadTestsFromTestCase(TestProjeto)
    suite2 = unittest.TestLoader().loadTestsFromTestCase(TestCriarUsuario)
    suite3 = unittest.TestLoader().loadTestsFromTestCase(TestObterInfoProjeto)
    suite_all =  unittest.TestSuite([suite1, suite2, suite3])
    unittest.TextTestRunner(verbosity=2).run(suite_all)