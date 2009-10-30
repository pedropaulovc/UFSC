package infra;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.nome.NomeBiblioteca;
import producao.livro.TipoLivro;
import producao.livro.autor.Autor;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;
import producao.livro.exemplar.anoPublicacao.AnoPublicacao;
import producao.livro.exemplar.nomeEditora.NomeEditora;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucao;
import producao.livro.titulo.Titulo;

public abstract class CenarioComBiblioteca extends Cenario {
	private TipoEditora editora;
	private TipoDadosLivro dados;
	private TipoConfiguracaoBiblioteca configBiblioteca;

	public CenarioComBiblioteca() {
		this.editora = new Editora();
		this.dados = new DadosLivro(new Titulo("Titulo"), new Autor("Autor"),
				new NomeEditora("Editora"), new AnoPublicacao(1999));
		this.configBiblioteca = new ConfiguracaoBiblioteca(new NomeBiblioteca(
				"Biblioteca Central"), new PrazoDevolucao(15));

	}

	public TipoLivro obterLivro() {
		return editora.criarLivro(dados);
	}

	public TipoBiblioteca obterBiblioteca() {
		return new Biblioteca(configBiblioteca);
	}
	
	public TipoEditora obterEditora(){
		return editora;
	}
}
