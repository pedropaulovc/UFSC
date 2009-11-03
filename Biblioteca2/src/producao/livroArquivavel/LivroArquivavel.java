package producao.livroArquivavel;

import static producao.livro.EstadoEmprestimo.*;
import producao.dados.id.Id;
import producao.dados.id.TipoId;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.EstadoEmprestimo;
import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livroArquivavel.dados.TipoDadosLivroArquivavel;

public class LivroArquivavel extends Livro implements TipoLivroArquivavel {

	private TipoId id;
	private EstadoEmprestimo estado;
	private TipoPrazoDevolucao prazoDevolucao;
	private TipoDadosLivroArquivavel dados;
	private TipoLivro livro;

	public LivroArquivavel(TipoLivro livro, TipoDadosLivroArquivavel dados) {
		super(livro.obterDados());
		this.livro = livro;
		this.id = new Id();
		this.estado = DISPONÍVEL;
		this.prazoDevolucao = new PrazoDevolucaoNulo();
		this.dados = dados;
	}
	
	public TipoId obterId(){
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

	public TipoLivro obterLivro() {
		return livro;
	}

}
