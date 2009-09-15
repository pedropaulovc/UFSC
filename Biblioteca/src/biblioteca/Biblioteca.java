package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private String nome;
	private List<Documento> acervo;
	
	public Biblioteca(String nome){
		this.nome = nome;
		acervo = new ArrayList<Documento>();
	}
	
	public String obterNome(){
		return nome;
	}
	
	public int qtdDocumentos(){
		return acervo.size();
	}
	
	public void adicionarDocumento(Documento d){
		acervo.add(d);
	}
	
	public Documento obterDocumento(int d){
		return acervo.get(d);
	}
	
	public Documento removerDocumento(int d){
		return acervo.remove(d);
	}
	
	public String toString(){
		return nome + ". Possui acervo de " + qtdDocumentos() + " documentos."; 
	}
}