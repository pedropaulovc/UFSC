package producao.documento;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumentoNulo;
import producao.documento.dados.TipoDadosDocumento;

public class DocumentoNulo implements TipoDocumento {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoNome obterTitulo() {
		return new NomeNulo();
	}

	public TipoDadosDocumento obterDados() {
		return new DadosDocumentoNulo();
	}

}
