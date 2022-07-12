package Repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import data.Produto;

public class RepositorioProdutos {
    private Map<String, Produto> listaProdutos = new HashMap<String, Produto>();

    public void novoProduto(Produto prod){
        listaProdutos.put(prod.getNome(), prod);
    }

    public void alterarProduto(Produto prod){
        this.listaProdutos.put(prod.getNome(), prod);
    }

    public void removerProduto(Produto prod){
        this.listaProdutos.remove(prod.getNome());
    }

    public Collection<Produto> listaProduto(){
        return listaProdutos.values();
    }

    public Produto consultaProduto(String nomeProduto){
        Produto existe = null;
        for (Produto produto : listaProdutos.values()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                existe = produto;
                break;
            }
        }
        return existe;
    }
}
