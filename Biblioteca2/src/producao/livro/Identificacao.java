package producao.livro;

import java.util.UUID;

public class Identificacao implements TipoIdentificacao {
	private UUID id ;

	public Identificacao(){
		this.id = UUID.randomUUID();
	}
	
	public Identificacao(String id){
		this.id = UUID.fromString(id);
	}

	public String toString(){
		return id.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identificacao other = (Identificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}