package producao.livro;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.Documento;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;

public class Livro extends Documento implements TipoLivro {

	private DadosLivro dados;

	public Livro(DadosLivro dados) {
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
	
	public String toString(){
		return "LIVRO: " + dados.toString();
	}
}
