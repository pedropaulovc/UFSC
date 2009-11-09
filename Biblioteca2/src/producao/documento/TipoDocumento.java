package producao.documento;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.TipoNome;

public interface TipoDocumento {
	public TipoNome obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();
}
