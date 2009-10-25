package producao.livro;

import java.util.Date;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public TipoIdentificacaoExemplar adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacaoExemplar exemplar);
	
	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacaoExemplar exemplar);

	public boolean emprestar(TipoIdentificacaoExemplar idExemplar);

	public EstadoEmprestimo obterEstado(TipoIdentificacaoExemplar idExemplar);

	public Date obterPrazoDevolucao(TipoIdentificacaoExemplar idExemplar);
}
