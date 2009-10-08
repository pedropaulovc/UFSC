package producao;

public class Livro {
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	
	public void alterarTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String obterTitulo() {
		return titulo;
	}

	public void alterarAutor(String autor) {
		this.autor = autor;
	}

	public String obterAutor() {
		return autor;
	}

	public void alterarEditora(String editora) {
		this.editora = editora;
	}

	public String obterEditora() {
		return editora;
	}

	public void alterarAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int obterAnoPublicacao() {
		return anoPublicacao;
	}
}
