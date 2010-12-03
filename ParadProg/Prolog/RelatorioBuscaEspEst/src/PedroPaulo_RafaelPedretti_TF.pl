% INE5416 - PARADIGMAS DE PROGRAMACAO
% ALUNOS: PEDRO PAULO VEZZA CAMPOS - 09132033 E RAFAEL ELIAS PEDRETTI - 09132035
% TRABALHO FINAL: IMPLEMENTACAO DE BUSCA EM ESPACO DE ESTADO - PROBLEMA DA OVELHA, LOBO E ALFACE

% operacao: inicial
% especificacao: retorna o estado inicial da busca em espaco de estados
% argumento: o estado inicial
inicial(X):- X = [[],[barco,ovelha, lobo, alface]].

% operacao: final
% especificacao: retorna o estado final da busca em espaco de estados
% argumento: o estado final
final(X):- X = [[barco,ovelha, lobo, alface],[]].

% operacao: moveBarco
% especificacao: retorna o novo estado gerado apos a troca do barco (sem nenhuma compra)
% de margem dado que nem o lobo e a ovelha nem a alface e a ovelha fiquem sozinhos
% 1o. argumento: o estado atual
% 2o. argumento: o proximo estado com o barco na outra margem
moveBarco([D,E],[Dn,En]):- \+mesmaMargem(lobo,ovelha,D), \+mesmaMargem(alface,ovelha,D),
                           membro(barco,D),troca(barco,D,E,Dn,En).

moveBarco([D,E],[Dn,En]):- \+mesmaMargem(lobo,ovelha,E), \+mesmaMargem(alface,ovelha,E),
                           membro(barco,E),troca(barco,E,D,En,Dn).

% operacao: moveOvelha
% especificacao: retorna o novo estado gerado apos a troca do barco e da ovelha de margem
% 1o. argumento: o estado atual
% 2o. argumento: o proximo estado com o barco e a ovelha na outra margem
moveOvelha([D,E],[Dn,En]):- membro(ovelha,D), membro(barco,D), troca(ovelha,D,E,Dni,Eni),
                            moveBarco([Dni,Eni],[Dn,En]).

moveOvelha([D,E],[Dn,En]):- membro(ovelha,E), membro(barco,E), troca(ovelha,E,D,Eni,Dni),
                            moveBarco([Dni,Eni],[Dn,En]).

% operacao: moveAlface
% especificacao: retorna o novo estado gerado apos a troca do barco e da alface de margem dado
% que o lobo e a ovelha nao fiquem sozinhos 
% 1o. argumento: o estado atual
% 2o. argumento: o proximo estado com o barco e a alface na outra margem
moveAlface([D,E],[Dn,En]):- membro(alface,D), membro(barco,D),
                            \+mesmaMargem(lobo,ovelha,D), troca(alface,D,E,Dni,Eni),
                            moveBarco([Dni,Eni],[Dn,En]).

moveAlface([D,E],[Dn,En]):- membro(alface,E), membro(barco,E),
                            \+mesmaMargem(lobo,ovelha,E), troca(alface,E,D,Eni,Dni),
                            moveBarco([Dni,Eni],[Dn,En]).

% operacao: moveLobo
% especificacao: retorna o novo estado gerado apos a troca do barco e do lobo de margem dado
% que a ovelha e a alface nao fiquem sozinhos 
% 1o. argumento: o estado atual
% 2o. argumento: o proximo estado com o barco e o lobo na outra margem
moveLobo([D,E],[Dn,En]):- membro(lobo,D), membro(barco,D),
                          \+mesmaMargem(alface,ovelha,D), troca(lobo,D,E,Dni,Eni),
                          moveBarco([Dni,Eni],[Dn,En]).

moveLobo([D,E],[Dn,En]):- membro(lobo,E), membro(barco,E),
                          \+mesmaMargem(alface,ovelha,E), troca(lobo,E,D,Eni,Dni),
                          moveBarco([Dni,Eni],[Dn,En]).

% operacao: resolve
% especificacao: metodo principal da resolucao do problema. Inicia a busca em profundidade a
% partir do estado inicial e exibe a solucao encontrada em ordem
resolve:- inicial(X),profundidade([], X, Solucao), mostraSolOrdem(Solucao).

% operacao: profundidade
% especificacao: executa uma busca em profundidade ate que a clausula objetivo/1 retorne verdade ou
% esgote os espaco de solucoes. Retorna os estados percorridos da origem fornecida no 2o argumento
% ate a solucao
% 1o. argumento: os estados ja visitados anteriormente
% 2o. argumento: o estado atual da busca em profundidade
% 3o. argumento: a solucao encontrada pela busca em profundidade
profundidade(Caminho, Atual, [Atual | Caminho]) :- objetivo(Atual).
profundidade(Caminho, Atual, Solucao) :- sucessor(Atual, Sucessor), \+membro(Sucessor, Caminho),
                                         profundidade([Atual | Caminho], Sucessor, Solucao).

% operacao: objetivo
% especificacao: retorna verdadeiro se a busca em profundidade atingiu o estado final e suspende o
% backtracking 
% argumento: retorna o estado final da busca em espaco de estados
objetivo(N):- final(N),!.

% operacao: sucessor
% especificacao: clausula geradora de proximo estado. Tenta mover um dos itens: ovelha + barco,
% alface + barco, lobo + barco, somente barco
% 1o. argumento: estado atual
% 2o. argumento: proximo estado gerado
sucessor(Atual,Sucessor):- moveOvelha(Atual,Sucessor);moveAlface(Atual,Sucessor);
                           moveLobo(Atual,Sucessor); moveBarco(Atual,Sucessor).

% operacao: mesmaMargem
% especificacao: retorna verdadeiro se os dois itens fornecidos estao em uma mesma margem
% 1o. argumento: primeiro item a ser verificado
% 2o. argumento: segundo item a ser verificado
% 3o. argumento: o estado representando as margens do rio
mesmaMargem(Coisa1,Coisa2,Margem):- membro(Coisa1,Margem), membro(Coisa2,Margem).

% operacao: mostraSolucao
% especificacao: exibe cada um dos estados da solucao final um por linha
% argumento: a solucao a ser exibida
mostraSolucao([H|[]]):- write(H), nl.
mostraSolucao([H|T]):- write(H), nl, mostraSolucao(T).

% operacao: mostraSolOrdem
% especificacao: inverte a lista de estados da solucao e a exibe na tela
% argumento: a lista de estados a ser exibida
mostraSolOrdem(L):- inverte(L,Ln), mostraSolucao(Ln).


% operacao: troca
% especificacao: remove um item dado de uma lista e insere no inicio de outra
% 1o. argumento: item a ser trocado de lista
% 2o. argumento: lista de origem
% 3o. argumento: lista de destino
% 4o. argumento: nova lista de origem sem o elemento trocado
% 5o. argumento: nova lista de destino com o elemento trocado
% exemplo: troca(a, [a,b,c], [d,e,f], [b,c], [a,d,e,f]).

troca(_, [], [], D, D).
troca(E, [E|T], D, T, Dn) :- insereNoInicio(E, D, Dn).
troca(E, [H|T], D, On, Dn) :- troca(E, T, D, On2, Dn), insereNoInicio(H, On2, On).

% operacao: inverte
% especificacao: inverte os elementos de uma lista
% 1o. argumento: lista
% 2o. argumento: lista invertida
inverte([],[]).
inverte([H|T],I) :- inverte(T, R), concat(R, [H], I).

% operacao: membro
% especificacao: verifica se um termo eh membro de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
membro(X,[X|_]).
membro(X,[_|Y]):- membro(X,Y).

% operacao: concat
% especificacao: concatena 2 listas
% 1o. argumento: 1o. lista
% 2o. argumento: 2o. lista 
% 3o. argumento: lista concatenada
concat(X, [], X).
concat([], X, X).
concat([H|T], Y, C) :- concat(T, Y, C1), cons(H, C1, C).

% operacao: insereNoInicio
% especificacao: insere um termo no inicio de uma lista
% 1o. argumento: termo
% 2o. argumento: lista
% 3o. argumento: lista com o termo inserido
insereNoInicio(X, L, I) :- concat([X], L, I).

% operacao: cons
% especificacao: retorna uma lista
% 1o. argumento: cabeca da lista
% 2o. argumento: cauda da lista
% 3o. argumento: a lista construida  
cons(H, T, L) :- L = [H|T].
