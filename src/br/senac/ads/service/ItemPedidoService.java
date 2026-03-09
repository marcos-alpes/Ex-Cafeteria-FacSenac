package br.senac.ads.service;

import java.util.ArrayList;
import java.util.List;

import br.senac.ads.model.ItemPedido;
import br.senac.ads.model.Produto;

public class ItemPedidoService {

    private List<ItemPedido> itensPedido = new ArrayList<>();
    private ProdutoService produtoService;

    public ItemPedidoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void adicionarItemPedido(int idPedido, int idProduto, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero.");
            return;
        }

        Produto produto = produtoService.buscarProdutoPorId(idProduto);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        double precoUnitario = produto.getPreco();

        ItemPedido item = new ItemPedido(idPedido, produto, quantidade, precoUnitario);

        itensPedido.add(item);

        System.out.println("Item adicionado ao pedido.");
    }

    public void listarItensPedido() {

        if (itensPedido.isEmpty()) {
            System.out.println("Nenhum item no pedido.");
            return;
        }

        for (ItemPedido item : itensPedido) {
            item.exibirItemPedido();
        }
    }

    public void calcularTotalPedido() {

        double total = 0;

        for (ItemPedido item : itensPedido) {
            total += item.calcularSubtotal();
        }

        System.out.println("Total do pedido: R$ " + total);
    }
    
    public void removerItemPedido(int idPedido) {

        ItemPedido itemRemover = null;

        for (ItemPedido item : itensPedido) {

            if (item.getIdPedido() == idPedido) {
                itemRemover = item;
                break;
            }
        }

        if (itemRemover != null) {

            itensPedido.remove(itemRemover);
            System.out.println("Item removido do pedido.");

        } else {

            System.out.println("Item não encontrado.");
        }
    }
}
