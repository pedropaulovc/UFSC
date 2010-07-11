#!/bin/bash

# Script criado para facilitar o trabalho de criar o arquivo .dat
# Motivacao: dificuldade de trabalhar com strings em c++ por causa
#            da codificacao dos caracteres dos arquivos .txt
 

IFS='\n'
arquivoDat="portarias.dat"


# Para cada arquivo na pasta atual
for file in *
do
	# Se o arquivo for .txt
    if echo "$file" | grep ".txt" > /dev/null
    then
    	# Se o arquivo estiver com a codificação padrão, mudar para UTF-8
		if file "$file" | grep "ISO-8859" > /dev/null
		then
	    	iconv --from-code=ISO-8859-15 --to-code=UTF-8 "$file" >> temp && mv temp "$file"
		fi

	#remove o .txt do nome do arquivo
	nomeReal=$(echo "$file" | sed s/"\.txt"/""/)
	
	echo -n "$nomeReal|" >> "$arquivoDat"

	# faz as transformacoes necessarias no texto
    cat "$file" | sed -n -e "/PORTARIAS/,$"p | \
                      sed -e s/'PORTARIAS'/''/ \
                          -e s/"[áÁàÀâÂãÃ]"/"a"/g \
                          -e s/"[éÉêÊ]"/"e"/g \
                          -e s/"[íÍ]"/"i"/g \
                          -e s/"[óÓôÔõÕ]"/"o"/g \
                          -e s/"[úÚüÜ]"/"u"/g \
                          -e s/"[çÇ]"/"c"/g \
	                  -e s/"\&quot;"/"\""/g | \
	tr [:lower:] [:upper:] | tr [:space:] ' ' >> "$arquivoDat"
	echo -ne "|\n" >> "$arquivoDat"
   fi
done

#imprime o numero de entradas na primeira linha do arquivo

numeroLinhas=$(wc -l "$arquivoDat" | sed s/"[^0-9]"/""/g)
sed 1i\ "$numeroLinhas" "$arquivoDat" > temp && mv temp "$arquivoDat"



