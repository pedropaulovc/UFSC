#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
import unittest
from projeto import Projeto
from scrumPy import ScrumPy


class TestObterInfoProjeto(unittest.TestCase):

    def setUp(self):
        scrumpy = ScrumPy()
        scrumpy.cadastrarUsuario('rafael', 'pepe', '123')
        self.projeto = Projeto('proj', 'pepe', 'pepe', 'pepe', 'proj1')

    def testObterNomeProjeto(self):
        nome, id = self.projeto.obterInfo()
        self.assertEquals(nome, 'proj')
        
    def testObteridProjeto(self):
        id = self.projeto.obterId()
        self.assertEquals(id, 'proj1')

    def testObterTarefasProjeto(self):
        tarefas = self.projeto.obterTarefas()
        self.assertTrue(len(tarefas) == 0)
        
    def testUsuarioParticipa(self):
        self.assertTrue(self.projeto.usuarioParticipa('pepe'))