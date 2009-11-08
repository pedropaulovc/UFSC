package producao.documento;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.dados.titulo.modelo.TituloNulo;

public class DocumentoNulo implements TipoDocumento {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

}
