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
		
			let nomesArquivosRGB = ["saidaR.txt", "saidaG.txt", "saidaB.txt"]

			--abrindo os arquivos para escrita
			arquivosRGB <- mapM abrirEscrita nomesArquivosRGB

			--separando o cabeçalho da imagem
			let (cabecalho, imagem) = obterCabecalho arquivoStr
			let largura = obterLargura cabecalho
			let imagemSemPadding = removePadding imagem largura
			
			--a partir da string de bytes obter a lista de pixels da imagem
			let pixels = gerarTriplas imagemSemPadding
			
			--a transposição é o núcleo da separação em camadas. De uma lista de
			--pixels (Triplas), temos três listas de strings, cada uma contendo os
			--bytes de uma cor
			--arquivos bmp são codificados como bgr, a reversão gera o rgb.
			let rgb = reverse (transpose pixels)

			--gravar os dados obtidos em cada arquivo
			sequence [hPrint arq byte | (arq, byte) <- zip arquivosRGB rgb]

			--fecha os arquivos
			mapM hClose arquivosRGB

			putStr "Fim.\n"
	
		_	-> do
				putStr "Forneca a imagem a ser decomposta como parametro:\n"
				putStr "Uso: ./decompor_imagem imagem.bmp\n"

abrirEscrita :: [Char] -> IO Handle
abrirEscrita arquivo = openFile arquivo WriteMode

obterCabecalho :: [Char] -> ([Char],[Char])
obterCabecalho [] = ([],[])
obterCabecalho imagem = splitAt 54 imagem

gerarTriplas :: [Char] -> [ [Char] ]
gerarTriplas [] = []
gerarTriplas arquivo = (take 3 arquivo):(gerarTriplas (drop 3 arquivo) )

-- Funções para obter as dimenções da imagem a partir do cabeçalho
obterLargura :: [Char] -> Int
obterLargura [] = 0
obterLargura arquivoStr = let lista = map ord (take 4 (drop 18 arquivoStr))  in  (lista!!0) + (lista!!1) * 256


-- Funções que removem e adicionam os bytes nulos de padding, para que cada linha
-- da imagem tenha um número de bytes múltiplo de 4
removePadding :: [Char] -> Int -> [Char]
removePadding [] _ = []
removePadding imagem largura = let (atual, resto) = splitAt (largura*3) imagem
				   pads = mod (largura*3) 4  in
					let proximasLinhas = drop pads resto  in
						atual ++ (removePadding proximasLinhas largura)

