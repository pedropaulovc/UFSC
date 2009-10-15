package historia;

import infra.Cenario;

import org.junit.Test;

public class AdicionarNovoTipoDocumento extends Cenario {

	public void dadoQue() {
		existeUmaBiblioteca();
	}

	public void quando() {
		mandaBibliotecaArmazenarNovoTipoDocumento();
	}

	public void então() {
		bibliotecaAceitaNovoTipoDocumento();
	}

	private void existeUmaBiblioteca() {
	
	}

	private void mandaBibliotecaArmazenarNovoTipoDocumento() {
		
	}

	@Test
	public void bibliotecaAceitaNovoTipoDocumento() {
		
	}
}
