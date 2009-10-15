package historia;

import junit.framework.Assert;

import org.junit.Test;

import producao.documento.AnoPublicacaoConcreto;
import producao.documento.AutorConcreto;
import producao.documento.EdicaoConcreta;
import producao.documento.EditoraConcreta;
import producao.documento.NumeroChamadaConcreto;
import producao.documento.TituloConcreto;
import producao.livro.ConstrutorDeLivro;
import producao.livro.Livro;
import infra.Cenario;

public class CriarLivro extends Cenario {
	private ConstrutorDeLivro c;
	private Livro l;

	public void dadoQue() {
		existeUmConstrutorDeLivro();
	}

	public void quando() {
		mandoCriarUmLivroNovo();
	}

	public void então() {
		receboUmNovoLivro();
	}

	private void existeUmConstrutorDeLivro() {
		c = new ConstrutorDeLivro();

	}

	private void mandoCriarUmLivroNovo() {
		c.alterarTitulo(new TituloConcreto("Título"));
		c.alterarAutor(new AutorConcreto("Autor"));
		c.alterarEdicao(new EdicaoConcreta("2a ed."));
		c.alterarAnoPublicacao(new AnoPublicacaoConcreto(1999));
		c.alterarNumeroChamada(new NumeroChamadaConcreto("Número chamada 123"));
		c.alterarEditora(new EditoraConcreta("Editora"));

		l = c.obterLivro();
	}

	@Test
	public void receboUmNovoLivro() {
		Assert.assertEquals(l.obterTitulo().toString(), new TituloConcreto(
				"Título").toString());
		
		Assert.assertEquals(l.obterEdicao().toString(), new EdicaoConcreta(
				"2a ed.").toString());
		
		Assert.assertEquals(l.obterAnoPublicacao().toString(),
				new AnoPublicacaoConcreto(1999).toString());
		
		Assert.assertEquals(l.obterNumeroChamada().toString(),
				new NumeroChamadaConcreto("Número chamada 123").toString());
		
		Assert.assertEquals(l.obterEditora().toString(), new EditoraConcreta(
				"Editora").toString());
	}
}
