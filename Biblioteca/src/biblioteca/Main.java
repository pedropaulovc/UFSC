package biblioteca;

public class Main {

	public static void main(String[] args) {
		Situacao situacao = new Situacao();
		Exemplar exemplar = new Exemplar(1, situacao, "localizado");
		NumeroChamada numeroChamada = new NumeroChamada("Numero chamada");
		Edicao edicao = new Edicao(exemplar, numeroChamada, 1900);
		Documento documento = new Documento("titulo", "autor", edicao);
		
		System.out.println(documento.toString());
	}
}
