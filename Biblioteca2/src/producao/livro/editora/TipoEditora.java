package producao.livro.editora;

import producao.livro.TipoLivro;
import producao.livro.dados.TipoDadosLivro;

public interface TipoEditora {
	public TipoLivro criarLivro(TipoDadosLivro dados);

}
