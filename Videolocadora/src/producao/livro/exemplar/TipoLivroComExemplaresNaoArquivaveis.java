package producao.livro.exemplar;

import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.id.TipoIdExemplar;


public interface TipoLivroComExemplaresNaoArquivaveis extends TipoLivroComExemplares {
	public TipoIdExemplar adicionarExemplar(TipoDadosExemplar dadosExemplar);
}
