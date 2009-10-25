package producao.livro;

import static producao.livro.EstadoEmprestimo.*;

import java.util.Date;
import java.util.GregorianCalendar;

public class ExemplarArquivavel extends Exemplar implements
		TipoExemplarArquivavel {
	private TipoDadosExemplarArquivavel dados;
	private EstadoEmprestimo estado;
	private Date prazoDevolucao;

	public ExemplarArquivavel(TipoDadosExemplarArquivavel dados) {
		super(dados);
		this.dados = dados;
		this.estado = DISPONÍVEL;
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

	public boolean emprestar() {
		if (estado.equals(DISPONÍVEL)){
			estado = EMPRESTADO;
			prazoDevolucao = gerarPrazoDevolucao();
			return true;
		}
		return false;
	}

	private Date gerarPrazoDevolucao() {
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.set(GregorianCalendar.DAY_OF_MONTH, 15);
		
		return calendario.getTime();
	}

	public EstadoEmprestimo obterEstado() {
		return estado;
	}

	public Date obterPrazoDevolucao() {
		if(estado.equals(EMPRESTADO)){
			return prazoDevolucao;
		}
		return new Date();
	}
}
