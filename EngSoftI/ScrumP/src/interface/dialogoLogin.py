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
        self.__dados = None
    
    def setupUi(self, Dialog):
        self.Dialog = Dialog
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(398, 189)
        self.__botoesCancelOk = QtGui.QDialogButtonBox(Dialog)
        self.__botoesCancelOk.setGeometry(QtCore.QRect(40, 150, 341, 32))
        self.__botoesCancelOk.setOrientation(QtCore.Qt.Horizontal)
        self.__botoesCancelOk.setStandardButtons(QtGui.QDialogButtonBox.Cancel|QtGui.QDialogButtonBox.Ok)
        self.__botoesCancelOk.setObjectName(_fromUtf8("__botoesCancelOk"))
        self.__labelLogin = QtGui.QLabel(Dialog)
        self.__labelLogin.setGeometry(QtCore.QRect(90, 60, 61, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelLogin.setFont(font)
        self.__labelLogin.setObjectName(_fromUtf8("__labelLogin"))
        self.__labelSenha = QtGui.QLabel(Dialog)
        self.__labelSenha.setGeometry(QtCore.QRect(90, 90, 61, 16))
        font = QtGui.QFont()
        font.setFamily(_fromUtf8("Serif"))
        font.setPointSize(12)
        self.__labelSenha.setFont(font)
        self.__labelSenha.setObjectName(_fromUtf8("__labelSenha"))
        self.__login = QtGui.QLineEdit(Dialog)
        self.__login.setGeometry(QtCore.QRect(150, 60, 161, 20))
        self.__login.setObjectName(_fromUtf8("__login"))
        self.__senha = QtGui.QLineEdit(Dialog)
        self.__senha.setGeometry(QtCore.QRect(150, 90, 161, 20))
        self.__senha.setObjectName(_fromUtf8("__senha"))

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.__botoesCancelOk, QtCore.SIGNAL(_fromUtf8("accepted()")), self.__enviarDados)
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