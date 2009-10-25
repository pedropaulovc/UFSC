package producao.livro;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();
	
	public TipoIdentificacaoLivro obterIdentificacao();
	
	public TipoDadosLivro obterDados();
}
