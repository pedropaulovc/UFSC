package producao.livro.exemplar;

import java.util.HashMap;
import java.util.Map;

import producao.livro.Livro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;

public class LivroComExemplaresArquivaveis extends Livro implements
		TipoLivroComExemplaresArquivaveis {

	private Map<TipoIdExemplar, TipoExemplarArquivavel> mapaExemplares;

	public LivroComExemplaresArquivaveis(TipoDadosLivro dados) {
		super(dados);
		this.mapaExemplares = new HashMap<TipoIdExemplar, TipoExemplarArquivavel>();
	}

	public int qtdExemplares() {
		return mapaExemplares.size();
	}

	public TipoIdExemplar adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar) {
		mapaExemplares.put(dadosExemplar.obterIdentificacao(), new ExemplarArquivavel(dadosExemplar));
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterAnoPublicacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterDados();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterEditora();
	}

	public void removerExemplar(TipoIdExemplar exemplar) {
		mapaExemplares.remove(exemplar);
	}

	public TipoNumeroChamada obterNumeroChamada(TipoIdExemplar exemplar) {
		return mapaExemplares.get(exemplar).obterNumeroChamada();
	}

	public boolean contemExemplar(TipoIdExemplar idExemplar) {
		return mapaExemplares.containsKey(idExemplar);
	}

	public boolean emprestar(TipoIdExemplar idExemplar, int prazo) {
		return mapaExemplares.get(idExemplar).emprestar(prazo);
	}

	public EstadoEmprestimo obterEstado(TipoIdExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).obterEstado();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).obterPrazoDevolucao();
	}

	@Override
	public boolean devolver(TipoIdExemplar idExemplar) {
		return mapaExemplares.get(idExemplar).devolver();
	}
}
