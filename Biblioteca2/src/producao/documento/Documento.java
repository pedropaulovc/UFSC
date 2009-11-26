package producao.documento;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public class Documento implements TipoDocumento {

	private TipoDadosDocumento dados;

	public Documento(TipoDadosDocumento dados) {
		if(dados == null)
			throw new ExcecaoParametroInvalido("Parâmetro inválido");
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
	
	public String toString(){
		return dados.toString();
	}

}
