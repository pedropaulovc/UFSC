#-*- coding: utf-8 -*-
'''
INE5414 - REDES DE COMPUTADORES I
TRABALHO PRATICO 4 - IMPLEMENTACAO DE UM PROTOCOLO DA CAMADA DE TRANSPORTE
ALUNO: PEDRO PAULO VEZZA CAMPOS
'''
from PyQt4 import QtCore, QtGui
import logging

class Ui_MainWindow(object):
    def __init__(self, camAplicOrigem, camAplicDestino):
        self.camAplicOrigem = camAplicOrigem
        self.camAplicDestino = camAplicDestino
        self.idOrigem = camAplicOrigem.id
        self.idDestino = camAplicDestino.id
    
    
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(748, 582)
        self.centralwidget = QtGui.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.pushButton = QtGui.QPushButton(self.centralwidget)
        self.pushButton.setGeometry(QtCore.QRect(240, 280, 98, 27))
        self.pushButton.setObjectName("pushButton")
        self.lineEdit = QtGui.QLineEdit(self.centralwidget)
        self.lineEdit.setGeometry(QtCore.QRect(80, 240, 261, 31))
        self.lineEdit.setObjectName("lineEdit")
        self.pushButton_2 = QtGui.QPushButton(self.centralwidget)
        self.pushButton_2.setGeometry(QtCore.QRect(560, 280, 98, 27))
        self.pushButton_2.setObjectName("pushButton_2")
        self.lineEdit_2 = QtGui.QLineEdit(self.centralwidget)
        self.lineEdit_2.setGeometry(QtCore.QRect(400, 240, 261, 31))
        self.lineEdit_2.setObjectName("lineEdit_2")
        self.plainTextEdit = QtGui.QPlainTextEdit(self.centralwidget)
        self.plainTextEdit.setEnabled(True)
        self.plainTextEdit.setGeometry(QtCore.QRect(80, 40, 261, 191))
        self.plainTextEdit.setPlainText("")
        self.plainTextEdit.setObjectName("plainTextEdit")
        self.plainTextEdit_2 = QtGui.QPlainTextEdit(self.centralwidget)
        self.plainTextEdit_2.setGeometry(QtCore.QRect(80, 330, 261, 181))
        self.plainTextEdit_2.setObjectName("plainTextEdit_2")
        self.plainTextEdit_3 = QtGui.QPlainTextEdit(self.centralwidget)
        self.plainTextEdit_3.setGeometry(QtCore.QRect(400, 40, 261, 191))
        self.plainTextEdit_3.setObjectName("plainTextEdit_3")
        self.plainTextEdit_4 = QtGui.QPlainTextEdit(self.centralwidget)
        self.plainTextEdit_4.setGeometry(QtCore.QRect(400, 330, 261, 181))
        self.plainTextEdit_4.setObjectName("plainTextEdit_4")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtGui.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 748, 25))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtGui.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL("clicked()"), lambda o=1, d=2: self.__enviarPacote(o, d))
        QtCore.QObject.connect(self.pushButton_2, QtCore.SIGNAL("clicked()"),lambda o=2, d=1: self.__enviarPacote(o, d))
        QtCore.QMetaObject.connectSlotsByName(MainWindow)
        
        self.__configurarLog()

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QtGui.QApplication.translate("MainWindow", "Trabalho Pratico 4 - Implementacao de Camada de Transporte", None, QtGui.QApplication.UnicodeUTF8))
        self.pushButton.setText(QtGui.QApplication.translate("MainWindow", "Enviar", None, QtGui.QApplication.UnicodeUTF8))
        self.pushButton_2.setText(QtGui.QApplication.translate("MainWindow", "Enviar", None, QtGui.QApplication.UnicodeUTF8))
    
    def iniciarConexao(self):
        self.camAplicOrigem.aplicacao = self
        self.camAplicDestino.aplicacao = self
        self.camAplicOrigem.conectar(self.camAplicDestino.id)
        
    def __enviarPacote(self, origem, destino):
        if origem == self.idOrigem and destino == self.idDestino:
            self.camAplicOrigem.enviarMensagem(str(self.lineEdit.text()))
        elif origem == self.idDestino and destino == self.idOrigem:
            self.camAplicDestino.enviarMensagem(str(self.lineEdit_2.text()))
    
    def receberMensagem(self, s, id):
        if id == self.idOrigem:
            self.plainTextEdit.appendPlainText(unicode(s))
        elif id == self.idDestino:
            self.plainTextEdit_3.appendPlainText(unicode(s))
            
    def __configurarLog(self):
        logOrigem = logging.StreamHandler(AdaptadorStreamLogQt(self.plainTextEdit_2))
        logOrigem.setLevel(logging.INFO)
        logDestino = logging.StreamHandler(AdaptadorStreamLogQt(self.plainTextEdit_4))
        logDestino.setLevel(logging.INFO)
        
        self.camAplicOrigem.log.addHandler(logOrigem)
        self.camAplicDestino.log.addHandler(logDestino)
        
class AdaptadorStreamLogQt(object):
    def __init__(self, campo):
        self.campo = campo
    
    def write(self, entrada):
        self.campo.appendPlainText(unicode(entrada[:-1]))
    
    def flush(self):
        pass