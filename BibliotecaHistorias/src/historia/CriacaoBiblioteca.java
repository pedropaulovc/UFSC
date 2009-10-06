package historia;

import infra.Cenario;

import org.junit.*;

public class CriacaoBiblioteca extends Cenario {

	//private Biblioteca b;

	public void dadoQue() {
		existeUmaFábricaDeBiblioteca();
	}	

	public void quando() {
		pedeUmaBiblioteca();
	}
	
	public void então() {
		obtemUmaNovaBiblioteca();
	}
	
	private void existeUmaFábricaDeBiblioteca() {
		//FabricaBiblioteca fabrica = new FabricaBiblioteca();
		
	}
	
	private void pedeUmaBiblioteca() {
		//b = fabrica.criarBiblioteca("Biblioteca Central");
	}
	
	private void obtemUmaNovaBiblioteca() {
		Assert.assertTrue(true);
	}

}
