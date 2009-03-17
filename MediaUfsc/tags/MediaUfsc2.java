import javax.swing.JOptionPane;

public class MediaUfsc2 {

	/**
	 * @param args
	 * @author Pedro Paulo Vezzá Campos - 0132A
	 */
	public static void main(String[] args) {
	    String snota1, snota2, snota3;
	    float nota1, nota2, nota3, media;
	 
	    snota1 = JOptionPane.showInputDialog("Entre com a primeira nota");
	    snota2 = JOptionPane.showInputDialog("Entre com a segunda nota");
	    snota3 = JOptionPane.showInputDialog("Entre com a terceira nota");
	 
	    nota1 = Float.parseFloat(snota1);
	    nota2 = Float.parseFloat(snota2);
	    nota3 = Float.parseFloat(snota3);
	 
	    media = (nota1 + nota2 + nota3)/3;
	 
	    //mostra o resultado da soma para o usuário
	    JOptionPane.showMessageDialog(null,"A média do aluno é: " + media,"Resultado",JOptionPane.PLAIN_MESSAGE);
	}
}
