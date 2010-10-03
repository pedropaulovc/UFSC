'''
Created on 03/10/2010

@author: pepe
'''
from PyQt4 import QtGui
from interface.janelaPrincipal import JanelaPrincipal
from scrumPy import ScrumPy
import sys

if __name__ == '__main__':
    scrumPy = ScrumPy()
    scrumPy.cadastrarUsuario("Pedro Paulo", "pp", "pp")
    app = QtGui.QApplication(sys.argv)
    janela = QtGui.QMainWindow()
    ui = JanelaPrincipal(scrumPy)
    ui.setupUi(janela)
    janela.show()
    sys.exit(app.exec_())