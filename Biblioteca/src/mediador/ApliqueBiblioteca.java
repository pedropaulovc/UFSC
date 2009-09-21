package mediador;

import controle.ControleBiblioteca;
import controleDadosExemplo.TratadorDadosExemplo;
import dadosExemplo.DadosExemplo;
import visao.VisaoBiblioteca;
import visaoDadosExemplo.VisaoDadosExemplo;
import biblioteca.Biblioteca;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	@Override
	public void iniciar() {
		PaginaDix pagina = this.obterPaginaDix();
		
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
		VisaoBiblioteca visaoBiblioteca = new VisaoBiblioteca(pagina);
		new ControleBiblioteca(biblioteca, visaoBiblioteca);
		
		DadosExemplo dadosDeExemplo = new DadosExemplo(biblioteca);
		VisaoDadosExemplo visaoDadosDeExemplo = new VisaoDadosExemplo(pagina);
		new TratadorDadosExemplo(dadosDeExemplo, visaoDadosDeExemplo);
	}
}