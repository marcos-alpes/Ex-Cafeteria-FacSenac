package br.senac.ads.service;

import java.util.ArrayList;
import java.util.List;
import br.senac.ads.model.Cliente;

public class ClienteService {

	List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void adicionarCliente(int id, String nome, String telefone) {
		Cliente c = new Cliente(id, nome, telefone);
		clientes.add(c);
		
		System.out.println("Cliente adicionado com sucesso!!!");
		
	}
	
	public void listarClientes() {

	    for(Cliente c: clientes) {
	        c.exibirCliente();
	    }

	}
	
	public void buscarClientePorId(int id) {

		for(Cliente c: clientes) {

	        if(c.getId() == id) {
	            c.exibirCliente();
	            return;
	        }

	    }

	    System.out.println("Cliente não encontrado");

	}
	
	public void removerClientePorId(int id) {

		for(Cliente c: clientes) {

	        if(c.getId() == id) {

	            clientes.remove(c);

	            System.out.println("Cliente removido");
	            return;
	        }

	    }

	    System.out.println("Cliente não encontrado");

	}

}