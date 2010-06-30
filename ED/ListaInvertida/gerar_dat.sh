#!/bin/bash

#echo "$files"

for file in *.txt;
do
   iconv --from-code=ISO-8859-15 --to-code=UTF-8 "$file" >> temp && mv temp "$file"
   cat "$file" | sed -n "/PORTARIA Nº/,$"p | sed s/".*\(PORTARIA Nº.*\)"/"\1"/ >> arquivo.dat
done;
