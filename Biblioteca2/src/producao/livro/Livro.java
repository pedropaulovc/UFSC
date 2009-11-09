package producao.livro;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.Documento;
import producao.livro.dados.TipoDadosLivro;

public class Livro extends Documento implements TipoLivro {

	private TipoDadosLivro dados;

	public Livro(TipoDadosLivro dados) {
		super(dados);
		this.dados = dados;
	}

	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoDadosLivro obterDados() {
		return dados;
	}

	public TipoNome obterNomeEditora() {
		return dados.obterEditora();
	}
}
