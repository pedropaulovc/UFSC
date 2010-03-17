package producao.documento;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public interface TipoDocumento {
	public TipoNome obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();

	public TipoDadosDocumento obterDados();
}
