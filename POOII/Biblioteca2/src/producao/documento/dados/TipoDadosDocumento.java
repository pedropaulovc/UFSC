package producao.documento.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.TipoNome;

public interface TipoDadosDocumento {
	public TipoNome obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();
}
