# ----------------------------------------------------------
# Arquivo de comandos GnuPlot para a plotagem da curva de 
# Complexidade de Tempo da Árvore AVL
#
# ----------------------------------------------------------
set title "Plot de Complexidade da Árvore AVL"
#
#Seta tamanho da janela automaticamente de acordo com os dados
set autoscale

set data style linespoints

set xlabel "Quantidade de CEPs Armazenados"
set ylabel "Tempo (s)"
#
#Seta posicao em coordenadas dos dados, onde vao aparecer os titulos
#Ist voce DEVE adaptar aos seus dados
set key 4000, 140
#
#Seta grade
set grid
#
# Le arquivos e plota dados
plot \
        "analise/out.txt" title "Tempos Árvore AVL" w linespoints 3
#
# Para que voce possa chamar o gnuplot diretamente de dentro de seu 
# programa em C usando o comando system(). Se voce nao colocar uma
# pausa no final de seu plot, a janela fecha imediatamente apos 
# ter sido desenhada.
pause -1 "Tecle enter para sair..."
