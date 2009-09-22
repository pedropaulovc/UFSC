package modelo.biblioteca.situacoesEmprestimo;

import java.util.Date;

public class EmRestauracao {
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
}
