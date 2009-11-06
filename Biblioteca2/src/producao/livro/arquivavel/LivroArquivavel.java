package producao.livro.arquivavel;

import producao.dados.id.TipoId;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.DocumentoArquivavel;
import producao.documento.arquivavel.TipoDocumentoArquivavel;
import producao.livro.EstadoEmprestimo;
import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.DadosLivroArquivavelNulo;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;

public class LivroArquivavel extends Livro implements TipoLivroArquivavel,
		TipoDocumentoArquivavel {
	
	private TipoDadosLivroArquivavel dados;
	private TipoLivro livro;
	private TipoDocumentoArquivavel arquivavel;

	public LivroArquivavel(TipoLivro livro, TipoDadosLivroArquivavel dados) {
		super(livro.obterDados());
		this.arquivavel = new DocumentoArquivavel();
		this.livro = livro;
		this.dados = dados;
	}

	public LivroArquivavel(TipoLivro livro) {
		this(livro, new DadosLivroArquivavelNulo());
	}

	public TipoId obterId() {
		return arquivavel.obterId();
	}

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return arquivavel.alterarEstado(estado);
	}

	public boolean devolver() {
		return arquivavel.devolver();
	}

	public boolean emprestar(TipoPrazoDevolucao prazoDevolucao) {
		return arquivavel.emprestar(prazoDevolucao);
	}

	public EstadoEmprestimo obterEstado() {
		return arquivavel.obterEstado();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dados.obterNumeroChamada();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return arquivavel.obterPrazoDevolucao();
	}

	public TipoLivro obterLivro() {
		return livro;
	}

	public TipoDocumento obterDocumento() {
		return livro;
	}
}
