package producao.livroArquivavel;

import static producao.livroArquivavel.emprestimo.EstadoEmprestimo.DISPONÍVEL;
import producao.dados.anoPublicacao.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.autor.AutorNulo;
import producao.dados.autor.TipoAutor;
import producao.dados.id.IdNulo;
import producao.dados.id.TipoId;
import producao.dados.nomeEditora.NomeEditoraNulo;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.numeroChamada.NumeroChamadaNulo;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.dados.titulo.TipoTitulo;
import producao.dados.titulo.TituloNulo;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivroNulo;
import producao.livro.dados.TipoDadosLivro;
import producao.livroArquivavel.devolucao.DevolucaoNula;
import producao.livroArquivavel.devolucao.TipoDevolucao;
import producao.livroArquivavel.emprestimo.EstadoEmprestimo;

public class LivroArquivavelNulo implements TipoLivroArquivavel {

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return false;
	}

	public TipoDevolucao devolver() {
		return new DevolucaoNula();
	}

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao) {
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return DISPONÍVEL;
	}

	public TipoId obterId() {
		return new IdNulo();
	}

	public TipoLivro obterLivro() {
		return new LivroNulo();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

	@Override
	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return new PrazoDevolucaoNulo();
	}

	@Override
	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoDadosLivro obterDados() {
		return new DadosLivroNulo();
	}

	public TipoNomeEditora obterNomeEditora() {
		return new NomeEditoraNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

}
