package producao.livro.arquivavel.dados;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.documento.arquivavel.dados.DadosDocumentoArquivavel;

public class DadosLivroArquivavel extends DadosDocumentoArquivavel implements
		TipoDadosLivroArquivavel {

	private TipoNumeroChamada numeroChamada;

	public DadosLivroArquivavel(TipoNumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}
	
	public String toString(){
		return "Número de Chamada: " + numeroChamada.toString();
	}

}
