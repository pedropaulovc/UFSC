package visao.biblioteca.acervo;

import modelo.biblioteca.Documento;
import modelo.biblioteca.Edicao;
import modelo.biblioteca.ListaDe;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoDocumento {

	private PaginaDix pagina;
	private Documento documento;
	private int numeroDocumento;

	public VisaoDocumento(Documento documento, int numeroDocumento,
			PaginaDix pagina) {
		this.pagina = pagina;
		this.numeroDocumento = numeroDocumento;
		this.documento = documento;
		exibir();
	}

	private void exibir() {
		ComponenteDix etiquetaDocumento = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "documento_" + Math.random()
				+ "_" + numeroDocumento);
		etiquetaDocumento.fixarTopo(120).fixarEsquerda(
				550 + 50 + 320 * numeroDocumento).fixarLargura(300).fixarTexto(
				documento.toString());

		ListaDe<Edicao> edicoes = documento.obterEdicoes();
		for (int i = 0; i < edicoes.tamanho(); i++) {
			Edicao edicao = edicoes.obter(i);
			int numeroEdicao = numeroDocumento + i;
			new VisaoEdicao(edicao, numeroEdicao, pagina);
		}
	}
}
