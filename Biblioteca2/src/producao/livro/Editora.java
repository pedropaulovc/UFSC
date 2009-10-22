package producao.livro;

public class Editora implements TipoEditora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

}
