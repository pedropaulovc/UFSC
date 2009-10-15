package producao.livro;

import java.util.List;

import producao.documento.AnoPublicacao;
import producao.documento.Autor;
import producao.documento.Edicao;
import producao.documento.Editora;
import producao.documento.NumeroChamada;
import producao.documento.Titulo;

public interface Livro {
	List<Autor> obterAutores();
	Titulo obterTitulo();
	Edicao obterEdicao();
	AnoPublicacao obterAnoPublicacao();
	NumeroChamada obterNumeroChamada();
	Editora obterEditora();
	void alterarTitulo(Titulo titulo);
	void alterarListaAutores(List<Autor> listaAutores);
	void alterarEdicao(Edicao edicao);
	void alterarAnoPublicacao(AnoPublicacao anoPublicacao);
	void alterarNumeroChamada(NumeroChamada numeroChamada);
	void alterarEditora(Editora editora);
}
