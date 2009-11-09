package producao.livro.arquivavel;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.id.TipoId;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.dados.numeroChamada.modelo.NumeroChamadaNulo;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.DocumentoArquivavelNulo;
import producao.documento.arquivavel.EstadoEmprestimo;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivroNulo;
import producao.livro.dados.TipoDadosLivro;

public class LivroArquivavelNulo implements TipoLivroArquivavel {

	private DocumentoArquivavelNulo arquivavelNulo;

	public LivroArquivavelNulo() {
		this.arquivavelNulo = new DocumentoArquivavelNulo();
	}

	public TipoLivro obterLivro() {
		return new LivroNulo();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoDadosLivro obterDados() {
		return new DadosLivroNulo();
	}

	public TipoNome obterNomeEditora() {
		return new NomeNulo();
	}

	public TipoNome obterTitulo() {
		return new NomeNulo();
	}

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return arquivavelNulo.alterarEstado(estado);
	}

	public boolean devolver() {
		return arquivavelNulo.devolver();
	}

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao) {
		return arquivavelNulo.emprestar(tipoPrazoDevolucao);
	}

	public TipoDadosDocumentoArquivavel obterDadosDeArquivo() {
		return arquivavelNulo.obterDadosDeArquivo();
	}

	public TipoDocumento obterDocumento() {
		return arquivavelNulo.obterDocumento();
	}

	public EstadoEmprestimo obterEstado() {
		return arquivavelNulo.obterEstado();
	}

	public TipoId obterId() {
		return arquivavelNulo.obterId();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return arquivavelNulo.obterPrazoDevolucao();
	}

}
