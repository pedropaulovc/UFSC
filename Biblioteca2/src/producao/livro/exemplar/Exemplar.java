package producao.livro.exemplar;

import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;


public class Exemplar implements TipoExemplar {

	private TipoDadosExemplar dados;

	public Exemplar(TipoDadosExemplar dados) {
		this.dados = dados;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	public TipoNomeEditora obterEditora() {
		return dados.obterEditora();
	}

	public TipoDadosExemplar obterDados() {
		return dados;
	}

}
