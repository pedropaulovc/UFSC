package infra;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.dados.anoPublicacao.AnoPublicacao;
import producao.dados.autor.Autor;
import producao.dados.nome.Nome;
import producao.dados.nomeEditora.NomeEditora;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.dados.titulo.Titulo;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;

public abstract class CenarioComVideoteca extends Cenario {
	private TipoEditora editora;
	private TipoDadosLivro dados;
	private TipoConfiguracaoBiblioteca configBiblioteca;

	public CenarioComVideoteca() {
		this.editora = new Editora();
		this.dados = new DadosLivro(new Titulo("Titulo"), new Autor("Autor"),
				new NomeEditora("Editora"), new AnoPublicacao(1999));
		this.configBiblioteca = new ConfiguracaoBiblioteca(new Nome(
				"Biblioteca Central"), new PrazoDevolucao(15));

	}

	public TipoLivro obterLivro() {
		return editora.criarLivro(dados);
	}

	public TipoBiblioteca obterBiblioteca() {
		return new Biblioteca(configBiblioteca);
	}

	public TipoEditora obterEditora() {
		return editora;
	}
}
