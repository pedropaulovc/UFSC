#-*- coding: utf-8 -*-
from PyQt4 import QtCore, QtGui
from interface.dialogoLogin import DialogoLogin
from excecoes import UsuarioNaoExiste, SenhaInvalida

try:
    _fromUtf8 = QtCore.QString.fromUtf8
except AttributeError:
    _fromUtf8 = lambda s: s

class JanelaPrincipal(object):
    
    def __init__(self,scrumpy):
        self.__scrumpy = scrumpy
    
    def setupUi(self, MainWindow):
        MainWindow.setObjectName(_fromUtf8("MainWindow"))
        MainWindow.resize(838, 504)
        self.centralwidget = QtGui.QWidget(MainWindow)
        self.centralwidget.setObjectName(_fromUtf8("centralwidget"))
        self.__labelUsuario = QtGui.QLabel(self.centralwidget)
        self.__labelUsuario.setGeometry(QtCore.QRect(580, 20, 151, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelUsuario.setFont(font)
        self.__labelUsuario.setObjectName(_fromUtf8("__labelUsuario"))
        self.__labelProjeto = QtGui.QLabel(self.centralwidget)
        self.__labelProjeto.setGeometry(QtCore.QRect(580, 40, 151, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelProjeto.setFont(font)
        self.__labelProjeto.setObjectName(_fromUtf8("__labelProjeto"))
        self.__nomeUsuarioLogado = QtGui.QLabel(self.centralwidget)
        self.__nomeUsuarioLogado.setGeometry(QtCore.QRect(730, 20, 151, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__nomeUsuarioLogado.setFont(font)
        self.__nomeUsuarioLogado.setObjectName(_fromUtf8("__nomeUsuarioLogado"))
        self.__nomeProjetoAberto = QtGui.QLabel(self.centralwidget)
        self.__nomeProjetoAberto.setGeometry(QtCore.QRect(730, 40, 151, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__nomeProjetoAberto.setFont(font)
        self.__nomeProjetoAberto.setObjectName(_fromUtf8("__nomeProjetoAberto"))
        self.listWidget = QtGui.QListWidget(self.centralwidget)
        self.listWidget.setGeometry(QtCore.QRect(600, 100, 201, 351))
        self.listWidget.setObjectName(_fromUtf8("listWidget"))
        self.__labelProjetosParticipados = QtGui.QLabel(self.centralwidget)
        self.__labelProjetosParticipados.setGeometry(QtCore.QRect(610, 80, 191, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelProjetosParticipados.setFont(font)
        self.__labelProjetosParticipados.setObjectName(_fromUtf8("__labelProjetosParticipados"))
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtGui.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 838, 23))
        self.menubar.setObjectName(_fromUtf8("menubar"))
        self.menuMenu = QtGui.QMenu(self.menubar)
        self.menuMenu.setObjectName(_fromUtf8("menuMenu"))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtGui.QStatusBar(MainWindow)
        self.statusbar.setObjectName(_fromUtf8("statusbar"))
        MainWindow.setStatusBar(self.statusbar)
        self.actionLogar_Usuario = QtGui.QAction(MainWindow)
        self.actionLogar_Usuario.setObjectName(_fromUtf8("actionLogar_Usuario"))
        self.menuMenu.addAction(self.actionLogar_Usuario)
        self.menubar.addAction(self.menuMenu.menuAction())

        self.retranslateUi(MainWindow)
        QtCore.QObject.connect(self.actionLogar_Usuario, QtCore.SIGNAL(_fromUtf8("triggered()")), self.__logarUsuario)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QtGui.QApplication.translate("MainWindow", "MainWindow", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelUsuario.setText(QtGui.QApplication.translate("MainWindow", "Usuário Logado:", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelProjeto.setText(QtGui.QApplication.translate("MainWindow", "Projeto Aberto:", None, QtGui.QApplication.UnicodeUTF8))
        self.__nomeUsuarioLogado.setText(QtGui.QApplication.translate("MainWindow", "Nenhum", None, QtGui.QApplication.UnicodeUTF8))
        self.__nomeProjetoAberto.setText(QtGui.QApplication.translate("MainWindow", "Nenhum", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelProjetosParticipados.setText(QtGui.QApplication.translate("MainWindow", "Projeto Participados:", None, QtGui.QApplication.UnicodeUTF8))
        self.menuMenu.setTitle(QtGui.QApplication.translate("MainWindow", "Menu", None, QtGui.QApplication.UnicodeUTF8))
        self.actionLogar_Usuario.setText(QtGui.QApplication.translate("MainWindow", "Logar Usuario", None, QtGui.QApplication.UnicodeUTF8))

    def __logarUsuario(self):
        dialogoLogin = DialogoLogin()
        janela = QtGui.QDialog()
        dialogoLogin.setupUi(janela)
        janela.show()
        janela.exec_()
        login, senha = dialogoLogin.obterDados()
        try:
            self.__scrumpy.logarUsuario(login, senha)
            usuario = self.__scrumpy.obterUsuarioAtual()
            self.__nomeUsuarioLogado.setText(usuario)
        except UsuarioNaoExiste:
            self.__mensagemErroLogin()
        except SenhaInvalida:
            self.__mensagemErroLogin()
            
    def __mensagemErroLogin(self):
        mensagem  = QtGui.QMessageBox()
        mensagem.setText(u"Usuário e/ou senha inválidos")
        mensagem.exec_()