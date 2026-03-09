package br.senac.ads.model;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    
    List<Produto> produtos = new ArrayList<>();

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco > 0) {
            this.preco = preco;
        }
    }

    public void exibirProduto() {
        System.out.println("Produto ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
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
