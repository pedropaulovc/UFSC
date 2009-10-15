package producao.documento;


public abstract class DocumentoAbstrato implements Documento {
	public boolean emprestar(){
		return false;
	}
	
	public boolean devolver(){
		return false;
	}
}
