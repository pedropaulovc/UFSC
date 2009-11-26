package producao.xteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import producao.dados.id.TipoId;
import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.DocumentoArquivavelNulo;
import producao.documento.arquivavel.EstadoEmprestimo;
import producao.documento.arquivavel.TipoDocumentoArquivavel;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;
import producao.log.modelo.Mensagem;
import producao.xteca.configuracao.ConfiguracaoXteca;

public abstract class Xteca extends Observable {
	private Map<TipoId, TipoDocumentoArquivavel> mapaDocumentos;
	private ConfiguracaoXteca config;

	public Xteca(ConfiguracaoXteca config) {
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

		notificarAlteracao("Documento " + doc.toString() + "foi removido.", doc);
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idLivro) {
		return buscarDocumento(idLivro).obterPrazoDevolucao();
	}

	public boolean devolver(TipoId doc) {
		boolean devolvido = buscarDocumento(doc).devolver();
		if (devolvido)
			notificarAlteracao(
					"Documento " + doc.toString() + " foi devolvido", doc);
		return devolvido;
	}

	public boolean alterarEstado(TipoId doc, EstadoEmprestimo estado) {
		boolean alterado = buscarDocumento(doc).alterarEstado(estado);
		if (alterado)
			notificarAlteracao("Documento " + doc.toString()
					+ " passou para o estado " + estado.toString(), doc);
		return alterado;
	}

	public EstadoEmprestimo obterEstadoDocumento(TipoId doc) {
		return buscarDocumento(doc).obterEstado();
	}

	public boolean emprestar(TipoId doc) {
		boolean emprestado = buscarDocumento(doc).emprestar(
				config.obterNovoPrazoDevolucao());
		if (emprestado)
			notificarAlteracao("Documento " + doc.toString()
					+ " foi emprestado", doc);
		return emprestado;
	}

	public TipoId adicionarDocumento(TipoDocumentoArquivavel doc) {
		assert doc != null;

		mapaDocumentos.put(doc.obterId(), doc);
		notificarAlteracao("Foi adicionado novo documento sob a id "
				+ doc.obterId().toString(), doc);
		return doc.obterId();
	}

	public TipoDadosDocumentoArquivavel obterDadosDeArquivo(TipoId idDoc) {
		return buscarDocumento(idDoc).obterDadosDeArquivo();
	}

	public TipoDocumento obterDocumento(TipoId idDocumento) {
		return buscarDocumento(idDocumento).obterDocumento();
	}

	private TipoDocumentoArquivavel buscarDocumento(TipoId idDoc) {
		TipoDocumentoArquivavel doc = mapaDocumentos.get(idDoc);
		if (doc != null)
			return doc;
		return new DocumentoArquivavelNulo();
	}

	/*public void adicionarObservador(Observer o) {
		addObserver(o);
	}*/

	private void notificarAlteracao(String mensagem, Object o) {
		setChanged();
		notifyObservers(new Mensagem(mensagem, o));
	}
}
