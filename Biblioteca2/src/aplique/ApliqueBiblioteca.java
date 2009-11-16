package aplique;

import producao.biblioteca.controle.ControleBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.TipoBiblioteca;
import producao.biblioteca.modelo.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.modelo.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.visao.TipoVisaoBiblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	public void iniciar() {
		PaginaDix pagina = this.obterPaginaDix();

		TipoConfiguracaoBiblioteca config = new ConfiguracaoBiblioteca(
				new Nome("Biblioteca Central"), new PrazoDevolucao(15));
		TipoBiblioteca biblioteca = new Biblioteca(config);

		TipoVisaoBiblioteca visaoBiblioteca = new VisaoBiblioteca(pagina,
				biblioteca);

		new ControleBiblioteca(biblioteca, visaoBiblioteca);
	}
}