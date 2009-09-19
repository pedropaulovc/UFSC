package biblioteca;

public class Situacao {
	public Situacao clone(){
		try {
			return (Situacao) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}
