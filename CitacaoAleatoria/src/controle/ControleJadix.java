package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import modelo.Citacao;
import modelo.CitacaoAleatoria;
import visao.VisaoDix;
import edugraf.jadix.Aplique;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class ControleJadix extends Aplique {
	private VisaoDix visao;
	private CitacaoAleatoria ca;

	@Override
	public void iniciar() {
		visao = new VisaoDix(this.obterPaginaDix());
		ca = new CitacaoAleatoria();

		inserirTratadoresEventos();
	}

	private void inserirTratadoresEventos() {
		visao.botaoGereCitacoes
				.adicionarTratadorDeEventos(new TratadorUsarCitacoesPrefinidas());
		visao.citacaoAleatoria
				.adicionarTratadorDeEventos(new TratadorCitacaoAleatoria());
		visao.botaoAdicione
				.adicionarTratadorDeEventos(new TratadorAdicionarCitacao());
	}

	private class TratadorUsarCitacoesPrefinidas extends TratadorDixAbstrato {

		@Override
		public void seDito(EventoSimples evento) {
			if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
				try {
					ca
							.gerarCitacoes(
									"http://www.inf.ufsc.br/~pedropaulovc/pfortune.txt",
									"UTF8", "\r\n%\r\n");
					visao.trocarQtdCitacoes(ca.qtdCitacoes());
					visao.trocarCitacaoAleatoria(ca.obterCitacaoAleatoria());
				} catch (FileNotFoundException e) {
					visao.log("FileNotFoundException: " + e.getMessage());
				} catch (UnsupportedEncodingException e) {
					visao
							.log("UnsupportedEncodingException: "
									+ e.getMessage());
				} catch (IOException e) {
					visao.log("IOException: " + e.getMessage());
				}
			}
		}
	}

	private class TratadorCitacaoAleatoria extends TratadorDixAbstrato {

		@Override
		public void seDito(EventoSimples evento) {
			if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)
					&& ca.qtdCitacoes() > 0) {
				visao.trocarCitacaoAleatoria(ca.obterCitacaoAleatoria());
			}
		}
	}

	private class TratadorAdicionarCitacao extends TratadorDixAbstrato {

		@Override
		public void seDito(EventoSimples evento) {
			if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
				ca.adicionarCitacao(new Citacao(visao.campoAdicione
						.obterTexto()));
				visao.trocarQtdCitacoes(ca.qtdCitacoes());
			}
		}
	}
}