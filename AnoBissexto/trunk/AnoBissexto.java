import java.util.Scanner;
public class AnoBissexto {

	/**
	 * @param args
	 * @author Pedro Paulo Vezzá Campos  - 0123A
	 * Teste: O sistema de SVN funciona realmente?
	 */
	public static void main(String[] args) {
		Scanner anoInput = new Scanner(System.in);
		int ano;
		boolean bissexto;
		
		System.out.print("Digite o ano desejado: ");
		ano = anoInput.nextInt();
		
		if (ano % 400 == 0){
			bissexto = true;
		} else if(ano % 100 == 0){
			bissexto = false;
		} else if(ano % 4 == 0){
			bissexto = true;
		} else {
			bissexto = false;
		}
		
		if(bissexto){
			System.out.println("O ano de " + ano + " é bissexto.");
		} else {
			System.out.println("O ano de " + ano + " não é bissexto.");
		}
	}

}
