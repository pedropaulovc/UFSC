package producao.livro;

import java.util.HashMap;
import java.util.Map;

public class LivroComExemplaresArquivaveis extends Livro implements
		TipoLivroComExemplaresArquivaveis {

	private Map<TipoIdentificacao, TipoExemplarArquivavel> mapaExemplares;

	public LivroComExemplaresArquivaveis(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdentificacao, TipoExemplarArquivavel>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdentificacao adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterIdentificacao(), new ExemplarArquivavel(dadosExemplar));
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdentificacao exemplar) {
		mapaExemplares.remove(exemplar);
	}

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacao exemplar) {
		return mapaExemplares.get(exemplar).obterNumeroChamada();
	}
}
