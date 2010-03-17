package infra;

import org.junit.Before;

public abstract class Cenario implements TipoCenario {
	
	@Before
	public void preliminares(){
		dadoQue();
		quando();
	}

}
