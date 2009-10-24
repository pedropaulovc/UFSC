package producao.livro;

public class ExemplarArquivavel extends Exemplar implements TipoExemplarArquivavel {
	private TipoIdentificacao id;

	public ExemplarArquivavel(TipoDadosExemplar dados) {
		super(dados);
		this.id = new Identificacao();
	}

	public TipoIdentificacao obterId() {
		return id;
	}
}
