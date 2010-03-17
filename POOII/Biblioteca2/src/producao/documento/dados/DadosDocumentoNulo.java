package producao.documento.dados;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;

public class DadosDocumentoNulo implements TipoDadosDocumento {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoNome obterTitulo() {
		return new NomeNulo();
	}

}
