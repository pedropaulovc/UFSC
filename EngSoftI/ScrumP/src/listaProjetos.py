'''
Created on 27/09/2010

@author: pepe
'''

class ListaProjetos(object):
    '''
    classdocs
    '''


    def __init__(self):
        self.__listaProjetos = {}
    
    def adicionarEstoria(self,estoria,idProjeto):
        self.__listaProjetos.get(idProjeto).adicionarEstoria(estoria)
        
    def adicionarProjeto(self,projeto):
        self.__listaProjetos[projeto.obterId()] = projeto
        
    def obterEstoria(self,idProjeto,idEstoria):
        return self.__listaProjetos.get(idProjeto).obterEstoria(idEstoria)
    
    def obterProjetosParticipados(self, login):
        participados = []
        for projeto in self.__listaProjetos.values():
            if projeto.usuarioParticipa(login):
                participados.append(projeto.obterId())
        return participados