package producao.livro;

public class Edicao implements TipoEdicao {

	private TipoDadosEdicao dados;

	public Edicao(TipoDadosEdicao dados){
		this.dados = dados;
	}
	
	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	@Override
	public TipoNomeEditora obterEditora() {
		return dados.obterEditora();
	}	
}
