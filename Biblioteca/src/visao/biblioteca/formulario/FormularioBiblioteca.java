package visao.biblioteca.formulario;

import modelo.biblioteca.ListaDe;
import modelo.biblioteca.MapaDe;
import controle.biblioteca.TratadorEnvioDados;
import controle.biblioteca.TratadorTipoDocumento;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class FormularioBiblioteca {
	private PaginaDix pagina;
	private Orientador orientador;
	private NumeroCapitulos numeroCapitulos;
	private BotaoEnviar botaoEnviar;
	private ListaEscolhaDocumento listaEscolhaDocumento;
	private MapaDe<String, CampoAbstratoFormulario> mapa;
	
	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		this.mapa = new MapaDe<String, CampoAbstratoFormulario>();
		montarFormulario();
	}

	private void montarFormulario() {
		mapa.adicionar("Titulo", new Titulo(pagina)); 
		mapa.adicionar("Autor", new Autor(pagina));
		mapa.adicionar("Numero Chamada", new NumeroChamada(pagina));
		numeroCapitulos = new NumeroCapitulos(pagina);
		mapa.adicionar("Numero Capitulos", numeroCapitulos);
		mapa.adicionar("Ano Publicacao", new AnoPublicacao(pagina));
		mapa.adicionar("Volume", new Volume(pagina));
		mapa.adicionar("Localizacao", new Localizacao(pagina));
		mapa.adicionar("Lista Escolha Situacao", new ListaEscolhaSituacao(pagina));
		listaEscolhaDocumento = new ListaEscolhaDocumento(pagina);
		mapa.adicionar("Lista Escolha Documento", listaEscolhaDocumento);
		orientador = new Orientador(pagina);
		mapa.adicionar("Orientador", orientador);
		botaoEnviar = new BotaoEnviar(pagina);
		mapa.adicionar("Botao Enviar", botaoEnviar); 
	}
	
	public MapaDe<String, CampoAbstratoFormulario> obterCampos(){
		return mapa;
	}
	
	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador){
		botaoEnviar.adicionarTratadorEventos(tratador);
	}
	
	public void adicionarTratadorTipoDocumento(TratadorDixAbstrato tratador){
		listaEscolhaDocumento.adicionarTratadorEventos(tratador);
	}
	
	public void tornarInvisiveisCamposOpcionais() {
		numeroCapitulos.tornarInvisivel();
		orientador.tornarInvisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeLivro() {
		numeroCapitulos.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeDissertacao() {
		orientador.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeTese() {
		orientador.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeTCC() {
		orientador.tornarVisivel();
	}
	
	public FormularioBiblioteca clone() {
		try {
			return (FormularioBiblioteca) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}
