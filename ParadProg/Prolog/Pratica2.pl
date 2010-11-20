% regiões da Bolívia 

regiao(planicie).
regiao(vales).
regiao(altiplano).

% cidades da Bolívia

cidade(cobija).
cidade(trinidad).
cidade(la_paz).
cidade(oruro).
cidade(santa_cruz).
cidade(sucre).
cidade(potosi).
cidade(tarija).
cidade(cochabamba).

% climas da Bolívia

clima(planicie,tropical).
clima(vales,temperado).
clima(altiplano,frio).

% altitudes das cidades 

altitude(cobija,240).
altitude(trinidad,250).
altitude(la_paz,3200).
altitude(oruro,4000).
altitude(santa_cruz,200).
altitude(sucre,2800).
altitude(potosi,3000).
altitude(tarija,2500).
altitude(cochabamba,2700).

% relação cidade - região 

localizacao(cobija,planicie).
localizacao(trinidad,planicie).
localizacao(la_paz,altiplano).
localizacao(oruro,altiplano).
localizacao(santa_cruz,planicie).
localizacao(sucre,vales).
localizacao(potosi,altiplano).
localizacao(tarija,vales).
localizacao(cochabamba,vales).

% relação cidade - tensão 

tensao(cobija,220).
tensao(trinidad,220).
tensao(la_paz,110).
tensao(oruro,220).
tensao(sucre,220).
tensao(santa_cruz,220).
tensao(potosi,220).
tensao(tarija,220).
tensao(cochabamba,220).

%Pratica 2

%1)Efetue consultas a base para responder:
%a)Quais são as cidades localizadas na região dos vales?
%b)Quais são as cidades localizadas acima de 2900 m?
%c)Quais são as cidades de clima temperado?
%d)Quais são as cidades com tensao 110 volts?


%1)Respostas:
%a)?- localizacao(X,vales).
%	X = sucre ? ;
%	X = tarija ? ;
%	X = cochabamba

%b)?- altitude(X,Y), (Y >= 2900)
%	X = la_paz
%	Y = 3200 ? ;
%	X = oruro
%	Y = 4000 ? ;
%	X = potosi
%	Y = 3000 ? ;

%c)?- clima(X, temperado), localizacao(Y, X).
%	X = vales
%	Y = sucre ? ;
%	X = vales
%	Y = tarija ? ;
%	X = vales
%	Y = cochabamba ? ;

%d)?- tensao(X, 110).
%	X = la_paz ? ;


%2)Crie novos predicados (na forma de regras) para facilitar as consultas acima.
%a)cidades_vales;
%b)cidades_altiplano;
%c)cidades_planicie;
%d)cidades_altas (acima de 2900m);
%e)cidades_baixas (abaixo de 500m);
%f)cidades_clima;
%g)cidades_110;
%h)cidades_220?


%2)Respostas:
cidades_vales(X) :- localizacao(X,vales).
cidades_altiplano(X) :- localizacao(X,altiplano).
cidades_planicie(X) :- localizacao(X,planicie).
cidades_altas(X) :- altitude(X,Y), (Y > 2900).
cidades_baixas(X) :- altitude(X,Y), (Y < 500).
cidades_clima(X,Y) :- localizacao(X,Z), clima(Z,Y).
cidades_110(X) :- tensao(X,110).
cidades_220(X) :- tensao(X,220).
