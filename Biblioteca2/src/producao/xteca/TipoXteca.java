package producao.xteca;

import java.util.Observer;

import producao.dados.id.TipoId;
import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.arquivavel.EstadoEmprestimo;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;

public interface TipoXteca {
	public TipoNome obterNome();

	public int tamanho();

	public void removerDocumento(TipoId documento);

	public boolean emprestar(TipoId idDocumento);

	public EstadoEmprestimo obterEstadoDocumento(TipoId idExemplar);

	public TipoDadosDocumentoArquivavel obterDadosDeArquivo(TipoId idDoc);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idDocumento);

	public boolean devolver(TipoId idDocumento);

	public boolean alterarEstado(TipoId idDocumento, EstadoEmprestimo estado);

	public void adicionarObservador(Observer o);
}
