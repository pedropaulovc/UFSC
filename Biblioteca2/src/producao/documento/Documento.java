package producao.documento;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public class Documento implements TipoDocumento {

	private TipoDadosDocumento dados;

	public Documento(TipoDadosDocumento dados) {
		this.dados = dados;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	public TipoNome obterTitulo() {
		return dados.obterTitulo();
	}

	public TipoDadosDocumento obterDados() {
		return dados;
	}

}
