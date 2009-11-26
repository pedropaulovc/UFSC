package producao.formulario.campos;

import producao.dados.anoPublicacao.visao.VisaoAnoPublicacao;
import producao.dados.autor.visao.VisaoAutor;
import producao.dados.nome.visao.VisaoFormularioNome;
import producao.dados.numeroChamada.visao.VisaoNumeroChamada;
import edugraf.jadix.fachada.PaginaDix;

public class CamposFormularioBiblioteca {

	private PaginaDix pagina;
	private VisaoFormularioNome titulo;
	private VisaoAutor autor;
	private VisaoAnoPublicacao anoPublicacao;
	private VisaoNumeroChamada numeroChamada;
	private VisaoFormularioNome nomeEditora;

	public CamposFormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo = new VisaoFormularioNome(pagina);
		autor = new VisaoAutor(pagina);
		anoPublicacao = new VisaoAnoPublicacao(pagina);
		numeroChamada = new VisaoNumeroChamada(pagina);
		nomeEditora = new VisaoFormularioNome(pagina);
	}

	public String obterTitulo() {
		return titulo.obterTexto();
	}

	public String obterAutor() {
		return autor.obterTexto();
	}

	public String obterAnoPublicacao() {
		return anoPublicacao.obterTexto();
	}

	public String obterNumeroChamada() {
		return numeroChamada.obterTexto();
	}

	public String obterNomeEditora() {
		return nomeEditora.obterTexto();
	}
}
