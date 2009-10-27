package producao.livro.exemplar.dados;

import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;


public interface TipoDadosExemplar {
	public TipoAnoPublicacao obterAnoPublicacao();

	public TipoNomeEditora obterEditora();
	
	public TipoIdExemplar obterId();
}
