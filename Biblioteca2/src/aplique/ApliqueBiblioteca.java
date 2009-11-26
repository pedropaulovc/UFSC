package aplique;

import producao.biblioteca.controle.ControleBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	private Biblioteca biblioteca;
	private PaginaDix pagina;
	private VisaoBiblioteca visaoBiblioteca;

	public void iniciar() {
		pagina = this.obterPaginaDix();

		criarModelo();
		criarVisao();
		criarControle();
	}

	private void criarModelo() {
		ConfiguracaoBiblioteca config = new ConfiguracaoBiblioteca(new Nome(
				"Biblioteca Central"), new PrazoDevolucao(15));
		biblioteca = new Biblioteca(config);
	}

	private void criarVisao() {
		visaoBiblioteca = new VisaoBiblioteca(pagina, biblioteca);
	}

	private void criarControle() {
		new ControleBiblioteca(biblioteca, visaoBiblioteca);
	}
}