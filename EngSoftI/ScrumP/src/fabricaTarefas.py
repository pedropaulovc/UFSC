#-*- coding: utf-8 -*-
from tarefa import Tarefa
class Callable:
	def __init__(self, anycallable):
		self.__call__ = anycallable

class FabricaTarefas(object):
	__tarefa = 0
	
	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisito 
	def criarTarefa(nome, descricao, dificuldade, tarefasPreRequisito):#@NoSelf
		id = FabricaTarefas.__gerarIdTarefa()
		return Tarefa(id, nome, descricao, dificuldade, tarefasPreRequisito)
	criarTarefa = Callable(criarTarefa)

	def __gerarIdTarefa(): #@NoSelf
		id = "TAR-" + str(FabricaTarefas.__tarefa)
		FabricaTarefas.__tarefa += 1 
		return id
	__gerarIdTarefa = Callable(__gerarIdTarefa)

