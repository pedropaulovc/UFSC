package mensagem;

import estados.EstadoLigacao;
import objetos.Celular;
import objetos.EstacaoBase;
import objetos.NumCelular;

public class Mensagem {

	private NumCelular numeroDestino;
	private NumCelular numeroOrigem;
	private EstacaoBase estacao;
	private CodigosMensagem codigo;
	private Celular celular;
	private EstadoLigacao estadoLigacao;
	private CodigosErro codigosErro;

	public EstacaoBase obterEstacao() {
		return estacao;
	}

	public void definirEstacao(EstacaoBase estacao) {
		this.estacao = estacao;
	}

	public Celular obterCelular() {
		return celular;
	}

	public void definirCelular(Celular celular) {
		this.celular = celular;
	}

	public void definirNumeroOrigem(NumCelular num) {
		this.numeroOrigem = num;
	}

	public NumCelular obterNumeroOrigem() {
		return numeroOrigem;
	}

	public CodigosMensagem obterCodigo() {
		return codigo;
	}

	public void definirCodigo(CodigosMensagem codigo) {
		this.codigo = codigo;
	}

	public NumCelular obterNumeroDestino() {
		return numeroDestino;
	}

	public void definirNumeroDestino(NumCelular num) {
		this.numeroDestino = num;
	}

	public void definirEstadoLigacao(EstadoLigacao estadoLigacao) {
		this.estadoLigacao = estadoLigacao;
	}

	public EstadoLigacao obterEstadoLigacao() {
		return estadoLigacao;
	}

	public void definirCodigoErro(CodigosErro codigosErro) {
		this.codigosErro = codigosErro;
	}

	public CodigosErro obterCodigoErro() {
		return codigosErro;
	}

}
