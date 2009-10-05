package producao;


public interface Alimento {
	public boolean equals(Object outro);
	public ListaDe<Ingrediente> obterListaIngredientes();
}
