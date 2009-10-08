package producao.acervo;

import producao.Livro;

public class AcervoDeLivro extends Acervo<Livro> {
	public AcervoDeLivro(Class<Livro> classe) {
		super(classe);
	}

	public ListaDe<Integer> buscarAutor(String autor){
		ListaDe<Integer> lista = new ListaDe<Integer>();
		for(int i = 0; i < super.tamanho(); i++)
			if(autor.equals(super.obter(i)))
				lista.adicionar(new Integer(i));
		return lista;
	}
}
