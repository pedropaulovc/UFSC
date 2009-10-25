package producao.livro;

import java.util.HashMap;
import java.util.Map;

public class LivroComExemplares extends Livro implements
		TipoLivroComExemplaresNaoArquivaveis {
	private Map<TipoIdentificacaoExemplar, TipoExemplar> mapaExemplares;

	public LivroComExemplares(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdentificacaoExemplar, TipoExemplar>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdentificacaoExemplar adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterIdentificacao(),
				new Exemplar(dadosExemplar));
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplar obterDadosExemplar(TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdentificacaoExemplar exemplar) {
		mapaExemplares.remove(exemplar);
	}

	public boolean contemExemplar(TipoIdentificacaoExemplar idExemplar) {
		return mapaExemplares.containsKey(idExemplar);
	}

}
