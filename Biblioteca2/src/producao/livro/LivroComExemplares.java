package producao.livro;

import java.util.HashMap;
import java.util.Map;

public class LivroComExemplares extends Livro implements
		TipoLivroComExemplaresNaoArquivaveis {
	private Map<TipoIdentificacao, TipoExemplar> mapaExemplares;

	public LivroComExemplares(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdentificacao, TipoExemplar>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdentificacao adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterIdentificacao(),
				new Exemplar(dadosExemplar));
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplar obterDadosExemplar(TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdentificacao exemplar) {
		mapaExemplares.remove(exemplar);
	}

}
