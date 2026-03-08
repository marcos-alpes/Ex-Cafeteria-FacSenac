package br.senac.ads.model;

public class ItemPedido {

    private int idPedido;
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(int idPedido, Produto produto, int quantidade, double precoUnitario) {
        this.idPedido = idPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade > 0) {
            this.quantidade = quantidade;
        }
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    public void exibirItemPedido() {
        System.out.println("Pedido ID: " + idPedido);
        System.out.println("Produto ID: " + produto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço Unitário: " + precoUnitario);
        System.out.println("Subtotal: " + calcularSubtotal());
    }
}