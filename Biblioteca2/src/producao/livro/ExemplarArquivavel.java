package producao.livro;

import static producao.livro.EstadoEmprestimo.DISPONÍVEL;
import static producao.livro.EstadoEmprestimo.EMPRESTADO;

public class ExemplarArquivavel extends Exemplar implements
		TipoExemplarArquivavel {
	private TipoDadosExemplarArquivavel dados;
	private EstadoEmprestimo estado;
	private TipoPrazoDevolucao prazoDevolucao;

	public ExemplarArquivavel(TipoDadosExemplarArquivavel dados) {
		super(dados);
		this.dados = dados;
		this.estado = DISPONÍVEL;
		this.prazoDevolucao = new PrazoDevolucaoNulo();
	}

	public TipoIdentificacaoExemplar obterIdentificacao() {
		return dados.obterIdentificacao();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dados.obterNumeroChamada();
	}

	public TipoDadosExemplarArquivavel obterDados() {
		return dados;
	}

	public boolean emprestar(int prazo) {
		if (estado.equals(DISPONÍVEL)) {
			estado = EMPRESTADO;
			prazoDevolucao = new PrazoDevolucao(prazo);
			return true;
		}
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return estado;
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return prazoDevolucao;
	}

	public boolean devolver() {
		if (!estado.equals(EMPRESTADO)) {
			return false;
		}

		if (prazoDevolucao.estaNoPrazo()) {
			estado = DISPONÍVEL;
			prazoDevolucao = new PrazoDevolucaoNulo();
			return true;
		}
		return false;
	}
}
