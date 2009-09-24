package modelo.biblioteca.estadosEmprestimo;

import java.util.Date;

public class EmRestauracao implements Situacao {
	private Date dataPrevistaRetorno;
	
	public EmRestauracao(Date dataPrevistaRetorno){
		this.dataPrevistaRetorno = dataPrevistaRetorno;
	}
	
	public Date obterDataPrevistaRetorno(){
		return dataPrevistaRetorno;
	}
	
	public void alterarDataPrevistaRetorno(Date dataPrevistaRetorno){
		this.dataPrevistaRetorno = dataPrevistaRetorno;
	}
	
	public EmRestauracao clone(){
		return new EmRestauracao(dataPrevistaRetorno);
	}
}
