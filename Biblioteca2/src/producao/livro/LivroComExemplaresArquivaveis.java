package producao.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroComExemplaresArquivaveis extends Livro implements
		TipoLivroComExemplaresArquivaveis {

	private List<TipoExemplarArquivavel> listaExemplares;

	public LivroComExemplaresArquivaveis(TipoDadosLivro dados) {
		super(dados);
		this.listaExemplares = new ArrayList<TipoExemplarArquivavel>();
	}

	public int qtdExemplares() {
		return listaExemplares.size();
	}

	public boolean adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar) {
		return listaExemplares.add(new ExemplarArquivavel(dadosExemplar));
	}

	public TipoExemplarArquivavel removerExemplar(int i) {
		return listaExemplares.remove(i - 1);
	}

	public TipoIdentificacao obterIdentificacaoExemplar(int i) {
		return listaExemplares.get(i - 1).obterIdentificacao();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(int i) {
		return listaExemplares.get(i - 1).obterAnoPublicacao();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(int i) {
		return listaExemplares.get(i - 1).obterEditora();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(int i) {
		return listaExemplares.get(i - 1).obterDados();
	}

	@Override
	public TipoNumeroChamada obterNumeroChamada(int i) {
		return listaExemplares.get(i - 1).obterNumeroChamada();
	}
}
