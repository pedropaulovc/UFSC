package producao.documento.arquivavel;

import static producao.livro.EstadoEmprestimo.NULO;
import producao.dados.anoPublicacao.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.id.IdNulo;
import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.dados.titulo.TipoTitulo;
import producao.dados.titulo.TituloNulo;
import producao.documento.DocumentoNulo;
import producao.documento.TipoDocumento;
import producao.livro.EstadoEmprestimo;

public class DocumentoArquivavelNulo implements TipoDocumentoArquivavel {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return false;
	}

	public boolean devolver() {
		return false;
	}

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao) {
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return NULO;
	}

	public TipoId obterId() {
		return new IdNulo();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return new PrazoDevolucaoNulo();
	}

	public TipoDocumento obterDocumento() {
		return new DocumentoNulo();
	}

}
