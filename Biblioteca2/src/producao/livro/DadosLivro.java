package producao.livro;


public class DadosLivro implements TipoDadosLivro {
	private TipoTitulo titulo;
	private TipoAutor autor;

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
	}
	
	public TipoTitulo obterTitulo(){
		return titulo;
	}
	
	public TipoAutor obterAutor(){
		return autor;
	}
}
