package producao.log.visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoLog implements TipoVisaoLog {

	private PaginaDix pagina;
	private TipoComponenteDix componente;

	public VisaoLog(PaginaDix p) {
		this.pagina = p;
		montarVisao();
	}

	private void montarVisao() {
		componente = pagina.criarComponente(
				TiposDeComponentesDix.ÁREA_DE_TEXTO, "log");
		componente.fixarTopo(120).fixarEsquerda(550).fixarLargura(400)
				.fixarAltura(400).fixarLegenda("Log de Mensagens");
	}

	public void atualizar(String s) {
		componente.adicionarAoTexto(" - " + s + "\n");
	}

}
