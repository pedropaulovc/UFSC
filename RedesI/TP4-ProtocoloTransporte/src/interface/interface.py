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
        app = QtGui.QApplication(sys.argv)
        janela = QtGui.QMainWindow()
        ui = Ui_MainWindow(camAplicOrigem, camAplicDestino)
        ui.setupUi(janela)
        janela.show()
        app.exec_()
        
        


        