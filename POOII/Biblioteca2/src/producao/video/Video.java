package producao.video;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.Documento;
import producao.video.dados.TipoDadosVideo;

public class Video extends Documento implements TipoVideo {

	private TipoDadosVideo dados;

	public Video(TipoDadosVideo dados) {
		super(dados);
		this.dados = dados;
	}

	public Categoria obterCategoria() {
		return dados.obterCategoria();
	}

	public TipoAutor obterDiretor() {
		return dados.obterDiretor();
	}

	public TipoNome obterNomeProdutora() {
		return dados.obterNomeProdutora();
	}

	public TipoNome obterEnredo(){
		return dados.obterEnredo();
	}
	
	public TipoDadosVideo obterDados() {
		return dados;
	}
	
	public String toString(){
		return "VÍDEO: " +  dados.toString();
	}

}
