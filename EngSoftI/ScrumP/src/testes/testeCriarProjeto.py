'''
Created on 20/10/2010

@author: pepe
'''
import unittest
from projeto import Projeto


class TestProjeto(unittest.TestCase):


    def testCriarProjeto(self):
        projeto = Projeto('proj', ['pepe'], 'pepe', 'pepe', 'projManual')
        self.assertEquals(projeto.obterId(), 'projManual')
        self.assertEquals(projeto.usuarioParticipa('pepe'), True)
        self.assertEquals(len(projeto.obterTarefas()), 0)
        del projeto

    def testObterInfoProjeto(self):
        projeto = Projeto('proj', ['pepe'], 'pepe', 'pepe', 'projManual')
        nome, id = projeto.obterInfo()
        self.assertEquals(nome, 'proj')
        self.assertEquals(id, 'projManual')
        