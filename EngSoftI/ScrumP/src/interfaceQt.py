'''
Created on 03/10/2010

@author: pepe
'''
# Juarez: Acho uma boa ideia renomear esse arquivo pra controlador ou mainzão
#         e deixa-lo responsavel por conversar com a fachada da interface escolhida,
#         assim possibilitando a comunicação tanto com a interface texto quanto com 
#         a gui.
#        Também pode ser uma boa criar um modulo pertencente a este pacote control
#        que guardaria a info de inicialização, assim podendo haver varios tipos de 
#        inicialização a nossa escolha. O modulo seria simples, uma única função loadMemória
#        que ia cadastrar o necessário.
#        Aguardo aceitação da ideia para começar a implementação.

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