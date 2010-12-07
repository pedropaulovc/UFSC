-- INE5416 - PARADIGMAS DE PROGRAMACAO
-- ALUNO: PEDRO PAULO VEZZA CAMPOS - 09132033
-- PROJETO FINAL 1: AREA E VOLUME DE SOLIDOS

module Main  ( Solido ( Esfera, Cilindro, Cone, TroncoCone, EsferoideOblato, EsferoideProlato),
				 Raio, Altura, SemiEixo,
				 excentricidade
				) where
import IO
import System.Exit

data Solido = Esfera Raio
			| Cilindro Raio Altura
			| Cone Raio Altura
			| TroncoCone Raio Raio Altura
			| EsferoideOblato SemiEixo SemiEixo
			| EsferoideProlato SemiEixo SemiEixo
	 deriving Show
type Raio = Float
type Altura = Float
type SemiEixo = Float

-----------------------------------------------------
---------------- main e interface -------------------
-----------------------------------------------------

main :: IO ()
main = entrada
entrada = do
 	putStrLn "\nDigite a opcao desejada:"
	putStrLn"1) Calcular area e volume de uma esfera."
	putStrLn"2) Calcular a area lateral, total e volume de um cilindro."
	putStrLn"3) Calcular a area lateral, total e volume de um cone."
	putStrLn"4) Calcular a area lateral, total e volume de um tronco de cone."
	putStrLn"5) Calcular a area e volume de um esferoide oblato."
	putStrLn"6) Calcular a area e volume de um esferoide prolato."
	putStrLn"7) Encerrar."
	x<-getLine 
	case x of 
		'1': _ -> do	print("Digite o raio da esfera.")
				raio<-getLine
				print("Area = "++show(areaTotal (Esfera(read raio))))
				print("Volume = "++show(volume (Esfera(read raio))))
				entrada	
	
		'2': _ -> do	print("Digite o raio do cilindro.")
				raio<-getLine
				print("Digite a altura do cilindro.")
				altura<-getLine
				print("Area lateral = "++show(areaLateral (Cilindro (read raio) (read altura))))
				print("Area total = "++show(areaTotal (Cilindro(read raio) (read altura))))
				print("Volume = "++show(volume (Cilindro (read raio)(read altura))))
				entrada	

		'3': _ -> do	print("Digite o raio do cone.")
				raio<-getLine
				print("Digite a altura do cone.")
				altura<-getLine
				print("Area lateral = "++show(areaLateral (Cone(read raio)(read altura))))
				print("Area total = "++show(areaTotal (Cone(read raio)(read altura))))
				print("Volume = "++show(volume (Cone(read raio)(read altura))))
				entrada	

		'4': _ -> do	print("Digite o raio menor do tronco de cone.")
				raioMenor<-getLine
				print("Digite o raio maior do tronco de cone.")
				raioMaior<-getLine
				print("Digite a altura do tronco de cone.")
				altura<-getLine
				print("Area lateral = "++show(areaLateral (TroncoCone(read raioMenor) (read raioMaior) (read altura))))
				print("Area total = "++show(areaTotal (TroncoCone(read raioMenor) (read raioMaior) (read altura))))
				print("Volume = "++show(volume (TroncoCone(read raioMenor) (read raioMaior) (read altura))))
				entrada

		'5': _ -> do	print("Digite o valor do semi-eixo menor.")
				semiMenor<-getLine
				print("Digite o valor do semi-eixo maior.")
				semiMaior<-getLine
				print("Area = "++show(areaTotal (EsferoideOblato(read semiMenor)(read semiMaior))))
				print("Volume = "++show(volume (EsferoideOblato(read semiMenor)(read semiMaior))))
				entrada	

		'6': _ -> do	print("Digite o valor do semi-eixo menor.")
				semiMenor<-getLine
				print("Digite o valor do semi-eixo maior.")
				semiMaior<-getLine
				print("Area = "++show(areaTotal (EsferoideProlato(read semiMenor)(read semiMaior))))
				print("Volume = "++show(volume (EsferoideProlato(read semiMenor)(read semiMaior))))
				entrada	

		'7' : _ -> do	exitSuccess
		_: _ -> do	print("Opcao invalida")			

-----------------------------------------------------
---------------- código da aplicacao ----------------
-----------------------------------------------------

excentricidade :: Float -> Float -> Float
excentricidade a b = (sqrt(a*a - b*b))/a

areaTotal ::  Solido -> Float
areaTotal (Esfera r) = 4 * pi * r * r
areaTotal (Cilindro r h) = (2 * pi * r * h) + (2 * pi * r * r)
areaTotal (Cone r h) = pi * r * ((sqrt r * r + h * h) + r )
areaTotal (TroncoCone rMenor rMaior h) = pi * rMenor * rMenor + pi * rMaior * rMaior + pi * (rMenor + rMaior)*(sqrt h * h + rMenor * rMenor + rMaior * rMaior -2 * rMenor * rMaior)
areaTotal (EsferoideOblato seMenor seMaior) = let e = excentricidade seMaior seMenor
			      							  in 2 * pi * seMenor * seMenor + pi * ((seMaior * seMaior)/e) * (log (1 + e)/(1 - e))

areaTotal (EsferoideProlato seMenor seMaior) = let e = excentricidade seMaior seMenor
			      							   in 2 * pi * seMaior * seMaior + 2 * pi * (seMenor * seMaior/e) * (asin e)

areaLateral :: Solido -> Float
areaLateral (Cilindro r h) = 2 * pi * r * h
areaLateral (Cone r h) = pi * r * (sqrt r * r + h * h)
areaLateral (TroncoCone rMenor rMaior h) = pi * (rMenor + rMaior)*(sqrt h * h + rMenor * rMenor + rMaior * rMaior - 2 * rMenor * rMaior)

volume :: Solido -> Float
volume (Esfera r) = (4/3) * pi * r * r * r
volume (Cilindro h r) = pi * r * r * h
volume (Cone h r) = (1/3) * pi * r * r * h
volume (TroncoCone rMenor rMaior h) = (1/3) * pi * h * (rMenor * rMenor + rMaior * rMaior + rMenor * rMaior)
volume (EsferoideOblato seMenor seMaior) = (4/3) * pi * seMenor * seMenor *seMaior
volume (EsferoideProlato seMenor seMaior) = (4/3) * pi * seMenor * seMaior * seMaior

