package infra;

import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;

public abstract class CenarioComBiblioteca extends Cenario {
	private TipoEditora editora;
	private TipoDadosLivro dados;
	private TipoConfiguracaoBiblioteca configBiblioteca;

	public CenarioComBiblioteca() {
		this.editora = new Editora();
		this.dados = new DadosLivro(new Nome("Titulo"), new Autor("Autor"),
				new Nome("Editora"), new AnoPublicacao(1999));
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
