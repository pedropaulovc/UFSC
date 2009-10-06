package producao.alimento;

import producao.ListaDe;
import producao.ingrediente.Ingrediente;


public interface Alimento {
	public boolean equals(Object outro);
	public ListaDe<Ingrediente> obterListaIngredientes();
}
