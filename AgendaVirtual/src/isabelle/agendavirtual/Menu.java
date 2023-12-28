package isabelle.agendavirtual;

import java.util.Scanner;

import isabelle.agendavirtual.exceptions.AgendaCheiaException;
import isabelle.agendavirtual.exceptions.AgendaVaziaException;
import isabelle.agendavirtual.exceptions.ContatoNaoExisteException;
import isabelle.agendavirtual.exceptions.OpcaoInvalidaException;

public class Menu {

	public static void main(String[] args) {
		 Agenda agenda = new Agenda();
		 Scanner scan = new Scanner(System.in);
		 
		 String opcao = null;
		 String nome;
		 String telefone;
		 String consulta;
		 
		 do {
			 try{
				 System.out.println("*****MENU*****\nSelecione:");
				 System.out.println("1- Consultar um contato");
				 System.out.println("2- Adicionar um contato");
				 System.out.println("3- Encerrar");
				 opcao = scan.nextLine();
				 agenda.validarOpcao(opcao);
			 }
			 catch(OpcaoInvalidaException e) {
				 System.out.println(e.getMessage());
				 System.out.println(">Retornando para opcoes MENU:");
			 }
			 catch(Exception e) {
				 System.out.println(e.getMessage());
				 System.out.println("> Retornando para opcoes MENU:");
			 }
			 
			 if(opcao.equals("1")) {
				 try{
					  System.out.print("Digite o nome ou telefone: ");
					  consulta = scan.nextLine();
					  agenda.verificarAgenda();
					  agenda.consultarContato(consulta);
					 }
				 
				 catch(ContatoNaoExisteException e) {
					 System.out.println(e);
					 System.out.println("> Retornando para opcoes MENU:");
				 }
				 
				 catch(AgendaVaziaException e){ 
					 System.out.println(e);
					 System.out.println("> Retornando para opcoes MENU:");
				 }
				 catch(Exception e) {
					 System.out.println(e.getMessage());
					 System.out.println("> Retornando para opcoes MENU:");
				 }
				 	 
			 }else if(opcao.equals("2")){
				try {
					  System.out.print("Digite o nome: ");
					  nome = scan.nextLine();
					  System.out.print("Digite o telefone: ");
				      telefone= scan.nextLine();
				      agenda.adicionarContato(nome,telefone);
				     }
				
				catch(AgendaCheiaException e) {
					System.out.println(e);
					System.out.println("> Retornando para opcoes MENU:");
				 }
				 catch(Exception e) {
					 System.out.println(e.getMessage());
					 System.out.println("> Retornando para opcoes MENU:");
				 }	
			} 
			
		 }while(!opcao.equals("3"));	 

	}
}
