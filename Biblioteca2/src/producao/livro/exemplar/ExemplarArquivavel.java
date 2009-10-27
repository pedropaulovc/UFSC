package producao.livro.exemplar;

import static producao.livro.exemplar.EstadoEmprestimo.*;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucao;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucaoNulo;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;

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

	public TipoIdExemplar obterId() {
		return dados.obterId();
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
	
	public boolean alterarEstado(EstadoEmprestimo estado){
		if(estado.equals(EMPRESTADO))
			return false;
		this.estado = estado;
		return true;
	}
}
