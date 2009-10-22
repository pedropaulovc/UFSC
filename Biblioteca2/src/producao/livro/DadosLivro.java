package producao.livro;

import producao.documento.AnoPublicacao;
import producao.documento.Autor;
import producao.documento.NomeEditora;
import producao.documento.TipoAnoPublicacao;
import producao.documento.TipoAutor;
import producao.documento.TipoNomeEditora;
import producao.documento.TipoTitulo;
import producao.documento.Titulo;

public class DadosLivro implements TipoDadosLivro {
	private TipoTitulo titulo;
	private TipoAutor autor;
	private TipoNomeEditora editora;
	private TipoAnoPublicacao anoPublicacao;

	/**
	 * @param dados: Uma string contendo os dados do livro, separados por ponto vírgula e
	 * na ordem "Título;Autor;Editora;Ano de Publicação"
	 */
	public DadosLivro(String dados){
		assert(dados != null);		
		
		String[] dadosSeparados = dados.split(";");
		assert(dadosSeparados.length == 4);
		
		this.titulo = new Titulo(dadosSeparados[0]);
		this.autor = new Autor(dadosSeparados[1]);
		this.editora = new NomeEditora(dadosSeparados[2]);
		this.anoPublicacao = new AnoPublicacao(dadosSeparados[3]);
	}
	
	public TipoTitulo obterTitulo(){
		return titulo;
	}
	
	public TipoAutor obterAutor(){
		return autor;
	}
	
	public TipoNomeEditora obterEditora(){
		return editora;
	}
	
	public TipoAnoPublicacao obterAnoPublicacao(){
		return anoPublicacao;
	}
}
