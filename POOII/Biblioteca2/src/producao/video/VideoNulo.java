package producao.video;

import static producao.dados.categoria.Categoria.OUTRA;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.DocumentoNulo;
import producao.video.dados.DadosVideoNulo;
import producao.video.dados.TipoDadosVideo;

public class VideoNulo extends DocumentoNulo implements TipoVideo {

	public TipoAutor obterDiretor() {
		return new AutorNulo();
	}

	public TipoNome obterNomeProdutora() {
		return new NomeNulo();
	}

	public TipoDadosVideo obterDados() {
		return new DadosVideoNulo();
	}

	public Categoria obterCategoria() {
		return OUTRA;
	}

}
