package producao.livro;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LivroComExemplaresArquivaveis extends Livro implements
		TipoLivroComExemplaresArquivaveis {

	private Map<TipoIdentificacaoExemplar, TipoExemplarArquivavel> mapaExemplares;

	public LivroComExemplaresArquivaveis(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdentificacaoExemplar, TipoExemplarArquivavel>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdentificacaoExemplar adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterIdentificacao(), new ExemplarArquivavel(dadosExemplar));
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdentificacaoExemplar exemplar) {
		mapaExemplares.remove(exemplar);
	}

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacaoExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterNumeroChamada();
	}

	public boolean contemExemplar(TipoIdentificacaoExemplar idExemplar) {
		return mapaExemplares.containsKey(idExemplar);
	}

	public boolean emprestar(TipoIdentificacaoExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).emprestar();
	}

	public EstadoEmprestimo obterEstado(TipoIdentificacaoExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).obterEstado();
	}

	public Date obterPrazoDevolucao(TipoIdentificacaoExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).obterPrazoDevolucao();
	}
}
