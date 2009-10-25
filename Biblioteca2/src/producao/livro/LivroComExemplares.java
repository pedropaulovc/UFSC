package producao.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroComExemplares extends Livro implements TipoLivroComExemplaresNaoArquivaveis {
	private List<TipoExemplar> listaExemplares;

	public LivroComExemplares(TipoDadosLivro dados) {
		super(dados);
		this.listaExemplares = new ArrayList<TipoExemplar>();
	}

	public int qtdExemplares() {
		return listaExemplares.size();
	}

	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		return listaExemplares.add(new Exemplar(dadosExemplar));
	}

	public TipoExemplar removerExemplar(int i) {
		return listaExemplares.remove(i - 1);
	}

	public TipoNomeEditora obterNomeEditoraExemplar(int i) {
		return listaExemplares.get(i - 1).obterEditora();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(int i) {
		return listaExemplares.get(i - 1).obterAnoPublicacao();
	}

	public TipoDadosExemplar obterDadosExemplar(int i) {
		return listaExemplares.get(i - 1).obterDados();
	}

}
