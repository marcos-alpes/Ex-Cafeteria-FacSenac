package br.senac.ads.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.ads.model.Cliente;
import br.senac.ads.model.Pedido;

public class PedidoService {

    List<Pedido> pedidos = new ArrayList<>();
    private ClienteService clienteService;

    public PedidoService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    public void criarPedido(int idPedido, int idCliente) {

        Cliente cliente = clienteService.buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        String data = LocalDate.now().toString();

        Pedido pedido = new Pedido(idPedido, cliente, data);

        pedidos.add(pedido);

        System.out.println("Pedido criado com sucesso!");
    }

    public void listarPedidos() {

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
            return;
        }

        for (Pedido p : pedidos) {
            p.exibirPedido();
        }
    }

    public void buscarPedido(int id) {

        for (Pedido p : pedidos) {

            if (p.getId() == id) {

                System.out.println("Pedido encontrado:");
                p.exibirPedido();
                return;
            }
        }

        System.out.println("Pedido não encontrado.");
    }

    public void cancelarPedido(int id) {

        Pedido pedidoRemover = null;

        for (Pedido p : pedidos) {

            if (p.getId() == id) {
                pedidoRemover = p;
                break;
            }
        }

        if (pedidoRemover != null) {

            pedidos.remove(pedidoRemover);
            System.out.println("Pedido cancelado com sucesso!");

        } else {

            System.out.println("Pedido não encontrado.");
        }
    }
}
