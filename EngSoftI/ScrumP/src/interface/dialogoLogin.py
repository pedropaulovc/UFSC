#-*- coding: utf-8 -*-
'''
Created on 03/10/2010

@author: pepe
'''
from PyQt4 import QtCore, QtGui

try:
    _fromUtf8 = QtCore.QString.fromUtf8
except AttributeError:
    _fromUtf8 = lambda s: s

class DialogoLogin(object):
    
    def __init__(self):
        self.__dados = ("","")
    
    def setupUi(self, Dialog):
        self.Dialog = Dialog
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(330, 131)
        self.gridLayout = QtGui.QGridLayout(Dialog)
        self.gridLayout.setObjectName(_fromUtf8("gridLayout"))
        self.__labelLogin = QtGui.QLabel(Dialog)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelLogin.setFont(font)
        self.__labelLogin.setObjectName(_fromUtf8("__labelLogin"))
        self.gridLayout.addWidget(self.__labelLogin, 2, 0, 1, 1)
        self.__login = QtGui.QLineEdit(Dialog)
        sizePolicy = QtGui.QSizePolicy(QtGui.QSizePolicy.MinimumExpanding, QtGui.QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.__login.sizePolicy().hasHeightForWidth())
        self.__login.setSizePolicy(sizePolicy)
        self.__login.setMinimumSize(QtCore.QSize(100, 0))
        self.__login.setObjectName(_fromUtf8("__login"))
        self.gridLayout.addWidget(self.__login, 2, 1, 1, 1)
        self.__labelSenha = QtGui.QLabel(Dialog)
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelSenha.setFont(font)
        self.__labelSenha.setObjectName(_fromUtf8("__labelSenha"))
        self.gridLayout.addWidget(self.__labelSenha, 6, 0, 1, 1)
        self.__botoesCancelOk = QtGui.QDialogButtonBox(Dialog)
        self.__botoesCancelOk.setOrientation(QtCore.Qt.Horizontal)
        self.__botoesCancelOk.setStandardButtons(QtGui.QDialogButtonBox.Cancel|QtGui.QDialogButtonBox.Ok)
        self.__botoesCancelOk.setObjectName(_fromUtf8("__botoesCancelOk"))
        self.gridLayout.addWidget(self.__botoesCancelOk, 7, 0, 1, 2)
        spacerItem = QtGui.QSpacerItem(20, 10, QtGui.QSizePolicy.Minimum, QtGui.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem, 4, 1, 1, 1)
        self.__senha = QtGui.QLineEdit(Dialog)
        sizePolicy = QtGui.QSizePolicy(QtGui.QSizePolicy.MinimumExpanding, QtGui.QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.__senha.sizePolicy().hasHeightForWidth())
        self.__senha.setSizePolicy(sizePolicy)
        self.__senha.setMinimumSize(QtCore.QSize(250, 0))
        self.__senha.setObjectName(_fromUtf8("__senha"))
        self.gridLayout.addWidget(self.__senha, 6, 1, 1, 1)
        spacerItem1 = QtGui.QSpacerItem(20, 40, QtGui.QSizePolicy.Minimum, QtGui.QSizePolicy.Expanding)
        self.gridLayout.addItem(spacerItem1, 1, 1, 1, 1)
        spacerItem2 = QtGui.QSpacerItem(20, 40, QtGui.QSizePolicy.Minimum, QtGui.QSizePolicy.Expanding)
        self.gridLayout.addItem(spacerItem2, 8, 0, 1, 1)

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.__botoesCancelOk, QtCore.SIGNAL(_fromUtf8("accepted()")), Dialog.accept)
        QtCore.QObject.connect(self.__botoesCancelOk, QtCore.SIGNAL(_fromUtf8("rejected()")), Dialog.reject)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(QtGui.QApplication.translate("Dialog", "Dialog", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelLogin.setText(QtGui.QApplication.translate("Dialog", "Login:", None, QtGui.QApplication.UnicodeUTF8))
        self.__labelSenha.setText(QtGui.QApplication.translate("Dialog", "Senha:", None, QtGui.QApplication.UnicodeUTF8))

    def __enviarDados(self):
        login = self.__login.text()
        login = str(login.toUtf8())
        senha = self.__senha.text()
        senha = str(senha.toUtf8())
        self.__dados = (login,senha)
        self.Dialog.accept()
    
    def obterDados(self):
        return self.__dados