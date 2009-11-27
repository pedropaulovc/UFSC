package aplique.selecaoSistemas;

import static edugraf.jadix.fachada.TiposDeComponentesDix.LISTA_DE_ESCOLHA;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import producao.biblioteca.controle.ControleBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.formulario.visao.BotaoEnviar;
import producao.videoteca.controle.ControleVideoteca;
import producao.videoteca.modelo.Videoteca;
import producao.videoteca.modelo.configuracao.ConfiguracaoVideoteca;
import producao.videoteca.visao.VisaoVideoteca;
import edugraf.jadix.componentesDix.ComponenteComLista;
import edugraf.jadix.fachada.PaginaDix;

public class SelecaoSistemas {
	private PaginaDix pagina;
	private ComponenteComLista componente;
	private BotaoEnviar botao;

	public SelecaoSistemas(PaginaDix pagina) {
		this.pagina = pagina;
		criarCaixaDeSelecao();
		criarBotão();
	}

	private void criarCaixaDeSelecao() {
		componente = pagina.criarComponente(LISTA_DE_ESCOLHA, "listaEscolha");
		componente.fixarTopo(270).fixarEsquerda(270).fixarLegenda(
				"Escolha seu sistema").fixarLargura(150);
		componente.fixarLista(criarListaSistemas());
	}

	private void criarBotão() {
		botao = new BotaoEnviar(pagina, new Rectangle(new Point(
				300, 300), new Dimension(100, 0)), "Escolher");

		TratadorSelecaoSistemas tratador = new TratadorSelecaoSistemas(this);

		botao.adicionarTratadorEventos(tratador);
	}

	private List<String> criarListaSistemas() {
		List<String> lista = new ArrayList<String>();
		lista.add("Biblioteca");
		lista.add("Videoteca");
		return lista;
	}

	public String obterEscolha() {
		return componente.obterTexto();
	}

	public void adicionarTratadorSelecaoSistemas(
			TratadorSelecaoSistemas tratador) {
		componente.adicionarTratadorDeEventos(tratador);
	}

	public void criarVideoteca() {
		removerSelecao();
		ConfiguracaoVideoteca config = new ConfiguracaoVideoteca(new Nome(
				"Videoteca"), new PrazoDevolucao(10));
		Videoteca videoteca = new Videoteca(config);
		System.out.println(videoteca);

		VisaoVideoteca visaoVideoteca = new VisaoVideoteca(pagina, videoteca);

		new ControleVideoteca(videoteca, visaoVideoteca);
	}

	public void criarBiblioteca() {
		removerSelecao();
		ConfiguracaoBiblioteca config = new ConfiguracaoBiblioteca(new Nome(
				"Biblioteca Central"), new PrazoDevolucao(15));
		Biblioteca biblioteca = new Biblioteca(config);

		VisaoBiblioteca visaoBiblioteca = new VisaoBiblioteca(pagina,
				biblioteca);

		new ControleBiblioteca(biblioteca, visaoBiblioteca);
	}

	private void removerSelecao() {
		componente.tornarInvisivel();
		botao.tornarInvisivel();
	}
}
