package modelo.biblioteca;

public class Edicao {
	private ListaDe<Exemplar> exemplares;
	private NumeroChamada numeroChamada;
	private int anoPublicacao;

	public Edicao(Exemplar exemplar, NumeroChamada numeroChamada,
			int anoPublicacao) {
		this.exemplares = new ListaDe<Exemplar>();
		exemplares.adicionar(exemplar);
		this.numeroChamada = numeroChamada;
		this.anoPublicacao = anoPublicacao;
	}

	public Edicao(ListaDe<Exemplar> exemplares, NumeroChamada numeroChamada,
			int anoPublicacao) {
		this.alterarNumeroChamada(numeroChamada);
		this.alterarExemplares(exemplares);
		this.alterarAnoPublicacao(anoPublicacao);
	}

	public void alterarAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int obterAnoPublicacao() {
		return anoPublicacao;
	}

	public void alterarNumeroChamada(NumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public NumeroChamada obterNumeroChamada() {
		return numeroChamada.clone();
	}

	public void alterarExemplares(ListaDe<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	public ListaDe<Exemplar> obterExemplares() {
		return exemplares.clone();
	}

	public String toString() {
		return "Edição do ano " + anoPublicacao + ". " + numeroChamada + ". Há " + exemplares.tamanho()
				+ " exemplares dessa edição.";
	}

	public Edicao clone() {
		try {
			return (Edicao) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}
