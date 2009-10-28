package producao.livro.exemplar;

import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;

public interface TipoExemplarArquivavel extends TipoExemplar {
	public TipoNumeroChamada obterNumeroChamada();
	
	public TipoIdExemplar obterId();
	
	public TipoDadosExemplarArquivavel obterDados();

	public boolean emprestar(int prazo);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public boolean devolver();

	public boolean alterarEstado(EstadoEmprestimo estado);
}
