#-*- coding: utf-8 -*-
from tarefa import Tarefa


class FabricaTarefas(object):
	__tarefa = 0
	
	# @ParamType nome 
	# @ParamType descricao 
	# @ParamType dificuldade 
	# @ParamType tarefasPreRequisito 
	
	@staticmethod
	def criarTarefa(nome, descricao, dificuldade, tarefasPreRequisito):
		id = FabricaTarefas.__gerarIdTarefa()
		return Tarefa(id, nome, descricao, dificuldade, tarefasPreRequisito)

	@staticmethod
	def __gerarIdTarefa():
		id = "TAR-" + str(FabricaTarefas.__tarefa)
		FabricaTarefas.__tarefa += 1 
		return id

