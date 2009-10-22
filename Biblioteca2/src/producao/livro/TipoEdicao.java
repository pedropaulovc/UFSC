package producao.livro;

public interface TipoEdicao extends TipoInformacao {
	public TipoAnoPublicacao obterAnoPublicacao();

	public TipoNomeEditora obterEditora();
}
