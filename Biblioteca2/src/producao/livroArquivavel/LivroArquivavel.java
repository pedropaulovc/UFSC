package producao.livroArquivavel;

import static producao.livroArquivavel.emprestimo.EstadoEmprestimo.DISPONÍVEL;
import static producao.livroArquivavel.emprestimo.EstadoEmprestimo.EMPRESTADO;
import producao.dados.id.Id;
import producao.dados.id.TipoId;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livroArquivavel.dados.DadosLivroArquivavelNulo;
import producao.livroArquivavel.dados.TipoDadosLivroArquivavel;
import producao.livroArquivavel.devolucao.Devolucao;
import producao.livroArquivavel.devolucao.DevolucaoNula;
import producao.livroArquivavel.devolucao.TipoDevolucao;
import producao.livroArquivavel.emprestimo.EstadoEmprestimo;

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

	public LivroArquivavel(TipoLivro livro) {
		this(livro, new DadosLivroArquivavelNulo());
	}

	public TipoId obterId() {
		return id;
	}

	public boolean alterarEstado(EstadoEmprestimo estado) {
		if (estado.equals(EMPRESTADO))
			return false;
		this.estado = estado;
		return true;
	}

	public TipoDevolucao devolver() {
		if (!estado.equals(EMPRESTADO))
			return new DevolucaoNula();

		if (prazoDevolucao.estaNoPrazo()) {
			estado = DISPONÍVEL;
			prazoDevolucao = new PrazoDevolucaoNulo();
			return new Devolucao();
		}
		return new Devolucao();
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
