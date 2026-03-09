package br.senac.ads;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.senac.ads.service.ClienteService;
import br.senac.ads.service.ItemPedidoService;
import br.senac.ads.service.ProdutoService;

public class Main {

    public static void main(String[] args) {

        // ---------------------------------------------------
        // CRIAÇÃO DO OBJETO SCANNER
        // ---------------------------------------------------
        // O Scanner será utilizado para ler dados digitados
        // pelo usuário no terminal.

        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        ItemPedidoService itemService = new ItemPedidoService(produtoService);

        // ---------------------------------------------------
        // VARIÁVEL QUE ARMAZENA A OPÇÃO DO MENU
        // ---------------------------------------------------
        int opcao = -1;

        // ---------------------------------------------------
        // LOOP PRINCIPAL DO SISTEMA
        // ---------------------------------------------------
        // O sistema continuará executando até o usuário
        // escolher a opção de sair.

        while (opcao != 0) {

        	try {
		            // ---------------------------------------------------
		            // EXIBIÇÃO DO MENU PRINCIPAL
		            // ---------------------------------------------------
		
		            System.out.println("\n===== SISTEMA DE PEDIDOS - CAFETERIA =====");
		            System.out.println("1 - Gerenciar Clientes");
		            System.out.println("2 - Gerenciar Produtos");
		            System.out.println("3 - Gerenciar Pedidos");
		            System.out.println("4 - Gerenciar Itens do Pedido");
		            System.out.println("0 - Sair");
		            System.out.print("Escolha uma opção: ");
		
		            // Leitura da opção digitada
		            opcao = scanner.nextInt();
		
		            // ---------------------------------------------------
		            // PROCESSAMENTO DA OPÇÃO ESCOLHIDA
		            // ---------------------------------------------------
		
		            switch (opcao) {
		
		            case 1:

		                int opcaoCliente = -1;

		                while (opcaoCliente != 0) {

		                    System.out.println("\n===== MENU CLIENTES =====");
		                    System.out.println("1 - Adicionar Cliente");
		                    System.out.println("2 - Listar Clientes");
		                    System.out.println("3 - Buscar Cliente por ID");
		                    System.out.println("4 - Remover Cliente por ID");
		                    System.out.println("0 - Voltar");
		                    System.out.print("Escolha uma opção: ");

		                    opcaoCliente = scanner.nextInt();
		                    scanner.nextLine();

		                    switch (opcaoCliente) {

		                        case 1:

		                            System.out.print("Digite o ID do cliente: ");
		                            int id = scanner.nextInt();
		                            scanner.nextLine();

		                            System.out.print("Digite o nome do cliente: ");
		                            String nome = scanner.nextLine();

		                            System.out.print("Digite o telefone do cliente: ");
		                            String telefone = scanner.nextLine();

		                            clienteService.adicionarCliente(id, nome, telefone);

		                            break;

		                        case 2:

		                            clienteService.listarClientes();

		                            break;

		                        case 3:

		                            System.out.print("Digite o ID do cliente: ");
		                            int idBusca = scanner.nextInt();

		                            clienteService.buscarClientePorId(idBusca);

		                            break;

		                        case 4:

		                            System.out.print("Digite o ID do cliente: ");
		                            int idRemover = scanner.nextInt();

		                            clienteService.removerClientePorId(idRemover);

		                            break;

		                        case 0:

		                            break;

		                        default:

		                            System.out.println("Opção inválida!");
		                    }
		                }

		                break;
		
		            case 2:

		                int opcaoProduto = -1;

		                while (opcaoProduto != 0) {

		                    System.out.println("\n===== MENU PRODUTOS =====");
		                    System.out.println("1 - Cadastrar Produto");
		                    System.out.println("2 - Listar Produtos");
		                    System.out.println("3 - Atualizar Preço");
		                    System.out.println("4 - Remover Produto");
		                    System.out.println("0 - Voltar");
		                    System.out.print("Escolha uma opção: ");

		                    opcaoProduto = scanner.nextInt();
		                    scanner.nextLine();

		                    switch (opcaoProduto) {

		                        case 1:

		                            System.out.print("Digite o ID do produto: ");
		                            int idProduto = scanner.nextInt();
		                            scanner.nextLine();

		                            System.out.print("Digite o nome do produto: ");
		                            String nomeProduto = scanner.nextLine();

		                            System.out.print("Digite o preço do produto: ");
		                            double precoProduto = scanner.nextDouble();

		                            produtoService.cadastrarProduto(idProduto, nomeProduto, precoProduto);

		                            break;

		                        case 2:

		                        	System.out.println("\nLista de produtos:");
		                        	produtoService.listarProdutos();

		                            break;

		                        case 3:

		                        	System.out.print("Digite o ID do produto: ");
		                            int idAtualizar = scanner.nextInt();

		                            System.out.print("Digite o novo preço: ");
		                            double novoPreco = scanner.nextDouble();

		                            produtoService.atualizarPreco(idAtualizar, novoPreco);

		                            break;

		                        case 4:

		                        	System.out.print("Digite o ID do produto que deseja remover: ");
		                            int idRemover = scanner.nextInt();

		                            produtoService.removerProduto(idRemover);

		                            break;

		                        case 0:

		                            break;

		                        default:

		                            System.out.println("Opção inválida!");
		                    }
		                }

		                break;
		
		                case 3:
		                    // Menu de pedidos
		                    // Aqui futuramente serão feitas chamadas
		                    // para as funções relacionadas a pedidos
		                    break;
		
		                case 4:

		                    int opcaoItem = -1;

		                    while (opcaoItem != 0) {

		                        System.out.println("\n===== MENU ITENS DO PEDIDO =====");
		                        System.out.println("1 - Adicionar Item");
		                        System.out.println("2 - Listar Itens");
		                        System.out.println("3 - Calcular Total");
		                        System.out.println("4 - Remover Item");
		                        System.out.println("0 - Voltar");
		                        System.out.print("Escolha uma opção: ");

		                        opcaoItem = scanner.nextInt();

		                        switch (opcaoItem) {

		                            case 1:

		                                System.out.print("ID do item: ");
		                                int idItem = scanner.nextInt();

		                                System.out.print("ID do produto: ");
		                                int idProduto = scanner.nextInt();

		                                System.out.print("Quantidade: ");
		                                int quantidade = scanner.nextInt();

		                                itemService.adicionarItemPedido(idItem, idProduto, quantidade);

		                                break;

		                            case 2:

		                                itemService.listarItensPedido();

		                                break;

		                            case 3:

		                                itemService.calcularTotalPedido();

		                                break;

		                            case 4:

		                                System.out.print("ID do item: ");
		                                int idRemover = scanner.nextInt();

		                                itemService.removerItemPedido(idRemover);

		                                break;

		                            case 0:
		                                break;

		                            default:
		                                System.out.println("Opção inválida!");
		                        }
		                    }

		                    break;
		
		                case 0:
		                    // Encerramento do sistema
		                    System.out.println("\nEncerrando o sistema...");
		                    break;
		
		                default:
		                    // Caso o usuário digite uma opção inválida
		                    System.out.println("\nOpção inválida!");
		            }
	                    
	            }catch (InputMismatchException e) {
	            	// Caso o usuário digite uma opção inválida
                    System.out.println("\nOpção inválida!");
				}catch (Exception e) {
					System.out.println("\nErro inesperado!");
				}
        	
        }
        
		// ---------------------------------------------------
        // FECHAMENTO DO SCANNER
        // ---------------------------------------------------

        scanner.close();

        
    }
}