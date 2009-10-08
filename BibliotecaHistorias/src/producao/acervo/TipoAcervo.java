package producao.acervo;

public interface TipoAcervo<Tipo> {

	public Class<Tipo> obterClasseBase();
	public int tamanho();
	public boolean adicionar(Tipo t);
	public Tipo remover(int i);
	public Tipo obter(int i);
}
