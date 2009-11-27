package producao.formulario;

import java.util.Observable;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.nome.modelo.Nome;
import producao.formulario.campos.CamposFormularioAbstrato;
import producao.log.modelo.Mensagem;

public abstract class AdaptadorFormularioAbstrato extends Observable {

	private CamposFormularioAbstrato campos;

	public AdaptadorFormularioAbstrato(CamposFormularioAbstrato campos) {
		this.campos = campos;
	}

	public AnoPublicacao criarAnoPublicacao() {

		try {
			return new AnoPublicacao(campos.obterAnoPublicacao());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao(e.getLocalizedMessage(), this);
		}

		return null;
	}

	public Nome criarTitulo() {
		try {
			return new Nome(campos.obterTitulo());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao("Campo Título vazio", this);
		}

		return null;
	}

	public void notificarAlteracao(String mensagem, Object o) {
		setChanged();
		notifyObservers(new Mensagem(mensagem, o));
	}
}
