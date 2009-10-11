package producao.acervo;

import java.util.ArrayList;
import java.util.List;

import producao.Livro;
import producao.busca.Buscador;

public class AcervoDeLivro extends Acervo<Livro> {

	public List<Livro> buscaExataAutor(String autorBuscado){
		List<Livro> resultados = new ArrayList<Livro>(); 
		for(Livro l : super.obterLista())
			if(Buscador.buscaExata(l.obterAutor(), autorBuscado))
				resultados.add(l);
		return resultados;
	}

}
