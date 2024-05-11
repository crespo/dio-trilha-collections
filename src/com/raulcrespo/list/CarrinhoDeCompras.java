package com.raulcrespo.list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarProduto(String nome, double preco, int quantidade) {
        carrinhoDeCompras.add(new Produto(nome, preco, quantidade));
    }

    public void removerProduto(String nome) {
        List<Produto> produtosParaRemover = new ArrayList<>();

        for (Produto p : carrinhoDeCompras) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                produtosParaRemover.add(p);
            }
        }

        carrinhoDeCompras.removeAll(produtosParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;

        for (Produto p : carrinhoDeCompras) {
            valorTotal += p.getPreco() * p.getQuantidade();
        }

        return valorTotal;
    }

    public void exibirProdutos() {
        System.out.println(carrinhoDeCompras);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarProduto("Manga", 5, 30);
        carrinho.adicionarProduto("Mamao", 5, 30);
        carrinho.adicionarProduto("Banana", 5, 30);
        carrinho.adicionarProduto("banana", 5, 30);
        carrinho.adicionarProduto("Morango", 5, 30);
        carrinho.removerProduto("banana");
        carrinho.exibirProdutos();
        System.out.println("Valor total: " + carrinho.calcularValorTotal());
    }
}
