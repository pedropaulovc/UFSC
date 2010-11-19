#-*- coding: utf-8 -*-
'''
Created on Nov 14, 2010

@author: pedropaulovc
'''
from camadaRede import CamadaRede
from camadaTransporte import CamadaTransporte
from camadaAplicacao import CamadaAplicacao
from interface.interface import Interface

if __name__ == '__main__':
    camRede = CamadaRede()
    
    camTransOrigem = CamadaTransporte(1, camRede)
    camTransDestino = CamadaTransporte(2, camRede)
    
    camRede.origem = camTransOrigem
    camRede.destino = camTransDestino
    
    camAplicOrigem = CamadaAplicacao(1, camTransOrigem)
    camAplicDestino = CamadaAplicacao(2, camTransDestino)
    
    camTransOrigem.camadaAplicacao = camAplicOrigem
    camTransDestino.camadaAplicacao = camAplicDestino
    
    interface = Interface(camAplicOrigem, camAplicDestino)
    
    camAplicDestino.start()
    camAplicOrigem.start()
    
    interface.iniciar()
    
