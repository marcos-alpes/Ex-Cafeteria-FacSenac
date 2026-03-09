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
	
}
