package producao.biblioteca;

import static producao.livro.exemplar.EstadoEmprestimo.DISPONÍVEL;
import static producao.livro.exemplar.EstadoEmprestimo.EMPRESTADO;
import producao.livro.Livro;
import producao.livro.TipoDadosLivroArquivavel;
import producao.livro.TipoLivro;
import producao.livro.TipoLivroArquivavel;
import producao.livro.exemplar.EstadoEmprestimo;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucaoNulo;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.IdLivro;
import producao.livro.id.TipoIdLivro;

public class LivroArquivavel extends Livro implements TipoLivroArquivavel {

	private TipoIdLivro id;
	private EstadoEmprestimo estado;
	private TipoPrazoDevolucao prazoDevolucao;
	private TipoDadosLivroArquivavel dados;

	public LivroArquivavel(TipoLivro livro, TipoDadosLivroArquivavel dados) {
		super(livro.obterDados());
		this.id = new IdLivro();
		this.estado = DISPONÍVEL;
		this.prazoDevolucao = new PrazoDevolucaoNulo();
		this.dados = dados;
	}
	
	public TipoIdLivro obterId(){
		return id;
	}

	public boolean alterarEstado(EstadoEmprestimo estado) {
		if(estado.equals(EMPRESTADO))
			return false;
		this.estado = estado;
		return true;
	}

	@Override
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

	public boolean emprestar(TipoPrazoDevolucao prazoDevolucao) {
		if (estado.equals(DISPONÍVEL)) {
			estado = EMPRESTADO;
			this.prazoDevolucao = prazoDevolucao;
			return true;
		}
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return estado;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dados.obterNumeroChamada();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return prazoDevolucao;
	}

}
