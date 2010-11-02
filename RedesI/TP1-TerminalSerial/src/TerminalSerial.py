# coding: utf-8
from serial import Serial
from threading import Thread
from Getch import getch
import sys

def main():
    """
    Função incial do programa. Invoca
    uma função que introduz o usuario ao
    programa e inicia a conexão.
    """
    exibirIntroducao()
    iniciarConexao()

def exibirIntroducao():
    """
    Exibe uma pequena introdução ao usuário do programa
    """
    
    print "INE5414 - REDES DE COMPUTADORES I"
    print "PEDRO PAULO VEZZÁ CAMPOS"
    print "TRABALHO PRÁTICO 1: INTERCONEXÃO DE COMPUTADORES USANDO RS-232\n"

def iniciarConexao():
    """
    Função principal do programa. Questiona o usuário das
    configurações desejadas, inicia a conexão com a porta
    serial definida e inicia duas threads: Uma responsável
    por ler os caracteres escritos pelo usuário e outra 
    responsável por escrever os caracteres recebidos do
    terminal remoto.
    """
    print "Forneça a porta serial a conexao utilizada: "
    porta = raw_input()
    if porta.startswith("CNC"):
        porta = "\\\\.\\" + porta

    print "Forneça a taxa de transferência (2400 bits/s): "
    taxa = geraValorDefault(raw_input(), 2400)
    
    print "Forneça o tamanho do byte (8 bits): "
    tamByte = geraValorDefault(raw_input(), 8)
    
    print "Forneça o número de stop bits (1 bit): "
    stopBits = geraValorDefault(raw_input(), 1)
    
    conexao = Serial(port=porta, baudrate=taxa, bytesize=tamByte, stopbits=stopBits)
    
    print "Conexão iniciada. Escreva sua mensagem, ela será exibida no outro terminal e vice-versa"
    Sender(conexao).start()
    Receiver(conexao).start()
    conexao.close
    
def geraValorDefault(valor, default):
    """
    Gera um inteiro parseado de valor se valor 
    é diferente de vazio senão retorna o valor
    passado em default.
    """
    if valor == "":
        valor = default
    else:
        valor = int(valor)
    return valor

class Sender(Thread):
    """
    Classe responsável por realizar um polling
    capturando uma letra por vez, exibindo-a 
    ao usuário e enviando-a via
    interface serial.
    """
    def __init__(self, conexao):
        Thread.__init__(self)
        self.conexao = conexao
        
    def run(self):
        while True:
            ch = getch()
            sys.stdout.write(ch)
            self.conexao.write(ch)

class Receiver(Thread):
    """
    Classe responsável por realizar um polling
    lendo uma letra por vez da interface serial
    e exibindo-a ao usuário.
    """
    def __init__(self, conexao):
        Thread.__init__(self)
        self.conexao = conexao
    
    def run(self):
        while True:
            sys.stdout.write(self.conexao.read())

if __name__ == "__main__":
    main()
