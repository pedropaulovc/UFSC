#!/bin/bash

IFS='\n'
arquivoDat="portarias.dat"

for file in *
do
    if echo "$file" | grep ".txt" > /dev/null
    then
	if file "$file" | grep "ISO-8859" > /dev/null
	then
	    iconv --from-code=ISO-8859-15 --to-code=UTF-8 "$file" >> temp && mv temp "$file"
	fi

	nomeReal=$(echo "$file" | sed s/"\.txt"/""/)
	echo -n "$nomeReal|" >> "$arquivoDat"

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

numeroLinhas=$(wc -l "$arquivoDat" | sed s/"[^0-9]"/""/g)
sed 1i\ "$numeroLinhas" "$arquivoDat" > temp && mv temp "$arquivoDat"



