package producao.documento;

import producao.dados.anoPublicacao.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.titulo.TipoTitulo;
import producao.dados.titulo.TituloNulo;

public class DocumentoNulo implements TipoDocumento {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

}
