%Operadores relacionais
% X = Y		X e Y são iguais;
% X \= Y	X e Y são diferentes;
% X < Y		X é menor que Y;
% X > Y		X é maior que Y;
% X =< Y	X é menor ou igual a Y;
% X >= Y	X é maior ou igual a Y.
% X =:= Y	X e Y são iguais (p/ números);
% X =\= Y	X e Y são diferentes (p/ números).

%Operadores aritméticos
% X + Y		soma de X e Y;
% X - Y		diferença de X e Y;
% X * Y		multiplicação de X por Y;
% X / Y		divisão de X por Y;
% X mod Y	resto da divisão de X por Y.
%
%Atribuição de valores numéricos "is":
% ?- X is 10 + 2.
%
%Negação de predicados:
%\+ 		não

%Utilizando Operadores Relacionais, construa regras para:
% soma(X,Y,Z) - Z é o resultado da soma de X e Y.
% sub(X,Y,Z) - Z é o resultado da subtracão de X e Y.
% maior(X,Y,Z) - Z é o maior entre X e Y
% menor(X,Y,Z) - Z é o menor entre X e Y.
% impar (X) - retorna true caso X seja impar e false caso contrário.
% par (X) - retorna true caso X seja par e false caso contrário.
% 

%Respostas:
soma(X,Y,Z) :- Z is X + Y.
sub(X,Y,Z) :- Z is X - Y.
maior(X,Y,Z) :- ((X > Y), (Z is X)); ((X =< Y), (Z is Y)).
menor(X,Y,Z) :- ((X < Y), (Z is X)); ((X >= Y), (Z is Y)).
impar(X) :- (X mod 2) =:= 1.
par(X) :- (X mod 2) =:= 0.
