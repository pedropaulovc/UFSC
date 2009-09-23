package visao.biblioteca.formulario;

import controle.biblioteca.TratadorTipoDocumento;
import edugraf.jadix.fachada.PaginaDix;

public class FormularioBiblioteca {
	private PaginaDix pagina;
	private Orientador orientador;
	private NumeroCapitulos numeroCapitulos;
	private ListaEscolhaDocumento listaEscolhaDocumento;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
		adicionarTratadoresEventos();
	}

	private void montarFormulario() {
		new Titulo(pagina);
		new Autor(pagina);
		new NumeroChamada(pagina);
		numeroCapitulos = new NumeroCapitulos(pagina);
		new AnoPublicacao(pagina);
		new Volume(pagina);
		new Localizacao(pagina);
		new ListaEscolhaSituacao(pagina);
		listaEscolhaDocumento = new ListaEscolhaDocumento(pagina);
		orientador = new Orientador(pagina);
		new BotaoEnviar(pagina);
	}
	
	private void adicionarTratadoresEventos() {
		//botaoEnviar.adicionarTratadorEventos(new TratadorEnvioDados())
		listaEscolhaDocumento.adicionarTratadorEventos(new TratadorTipoDocumento(this));
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
