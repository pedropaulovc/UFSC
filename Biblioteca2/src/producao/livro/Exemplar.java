package producao.livro;

public class Exemplar implements TipoExemplar {
	
	private TipoDadosExemplar dados;
	private TipoIdentificacao id;

	public Exemplar(TipoDadosExemplar dados){
		this.dados = dados;
		this.id = new Identificacao();
	}
	
	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	public TipoNomeEditora obterEditora() {
		return dados.obterEditora();
	}

	public TipoIdentificacao obterId() {
		return id;
	}

}
