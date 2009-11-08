package producao.biblioteca.visao;

import java.util.Observable;
import java.util.Observer;

import producao.biblioteca.controle.TratadorEnvioDados;
import producao.biblioteca.estatistica.VisaoEstatisticas;
import producao.biblioteca.estatistica.TipoVisaoEstatisticas;
import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.nome.visao.VisaoNome;
import producao.formulario.campos.TipoCamposFormulario;
import producao.formulario.visao.FormularioBiblioteca;
import producao.formulario.visao.TipoFormularioBiblioteca;
import producao.log.modelo.Mensagem;
import producao.log.visao.TipoVisaoLog;
import producao.log.visao.VisaoLog;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoBiblioteca implements TipoVisaoBiblioteca, Observer {
	private TipoVisaoEstatisticas estatisticas;
	private TipoFormularioBiblioteca formulario;
	private TipoBiblioteca b;
	private TipoVisaoLog log;

	public VisaoBiblioteca(PaginaDix pagina, TipoBiblioteca biblioteca) {
		this.b = biblioteca;
		b.adicionarObservador(this);

		montarVisao(pagina);
	}

	private void montarVisao(PaginaDix pagina) {
		new VisaoNome(b.obterNome(), pagina);
		estatisticas = new VisaoEstatisticas(pagina);
		estatisticas.exibir("Não há livro no acervo ainda");
		formulario = new FormularioBiblioteca(pagina);
		log = new VisaoLog(pagina);
	}

	public void update(Observable arg0, Object arg1) {
		estatisticas.exibir("Tamanho do acervo: " + b.tamanho());
		log.atualizar(((Mensagem) arg1).toString());
	}

	public TipoCamposFormulario obterCamposFormulario() {
		return formulario.obterCampos();
	}

	public void adicionarTratadorEnvioDados(TratadorEnvioDados tratador) {
		formulario.adicionarTratadorEnvioDados(tratador);
	}
}