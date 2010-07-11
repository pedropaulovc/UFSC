#!/bin/bash

IFS='\n'

for file in *
do
    if echo "$file" | grep ".txt" > /dev/null
    then
	if file "$file" | grep "ISO-8859" > /dev/null
	then
	    iconv --from-code=ISO-8859-15 --to-code=UTF-8 "$file" >> temp && mv temp "$file"
	fi

        cat "$file" | sed -n -e "/PORTARIA Nº/,$"p | \
                      sed -e s/".*\(PORTARIA Nº.*\)"/"\1"/ \
                          -e s/"[áÁàÀâÂãÃ]"/"a"/g \
                          -e s/"[éÉêÊ]"/"e"/g \
                          -e s/"[íÍ]"/"i"/g \
                          -e s/"[óÓôÔõÕ]"/"o"/g \
                          -e s/"[úÚüÜ]"/"u"/g \
                          -e s/"[çÇ]"/"c"/g \
	                  -e s/"\&quot;"/"\""/g | \
	tr [:lower:] [:upper:] >> arquivo.dat
   fi
done


