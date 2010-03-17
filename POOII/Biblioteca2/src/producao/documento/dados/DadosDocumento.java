package producao.documento.dados;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.Nome;
import producao.dados.nome.modelo.TipoNome;

public class DadosDocumento implements TipoDadosDocumento {

	private TipoNome titulo;
	private TipoAnoPublicacao anoPublicacao;

	public DadosDocumento(Nome titulo, AnoPublicacao anoPublicacao) {
		assert titulo != null;
		assert anoPublicacao != null;

		if(titulo == null || anoPublicacao == null)
			throw new ExcecaoParametroInvalido("Parâmetros inválidos");
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}

	public TipoNome obterTitulo() {
		return titulo;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}
	
	public String toString(){
		return "Título: " + titulo.toString() + ", Ano de Publicação: " + anoPublicacao.toString();
	}

}
