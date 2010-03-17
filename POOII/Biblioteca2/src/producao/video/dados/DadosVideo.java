package producao.video.dados;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.Nome;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumento;

public class DadosVideo extends DadosDocumento implements TipoDadosVideo {

	private TipoAutor diretor;
	private TipoNome nomeProdutora;
	private Categoria categoria;
	private Nome enredo;

	public DadosVideo(Nome titulo, Autor diretor, Nome nomeProdutora,
			AnoPublicacao anoPublicacao, Categoria categoria, Nome enredo) {
		super(titulo, anoPublicacao);

		if (diretor == null || nomeProdutora == null || enredo == null
				|| categoria == null)
			throw new ExcecaoParametroInvalido("Parâmetros inválidos");
		this.diretor = diretor;
		this.nomeProdutora = nomeProdutora;
		this.categoria = categoria;
		this.enredo = enredo;
	}

	public TipoAutor obterDiretor() {
		return diretor;
	}

	public TipoNome obterNomeProdutora() {
		return nomeProdutora;
	}

	public Categoria obterCategoria() {
		return categoria;
	}

	public TipoNome obterEnredo() {
		return enredo;
	}

	public String toString() {
		return super.toString() + "; Diretor: " + diretor.toString()
				+ "; Nome da Produtora: " + nomeProdutora.toString()
				+ "; Categoria: " + categoria.toString() + "; Enredo: " + enredo.toString();
	}
}
