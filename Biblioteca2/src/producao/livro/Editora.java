package producao.livro;

public class Editora implements TipoEditora {

	@Override
	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

}
