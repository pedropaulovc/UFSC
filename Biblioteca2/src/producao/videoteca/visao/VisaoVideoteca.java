package producao.videoteca.visao;

import java.util.Observable;
import java.util.Observer;

import producao.biblioteca.controle.TratadorEnvioDados;
import producao.dados.nome.visao.VisaoNome;
import producao.estatistica.VisaoEstatisticas;
import producao.formulario.campos.CamposFormularioVideoteca;
import producao.formulario.visao.FormularioVideoteca;
import producao.log.modelo.Mensagem;
import producao.log.visao.VisaoLog;
import producao.videoteca.modelo.Videoteca;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoVideoteca implements Observer {
	private VisaoEstatisticas estatisticas;
	private FormularioVideoteca formulario;
	private Videoteca v;
	private VisaoLog log;

	public VisaoVideoteca(PaginaDix pagina, Videoteca videoteca) {
		this.v = videoteca;
		v.addObserver(this);

		montarVisao(pagina);
	}

	private void montarVisao(PaginaDix pagina) {
		new VisaoNome(v.obterNome(), pagina);
		estatisticas = new VisaoEstatisticas(pagina);
		estatisticas.exibir("Não há vídeos no acervo ainda");
		formulario = new FormularioVideoteca(pagina);
		log = new VisaoLog(pagina);
	}

	public void update(Observable arg0, Object arg1) {
		estatisticas.exibir("Tamanho do acervo: " + v.tamanho());
		log.atualizar(((Mensagem) arg1).toString());
	}

	public CamposFormularioVideoteca obterCamposFormulario() {
		return formulario.obterCampos();
	}

	public void adicionarTratadorEnvioDados(TratadorEnvioDados tratador) {
		formulario.adicionarTratadorEnvioDados(tratador);
	}
}