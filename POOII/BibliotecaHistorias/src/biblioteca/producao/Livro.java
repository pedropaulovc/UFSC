package biblioteca.producao;

import java.util.Calendar;
import java.util.Date;

import acervo.producao.TipoArquivavel;

public class Livro implements TipoArquivavel {
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	private EstadoEmprestimo estado;
	private Date dataDevolucao;
	private static int tempoDevolucao = 15;
	
	public enum EstadoEmprestimo {EMPRESTADO, DISPONIVEL, CONSULTA_LOCAL, EM_RESTAURAÇÃO}
	
	public Livro(){
		estado = EstadoEmprestimo.DISPONIVEL;
	}
	
	public void alterarTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String obterTitulo() {
		return titulo;
	}

	public void alterarAutor(String autor) {
		this.autor = autor;
	}

	public String obterAutor() {
		return autor;
	}

	public void alterarEditora(String editora) {
		this.editora = editora;
	}

	public String obterEditora() {
		return editora;
	}

	public void alterarAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int obterAnoPublicacao() {
		return anoPublicacao;
	}
	
	public boolean emprestar(){
		if(estado.equals(EstadoEmprestimo.DISPONIVEL)){
			estado = EstadoEmprestimo.EMPRESTADO;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, tempoDevolucao);
			dataDevolucao = cal.getTime();
			return true;
		}
		return false;
	}
	
	public boolean devolver(){
		if(estado.equals(EstadoEmprestimo.EMPRESTADO)){
			estado = EstadoEmprestimo.DISPONIVEL;
			return true;
		}
		return false;
	}
	
	public Date obterDataDevolucao(){
		return dataDevolucao;
	}

	public boolean estaEmprestado() {
		if(estado.equals(EstadoEmprestimo.EMPRESTADO)){
			return true;
		}
		return false;
	}
}
