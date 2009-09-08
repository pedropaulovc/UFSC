package modelo;

import java.util.ArrayList;
import java.util.Random;

public class ListaCitacoes {
	private ArrayList<Citacao> citacoes;
	
	public ListaCitacoes() {
		citacoes = new ArrayList<Citacao>();
	}
	
	public void adicionarCitacao(Citacao citacao){
		citacoes.add(citacao);
	}
	
	public Citacao obterCitacao(int num){
		return citacoes.get(num).clone();
	}
	
	public int qtdCitacoes(){
		return citacoes.size();
	}
	
	public Citacao obterCitacaoAleatoria(){
		Random random = new Random();
		return citacoes.get(random.nextInt(citacoes.size())).clone();
	}

}
