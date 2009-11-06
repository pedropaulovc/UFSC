package producao.documento;

import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.titulo.TipoTitulo;

public interface TipoDocumento {
	public TipoTitulo obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();
}
