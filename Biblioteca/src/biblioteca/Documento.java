package biblioteca;

public class Documento {
	private String titulo;
	private String autor;
	private ListaDe<Edicao> edicoes;
	
	public Documento (String titulo, String autor, Edicao edicao){
		this.titulo = titulo;
		this.autor = autor;
		this.edicoes = new ListaDe<Edicao>();
		this.edicoes.adicionar(edicao);
	}

	public Documento(String titulo, String autor, ListaDe<Edicao> edicoes) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicoes = edicoes;
	}

	public void alterarAutor(String autor) {
		this.autor = autor;
	}

	public void alterarTiulo(String titulo) {
		this.titulo = titulo;
	}

	public String obterAutor() {
		return autor;
	}

	public String obterTitulo() {
		return titulo;
	}

	public void alterarEdicoes(ListaDe<Edicao> edicoes) {
		this.edicoes = edicoes;
	}

	public ListaDe<Edicao> obterEdicoes() {
		return edicoes;
	}

	public String toString() {
		return titulo + " do autor " + autor + ". Há " + edicoes.tamanho()
				+ " edições desse documento.";
	}

	public Documento clone() {
		try {
			return (Documento) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
	
}
