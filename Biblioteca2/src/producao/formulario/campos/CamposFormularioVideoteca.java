package producao.formulario.campos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import producao.dados.categoria.Categoria;
import producao.video.arquivavel.TipoLancamento;
import edugraf.jadix.componentesDix.ComponenteComLista;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class CamposFormularioVideoteca extends CamposFormularioAbstrato {

	private PaginaDix pagina;
	private CampoFormulario nomeProdutora;
	private CampoFormulario diretor;
	private CampoFormulario enredo;
	private ComponenteComLista categoria;
	private ComponenteComLista tipoLancamento;

	public CamposFormularioVideoteca(PaginaDix pagina) {
		super(pagina);
		this.pagina = pagina;
		criarCamposVideoteca();
	}

	private void criarCamposVideoteca() {
		diretor = new CampoFormulario(pagina, new Rectangle(new Point(170, 20),
				new Dimension(500, 0)), "Diretor");

		nomeProdutora = new CampoFormulario(pagina, new Rectangle(new Point(
				220, 20), new Dimension(500, 0)), "Nome da Produtora");

		enredo = new CampoFormulario(pagina, new Rectangle(new Point(320, 20),
				new Dimension(500, 0)), "Enredo");

		categoria = criarCategoria();

		tipoLancamento = criarTipoLancamento();
	}

	private ComponenteComLista criarTipoLancamento() {
		ComponenteComLista componente = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "tipoLancamento");
		componente.fixarTopo(270).fixarEsquerda(20).fixarLargura(150)
				.fixarLegenda("Tipo Lançamento");
		componente.fixarLista(criarListaLancamento());

		return componente;
	}

	private ComponenteComLista criarCategoria() {
		ComponenteComLista componente = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "categorias");
		componente.fixarTopo(270).fixarEsquerda(200).fixarLargura(150)
				.fixarLegenda("Categoria");
		componente.fixarLista(criarListaCategorias());

		return componente;
	}

	private List<String> criarListaLancamento() {
		List<String> lista = new ArrayList<String>();
		for (TipoLancamento l : TipoLancamento.values()) {
			lista.add(l.toString());
		}
		return lista;
	}

	private List<String> criarListaCategorias() {
		List<String> lista = new ArrayList<String>();
		for (Categoria c : Categoria.values()) {
			lista.add(c.toString());
		}
		return lista;
	}

	public String obterDiretor() {
		return diretor.obterTexto();
	}

	public String obterNomeProdutora() {
		return nomeProdutora.obterTexto();
	}

	public String obterEnredo() {
		return enredo.obterTexto();
	}

	public String obterCategoria() {
		return categoria.obterTexto();
	}

	public String obterTipoLancamento() {
		return tipoLancamento.obterTexto();
	}

}
