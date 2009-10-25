package producao.livro;

public class Editora implements TipoEditora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

	public TipoLivroComExemplaresNaoArquivaveis criarLivroComExemplares(
			TipoDadosLivro dados) {
		return new LivroComExemplares(dados);
	}

}
