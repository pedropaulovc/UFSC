-- INE5416 - PARADIGMAS DE PROGRAMACAO
-- ALUNO: PEDRO PAULO VEZZA CAMPOS - 09132033
-- PROJETO FINAL 2: SERIES

module Main (somaInt, totalInt, somaImpares, totalImpares, somaPares, totalPares,
			  somaQuadrados, totalQuadrados, somaQuadradosImpares,
			  totalQuadradosImpares, quaseUm, quaseDois, fat, quaseE) where

import IO
import System.Exit

-----------------------------------------------------
---------------- main e interface -------------------
-----------------------------------------------------

main :: IO ()
main = entrada
entrada = do
 	putStrLn "Digite o numero da opcao desejada:"
	putStrLn "1) Para soma de uma lista de inteiros"
	putStrLn "2) Para soma de uma lista de inteiros impares"
	putStrLn "3) Para soma de uma lista de inteiros pares"
	putStrLn "4) Para soma de uma lista de quadrados de inteiros"
	putStrLn "5) Para soma de uma lista de quadrados de inteiros impares"
	putStrLn "6) Para soma infinita quase 1."
	putStrLn "7) Para soma infinita quase e."
	putStrLn "8) Para soma infinita quase 2."
	putStrLn "9) Para sair."
	x<-getLine 
	
	print("Digite o numero de elementos da lista.")
	elemento<-getLine

	case x of 
		'1': _ -> do			
				print("A soma de uma lista de "++elemento++" inteiros = "++show(totalInt (read elemento)))
				entrada	
		
		'2': _ -> do			
				print("A soma de uma lista de "++elemento++" inteiros impares = "++show(totalImpares (read elemento)))
				entrada	

		'3': _ -> do				
				print("A soma de uma lista de "++elemento++" inteiros pares = "++show(totalPares (read elemento)))
				entrada	
		
		'4': _ -> do				
				print("A soma de uma lista de "++elemento++" quadrados de inteiros = "++show(totalQuadrados (read elemento)))
				entrada	
		
		'5': _ -> do				
				print("A soma de uma lista de "++elemento++" quadrados de inteiros impares = "++show(totalQuadradosImpares (read elemento)))
				entrada	

		'6': _ -> do			
				print("O numero quase um = "++show(quaseUm (read elemento)))
				entrada	

		'7': _ -> do				
				print("O numero quase e = "++show(quaseE (read elemento)))
				entrada	

		'8': _ -> do				
				print("O numero quase dois = "++show(quaseDois (read elemento)))
				entrada	

		'9' : _ -> do	exitSuccess

		_: _ -> do	print("Opcao invalida")		

-----------------------------------------------------
---------------- código da aplicação ----------------
-----------------------------------------------------

somaInt :: (Fractional a, Enum a) => a -> [a]
somaInt n = map (\x->(x*(1+x)/2)) [1..n]
totalInt :: (Fractional a, Enum a) => a -> a
totalInt n = last (somaInt n)

somaImpares :: Int -> [Int]
somaImpares n = map(\x->x * x) [1..n]
totalImpares :: Int -> Int
totalImpares n = last (somaImpares n)

somaPares :: (Fractional a, Enum a) => a -> [a]
somaPares n = map(\x->x * (x - 1)) [1..n]
totalPares :: (Fractional a, Enum a) => a -> a
totalPares n = last (somaPares n)

somaQuadrados :: (Fractional a, Enum a) => a -> [a]
somaQuadrados n = map(\x->x * (x + 1) * (2 * x + 1)/6) [1..n]
totalQuadrados :: (Fractional a, Enum a) => a -> a
totalQuadrados n = last (somaQuadrados n)

somaQuadradosImpares :: (Fractional a, Enum a) => a -> [a]
somaQuadradosImpares n = map(\x->x * (4 * x * x - 1)/3) [1..n]
totalQuadradosImpares :: (Fractional a, Enum a) => a -> a
totalQuadradosImpares n = last (somaQuadradosImpares n)

quaseUm :: Int -> Double
quaseUm n = sum( map( \x->( 1/(x * x + x) )) (take n [1..]) )

quaseDois :: Int -> Double
quaseDois n = sum( map( \x->( 2/(x * x + x) )) (take n [1..]) )

fat 0 = 1
fat n = n * fat (n - 1)

quaseE :: Int -> Double
quaseE n = sum( map( \x->( 1/(fat x) ) ) (take n [0..]) )
