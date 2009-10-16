package producao.documento;

public interface Documento {
	boolean emprestar();
	boolean devolver();
	Dado obterDado(Campo campo);
	void adicionarDado(Campo campo, Dado dado);
}
