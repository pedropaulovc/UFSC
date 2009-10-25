package producao.livro;


public class DadosExemplar implements TipoDadosExemplar {

	private String[] dadosSeparados;
	private TipoAnoPublicacao anoPublicacao;
	private TipoNomeEditora editora;
	private TipoIdentificacao id;

	/**
	 * @param dados: Uma string contendo os dados do exemplar, separados por ponto vírgula e
	 * na ordem "Editora;Ano de Publicação"
	 */
	public DadosExemplar(String dados) {
		assert (dados != null);
		dadosSeparados = dados.split(";");

		editora = new NomeEditora(dadosSeparados[0]);
		anoPublicacao = new AnoPublicacao(dadosSeparados[1]);
		id = new Identificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

	public TipoNomeEditora obterEditora() {
		return editora;
	}
	

	public TipoIdentificacao obterIdentificacao() {
		return id;
	}

}
