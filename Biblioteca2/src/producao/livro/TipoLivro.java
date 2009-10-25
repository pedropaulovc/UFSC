package producao.livro;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();
	
	public TipoIdentificacao obterIdentificacao();
	
	public TipoDadosLivro obterDados();
}
