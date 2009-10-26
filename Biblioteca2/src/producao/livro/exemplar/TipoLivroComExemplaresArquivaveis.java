package producao.livro.exemplar;

import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;



public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public TipoIdExemplar adicionarExemplar(
			TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(
			TipoIdExemplar exemplar);

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdExemplar exemplar);

	public boolean emprestar(TipoIdExemplar idExemplar, int prazo);

	public EstadoEmprestimo obterEstado(TipoIdExemplar idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(
			TipoIdExemplar idExemplar);

	public boolean devolver(TipoIdExemplar idExemplar);
}
