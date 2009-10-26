package producao.livro.exemplar.dados;

import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;


public interface TipoDadosExemplarArquivavel extends TipoDadosExemplar {
	public TipoNumeroChamada obterNumeroChamada();
}
