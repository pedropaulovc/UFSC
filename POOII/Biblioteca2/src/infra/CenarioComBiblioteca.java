package infra;

import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.configuracao.ConfiguracaoBiblioteca;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.livro.Livro;
import producao.livro.dados.DadosLivro;
import producao.livro.editora.Editora;

public abstract class CenarioComBiblioteca extends Cenario {
	private Editora editora;
	private DadosLivro dados;
	private ConfiguracaoBiblioteca configBiblioteca;

	public CenarioComBiblioteca() {
		this.editora = new Editora();
		this.dados = new DadosLivro(new Nome("Titulo"), new Autor("Autor"),
				new Nome("Editora"), new AnoPublicacao(1999));
		this.configBiblioteca = new ConfiguracaoBiblioteca(new Nome(
				"Biblioteca Central"), new PrazoDevolucao(15));

	}

	public Livro obterLivro() {
		return editora.criarLivro(dados);
	}

	public Biblioteca obterBiblioteca() {
		return new Biblioteca(configBiblioteca);
	}

	public Editora obterEditora() {
		return editora;
	}
}
