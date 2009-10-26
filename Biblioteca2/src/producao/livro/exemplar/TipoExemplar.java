package producao.livro.exemplar;

import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;


public interface TipoExemplar {
	public TipoAnoPublicacao obterAnoPublicacao();
	
	public TipoNomeEditora obterEditora();

	public TipoDadosExemplar obterDados();
}
