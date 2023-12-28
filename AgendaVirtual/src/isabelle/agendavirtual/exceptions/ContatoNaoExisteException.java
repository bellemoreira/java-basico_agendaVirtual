package isabelle.agendavirtual.exceptions;

public class ContatoNaoExisteException extends Exception {

	
	public String dado;
	
	public ContatoNaoExisteException(String dado) {
		this.dado= dado;
	}
	
	public String toString() {
		return "ERRO: Contato // "+dado+"//  não existente";
	}
}
