#-*- coding: utf-8 -*-
from PyQt4 import QtCore, QtGui
from interface.dialogoLogin import DialogoLogin
from excecoes import UsuarioNaoExiste, SenhaInvalida

try:
    _fromUtf8 = QtCore.QString.fromUtf8
except AttributeError:
    _fromUtf8 = lambda s: s

class JanelaPrincipal(QtCore.QThread):
    
    def __init__(self,scrumpy):
        self.__scrumpy = scrumpy
        QtCore.QThread.__init__(self)
    
    def setupUi(self, janelaPrincipal):
        janelaPrincipal.setObjectName(_fromUtf8("janelaPrincipal"))
        janelaPrincipal.resize(847, 498)
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap(_fromUtf8("scrumpy.bmp")), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        janelaPrincipal.setWindowIcon(icon)
        self.centralwidget = QtGui.QWidget(janelaPrincipal)
        self.centralwidget.setObjectName(_fromUtf8("centralwidget"))
        self.gridLayout_2 = QtGui.QGridLayout(self.centralwidget)
        self.gridLayout_2.setObjectName(_fromUtf8("gridLayout_2"))
        self.gridLayout = QtGui.QGridLayout()
        self.gridLayout.setObjectName(_fromUtf8("gridLayout"))
        self.__labelUsuario = QtGui.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelUsuario.setFont(font)
        self.__labelUsuario.setObjectName(_fromUtf8("__labelUsuario"))
        self.gridLayout.addWidget(self.__labelUsuario, 2, 0, 1, 1)
        self.__nomeUsuarioLogado = QtGui.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__nomeUsuarioLogado.setFont(font)
        self.__nomeUsuarioLogado.setObjectName(_fromUtf8("__nomeUsuarioLogado"))
        self.gridLayout.addWidget(self.__nomeUsuarioLogado, 0, 1, 1, 1)
        self.__nomeProjetoAberto = QtGui.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__nomeProjetoAberto.setFont(font)
        self.__nomeProjetoAberto.setObjectName(_fromUtf8("__nomeProjetoAberto"))
        self.gridLayout.addWidget(self.__nomeProjetoAberto, 2, 1, 1, 1)
        self.__labelProjeto = QtGui.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelProjeto.setFont(font)
        self.__labelProjeto.setObjectName(_fromUtf8("__labelProjeto"))
        self.gridLayout.addWidget(self.__labelProjeto, 0, 0, 1, 1)
        self.gridLayout_2.addLayout(self.gridLayout, 0, 1, 1, 1)
        self.gridLayout_3 = QtGui.QGridLayout()
        self.gridLayout_3.setSizeConstraint(QtGui.QLayout.SetMinimumSize)
        self.gridLayout_3.setObjectName(_fromUtf8("gridLayout_3"))
        self.__labelProjetosParticipados = QtGui.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelProjetosParticipados.setFont(font)
        self.__labelProjetosParticipados.setObjectName(_fromUtf8("__labelProjetosParticipados"))
        self.gridLayout_3.addWidget(self.__labelProjetosParticipados, 0, 0, 1, 1)
        self.listWidget = QtGui.QListWidget(self.centralwidget)
        sizePolicy = QtGui.QSizePolicy(QtGui.QSizePolicy.MinimumExpanding, QtGui.QSizePolicy.Expanding)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.listWidget.sizePolicy().hasHeightForWidth())
        self.listWidget.setSizePolicy(sizePolicy)
        self.listWidget.setMinimumSize(QtCore.QSize(0, 250))
        self.listWidget.setObjectName(_fromUtf8("listWidget"))
        self.gridLayout_3.addWidget(self.listWidget, 1, 0, 1, 1)
        spacerItem = QtGui.QSpacerItem(40, 20, QtGui.QSizePolicy.Fixed, QtGui.QSizePolicy.Minimum)
        self.gridLayout_3.addItem(spacerItem, 1, 1, 1, 1)
        self.gridLayout_2.addLayout(self.gridLayout_3, 2, 1, 1, 1)
        spacerItem1 = QtGui.QSpacerItem(250, 20, QtGui.QSizePolicy.MinimumExpanding, QtGui.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem1, 0, 0, 1, 1)
        spacerItem2 = QtGui.QSpacerItem(20, 10, QtGui.QSizePolicy.Minimum, QtGui.QSizePolicy.Fixed)
        self.gridLayout_2.addItem(spacerItem2, 1, 1, 1, 1)
        janelaPrincipal.setCentralWidget(self.centralwidget)
        self.menubar = QtGui.QMenuBar(janelaPrincipal)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 847, 23))
        self.menubar.setObjectName(_fromUtf8("menubar"))
        self.menuMenu = QtGui.QMenu(self.menubar)
        self.menuMenu.setObjectName(_fromUtf8("menuMenu"))
        janelaPrincipal.setMenuBar(self.menubar)
        self.statusbar = QtGui.QStatusBar(janelaPrincipal)
        self.statusbar.setObjectName(_fromUtf8("statusbar"))
        janelaPrincipal.setStatusBar(self.statusbar)
        self.actionLogar_Usuario = QtGui.QAction(janelaPrincipal)
        self.actionLogar_Usuario.setObjectName(_fromUtf8("actionLogar_Usuario"))
        self.menuMenu.addAction(self.actionLogar_Usuario)
        self.menubar.addAction(self.menuMenu.menuAction())

        self.retranslateUi(janelaPrincipal)
        QtCore.QObject.connect(self.actionLogar_Usuario, QtCore.SIGNAL(_fromUtf8("triggered()")), self.__logarUsuario)
        QtCore.QMetaObject.connectSlotsByName(janelaPrincipal)

    def retranslateUi(self, janelaPrincipal):
        janelaPrincipal.setWindowTitle(QtGui.QApplication.translate("janelaPrincipal", "ScrumPy", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelUsuario.setText(QtGui.QApplication.translate("janelaPrincipal", "Usuário Logado:", None, QtGui.QApplication.UnicodeUTF8))
        self.__nomeUsuarioLogado.setText(QtGui.QApplication.translate("janelaPrincipal", "Nenhum", None, QtGui.QApplication.UnicodeUTF8))
        self.__nomeProjetoAberto.setText(QtGui.QApplication.translate("janelaPrincipal", "Nenhum", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelProjeto.setText(QtGui.QApplication.translate("janelaPrincipal", "Projeto Aberto:", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelProjetosParticipados.setText(QtGui.QApplication.translate("janelaPrincipal", "Projeto Participados:", None, QtGui.QApplication.UnicodeUTF8))
        self.menuMenu.setTitle(QtGui.QApplication.translate("janelaPrincipal", "Menu", None, QtGui.QApplication.UnicodeUTF8))
        self.actionLogar_Usuario.setText(QtGui.QApplication.translate("janelaPrincipal", "Logar Usuario", None, QtGui.QApplication.UnicodeUTF8))

    def __logarUsuario(self):
        dialogoLogin = DialogoLogin()
        janela = QtGui.QDialog()
        dialogoLogin.setupUi(janela)
        janela.show()
        ok = janela.exec_()
        if ok:
            login, senha = dialogoLogin.obterDados()
            try:
                self.__scrumpy.logarUsuario(login, senha)
                usuario = self.__scrumpy.obterUsuarioAtual()
                self.__nomeUsuarioLogado.setText(usuario)
            except UsuarioNaoExiste:
                self.__mensagemErroLogin()
            except SenhaInvalida:
                self.__mensagemErroLogin()
        del janela, dialogoLogin
            
    def __mensagemErroLogin(self):
        mensagem  = QtGui.QMessageBox()
        mensagem.setWindowTitle("ERRO!")
        mensagem.setText(u"Usuário e/ou senha inválidos")
        mensagem.exec_()