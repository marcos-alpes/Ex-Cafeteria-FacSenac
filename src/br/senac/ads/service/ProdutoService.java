package br.senac.ads.service;

import java.util.ArrayList;
import java.util.List;

import br.senac.ads.model.Produto;

public class ProdutoService {
	List<Produto> produtos = new ArrayList<>();
	
	public Produto cadastrarProduto(int id, String nome, double preco){
		Produto p = new Produto(id, nome, preco);
		produtos.add(p);
		return p;
	}
	
	public void listarProdutos() {
		for(Produto p : produtos) {
			p.exibirProduto();
		}
	}
	
	public void atualizarPreco(int id, double novoPreco) {
		for(Produto p : produtos) {
			if(p.getId() == id) {
				if(novoPreco > 0) {
					p.setPreco(novoPreco);
		            System.out.println("Preço atualizado.");
				}
			}
		}
	}
	
	public void removerProduto(int id) {
	    for(Produto p : produtos) {
	        if(p.getId() == id) {
	            produtos.remove(p);
	            System.out.println("Produto removido.");
	            break;
	        }
	    }
	}
	
	public static void main(String[]args) {
		ProdutoService service = new ProdutoService();
		
		service.cadastrarProduto(1,"Coca-Cola", 7.0);
		service.cadastrarProduto(2,"Sprite", 6.0);
		service.cadastrarProduto(3,"Mineiro", 5.0);
		
		System.out.println("Lista de produtos: ");
		service.listarProdutos();
		
		System.out.println("Atualizando preço...");
		service.atualizarPreco(1, 8.0);
		
		System.out.println("Lista atualizada: ");
		service.listarProdutos();
		
		System.out.println("Removendo produto...");
		service.removerProduto(2);
		
		System.out.println("Lista final: ");
		service.listarProdutos();

	}

	public Produto buscarProdutoPorId(int id) {

        for (Produto p : produtos) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }
}
