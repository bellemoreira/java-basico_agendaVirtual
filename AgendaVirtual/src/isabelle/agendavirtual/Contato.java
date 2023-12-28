package isabelle.agendavirtual;

import java.util.Random;

public class Contato {
	
	
	private String nome;
	private String telefone;
	private String identificador;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public Contato(String nome, String telefone, String identificador) {
		this.nome= nome;
		this.telefone = telefone;
	    this.identificador = identificador;	
	}
	

}
