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

	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		return listaExemplares.add(new ExemplarArquivavel(dadosExemplar));
	}

	public TipoExemplarArquivavel removerExemplar(int i) {
		return listaExemplares.remove(i - 1);
	}

	public TipoIdentificacao obterIdentificacaoExemplar(int i) {
		return listaExemplares.get(i - 1).obterId();
	}

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(int i) {
		return listaExemplares.get(i - 1).obterAnoPublicacao();
	}

	public TipoNomeEditora obterNomeEditoraExemplar(int i) {
		return listaExemplares.get(i - 1).obterEditora();
	}

	public TipoDadosExemplar obterDadosExemplar(int i) {
		return listaExemplares.get(i - 1).obterDados();
	}
}
