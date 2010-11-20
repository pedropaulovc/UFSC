% A recursão é uma ferramenta poderosa e uma das mais usadas na liguagem Prolog. Desta forma, a definição de listas é bastante natural em Prolog. 
% Uma lista é uma sequencia de termos separados por "," e delimitados por "[" e "]".
% Exemplo: [], [a],[a,b,c]
% Internamente, uma lista é representada como uma estrutura em árvore.
%    /\ 
%   a  /\
%     b  /\
%       c  []
% 
% O último elemento de uma lista é sempre uma lista vazia.
%
% Notação PROLOG para listas [X|Y] - onde X é a cabeca da lista e Y a cauda
%
% Brinque no Prolog verificando se as unificações seguintes são possíveis
% ?- [ ] = X.
% ?- [a] = X.
% ?- [a,b] = [X].
% ?- [a,b] = [X,Y].
% ?- [a] = [X|Y].
% ?- [a,b] = [X|Y].
% ?- [a,b,c] = [X|Y]
%
% Contudo, a linguagem Prolog não operacoes sobre listas.
% Sendo assim...
% Defina as operacoes seguintes para trabalhar sobre listas em Prolog (para inspiracao algumas funcoes já estão definidas):


% operacao: cons
% especificacao: retorna uma lista
% 1o. argumento: cabeca da lista
% 2o. argumento: cauda da lista
% 3o. argumento: a lista construida   

cons(H, T, L) :- L = [H|T].

% operacao: lista
% especificacao: verifica se um termo eh uma lista
% argumento: termo

lista([]).
lista([_|L]):- lista(L).

% operacao: membro
% especificacao: verifica se um termo eh membro de uma lista
% 1o. argumento: termo
% 2o. argumento: lista

membro(X,[X|_]).
membro(X,[_|Y]):- membro(X,Y).

% operacao: remove
% especificacao: elimina o primeiro termo de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista resultado

remove(X,[X|Y],Y).
remove(X,[Y|L1],[Y|L2]):- remove(X,L1,L2).

% operacao: primeiro
% especificacao: verifica se um termo eh o primeiro elemento de uma lista
% 1o. argumento: termo
% 2o. argumento: lista

primeiro(X, [X|_]).

% operacao: segundo
% especificacao: verifica se um termo eh o segundo elemento de uma lista
% 1o. argumento: termo
% 2o. argumento: lista

segundo(X, [_,X|_]).

% operacao: ultimo
% especificacao: identifica o ultimo elemento de uma lista
% 1o. argumento: termo
% 2o. argumento: lista

ultimo(X, [X]).
ultimo(X, [_|T]) :- ultimo(X, T).

% operacao: consec
% especificacao: verifica se 2 termos sao consecutivos em uma lista
% 1o. argumento: 1o. termo
% 2o. argumento: 2o. termo
% 3o. argumento: lista

consec(X, Y, [X,Y|_]).
consec(X, Y, [_|T]) :- consec(X, Y, T).

% operacao: concat
% especificacao: concatena 2 listas
% 1o. argumento: 1o. lista
% 2o. argumento: 2o. lista 
% 3o. argumento: lista concatenada

concat(X, [], X).
concat([], X, X).
concat([H|T], Y, C) :- concat(T, Y, C1), cons(H, C1, C).

% operacao: inverte
% especificacao: inverte os elementos de uma lista
% 1o. argumento: lista
% 2o. argumento: lista invertida

inverte([],[]).
inverte([H|T],I) :- inverte(T, R), concat(R, [H], I).

% operacao: tamanho
% especificacao: retorna o numero de elementos em uma lista
% 1o. argumento: lista
% 2o. argumento: numero de elementos 

tamanho([], 0).
tamanho([_|T], N) :- tamanho(T, E), N is 1 + E.

% operacao: posicao
% especificacao: retorna a posicao de um termo na lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: posicao (se o termo nao esta na lista posicao = 0)

posicao(_, [] , 0).
posicao(X, [H|T], P) :- X = H, P is 1; posicao(X, T, Q), Q =\= 0, P is 1 + Q; P is 0.

% operacao: insereNoInicio
% especificacao: insere um termo no inicio de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista com o termo inserido

insereNoInicio(X, L, I) :- concat([X], L, I).

% operacao: insereNoFinal
% especificacao: insere um termo no final de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista com o termo inserido

insereNoFinal(X, L, I) :- concat(L, [X], I).

% operacao: insereNaPos
% especificacao: insere um termo em uma posicao determinada na lista
% 1o. argumento: termo
% 2o. argumento: posicao
% 3o. argumento: lista
% 4o. argumento: lista com o termo inserido

insereNaPos(X, 1, L, I) :- insereNoInicio(X, L, I).
insereNaPos(X, P, [H|T], I) :- Q is P - 1, insereNaPos(X, Q, T, J), insereNoInicio(H, J, I).


% operacao: removeDoInicio
% especificacao: remove um termo do inicio de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista com o termo removido

removeDoInicio(X, [X|T], T).

% operacao: removeDoFinal
% especificacao: remove um termo do final de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista com o termo removido

removeDoFinal(X, [X], []).
removeDoFinal(X, [_|T], R) :- removeDoFinal(X, T, R).

% operacao: removeDaPos
% especificacao: remove um termo de uma posicao determinada na lista
% 1o. argumento: termo
% 2o. argumento: posicao
% 3o. argumento: lista
% 4o. argumento: lista com o termo inserido

removeDaPos(X, 1, L, R) :- removeDoInicio(X, L, R).
removeDaPos(X, P, [H|T], R) :- Q is P - 1, removeDaPos(X, Q, T, S), insereNoInicio(H, S, R).

% operacao: homogeneizar
% especificacao: dada uma lista do tipo [a, [b, c], [d, [e, f]]] retorna [a, b, c, d, e, f]
% 1o. argumento: lista heterogenea
% 2o. argumento: lista homogeneizada

homogeneizar([], []).
homogeneizar([C|R], H) :- (lista(C), homogeneizar(C, Ch); Ch = [C]), homogeneizar(R, Rh), concat(Ch, Rh, H).

