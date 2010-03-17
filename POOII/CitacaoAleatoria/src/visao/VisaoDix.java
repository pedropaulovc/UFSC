package visao;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class VisaoDix extends Aplique {
	public PaginaDix pagina;
	private Estatisticas estatisticas;
	private VisaoExibirCitacaoAleatoria visaoExibirCitacaoAleatoria;
	private CampoAdicionarCitacao campoAdicionarCitacao;
	private BotaoUsarCitacoesAleatorias botaoUsarCitacoesAleatorias;

	public VisaoDix(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		new Titulo(pagina);
		estatisticas = new Estatisticas(pagina);
		visaoExibirCitacaoAleatoria = new VisaoExibirCitacaoAleatoria(pagina);
		campoAdicionarCitacao = new CampoAdicionarCitacao(pagina);
		botaoUsarCitacoesAleatorias = new BotaoUsarCitacoesAleatorias(pagina);
	}

	public void trocarQtdCitacoes(int qtd) {
		estatisticas.atualizar(qtd);
	}

	public void trocarCitacaoAleatoria(String citacao) {
		visaoExibirCitacaoAleatoria.atualizar(citacao);
	}

	public void log(String log) {
		System.out.println(log);
	}

	public String obterCitacaoDigitada() {
		return campoAdicionarCitacao.obterTexto();
	}

	public void adicionarTratadorUsarCitacoesPrefinidas(
			TratadorDixAbstrato tratador) {

		botaoUsarCitacoesAleatorias.adicionarTratadorDeEventos(tratador);
	}

	public void adicionarTratadorExibirCitacaoAleatoria(
			TratadorDixAbstrato tratador) {
		visaoExibirCitacaoAleatoria.adicionarTratadorDeEventos(tratador);

	}

	public void adicionarTratadorAdicionarCitacao(
			TratadorDixAbstrato tratador) {
		campoAdicionarCitacao.adicionarTratadorDeEventos(tratador);
		
	}

}