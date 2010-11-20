%Operadores relacionais
% X = Y		X e Y s�o iguais;
% X \= Y	X e Y s�o diferentes;
% X < Y		X � menor que Y;
% X > Y		X � maior que Y;
% X =< Y	X � menor ou igual a Y;
% X >= Y	X � maior ou igual a Y.
% X =:= Y	X e Y s�o iguais (p/ n�meros);
% X =\= Y	X e Y s�o diferentes (p/ n�meros).

%Operadores aritm�ticos
% X + Y		soma de X e Y;
% X - Y		diferen�a de X e Y;
% X * Y		multiplica��o de X por Y;
% X / Y		divis�o de X por Y;
% X mod Y	resto da divis�o de X por Y.
%
%Atribui��o de valores num�ricos "is":
% ?- X is 10 + 2.
%
%Nega��o de predicados:
%\+ 		n�o

%Utilizando Operadores Relacionais, construa regras para:
% soma(X,Y,Z) - Z � o resultado da soma de X e Y.
% sub(X,Y,Z) - Z � o resultado da subtrac�o de X e Y.
% maior(X,Y,Z) - Z � o maior entre X e Y
% menor(X,Y,Z) - Z � o menor entre X e Y.
% impar (X) - retorna true caso X seja impar e false caso contr�rio.
% par (X) - retorna true caso X seja par e false caso contr�rio.
% 

%Respostas:
soma(X,Y,Z) :- Z is X + Y.
sub(X,Y,Z) :- Z is X - Y.
maior(X,Y,Z) :- ((X > Y), (Z is X)); ((X =< Y), (Z is Y)).
menor(X,Y,Z) :- ((X < Y), (Z is X)); ((X >= Y), (Z is Y)).
impar(X) :- (X mod 2) =:= 1.
par(X) :- (X mod 2) =:= 0.
