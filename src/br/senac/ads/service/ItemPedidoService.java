package br.senac.ads.service;

import br.senac.ads.model.ItemPedido;
import br.senac.ads.model.Pedido;
import br.senac.ads.model.Produto;

public class ItemPedidoService {

	public ItemPedido adicionarItem(int idPedido, Produto produto, int quantidade, double precoUnitario) {
		ItemPedido i = new ItemPedido(idPedido, produto, quantidade, precoUnitario);
		return i;
	}
	
	// Calcula o valor total do item do pedido
	public double calcularTotal(ItemPedido item) {
		return item.getQuantidade() * item.getPrecoUnitario();
	}
	
	// Lista as informações do item do pedido
	public void listarItem(ItemPedido item) {
		System.out.println ("Pedido:" + item.getIdPedido());
		System.out.println ("Produto:" + item.getProduto());
		System.out.println ("Quantidade:" + item.getQuantidade());
		System.out.println ("Preço Unitário:" + item.getPrecoUnitario());
		
	}
	
	public void removerItem(ItemPedido item) {
	    item = null;
	    System.out.println("Item removido!");
	}
		
	}
	

