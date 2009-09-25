package controle;

import modelo.CitacaoAleatoria;
import visao.VisaoDix;
import edugraf.jadix.Aplique;

public class ControleJadix extends Aplique {
	private VisaoDix visao;
	private CitacaoAleatoria ca;

	@Override
	public void iniciar() {
		visao = new VisaoDix(this.obterPaginaDix());
		ca = new CitacaoAleatoria(visao);

		inserirTratadoresEventos();
	}

	private void inserirTratadoresEventos() {
		visao.adicionarTratadorUsarCitacoesPrefinidas(new TratadorUsarCitacoesPrefinidas(ca));
		visao.adicionarTratadorExibirCitacaoAleatoria(new TratadorCitacaoAleatoria(ca));
		visao.adicionarTratadorAdicionarCitacao(new TratadorAdicionarCitacao(ca, visao));
	}
}