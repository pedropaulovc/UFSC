package producao.acervo;

public class Acervo<Tipo> implements TipoAcervo<Tipo> {

	private Class<Tipo> classeBase;
	private ListaDe<Tipo> acervo;

	public Acervo(Class<Tipo> classe) {
		classeBase = classe;
		acervo = new ListaDe<Tipo>();
	}

	public Class<Tipo> obterClasseBase() {
		return classeBase;
	}

	public int tamanho() {
		return acervo.tamanho();
	}

	public boolean adicionar(Tipo t) {
		return acervo.adicionar(t);
	}

	public Tipo obter(int i) {
		return acervo.obter(i);
	}

	public Tipo remover(int i) {
		return acervo.remover(i);
	}

}
