#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
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
        