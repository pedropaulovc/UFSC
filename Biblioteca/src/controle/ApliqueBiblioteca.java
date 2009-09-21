package controle;

import dadosExemplo.DadosDeExemplo;
import visao.VisaoDadosExemplo;
import visao.VisaoDix;
import biblioteca.Biblioteca;
import edugraf.jadix.Aplique;

public class ApliqueBiblioteca extends Aplique {
	@Override
	public void iniciar() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
		new VisaoDix(this.obterPaginaDix());

		VisaoDadosExemplo visaoDadosExemplo = new VisaoDadosExemplo(this
				.obterPaginaDix());
		visaoDadosExemplo.adicionarTratador(new TratadorDadosExemplo(
				new DadosDeExemplo(biblioteca)));

	}
}