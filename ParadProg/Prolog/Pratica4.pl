%Pratica 4
% introdução de predicados extra e meta-logicos
%
% Alguns comandos extra-lógicos:
% ?- consult('base.pl'). -> compila e executa a base.pl. Usado dentro do gprolog. Permite "carregar" mais de uma base de conhecimento.
% ?- listing. -> lista a base de dados que está na memória do prolog.
%
% Comandos:
% - write('abc'). ou write(I). -> imprime o conteúdo entre ''s ou o valor da variável I.
% - read(X). -> lê um valor do teclado
%
%
% Programa Exemplo:
% o programa abaixo conta de 1 até 10. Para executá-lo chame no prolog o predicado conta.
% 
% 
% Dependência: Pratica3.pl deve estar no mesmo diretório que este arquivo.
% 
% Execução: Utilizar a clausula "executa" 
% 
conta :- conta(1,10).

conta(A,B) :- A =< B,
              (write(A), write(' '),
              A1 is A + 1,
              conta(A1, B));
              nl.

imprime_intro :- write('INE5416 - PARADIGMAS DE PROGRAMACAO'), nl,
                 write('ALUNO: PEDRO PAULO VEZZA CAMPOS'), nl,
                 write('PRATICA 4 - PREDICADOS EXTRA E META-LOGICOS'), nl, nl.

imprime_menu_principal :- write('Escolha uma opcao: '), nl,
                          write('Programa 1: Leitura e escrita de dados.'), nl,
                          write('Programa 2: Sequencia de numeros.'), nl,
                          write('Programa 3: Somatorio.'), nl,
                          write('Programa 4: Fatorial.'), nl.

executa :- consult('Pratica3.pl'),
           imprime_intro,
           imprime_menu_principal,
           read(X),
           escolhe_programa(X).

escolhe_programa(1) :- executa_1.
escolhe_programa(2) :- executa_2.
escolhe_programa(3) :- executa_3.
escolhe_programa(4) :- executa_4.

% Exercícios:
% 1- Crie um menu em prolog com as seguintes opcões:
% Opcão A - lê um valor X e retorna o valor lido.
% Opcão B - lê um valor X e retorna se ele é par ou impar.
% Opcão C - lê um valor X e um valor Y e retorna o resto do maior pelo menor
% Dica: tente usar as regras construidas na última aula.

imprime_menu :- write('Escolha uma opcao: '), nl,
                write('Opcao a - le um valor X e retorna o valor lido.'), nl,
                write('Opcao b - le um valor X e retorna se ele e par ou impar.'), nl,
                write('Opcao c - le um valor X e um valor Y e retorna o resto do maior pelo menor'), nl.

executa_1 :- imprime_menu,
             read(X),
             escolhe_opcao(X).

escolhe_opcao(a) :- opcao_a.
escolhe_opcao(b) :- opcao_b.
escolhe_opcao(c) :- opcao_c.

opcao_a :- write('Opcao a: Digite um valor: '), read(X), write(X).
opcao_b :- write('Opcao b: Digite um valor: '), read(X), par(X).
opcao_c :- write('Opcao c: Digite um valor: '), read(X), write('Digite outro valor: '), read(Y), maior(X,Y,G), menor(X,Y,P), D is G mod P, write(D).


% 2- Crie um programa prolog que lê 2 valores, verifica qual o menor e qual o maior e imprime os números do intervalo em ordem crescente. Dica: use o programa conta.

executa_2 :- write('Digite um valor: '), read(X),
             write('Digite outro valor: '), read(Y),
             maior(X,Y,G), menor(X,Y,P), conta(P, G).

% 3- Crie um programa prolog que leia um número N positivo e imprima na tela o somatório de 1 até N. Dica: o somatório de 1 é igual a 1.

executa_3 :- write('Digite um valor: '), read(X),
             write('Somatorio de 1 ate '), write(X), write(' = '),
             somatorio(X, S), write(S).

somatorio(N, S) :- N =< 1, S is 1;
                   N > 1, N1 is N - 1, somatorio(N1,SR), S is N + SR.

% 4- Implemente um programa para gerar o fatorial de um número.

executa_4 :- write('Digite um valor: '), read(X),
             write('Fatorial de '), write(X), write(' = '),
             fatorial(X, F), write(F).

fatorial(N, F) :- N =< 1, F is 1;
                  N > 1, N1 is N - 1, fatorial(N1,FR), F is N * FR.
