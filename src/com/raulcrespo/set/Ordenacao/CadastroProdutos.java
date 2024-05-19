package com.raulcrespo.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos produtos = new CadastroProdutos();

        produtos.adicionarProduto(4L, "Produto 5", 15d, 5);
        produtos.adicionarProduto(1L, "Produto 2", 12d, 5);
        produtos.adicionarProduto(3L, "Produto 4", 17d, 5);
        produtos.adicionarProduto(2L, "Produto 3", 11d, 5);
        produtos.adicionarProduto(1L, "Produto 1", 15d, 5);

        //System.out.println(produtos.produtoSet);
        //System.out.println(produtos.exibirProdutosPorNome());
        System.out.println(produtos.exibirProdutosPorPreco());
    }
}
