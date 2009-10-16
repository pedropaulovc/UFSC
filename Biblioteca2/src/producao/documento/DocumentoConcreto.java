package producao.documento;

import java.util.HashMap;
import java.util.Map;


public class DocumentoConcreto implements Documento {
	private Map<Campo, Dado> dados;
	
	public DocumentoConcreto(){
		dados = new HashMap<Campo, Dado>();
	}
	
	public boolean emprestar(){
		return false;
	}
	
	public boolean devolver(){
		return false;
	}
	
	public void adicionarDado(Campo campo, Dado dado) {
		dados.put(campo, dado);
	}

	public Dado obterDado(Campo campo) {
		return dados.get(campo);
	}
}
