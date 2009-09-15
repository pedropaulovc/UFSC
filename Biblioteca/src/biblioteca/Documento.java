package biblioteca;

import java.util.List;

public abstract class Documento implements Cloneable {
	private String titulo;
	private int anoPublicacao;
	private String autor;
	private String localizacaoEstante;
	private NumeroChamada numeroChamada;
	private List<Exemplar> exemplares;

	public Documento(String titulo, int anoPublicacao, String autor,
			String localizacaoEstante, NumeroChamada numeroChamada,
			List<Exemplar> exemplares) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.autor = autor;
		this.localizacaoEstante = localizacaoEstante;
		this.numeroChamada = numeroChamada;
		this.exemplares = exemplares;
	}

	public void alterarAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public void alterarAutor(String autor) {
		this.autor = autor;
	}

	public void alterarLocalizacaoEstante(String localizacaoEstante) {
		this.localizacaoEstante = localizacaoEstante;
	}

	public void alterarTiulo(String titulo) {
		this.titulo = titulo;
	}

	public void adicionarExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}

	public int obterAnoPublicacao() {
		return anoPublicacao;
	}

	public String obterAutor() {
		return autor;
	}

	public String obterLocalizacaoEstante() {
		return localizacaoEstante;
	}

	public String obterTitulo() {
		return titulo;
	}

	public void alterarNumeroChamada(NumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;

	}

	public NumeroChamada obterNumeroChamada() {
		return numeroChamada.clone();
	}

	public Exemplar obterExemplar(int exemplar) {
		return exemplares.get(exemplar).clone();
	}

	public Exemplar removerExemplar(int exemplar) {
		return exemplares.remove(exemplar);
	}

	public int qtdExemplares() {
		return exemplares.size();
	}

}
