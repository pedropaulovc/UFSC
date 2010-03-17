package producao.formulario;

import java.util.Observable;

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
		return new AnoPublicacao(campos.obterAnoPublicacao());
	}

	public Nome criarTitulo() {
		return new Nome(campos.obterTitulo());
	}

	public void verificarCampos() {
		if (!AnoPublicacao.validar(campos.obterAnoPublicacao()))
			notificarAlteracao("Ano inválido", this);

		if (!Nome.validar(campos.obterTitulo()))
			notificarAlteracao("Título inválido", this);
	}

	public void notificarAlteracao(String mensagem, Object o) {
		setChanged();
		notifyObservers(new Mensagem(mensagem, o));
	}
}
