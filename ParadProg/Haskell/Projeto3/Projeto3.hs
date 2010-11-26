import IO
import Char
import List
import Control.Monad
import System (getArgs, exitFailure)

main :: IO ()
main = do
	args <- getArgs
	case args of
		[nomeArquivo] -> do
			-- Lendo o arquivo fornecido
			arquivoStr <- readFile nomeArquivo
			
			-- Verificando se o arquivo realmente é uma imagem BMP
			when (not(ehBMP arquivoStr)) $ erro "Imagem nao e do formato BMP\n"
			
			-- Gerando os nomes dos arquivos de resultados
			let nome = take (length nomeArquivo -4) nomeArquivo
			let nomesArqsRGB = map (nome ++) ["-R.txt", "-G.txt", "-B.txt"]
			
			-- Abrindo os arquivos de resultados para escrita
			arquivosRGB <- mapM abrirEscrita nomesArqsRGB

			-- Separando o cabeçalho do restante imagem
			let (cabecalho, corpoImagem) = obterCabecalho arquivoStr
			let largura = obterLargura cabecalho
			
			-- Removendo o padding da imagem BMP
			let imagemSemPadding = removerPadding corpoImagem largura
			
			-- A partir da string de bytes resultante obter os pixels da imagem
			let pixels = gerarPixels imagemSemPadding

			-- Ao transpor os pixels (Triplas BGR), gera-se três strings,
			-- cada uma contendo os bytes de uma cor.
			-- Ao reverter o bgr obtem-se o rgb
			let rgb = reverse (transpose pixels)

			-- Gravando os dados obtidos em cada arquivo
			sequence [gravarCor arq cor | (arq, cor) <- zip arquivosRGB rgb]

			-- Fechando os arquivos
			mapM hClose arquivosRGB

			putStr "Fim.\n"
	
		_	-> do
				putStr "Forneca a imagem a ser decomposta como parametro:\n"
				putStr "Uso: ./decompor_imagem imagem.bmp\n"

-- Abre um dado arquivo para escrita e retorna o Handle correspondente.
abrirEscrita :: [Char] -> IO Handle
abrirEscrita arquivo = openFile arquivo WriteMode

-- Verifica se o início do header corresponde a um de uma imagem BMP.
ehBMP :: [Char] -> Bool
ehBMP arquivo = take 2 arquivo == "BM"

-- Separa o cabeçalho da imagem do restante, retorna ambos em uma dupla.
obterCabecalho :: [Char] -> ([Char],[Char])
obterCabecalho [] = ([],[])
obterCabecalho imagem = splitAt 54 imagem

-- A partir de uma imagem sem padding pega de 3 em 3 bytes, gerando um pixel 
gerarPixels :: [Char] -> [ [Char] ]
gerarPixels [] = []
gerarPixels arquivo = (take 3 arquivo):(gerarPixels (drop 3 arquivo) )

-- A partir do cabeçalho da imagem obtém a largura em pixels da imagem.
obterLargura :: [Char] -> Int
obterLargura [] = 0
obterLargura arquivoStr = let lista = map ord (take 4 (drop 18 arquivoStr))  in  (lista!!0) + (lista!!1) * 256


-- Removem os bytes nulos de alinhamento (padding) com palavras de 32 bits,
-- i.e. um byte a cada pixel. 
removerPadding :: [Char] -> Int -> [Char]
removerPadding [] _ = []
removerPadding imagem largura = let (atual, resto) = splitAt (largura*3) imagem
				    pads = mod (largura*3) 4  in
					let proximasLinhas = drop pads resto  in
						atual ++ (removerPadding proximasLinhas largura)

-- A partir de uma string correspondente a uma única cor, a transforma em uma lista
-- de números e grava no arquivo fornecido.
gravarCor :: Handle -> [Char] -> IO ()
gravarCor arquivo cor = hPrint arquivo (map ord cor)

-- Exibe uma mensagem de erro ao usuário e termina a execução do programa prematuramente
erro :: String -> IO a
erro mensagem = do
          putStr mensagem
          exitFailure

