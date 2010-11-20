import IO
import Char
import List
import System (getArgs)

main :: IO ()
main = do
	args <- getArgs
	case args of
		[nomeArquivo] -> do	
			arquivoStr <- readFile nomeArquivo
		
			let nomesArquivosRGB = ["saidaR.dat", "saidaG.dat", "saidaB.dat"]

			--abrindo os arquivos para escrita
			arquivosRGB <- sequence [openFile f WriteMode | f <- nomesArquivosRGB]

			--separando o cabeçalho da imagem
			let (cabecalho, imagem) = obterCabecalho arquivoStr
			let largura = obterLargura cabecalho
			let imagemSemPadding = removePadding imagem largura
			
			--a partir da string de bytes obter a lista de pixels da imagem
			let pixels = fazTriplas imagemSemPadding
			
			--a transposição é o núcleo da separação em camadas. De uma lista de
			--pixels (Triplas), temos três listas de strings, cada uma contendo os
			--bytes de uma cor
			--arquivos bmp são codificados como bgr, a reversão gera o rgb.
			let rgb = reverse (transpose pixels)
			
			let rgbEmLinhas = map (rearranjaPixelList largura) rgb
			
			--imprime nos arquivos as streams correspondentes
			sequence [gravarAquivo arq byte | (arq, byte) <- zip arquivosRGB rgbEmLinhas]

			--fecha os arquivos
			sequence [hClose f | f <- arquivosRGB]

			putStr "Fim. Arquivos saída: \n "
			putStr $ concat $ map (++ "\n") nomesArquivosRGB
	
		_	-> do
				putStr "Execute o programa criado passando como parametro o nome do arquivo a ser separado em camadas\n"
				putStr "Por exemplo: ./programa_compilado vermelho.bmp\n"

obterCabecalho :: [Char] -> ([Char],[Char])
obterCabecalho [] = ([],[])
obterCabecalho imagem = splitAt 54 imagem


fazTriplas :: [Char] -> [ [Char] ]
fazTriplas [] = []
fazTriplas arquivo = (take 3 arquivo):(fazTriplas (drop 3 arquivo) )


-- Funções para obter as dimenções da imagem a partir do cabeçalho
obterLargura :: [Char] -> Int
obterLargura [] = 0
obterLargura arquivoStr = let lista = map ord (take 4 (drop 18 arquivoStr))  in  (lista!!0) + (lista!!1) * 256


obterAltura :: [Char] -> Int
obterAltura [] = 0
obterAltura arquivoStr = let lista = map ord (take 4 (drop 22 arquivoStr))  in  (lista!!0) + (lista!!1) * 256


obterDimensoes :: [Char] -> (Int, Int)
obterDimensoes arquivoStr = ( (obterLargura arquivoStr), (obterAltura arquivoStr) )


-- Funções que removem e adicionam os bytes nulos de padding, para que cada linha
-- da imagem tenha um número de bytes múltiplo de 4
removePadding :: [Char] -> Int -> [Char]
removePadding [] _ = []
removePadding imagem largura = let (atual, resto) = splitAt (largura*3) imagem
				   pads = mod (largura*3) 4  in
					let proximasLinhas = drop pads resto  in
						atual ++ (removePadding proximasLinhas largura)


adicionaPadding :: Int -> [Char] -> [Char]
adicionaPadding _ [] = []
adicionaPadding largura imagem = let (atual, resto) = splitAt (largura*3) imagem 
				     pads = mod (largura*3) 4  in
					let proximasLinhas = (replicate pads (chr 0) ) ++ resto  in
						atual ++ (adicionaPadding largura proximasLinhas)


-- Funções para transformar a lista de pixels (Única cor), quebrando-a por linha
-- da imagem, e colocando-a na ordem "visual" e não a do arquivo BMP						
separaPixelList ::  Int -> [Char] -> [ [Char] ]
separaPixelList largura [] = []
separaPixelList largura pl = let s = splitAt largura pl in
				(fst s):(separaPixelList largura (snd s) )


rearranjaPixelList ::  Int -> [Char] -> [ [Char] ]
rearranjaPixelList largura pl = reverse (separaPixelList largura pl)


-- Função para escrever uma representação da lista de linhas no arquivo
gravarAquivo arquivo [] = return ()
gravarAquivo arquivo cs = do
				hPrint arquivo (map ord (head cs))
				gravarAquivo arquivo (tail cs)

