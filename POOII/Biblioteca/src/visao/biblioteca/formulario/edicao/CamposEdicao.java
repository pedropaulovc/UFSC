package visao.biblioteca.formulario.edicao;

import edugraf.jadix.fachada.PaginaDix;

public class CamposEdicao {
	private PaginaDix pagina;
	private NumeroChamada numeroChamada;
	private AnoPublicacao anoPublicacao;

	public CamposEdicao(PaginaDix pagina){
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		anoPublicacao = new AnoPublicacao(pagina); 
		numeroChamada = new NumeroChamada(pagina);
	}
	
	public String obterAnoPublicacao(){
		return anoPublicacao.obterTexto();
	}
	
	public String obterNumeroChamada(){
		return numeroChamada.obterTexto();
	}
}
