package producao.video.dados;

import static producao.dados.categoria.Categoria.OUTRA;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumentoNulo;

public class DadosVideoNulo extends DadosDocumentoNulo implements
		TipoDadosVideo {

	public TipoAutor obterDiretor() {
		return new AutorNulo();
	}

	public TipoNome obterNomeProdutora() {
		return new NomeNulo();
	}

	public Categoria obterCategoria() {
		return OUTRA;
	}

	public TipoNome obterEnredo() {
		return new NomeNulo();
	}
}
