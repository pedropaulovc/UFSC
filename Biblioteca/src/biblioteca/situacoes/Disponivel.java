package biblioteca.situacoes;

public class Disponivel implements Situacao {
	public Disponivel clone(){
		try {
			return (Disponivel) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}
