package producao.livro;

public class DadosExemplarArquivavel extends DadosExemplar implements TipoDadosExemplarArquivavel {

	private TipoNumeroChamada numeroChamada;
	private TipoIdentificacao id;

	/**
	 * @param dados: Uma string contendo os dados do exemplar arquivável,
	 * separados por ponto vírgula e na ordem
	 * "Editora;Ano de Publicação;Numero de Chamada"
	 */
	public DadosExemplarArquivavel(String dados) {
		super(dados);
		assert (dados != null);
		
		String[] dadosSeparados = dados.split(";");
		assert (dadosSeparados.length == 3);
		
		numeroChamada = new NumeroChamada(dadosSeparados[2]);
		id = new Identificacao();
	}

	public TipoIdentificacao obterIdentificacao() {
		return id;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}
