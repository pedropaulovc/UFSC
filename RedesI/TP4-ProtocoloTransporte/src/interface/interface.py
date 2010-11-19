'''
Created on Nov 17, 2010

@author: pedropaulovc
'''

from PyQt4 import QtGui
from layoutInterface import Ui_MainWindow
import sys

class Interface(object):
    '''
    classdocs
    '''
    def __init__(self, camAplicOrigem, camAplicDestino):
        self.app = QtGui.QApplication(sys.argv)
        self.janela = QtGui.QMainWindow()
        self.ui = Ui_MainWindow(camAplicOrigem, camAplicDestino)
        self.ui.setupUi(self.janela)
        self.janela.show()
        
   
    def iniciar(self): 
        self.ui.iniciarConexao()
        self.app.exec_()
