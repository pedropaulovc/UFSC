package historia.dados;

import static org.junit.Assert.assertNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.nome.modelo.Nome;

public class CriarNomeInvalido extends Cenario {

	private Nome nome;
	private String sNome;

	public void dadoQue() {
		existeUmNomeInválido();
	}

	public void quando() {
		try {criaUmNovoNome();} catch (Exception e) {}
	}

	public void então() {
		recebeErro();
	}

	private void existeUmNomeInválido() {
		this.sNome = "";
	}

	@Test(expected = ExcecaoParametroInvalido.class)
	public void criaUmNovoNome() {
		this.nome = new Nome(sNome);
	}

	@Test
	public void recebeErro() {
		assertNull(nome);
	}

}