package producao.livro;

public interface TipoLivroComExemplaresNaoArquivaveis extends TipoLivroComExemplares {
	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar);
}
