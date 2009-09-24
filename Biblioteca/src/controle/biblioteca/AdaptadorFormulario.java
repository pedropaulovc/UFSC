package controle.biblioteca;

import java.lang.reflect.Constructor;

import modelo.biblioteca.Biblioteca;
import modelo.biblioteca.Documento;
import modelo.biblioteca.Edicao;
import modelo.biblioteca.Exemplar;
import modelo.biblioteca.MapaDe;
import modelo.biblioteca.NumeroChamada;
import modelo.biblioteca.arquivaveis.Arquivavel;
import modelo.biblioteca.arquivaveis.ArquivavelNulo;
import modelo.biblioteca.estadosEmprestimo.Situacao;
import modelo.biblioteca.estadosEmprestimo.SituacaoNula;
import visao.biblioteca.VisaoBiblioteca;
import visao.biblioteca.formulario.CampoAbstratoFormulario;
import visao.biblioteca.formulario.FormularioBiblioteca;

public class AdaptadorFormulario {
	private Biblioteca biblioteca;
	private FormularioBiblioteca formulario;
	private MapaDe<String, CampoAbstratoFormulario> mapa;
	private Documento documento;

	public AdaptadorFormulario(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.biblioteca = biblioteca;
		this.mapa = visao.obterFormulario().obterCampos();
	}

	public void adaptar() {
		Exemplar exemplar = new Exemplar(Integer.parseInt(mapa.obter("Volume")
				.obterTexto()), instanciarSituacao(), mapa.obter("Localização")
				.obterTexto());
		Edicao edicao = new Edicao(exemplar, new NumeroChamada(mapa.obter(
				"Numero Chamada").obterTexto()), Integer.parseInt(mapa.obter(
				"Ano Publicacao").obterTexto()));
		documento = new Documento(mapa.obter("Titulo").obterTexto(), mapa
				.obter("Autor").obterTexto(), edicao);

		//biblioteca.adicionar(instanciarArquivavel());
	}


	private Situacao instanciarSituacao() {
		String nomeDaClasse = mapa.obter("Lista Escolha Situacao").obterTexto();
		Situacao classeInstanciada = new SituacaoNula();

		try {
			classeInstanciada = (Situacao) Class.forName(nomeDaClasse)
					.newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException" + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException" + e.getMessage());
		}

		return classeInstanciada;
	}
}
