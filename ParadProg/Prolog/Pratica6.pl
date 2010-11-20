% Pratica 6 - Banco de Dados em Prolog
% aplicação de Listas
%
%Considere a seguinte BD sobre clientes de stands de automóveis:
%  Stand       Nome    NºCliente Idade    Profissão    Compras
%                     
%  Vegas       Rui     2324      23       Médico       Carro Audi A2 por 20000 euros
%                                                      Carro BMW Serie3 por 30000 euros
%
%  Vegas       Rita    2325      32       Advogado     Carro Audi A3 por 30000 euros
%
%  Vegas       João    2326      26       Professor    Moto Honda GL1800 por 26000 eur.
%
%  Vegas       Ana     2327      49       Médico       Carro Audi A4 por 40000 euros
%                                                      Carro BMW Serie3 por 32000 euros
%                                                      Carro Ford Focus por 24000 euros
%
%  Miami       Rui     3333      33       Operário     Carro Fiat Panda por 12000 euros
%
%  Miami       Paulo   3334      22       Advogado     Carro Audi A4 por 36000 euros
%
%  Miami       Pedro   3335      46       Advogado     Carro Honda Accord por 32000 eur.
%                                                       Carro Audi A2 por 20000 euros
%
% 1) Registe em Prolog todos os dados relevantes da BD, utilizando predicados com a notação: 
%              
%                         stand(nome_stand,LC).
%
% onde LC é uma lista de clientes do tipo:
%
%             [cliente(nome,num,id,prof,C1),cliente(nome2,num2,id2,prof2,C2),...]
%
% onde C1, C2 são listas de compras do tipo:
%
%              [carro(marca1,modelo1,preco1), moto(marca2,modelo2,preco2),...]
%


%Fatos
:-dynamic(stand/2).

stand(vegas, [cliente(rui, 2324, 23, medico, [carro(audi, a2, 20000), carro(bmw, serie3, 30000)]), 
			  cliente(rita, 2325, 32, advogado, [carro(audi, a3, 30000)]),
			  cliente(joao, 2326, 26, professor, [moto(honda, gl1800, 26000)]),
			  cliente(ana, 2327, 49, medico, [carro(audi, a4, 40000), carro(bmw, serie3, 32000), carro(ford, focus, 24000)])]).

stand(miami, [cliente(rui, 3333, 33, operario, [carro(fiat, panda, 12000)]),
			  cliente(paulo, 3334, 22, advogado, [carro(audi, a4, 36000)]),
			  cliente(pedro, 3335, 46, advogado, [carro(honda, accord, 32000), carro(audi, a2, 20000)])]).


% 2) Defina em Prolog os seguintes predicados:
%
%     a) listar_clientes(X,LC) ­ devolve a lista LC com o nome de todos clientes do stand X;
%
%     b) listar_dados(X,C,D) ­ devolve a lista D com todos dados (i.e.: numero, idade e profissão) do cliente com o nome C do stand X;
%
%     c) listar_carros(X,LM) ­ devolve a lista LM com o nome de todas as marcas de carros vendidos pelo stand X.
%     d) listar_advogados(LA):- devolve a lista LA com o nome de todos os advogados de todos os stands;
%
%     e) preco_medio(X,Med) - devolve o preço médio (Med) de todos os carros vendidos por um stand. Dica: implemente um predicado "media(X,L)" onde X é o valor médio da soma dos elementos da lista L.
%
%     f) altera_id(X,C,Id) ­ altera a idade do cliente C do stand X para Id. 
%        Nota: pesquise no manual do prolog os predicados assert e retract.
%     
% Implemente predicados para nivelar uma lista e para remover elementos repetidos:
%
% nivela(L1,L2) ­ remove todos os [] extra de L1, devolvendo o resultado em L2;
%   
% eliminaRepetido(L1,L2) ­ remove elementos repetidos de L1, devolvendo L2;
% Exemplos: nivela([[1],[2,3]],[1,2,3]) e eliminaRepetido([1,2,2,3],[1,2,3]) retornam verdade.
%

listar_clientes(X, LC) :- stand(X, L), findall(C, member(cliente(C, _, _, _, _), L), LC).

listar_dados(X,C,D) :- stand(X, L), findall([N, I, P], member(cliente(C, N, I, P, _), L), Dt), acomoda(Dt, D).

listar_carros(X,LM) :- stand(X, L), findall(C, member(cliente(_, _, _, _, C), L), Lc), acomoda(Lc, Lca),
					   findall(C, member(carro(C, _, _), Lca), Lmr), eliminaRepetido(Lmr, LM).

listar_advogados(LA) :- stand(vegas, Lv), stand(miami, Lm),
						findall(A, member(cliente(A, _, _, advogado, _), Lv), Lav),
						findall(B, member(cliente(B, _, _, advogado, _), Lm), Lam),
						concat(Lav, Lam, LA).

preco_medio(X, Med) :- stand(X, L), findall(C, member(cliente(_, _, _, _, C), L), Lc), acomoda(Lc, Lca),
					   findall(P, member(carro(_, _, P), Lca), Lp),
					   media(Med, Lp).

altera_id(X,C,Id) :- stand(X, L),
					 posicao(cliente(C, N, _, P, V), L, Pos),
					 removeDaPos(_, Pos, L, Lcn),
					 insereNoInicio(cliente(C, N, Id, P, V), Lcn, LcN),
					 assertz(stand(X, LcN)),
					 retract(stand(X, L)).

soma_elementos(0, []).
soma_elementos(S, [H|T]) :- soma_elementos(St, T), S is H + St.

media(X, L) :- soma_elementos(S, L), tamanho(L, T), X is S / T.

acomoda([],[]).
acomoda(X,[X]):- \+lista(X).
acomoda([H|T],L):- lista(H), (acomoda(H,L1), acomoda(T,L2), concat(L1,L2,L)); acomoda(T,L2), cons(H,L2,L).

eliminaRepetido([],[]).
eliminaRepetido([H1|T1],[H1|L2]) :- \+ membro(H1, T1), eliminaRepetido(T1, L2).
eliminaRepetido([H1|T1],L2) :- membro(H1, T1), eliminaRepetido(T1, L2).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%% Predicados Prática 5 %%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
membro(X,[X|_]).
membro(X,[_|Y]):- membro(X,Y).

concat([],[],[]).
concat(X, [], X).
concat([], X, X).
concat([H|T], Y, C) :- concat(T, Y, C1), cons(H, C1, C).

insereNoInicio(X, L, I) :- concat([X], L, I).

cons(H, T, L) :- L = [H|T].

lista([]).
lista([_|L]):- lista(L).

tamanho([], 0).
tamanho([_|T], N) :- tamanho(T, E), N is 1 + E.

posicao(_, [] , 0).
posicao(X, [H|T], P) :- X = H, P is 1; posicao(X, T, Q), Q =\= 0, P is 1 + Q; P is 0.

removeDoInicio(X, [X|T], T).

removeDaPos(X, 1, L, R) :- removeDoInicio(X, L, R).
removeDaPos(X, P, [H|T], R) :- Q is P - 1, removeDaPos(X, Q, T, S), insereNoInicio(H, S, R).
