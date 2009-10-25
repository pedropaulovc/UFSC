package producao.livro;

public interface TipoLivroComExemplaresNaoArquivaveis extends TipoLivroComExemplares {
	public TipoIdentificacao adicionarExemplar(TipoDadosExemplar dadosExemplar);
}
