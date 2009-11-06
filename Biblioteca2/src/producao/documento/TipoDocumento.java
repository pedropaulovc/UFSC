package producao.documento;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.titulo.TipoTitulo;

public interface TipoDocumento {
	public TipoTitulo obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();
}
