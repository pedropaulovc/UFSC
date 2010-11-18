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
    
    camTransOrigem = CamadaTransporte(camRede)
    camTransDestino = CamadaTransporte(camRede)
    
    camRede.origem = camTransOrigem
    camRede.destino = camTransDestino
    
    camAplicOrigem = CamadaAplicacao(1, camTransOrigem)
    camAplicDestino = CamadaAplicacao(2, camTransDestino)
    
    camTransOrigem.camadaAplicacao = camAplicOrigem
    camTransDestino.camadaAplicacao = camAplicDestino
    
    camAplicDestino.start()
    camAplicOrigem.start()

    Interface(camAplicOrigem, camAplicDestino)

