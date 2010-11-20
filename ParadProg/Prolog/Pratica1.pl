%Familia Silva

homem(lineu).
homem(tuco).
homem(agostinho).
homem(floriano).
mulher(nene).
mulher(bebeu).

progenitor(lineu, tuco).
progenitor(nene, tuco).
progenitor(nene, bebeu).
progenitor(lineu, bebeu).
progenitor(floariano, lineu).

casal(agostinho, bebeu).
casal(lineu, nene).

mae(X,Y):-progenitor(X,Y), mulher(X).
pai(X,Y):-progenitor(X,Y), homem(X).

proprogenitor(X,Y):-progenitor(X,Z), progenitor(Z,Y).
avo(X,Y):-proprogenitor(X,Y), homem(X).
avoh(X,Y):-proprogenitor(X,Y), mulher(X).

meioirmao(X,Y):-progenitor(Z,X), progenitor(Z,Y), homem(X), (X \= Y).
meiairma(X,Y):-progenitor(Z,X), progenitor(Z,Y), mulher(X), (X \= Y).

irmao(X,Y):-pai(P,X), pai(P,Y), mae(M,X), mae(M,Y), homem(X), (X \= Y).
irma(X,Y):-pai(P,X), pai(P,Y), mae(M,X), mae(M,Y), mulher(X), (X \= Y).
fratelo(X,Y):-pai(P,X), pai(P,Y), mae(M,X), mae(M,Y), (X \= Y).

cunhada(X,Y):-casal(Y,Z), irma(X,Z).
cunhado(X,Y):-casal(Y,Z), irmao(X,Z).

tio(T,S):-progenitor(P,S), irmao(T,P).
tia(T,S):-progenitor(P,S), irma(T,P).

neto(N,A):-proprogenitor(A,N), homem(N).
neta(N,A):-proprogenitor(A,N), mulher(N).

primo(X,Y):-progenitor(Z,X), progenitor(W,Y), fratelo(Z,W), (Z \= W), (X \= Y), homem(X).
prima(X,Y):-progenitor(Z,X), progenitor(W,Y), fratelo(Z,W), (Z \= W), (X \= Y), mulher(X).
