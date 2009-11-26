package producao.dados.nome.visao;

import producao.dados.nome.modelo.TipoNome;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoNome {
	private PaginaDix pagina;
	private TipoNome nome;

	public VisaoNome(TipoNome nome, PaginaDix pagina) {
		this.pagina = pagina;
		this.nome = nome;
		criarTitulo();
	}

	private void criarTitulo() {
		pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"nome_" + Math.random()).fixarTopo(20).fixarEsquerda(500)
				.fixarTexto(nome.toString());
	}
}