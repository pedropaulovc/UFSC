package producao.livro;

public interface TipoLivroComExemplaresNaoArquivaveis extends TipoLivroComExemplares {
	public TipoIdentificacaoExemplar adicionarExemplar(TipoDadosExemplar dadosExemplar);
}
