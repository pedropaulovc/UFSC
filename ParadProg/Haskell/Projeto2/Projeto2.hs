module Series (somaInt, totalInt, somaImpares, totalImpares, somaPares, totalPares,
			  somaQuadrados, totalQuadrados, somaQuadradosImpares,
			  totalQuadradosImpares, quaseUm, quaseDois, fat, quaseE) where

somaInt n = map (\x->(x*(1+x)/2)) [1..n]
totalInt n = last (somaInt n)

somaImpares n = map(\x->x * x) [1..n]
totalImpares n = last (somaImpares n)

somaPares n = map(\x->x * (x - 1)) [1..n]
totalPares n = last (somaPares n)

somaQuadrados n = map(\x->x * (x + 1) * (2 * x + 1)/6) [1..n]
totalQuadrados n = last (somaQuadrados n)

somaQuadradosImpares n = map(\x->x * (4 * x * x - 1)/3) [1..n]
totalQuadradosImpares n = last (somaQuadradosImpares n)

quaseUm n = sum( map( \x->( 1/(x * x + x) )) (take n [1..]) )

quaseDois n = sum( map( \x->( 2/(x * x + x) )) (take n [1..]) )

fat 0 = 1
fat n = n * fat (n - 1)

quaseE n = sum( map( \x->( 1/(fat x) ) ) [0..n] )
