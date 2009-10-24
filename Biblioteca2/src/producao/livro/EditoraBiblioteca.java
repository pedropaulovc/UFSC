package producao.livro;

public class EditoraBiblioteca implements TipoEditoraBiblioteca {

	public TipoLivroArquivavel criarLivro(TipoDadosLivro dados) {
		return new LivroArquivavel(dados);
	}
}
