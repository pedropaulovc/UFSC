package producao.dados.id;

import java.util.UUID;

public class Id implements TipoId {
	private UUID id;

	public Id() {
		this.id = UUID.randomUUID();
	}

	public Id(String id) {
		this.id = UUID.fromString(id);
	}

	public String toString() {
		return id.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
