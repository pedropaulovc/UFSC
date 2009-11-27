package producao.biblioteca.visao;

import java.util.Observable;
import java.util.Observer;

import producao.biblioteca.controle.TratadorEnvioDadosBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.dados.nome.visao.VisaoNome;
import producao.estatistica.VisaoEstatisticas;
import producao.formulario.campos.CamposFormularioBiblioteca;
import producao.formulario.visao.FormularioBiblioteca;
import producao.log.modelo.Mensagem;
import producao.log.visao.VisaoLog;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoBiblioteca implements Observer {
	private VisaoEstatisticas estatisticas;
	private FormularioBiblioteca formulario;
	private Biblioteca b;
	private VisaoLog log;

	public VisaoBiblioteca(PaginaDix pagina, Biblioteca biblioteca) {
		this.b = biblioteca;
		b.addObserver(this);

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

	public CamposFormularioBiblioteca obterCamposFormulario() {
		return formulario.obterCampos();
	}

	public void adicionarTratadorEnvioDados(TratadorEnvioDadosBiblioteca tratador) {
		formulario.adicionarTratadorEnvioDados(tratador);
	}
}