package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import modelo.CitacaoAleatoria;

import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorUsarCitacoesPrefinidas extends TratadorDixAbstrato {

	private CitacaoAleatoria ca;

	public TratadorUsarCitacoesPrefinidas(CitacaoAleatoria ca) {
		this.ca = ca;
	}

	@Override
	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			try {
				ca.gerarCitacoes(
						"http://www.inf.ufsc.br/~pedropaulovc/pfortune.txt",
						"UTF8", "\r\n%\r\n");
			} catch (FileNotFoundException e) {
				ca.log("FileNotFoundException: " + e.getMessage());
			} catch (UnsupportedEncodingException e) {
				ca.log("UnsupportedEncodingException: " + e.getMessage());
			} catch (IOException e) {
				ca.log("IOException: " + e.getMessage());
			}
		}
	}
}