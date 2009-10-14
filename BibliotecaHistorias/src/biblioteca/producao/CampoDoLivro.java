package biblioteca.producao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CampoDoLivro {
	public static void main(String[] args) {
		Class<Livro> classe = Livro.class;
		String resultado = null;
		try {
			Method metodo = classe.getMethod("obter" + "Audfghd",
					new Class[] {});
			Livro livro = new Livro();
			livro.alterarAutor("teste");
			resultado = (String) metodo.invoke(livro, new Object[0]);
		} catch (SecurityException e) {

		} catch (NoSuchMethodException e) {

		} catch (IllegalArgumentException e) {

		} catch (IllegalAccessException e) {

		} catch (InvocationTargetException e) {

		}
		System.out.println(resultado);
	}

}
