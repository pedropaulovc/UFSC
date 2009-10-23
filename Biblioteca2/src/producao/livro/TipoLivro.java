package producao.livro;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();

	public int qtdExemplares();

	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar);

	public TipoExemplar obterExemplar(int i);

	public TipoExemplar removerExemplar(int i);
	
}
