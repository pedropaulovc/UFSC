package producao.formulario.campos;

import producao.dados.anoPublicacao.visao.TipoVisaoAnoPublicacao;
import producao.dados.anoPublicacao.visao.VisaoAnoPublicacao;
import producao.dados.autor.visao.TipoVisaoAutor;
import producao.dados.autor.visao.VisaoAutor;
import producao.dados.nome.visao.TipoVisaoCampoNome;
import producao.dados.nome.visao.VisaoCampoNome;
import producao.dados.numeroChamada.visao.TipoVisaoNumeroChamada;
import producao.dados.numeroChamada.visao.VisaoNumeroChamada;
import edugraf.jadix.fachada.PaginaDix;

public class CamposFormulario implements TipoCamposFormulario {

	private PaginaDix pagina;
	private TipoVisaoCampoNome titulo;
	private TipoVisaoAutor autor;
	private TipoVisaoAnoPublicacao anoPublicacao;
	private TipoVisaoNumeroChamada numeroChamada;
	private TipoVisaoCampoNome nomeEditora;

	public CamposFormulario(PaginaDix pagina) {
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo = new VisaoCampoNome(pagina);
		autor = new VisaoAutor(pagina);
		anoPublicacao = new VisaoAnoPublicacao(pagina);
		numeroChamada = new VisaoNumeroChamada(pagina);
		nomeEditora = new VisaoCampoNome(pagina);
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
	
	public String obterNomeEditora(){
		return nomeEditora.obterTexto();
	}
}
