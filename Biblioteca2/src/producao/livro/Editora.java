package producao.livro;

public class Editora implements TipoEditora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

	public TipoLivroComExemplares criarLivroComExemplares(TipoDadosLivro dados) {
		return new LivroComExemplares(dados);
	}

}
