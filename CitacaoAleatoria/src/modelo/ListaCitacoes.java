package modelo;

import java.util.ArrayList;
import java.util.Random;

public class ListaCitacoes extends ListaCitacoesAbstrata {
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
	
	public Citacao escolherCitacaoAleatoria(){
		Random random = new Random();
		return citacoes.get(random.nextInt(citacoes.size()));
	}

}
