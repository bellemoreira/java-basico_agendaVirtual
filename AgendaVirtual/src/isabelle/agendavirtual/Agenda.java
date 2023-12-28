package isabelle.agendavirtual;

import java.util.ArrayList;
import java.util.Random;

import isabelle.agendavirtual.exceptions.AgendaCheiaException;
import isabelle.agendavirtual.exceptions.AgendaVaziaException;
import isabelle.agendavirtual.exceptions.ContatoNaoExisteException;
import isabelle.agendavirtual.exceptions.OpcaoInvalidaException;

public class Agenda {
	
	public static int contador;
	private Contato[] contatos;
	private boolean contatoLocalizado;
	private boolean agendaComContatos;
	
	
		
	public Agenda() {
		contatos = new Contato[10]; // 10 contatos maximos na agenda, para testar a exception
		
		contador = 1;
		contatoLocalizado = false;
		agendaComContatos = false;
	}	
	
	public void validarOpcao(String opcao) throws OpcaoInvalidaException {
		if(!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")) {
			throw new OpcaoInvalidaException();
		}
	}
	
	public void verificarAgenda() throws AgendaVaziaException {
		if(!agendaComContatos) {
			throw new AgendaVaziaException();
		}
	}
	
	public void adicionarContato(String nome, String telefone) throws AgendaCheiaException{
			String id = String.format("%03d", contador);
			Contato c = new Contato(nome,telefone,id);
			try{
				contatos[contador-1] = c;
			    contador++;	
			    System.out.println("Contato adicionado!");
			    agendaComContatos = true;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				throw new AgendaCheiaException();
			}
			
	}
	
	public void consultarContato(String consulta) throws ContatoNaoExisteException{
			for(Contato contato: contatos) {
				if(contato.getNome().equals(consulta) || contato.getTelefone().equals(consulta)) {
					 System.out.print("Contato Localizado > ");
					 System.out.println("ID:"+contato.getIdentificador() + " Nome: " + contato.getNome()+ 
							 " Telefone: "+ contato.getTelefone());
					 contatoLocalizado = true;
				}
			}
			if(!contatoLocalizado) {
				throw new ContatoNaoExisteException(consulta);
			}
	}
		
	
}


