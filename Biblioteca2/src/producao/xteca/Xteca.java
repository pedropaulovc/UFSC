package producao.xteca;

import java.util.HashMap;
import java.util.Map;

import producao.dados.id.TipoId;
import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.DocumentoArquivavelNulo;
import producao.documento.arquivavel.TipoDocumentoArquivavel;
import producao.livro.EstadoEmprestimo;
import producao.xteca.configuracao.TipoConfiguracaoXteca;

public abstract class Xteca implements TipoXteca {
	private Map<TipoId, TipoDocumentoArquivavel> mapaDocumentos;
	private TipoConfiguracaoXteca config;

	public Xteca(TipoConfiguracaoXteca config) {
		assert config != null;

		this.config = config;
		this.mapaDocumentos = new HashMap<TipoId, TipoDocumentoArquivavel>();
	}

	public int tamanho() {
		return mapaDocumentos.size();
	}

	public TipoNome obterNome() {
		return config.obterNome();
	}

	public void removerDocumento(TipoId doc) {
		mapaDocumentos.remove(doc);
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idLivro) {
		return buscarDocumento(idLivro).obterPrazoDevolucao();
	}

	public boolean devolver(TipoId idLivro) {
		return buscarDocumento(idLivro).devolver();
	}

	public boolean alterarEstado(TipoId idLivro, EstadoEmprestimo estado) {
		return buscarDocumento(idLivro).alterarEstado(estado);
	}

	public EstadoEmprestimo obterEstadoDocumento(TipoId idLivro) {
		return buscarDocumento(idLivro).obterEstado();
	}

	public boolean emprestar(TipoId idLivro) {
		return buscarDocumento(idLivro).emprestar(
				config.obterNovoPrazoDevolucao());
	}

	public TipoId adicionarDocumento(TipoDocumentoArquivavel doc) {
		mapaDocumentos.put(doc.obterId(), doc);

		return doc.obterId();
	}

	public TipoDocumento obterDocumento(TipoId idDocumento) {
		return buscarDocumento(idDocumento).obterDocumento();
	}

	private TipoDocumentoArquivavel buscarDocumento(TipoId idLivro) {
		TipoDocumentoArquivavel doc = mapaDocumentos.get(idLivro);
		if (doc != null)
			return doc;
		return new DocumentoArquivavelNulo();
	}
}
