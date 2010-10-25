#-*- coding: utf-8 -*-
'''
INE5417 - ENGENHARIA DE SOFTWARE I
ITERAÇÃO 1 - SCRUMPY
ALUNOS: PEDRO PAULO V. CAMPOS, RAFAEL E. PEDRETTI, JUAREZ A. PIAZZA SACENTI
'''
class Excecoes(Exception):
    pass

class EstoriaNaoExiste(Excecoes):
    pass

class DuracaoInvalida(Excecoes):
    pass

class LoginJaExiste(Excecoes):
    pass

class ProjetoNaoExiste(Excecoes):
    pass

class SenhaInvalida(Excecoes):
    pass

class TarefaJaExiste(Excecoes):
    pass

class TarefaNaoExiste(Excecoes):
    pass

class UsuarioNaoExiste(Excecoes):
    pass

class UsuarioNaoLogado(Excecoes):
    pass

class SemProjetoAberto(Excecoes):
    pass

class UsuarioSemPermissao(Excecoes):
    pass

class NaoParticipaDoProjeto(Excecoes):
    pass

class TarefaJaConcluida(Excecoes):
    pass