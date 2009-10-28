package producao.biblioteca.nome;

public class NomeBiblioteca implements TipoNomeBiblioteca {
	private String nome;

	public NomeBiblioteca(String nome){
		this.nome = nome;
	}
	
	public String toString(){
		return nome;
	}
}

