package mediador;

import modelo.biblioteca.Biblioteca;
import modelo.dadosExemplo.DadosExemplo;
import controle.DadosExemplo.TratadorDadosExemplo;
import controle.biblioteca.ControleBiblioteca;
import visao.biblioteca.VisaoBiblioteca;
import visao.dadosExemplo.VisaoDadosExemplo;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	@Override
	public void iniciar() {
		PaginaDix pagina = this.obterPaginaDix();
		
		VisaoBiblioteca visaoBiblioteca = new VisaoBiblioteca(pagina);
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", visaoBiblioteca);
		new ControleBiblioteca(biblioteca, visaoBiblioteca);
		
		DadosExemplo dadosDeExemplo = new DadosExemplo(biblioteca);
		VisaoDadosExemplo visaoDadosDeExemplo = new VisaoDadosExemplo(pagina);
		new TratadorDadosExemplo(dadosDeExemplo, visaoDadosDeExemplo);
	}
}