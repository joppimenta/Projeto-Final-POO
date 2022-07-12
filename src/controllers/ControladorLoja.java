package controllers;

import java.util.ArrayList;
import java.util.Collection;

import Repositorios.RepositorioLojas;
import data.Loja;
import data.Produto;
import exceptions.ListaVazia;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoJaExistente;

public class ControladorLoja {
    
    private RepositorioLojas repositorioLojas;

    public ControladorLoja(RepositorioLojas repositorioLojas) {
        this.repositorioLojas = repositorioLojas;
    }

    public void novaLoja(Loja loja) throws LojaJaExistente, LojaNaoExistente{
        Loja loj = null;
        try {
            loj = consultaLoja(loja.getNome());
        } catch (LojaNaoExistente e) {
        }
        if (loj == null) {
            repositorioLojas.novaLoja(loja);
        } else {
            throw new LojaJaExistente();
        }
    }

    public void alteraLoja(Loja loja) throws LojaNaoExistente{
        consultaLoja(loja.getNome());
        repositorioLojas.alterarLoja(loja);
    }

    public void removeLoja(Loja loja) throws LojaNaoExistente{
        consultaLoja(loja.getNome());
        repositorioLojas.removerLoja(loja);
    }

    public void adicionarProduto(Loja loja, Produto prod) throws ProdutoJaExistente{
        ArrayList<Produto> lista = loja.getProdutos();
        for (Produto produto : lista) {
            if (produto.getNome().equalsIgnoreCase(prod.getNome())) {
                throw new ProdutoJaExistente();
            }
        }
        lista.add(prod);
        loja.setProdutos(lista);
    }

    public void removerProduto(Loja loja, Produto prod) throws ListaVazia{
        ArrayList<Produto> lista = loja.getProdutos();
        if (lista == null || lista.size()== 0) {
            throw new ListaVazia();
        }
        lista.remove(prod);
        loja.setProdutos(lista);
    }

    public Collection<Loja> listaLojaBairro(String bairro) throws ListaVazia{
        Collection<Loja> lista = repositorioLojas.listaLoja();
        if (lista == null || lista.size() == 0) {
            throw new ListaVazia();
        }
        for (Loja loja : lista) {
            if (!loja.getBairro().equalsIgnoreCase(bairro)) {
                lista.remove(loja);
            }
        }
        return lista;
    }

    public Collection<Loja> listaLojaCidade(String cidade) throws ListaVazia{
        Collection<Loja> lista = repositorioLojas.listaLoja();
        if (lista == null || lista.size() == 0) {
            throw new ListaVazia();
        }
        for (Loja loja : lista) {
            if (!loja.getCidade().equalsIgnoreCase(cidade)) {
                lista.remove(loja);
            }
        }
        return lista;
    }

    public Loja consultaLoja(String loja) throws LojaNaoExistente{
        if (repositorioLojas.consultaLoja(loja) == null) {
            throw new LojaNaoExistente();
        }
        return repositorioLojas.consultaLoja(loja);
    }
}
