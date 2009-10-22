package producao.livro;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();

	public boolean adicionarEdicao(TipoEdicao edicao);

	public TipoEdicao obterEdicao(int edicao);

	public TipoEdicao removerEdicao(int edicao);

	public int qtdEdicoes();
}
