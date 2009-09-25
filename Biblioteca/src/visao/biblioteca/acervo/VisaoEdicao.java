package visao.biblioteca.acervo;

import modelo.biblioteca.Edicao;
import modelo.biblioteca.Exemplar;
import modelo.biblioteca.ListaDe;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoEdicao {

	private PaginaDix pagina;
	private int numeroEdicao;
	private Edicao edicao;

	public VisaoEdicao(Edicao edicao, int numeroEdicao, PaginaDix pagina) {
		this.edicao = edicao;
		this.numeroEdicao = numeroEdicao;
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		ComponenteDix etiquetaEdicao = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "edicao_" + Math.random()
				+ "_" + numeroEdicao);
		etiquetaEdicao.fixarTopo(180).fixarEsquerda(
				550 + 70 + 320 * numeroEdicao).fixarLargura(300).fixarTexto(edicao.toString());
		
		ListaDe<Exemplar> exemplares = edicao.obterExemplares();
		for(int i = 0; i < exemplares.tamanho(); i++){
			Exemplar exemplar = exemplares.obter(i);
			int numeroExemplar = i + numeroEdicao;
			new VisaoExemplar(exemplar, numeroExemplar, pagina);
		}
		
	}



}
