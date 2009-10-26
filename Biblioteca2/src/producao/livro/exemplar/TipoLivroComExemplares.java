package producao.livro.exemplar;

import producao.livro.TipoLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;

public interface TipoLivroComExemplares extends TipoLivro {
	public int qtdExemplares();

	public void removerExemplar(TipoIdExemplar exemplar);

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdExemplar exemplar);

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdExemplar exemplar);

	public TipoDadosExemplar obterDadosExemplar(TipoIdExemplar exemplar);
	
	public boolean contemExemplar(TipoIdExemplar exemplar);
}
