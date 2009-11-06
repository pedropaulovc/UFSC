package aplique;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.controle.biblioteca.ControleBiblioteca;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.visao.biblioteca.TipoVisaoBiblioteca;
import producao.visao.biblioteca.VisaoBiblioteca;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	@Override
	public void iniciar() {
		PaginaDix pagina = this.obterPaginaDix();

		TipoConfiguracaoBiblioteca config = new ConfiguracaoBiblioteca(
				new Nome("Biblioteca Central"), new PrazoDevolucao(15));
		TipoBiblioteca biblioteca = new Biblioteca(config);

		TipoVisaoBiblioteca visaoBiblioteca = new VisaoBiblioteca(pagina,
				biblioteca);
		biblioteca.adicionarObservador(visaoBiblioteca);

		new ControleBiblioteca(biblioteca, visaoBiblioteca);
	}
}