#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''

from PyQt4 import QtGui
from layoutInterface import Ui_MainWindow
import sys

class Interface(object):
    def __init__(self, camAplicOrigem, camAplicDestino):
        self.app = QtGui.QApplication(sys.argv)
        self.janela = QtGui.QMainWindow()
        self.ui = Ui_MainWindow(camAplicOrigem, camAplicDestino)
        self.ui.setupUi(self.janela)
        self.janela.show()
        
   
    def iniciar(self): 
        self.ui.iniciarConexao()
        self.app.exec_()
