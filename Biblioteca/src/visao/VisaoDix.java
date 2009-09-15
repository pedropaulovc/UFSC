package visao;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoDix extends Aplique {
	public PaginaDix pagina;
	
	public VisaoDix(PaginaDix pagina){
		this.pagina = pagina;
		criarTitulo();
		criarCaixasOpcoes();
		criarCaixaResultados();
	}
	
	public void criarTitulo(){
		ComponenteDix titulo = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA, "titulo");
		titulo.fixarTopo(10).fixarEsquerda(500).fixarTexto("Sistema de Gerenciamento de Biblioteca");
	}
	
	public void criarCaixasOpcoes(){
		ComponenteDix botao = pagina.criarComponente(TiposDeComponentesDix.BOTÃO, "usarDadosTeste");
		botao.fixarTopo(30).fixarEsquerda(100).fixarTexto("Usar Dados Padrão");
		//botao.adicionarTratadorDeEventos(new TratadorBotaoDadosPadrao());
	}
	
	public void criarCaixaResultados(){
		ComponenteDix resultados = pagina.criarComponente(TiposDeComponentesDix.CAMPO_DE_TEXTO, "caixaResultados");
		resultados.fixarTopo(70).fixarEsquerda(50).fixarAltura(300).fixarLargura(500);
		//resultados.adicionarTratadorDeEventos(TratadorCaixaResultados());
	}
	
	
}