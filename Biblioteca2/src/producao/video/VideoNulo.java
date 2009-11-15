package producao.video;

import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.ListaAtoresNula;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.DocumentoNulo;
import producao.video.dados.DadosVideoNulo;
import producao.video.dados.TipoDadosVideo;

public class VideoNulo extends DocumentoNulo implements TipoVideo {

	public TipoAutor obterDiretor() {
		return new AutorNulo();
	}

	public TipoListaAtores obterListaAtores() {
		return new ListaAtoresNula();
	}

	public TipoNome obterNomeProdutora() {
		return new NomeNulo();
	}
	
	public TipoDadosVideo obterDados(){
		return new DadosVideoNulo();
	}

}
