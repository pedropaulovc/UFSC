package producao.livro.exemplar.dados;

import producao.livro.exemplar.anoPublicacao.AnoPublicacao;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.id.IdExemplar;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.nomeEditora.NomeEditora;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;



public class DadosExemplar implements TipoDadosExemplar {

	private String[] dadosSeparados;
	private TipoAnoPublicacao anoPublicacao;
	private TipoNomeEditora editora;
	private TipoIdExemplar id;

	/**
	 * @param dados: Uma string contendo os dados do exemplar, separados por ponto vírgula e
	 * na ordem "Editora;Ano de Publicação"
	 */
	public DadosExemplar(String dados) {
		assert (dados != null);
		dadosSeparados = dados.split(";");

		editora = new NomeEditora(dadosSeparados[0]);
		anoPublicacao = new AnoPublicacao(dadosSeparados[1]);
		id = new IdExemplar();
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

	public TipoNomeEditora obterEditora() {
		return editora;
	}
	

	public TipoIdExemplar obterId() {
		return id;
	}

}
