package biblioteca;

public class Biblioteca {
	private String nome;
	private ListaDe<Arquivavel> acervo;

	public Biblioteca(String nome) {
		this.nome = nome;
		acervo = new ListaDe<Arquivavel>();
	}

	public String obterNome() {
		return nome;
	}

	public int tamanhoAcervo() {
		return acervo.tamanho();
	}

	public boolean adicionar(Arquivavel a) {
		return acervo.adicionar(a);
	}

	public Arquivavel obter(int a) {
		return acervo.obter(a).clone();
	}

	public Arquivavel remover(int a) {
		return acervo.remover(a).clone();
	}

	public String toString() {
		return nome + ". Possui acervo de " + tamanhoAcervo() + " documentos.";
	}
}