package producao.biblioteca;

import static producao.livro.EstadoEmprestimo.*;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;
import producao.livro.TipoLivroArquivavel;
import producao.livro.autor.TipoAutor;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucaoNulo;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.TipoTitulo;

public class LivroArquivavelNulo implements TipoLivroArquivavel {

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return false;
	}

	public boolean devolver() {
		return false;
	}

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao) {
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return DISPONÍVEL;
	}

	public TipoIdLivro obterId() {
		return new IdLivroNulo();
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
