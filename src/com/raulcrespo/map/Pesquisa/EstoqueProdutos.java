package com.raulcrespo.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(codigo, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0D;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double precoMaisCaro = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() > precoMaisCaro) {
                    produtoMaisCaro = p;
                    precoMaisCaro = p.getPreco();
                }
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        double precoMaisBarato = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;

        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(produtoMaisBarato == null) {
                    produtoMaisBarato = p;
                    precoMaisBarato = produtoMaisBarato.getPreco();
                } else if(p.getPreco() < precoMaisBarato) {
                    produtoMaisBarato = p;
                    precoMaisBarato = produtoMaisBarato.getPreco();
                }
            }
        }

        return produtoMaisBarato;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(3L, "prod c", 10, 1);
        estoque.adicionarProduto(1L, "prod a", 30, 3);
        estoque.adicionarProduto(2L, "prod b", 20, 2);
        estoque.exibirProdutos();

        System.out.println(estoque.calcularValorTotalEstoque());
        System.out.println(estoque.obterProdutoMaisCaro());
        System.out.println(estoque.obterProdutoMaisBarato());
    }

}
