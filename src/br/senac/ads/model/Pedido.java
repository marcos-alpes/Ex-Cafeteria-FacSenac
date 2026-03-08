package br.senac.ads.model;

public class Pedido {

    private int id;
    private Cliente cliente;
    private String data;
    private ItemPedido[] itens;
    private int quantidadeItens;

    public Pedido(int id, Cliente cliente, String data) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ItemPedido[] getItens() {
		return itens;
	}

	public void setItens(ItemPedido[] itens) {
		this.itens = itens;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public void exibirPedido() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente ID: " + cliente.getId());
        System.out.println("Data: " + data);
    }
}
