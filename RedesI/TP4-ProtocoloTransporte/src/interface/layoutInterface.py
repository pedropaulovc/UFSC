# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'interface.ui'
#
# Created: Wed Nov 17 22:31:08 2010
#      by: PyQt4 UI code generator 4.7.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui

class Ui_MainWindow(object):
    def __init__(self, camAplicOrigem, camAplicDestino):
        self.camAplicOrigem = camAplicOrigem
        self.camAplicDestino = camAplicDestino
        self.idOrigem = camAplicOrigem.id
        self.idDestino = camAplicDestino.id
        
        self.__iniciarConexao()
    
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

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QtGui.QApplication.translate("MainWindow", "MainWindow", None, QtGui.QApplication.UnicodeUTF8))
        self.pushButton.setText(QtGui.QApplication.translate("MainWindow", "Enviar", None, QtGui.QApplication.UnicodeUTF8))
        self.pushButton_2.setText(QtGui.QApplication.translate("MainWindow", "Enviar", None, QtGui.QApplication.UnicodeUTF8))
    
    def __iniciarConexao(self):
        self.camAplicOrigem.conectar(self.camAplicDestino.id)
        
    def __enviarPacote(self, origem, destino):
        if origem == self.idOrigem and destino == self.idDestino:
            self.camAplicOrigem.enviarMensagem(str(self.lineEdit.text()))
        elif origem == self.idDestino and destino == self.idOrigem:
            self.camAplicOrigem.enviarMensagem(str(self.lineEdit_2.text()))
