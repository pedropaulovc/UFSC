package producao.livro;

public class DadosEdicao implements TipoDadosEdicao {

	private TipoNomeEditora editora;
	private TipoAnoPublicacao anoPublicacao;

	public DadosEdicao(String dados){
		assert(dados != null);
		String[] dadosSeparados = dados.split(";");
		
		assert(dadosSeparados.length == 2);
		
		this.editora = new NomeEditora(dadosSeparados[0]);
		this.anoPublicacao = new AnoPublicacao(dadosSeparados[1]);
	}
	
	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

	@Override
	public TipoNomeEditora obterEditora() {
		return editora;
	}

}
