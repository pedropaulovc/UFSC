#-*- coding: utf-8 -*-
from tarefa import Tarefa
from recursos.singleton import Singleton


class FabricaTarefas(Singleton):
	__tarefa = 0 
	
	def criarTarefa(self, nome, descricao, dificuldade, tarefasPreRequisito, estimativa):
		id = self.__gerarIdTarefa()
		return Tarefa(id, nome, descricao, dificuldade, tarefasPreRequisito, estimativa)

	def __gerarIdTarefa(self):
		id = "TAR-" + str(FabricaTarefas.__tarefa)
		FabricaTarefas.__tarefa += 1 
		return id

