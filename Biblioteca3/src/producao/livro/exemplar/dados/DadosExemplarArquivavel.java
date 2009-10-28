package producao.livro.exemplar.dados;

import producao.livro.exemplar.numeroChamada.NumeroChamada;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;


public class DadosExemplarArquivavel extends DadosExemplar implements TipoDadosExemplarArquivavel {

	private TipoNumeroChamada numeroChamada;
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
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}
