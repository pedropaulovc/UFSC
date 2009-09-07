package modelo;

import java.util.ArrayList;

public class ListaCitacoes {
	private ArrayList<Citacao> citacoes;
	
	public void adicionarCitacao(Citacao citacao){
		citacoes.add(citacao);
	}
	
	public Citacao obterCitacao(int num){
		return citacoes.get(num).clone();
	}
	
	public int qtdCitacoes(){
		return citacoes.size();
	}
}
