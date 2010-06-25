package mensagem;

import estados.EstadoLigacao;
import objetos.Celular;
import objetos.EstacaoBase;
import objetos.NumCelular;

public class Mensagem {

	private NumCelular numero;
	private EstacaoBase estacao;
	private CodigosMensagem codigo;
	private Celular celular;
	private EstadoLigacao estadoLigacao;

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

	public CodigosMensagem obterCodigo() {
		return codigo;
	}

	public void definirCodigo(CodigosMensagem codigo) {
		this.codigo = codigo;
	}

	public NumCelular obterNumero() {
		return numero;
	}

	public void definirNumero(NumCelular num) {
		this.numero = num;
	}

	public void definirEstadoLigacao(EstadoLigacao estadoLigacao) {
		this.estadoLigacao = estadoLigacao;
	}

	public EstadoLigacao obterEstadoLigacao() {
		return estadoLigacao;
	}

}
