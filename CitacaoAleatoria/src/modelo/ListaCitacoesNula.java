package modelo;

public class ListaCitacoesNula extends ListaCitacoesAbstrata {

	@Override
	public void adicionarCitacao(Citacao citacao) {	}

	public CitacaoNula escolherCitacaoAleatoria() {
		return new CitacaoNula();
	}

	public CitacaoNula obterCitacao(int num) {
		return new CitacaoNula();
	}

	@Override
	public int qtdCitacoes() {
		return 0;
	}

}
