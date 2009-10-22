package producao.livro;

public class Editora implements TipoEditora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

	public TipoLivroArquivavel criarLivro(DadosLivro dados,
			DadosArquivoLivro dadosArquivo) {
		return new LivroArquivavel(dados, dadosArquivo);
	}
}
