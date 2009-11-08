package producao.formulario;

import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;

public interface TipoAdaptadorFormulario {
	public TipoLivro adaptarLivro();

	public TipoDadosLivroArquivavel adaptarDadosDeArquivo();
}
