package producao.livro.exemplar;

import java.util.HashMap;
import java.util.Map;

import producao.livro.Livro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;

public class LivroComExemplares extends Livro implements
		TipoLivroComExemplaresNaoArquivaveis {
	private Map<TipoIdExemplar, TipoExemplar> mapaExemplares;

	public LivroComExemplares(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdExemplar, TipoExemplar>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdExemplar adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterId(),
				new Exemplar(dadosExemplar));
		
		return dadosExemplar.obterId();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplar obterDadosExemplar(TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdExemplar exemplar) {
		mapaExemplares.remove(exemplar);
	}

	public boolean contemExemplar(TipoIdExemplar idExemplar) {
		return mapaExemplares.containsKey(idExemplar);
	}

}
