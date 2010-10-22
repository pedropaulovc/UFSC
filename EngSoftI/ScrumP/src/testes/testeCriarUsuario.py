#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
import unittest
from usuario import Usuario


class TestCriarUsuario(unittest.TestCase):


    def testCriarUsuario(self):
        usuario = Usuario('rafael', 'pepe', '123')
        self.assertNotEquals(usuario, None)
        self.assertEquals(usuario.obterLogin(), 'pepe')
