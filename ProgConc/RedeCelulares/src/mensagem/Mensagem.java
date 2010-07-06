package mensagem;

import estados.EstadoLigacao;
import objetos.Celular;
import objetos.NumCelular;

public class Mensagem {

	private CodigosMensagem codigo;
	private NumCelular destino;
	private NumCelular origem;
	private EstadoLigacao estado;
	private int id;
	private CaixaPostal caixaPostal = CaixaPostal.obterCaixa();
	private Celular celular;

	public void definirCodigo(CodigosMensagem codigo) {
		this.codigo = codigo;
	}

	public CodigosMensagem obterCodigo() {
		return codigo;
	}

	public NumCelular obterDestino() {
		return destino;
	}

	public void definirDestino(NumCelular destino) {
		this.destino = destino;
	}

	public void definirOrigem(NumCelular origem) {
		this.origem = origem;
	}

	public NumCelular obterOrigem() {
		return origem;
	}

	public void definirEstadoLigacao(EstadoLigacao estado) {
		this.estado = estado;
	}

	public EstadoLigacao obterEstadoLigacao() {
		return estado;
	}

	public void gerarId() {
		this.id = caixaPostal.gerarNovaCaixaPostal();
	}

	public int obterId() {
		return id;
	}

	public void definirCelular(Celular celular) {
		this.celular = celular;		
	}
	
	public Celular obterCelular(){
		return celular;
	}

}
