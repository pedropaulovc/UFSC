package producao.livro;

import java.util.Date;

public interface TipoExemplarArquivavel extends TipoExemplar {
	public TipoNumeroChamada obterNumeroChamada();
	
	public TipoIdentificacaoExemplar obterIdentificacao();
	
	public TipoDadosExemplarArquivavel obterDados();

	public boolean emprestar();

	public EstadoEmprestimo obterEstado();

	public Date obterPrazoDevolucao();
}
