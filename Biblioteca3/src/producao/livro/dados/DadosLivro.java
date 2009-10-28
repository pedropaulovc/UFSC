package producao.livro.dados;

import producao.livro.autor.Autor;
import producao.livro.autor.TipoAutor;
import producao.livro.id.IdLivro;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.TipoTitulo;
import producao.livro.titulo.Titulo;


public class DadosLivro implements TipoDadosLivro {
	private TipoTitulo titulo;
	private TipoAutor autor;
	private TipoIdLivro id;

	/**
	 * @param dados: Uma string contendo os dados do livro, separados por ponto vírgula e
	 * na ordem "Título;Autor"
	 */
	public DadosLivro(String dados){
		assert(dados != null);		
		
		String[] dadosSeparados = dados.split(";");
		assert(dadosSeparados.length == 2);

		this.titulo = new Titulo(dadosSeparados[0]);
		this.autor = new Autor(dadosSeparados[1]);
		this.id = new IdLivro();
	}
	
	public TipoTitulo obterTitulo(){
		return titulo;
	}
	
	public TipoAutor obterAutor(){
		return autor;
	}
	
	public TipoIdLivro obterId(){
		return id;
	}
}
