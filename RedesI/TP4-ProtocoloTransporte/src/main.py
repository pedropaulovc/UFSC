#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''
from camadaRede import CamadaRede
from camadaTransporte import CamadaTransporte
from camadaAplicacao import CamadaAplicacao
from interface.interface import Interface

if __name__ == '__main__':
    #Criacao da camada de rede 
    camRede = CamadaRede()
    
    #Criacao das camadas de transporte utilizadas no programa.
    camTransOrigem = CamadaTransporte(1, camRede)
    camTransDestino = CamadaTransporte(2, camRede)
    
    #Associacao da camada de rede com as camadas de transporte.
    camRede.origem = camTransOrigem
    camRede.destino = camTransDestino
    
    #Criacao das camadas de aplicacao utilizadas no programa.
    camAplicOrigem = CamadaAplicacao(1, camTransOrigem)
    camAplicDestino = CamadaAplicacao(2, camTransDestino)
    
    #Associacao das camadas de transporte com as suas camadas de aplicacao
    #correspondentes.
    camTransOrigem.camadaAplicacao = camAplicOrigem
    camTransDestino.camadaAplicacao = camAplicDestino
    
    #Inicializacao das camadas de aplizacao
    camAplicDestino.start()
    camAplicOrigem.start()    

    #Criacao da interface grafica do programa.
    interface = Interface(camAplicOrigem, camAplicDestino)
    
    #Inicializacao da interface grafica.
    interface.iniciar()
    
