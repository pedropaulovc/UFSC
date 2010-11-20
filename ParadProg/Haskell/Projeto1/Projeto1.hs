module Solidos  ( Solido ( Esfera, Cilindro, Cone, TroncoCone, EsferoideOblato, EsferoideProlato),
				 Raio, Altura, SemiEixo,
				 excentricidade
				) where
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

excentricidade :: Float -> Float -> Float
excentricidade a b = (sqrt(a*a - b*b))/a

area ::  Solido -> Float
area (Esfera r) = 4 * pi * r * r
area (Cilindro r h) = (2 * pi * r * h) + (2 * pi * r * r)
area (Cone r h) = pi * r * ((sqrt r * r + h * h) + r )
area (TroncoCone rMenor rMaior h) = pi * rMenor * rMenor + pi * rMaior * rMaior + pi * (rMenor + rMaior)*(sqrt h * h + rMenor * rMenor + rMaior * rMaior -2 * rMenor * rMaior)
area (EsferoideOblato seMenor seMaior) = let e = excentricidade seMenor seMaior
			      						 in 2 * pi * seMenor * seMenor + pi * ((seMaior * seMaior)/e) * (log (1 + e)/(1 - e))
area (EsferoideProlato seMenor seMaior) = let e = excentricidade seMenor seMaior
			      						  in 2 * pi * seMaior * seMaior + 2 * pi * (seMenor * seMaior/e) * (asin e)

volume :: Solido -> Float
volume (Esfera r) = (4/3) * pi * r * r * r
volume (Cilindro h r) = pi * r * r * h
volume (Cone h r) = (1/3) * pi * r * r * h
volume (TroncoCone rMenor rMaior h) = (1/3) * pi * h * (rMenor * rMenor + rMaior * rMaior + rMenor * rMaior)
volume (EsferoideOblato seMenor seMaior) = (4/3) * pi * seMenor * seMenor *seMaior
volume (EsferoideProlato seMenor seMaior) = (4/3) * pi * seMenor * seMaior * seMaior

