package controllers;

import java.util.Collection;

import Repositorios.RepositorioProdutos;
import data.Produto;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

public class ControladorProduto {

    private RepositorioProdutos repositorioProdutos;

    public ControladorProduto(RepositorioProdutos repositorioProdutos) {
        this.repositorioProdutos = repositorioProdutos;
    }

    public void novoProduto(Produto prod) throws ProdutoJaExistente, ProdutoNaoExistente{
        Produto produto = null;
        try {
            produto = consultaProduto(prod.getNome());
        } catch (ProdutoNaoExistente e) {
        }

        if (produto == null) {
            repositorioProdutos.novoProduto(prod);
        } else {
            throw new ProdutoJaExistente();
        }
    }

    public void alteraProduto(Produto prod) throws ProdutoNaoExistente{
        consultaProduto(prod.getNome());
        repositorioProdutos.alterarProduto(prod);
    }

    public void removeProduto(Produto prod) throws ProdutoNaoExistente{
        consultaProduto(prod.getNome());
        repositorioProdutos.removerProduto(prod);
    }

    public Produto consultaProduto(String prod) throws ProdutoNaoExistente{
        if (repositorioProdutos.consultaProduto(prod) == null) {
            throw new ProdutoNaoExistente();
        }
        return repositorioProdutos.consultaProduto(prod);
    }

    public Collection<Produto> listaProduto() throws ProdutoNaoExistente{
        Collection<Produto> lista = repositorioProdutos.listaProduto();
        if (lista == null || lista.size() == 0) {
            throw new ProdutoNaoExistente();
        }
        return lista;
    }
}
