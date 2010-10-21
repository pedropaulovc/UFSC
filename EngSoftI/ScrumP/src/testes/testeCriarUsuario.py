'''
Created on 20/10/2010

@author: pepe
'''
import unittest
from usuario import Usuario


class TestCriarUsuario(unittest.TestCase):


    def testCriarUsuario(self):
        usuario = Usuario('rafael', 'pepe', '123')
        self.assertNotEquals(usuario, None)
        self.assertEquals(usuario.obterLogin(), 'pepe')
