package biblioteca.producao;

import java.util.ArrayList;
import java.util.List;


import acervo.producao.Acervo;
import acervo.producao.busca.Buscador;


public class AcervoDeLivro extends Acervo<Livro> {

	public List<Livro> buscaAutorExato(String autorBuscado){
		List<Livro> resultados = new ArrayList<Livro>(); 
		for(Livro l : super.obterLista())
			if(Buscador.buscaExata(l.obterAutor(), autorBuscado))
				resultados.add(l);
		return resultados;
	}

	public List<Livro> buscaAutorPorPalavra(String autorBuscado) {
		List<Livro> resultados = new ArrayList<Livro>(); 
		for(Livro l : super.obterLista())
			if(Buscador.buscaPorPalavra(l.obterAutor(), autorBuscado))
				resultados.add(l);
		return resultados;
	}

}
