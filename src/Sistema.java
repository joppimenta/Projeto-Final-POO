import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

import java.util.ArrayList;

public class Sistema {

    ArrayList<Loja> lojas = new ArrayList<Loja>();

    public boolean procurarLoja(Loja loja){
        boolean achou = false;
        for(Loja l: lojas){
            if(l == loja){
                achou = true;
            }
        }
        return achou;
    }

    public void inserirLoja(Loja l) throws LojaJaExistente {
        if(procurarLoja(l)){
            throw new LojaJaExistente();
        }
        else {
            lojas.add(l);
        }
    }

    public void alterarLoja(Loja l) throws LojaNaoExistente {
        boolean achou = false;
        for(Loja loja: lojas){
            if(l.getNome().equals(loja.getNome())){
                achou = true;
                loja = l;
                break;
            }
        }
        if(!achou){
            throw new LojaNaoExistente();
        }
    }

    public Loja consultarLoja(String nomeLoja) throws LojaNaoExistente{
        boolean achou = false;
        Loja lojaProcurada = null;

        for(Loja l: lojas){
            if(l.getNome().equals(nomeLoja)){
                achou = true;
                lojaProcurada = l;
            }
        }
        if(achou){
            return lojaProcurada;
        }
        else {
            throw new LojaNaoExistente();
        }
    }

    public void excluirLoja(Loja loja) throws LojaNaoExistente{
        if(!procurarLoja(loja)){
            throw new LojaNaoExistente();
        }
        else {
            lojas.remove(loja);
        }
    }

    public boolean procurarProduto(Produto produto) throws ProdutoNaoExistente {
        for(Loja l: lojas){
            l.procurarProduto(produto);
        }
        throw new ProdutoNaoExistente();
    }

    void incluirProduto(Produto produto, Loja loja) throws LojaNaoExistente, ProdutoJaExistente {
        if(procurarLoja(loja)){
            for(Loja l: lojas){
                if(l == loja){
                    if(!l.procurarProduto(produto)){
                        l.incluirProduto(produto);
                    }
                    else {
                        throw new ProdutoJaExistente();
                    }
                }
            }
        }
        else {
            throw new LojaNaoExistente();
        }
    }



    public void excluirProduto(Produto produto, Loja loja) throws ProdutoNaoExistente, LojaNaoExistente {
        if (procurarLoja(loja)) {
            for (Loja l : lojas) {
                if (l == loja) {
                    if (l.procurarProduto(produto)) {
                        l.excluirProduto(produto);
                    } else {
                        throw new ProdutoNaoExistente();
                    }
                }
            }
        }
        else {
            throw new LojaNaoExistente();
        }
    }

    public Produto consultarProduto(Produto produto, Loja loja) throws ProdutoNaoExistente, LojaNaoExistente {
        Produto produtoProcurado = null;
        if (procurarLoja(loja)) {
            for (Loja l : lojas) {
                if (l == loja) {
                    if (l.procurarProduto(produto)) {
                         produtoProcurado = l.consultarProduto(produto.getNome());
                    } else {
                        throw new ProdutoNaoExistente();
                    }
                }
            }
        }
        else {
            throw new LojaNaoExistente();
        }
        return produtoProcurado;
    }

    public void alterarProduto(Produto produto, Loja loja) throws ProdutoNaoExistente, LojaNaoExistente {
        if (procurarLoja(loja)) {
            for (Loja l : lojas) {
                if (l == loja) {
                    if (l.procurarProduto(produto)) {
                        l.alterarProduto(produto);
                    } else {
                        throw new ProdutoNaoExistente();
                    }
                }
            }
        }
        else {
            throw new LojaNaoExistente();
        }
    }

    public static void main(String[] args) throws ProdutoJaExistente, LojaJaExistente, LojaNaoExistente {
        Produto produtoTeste = new Produto("Vassoura", 2, 13.50);
        Produto produtoTeste2 = new Produto("Lápis", 5, 3);
        Produto tapioca = new Produto("Tapioca", 55, 12);
        Loja novaLoja = new Loja("Claudinha LOja", "RUa 44", "Jangurussu", "Fortaleza", "Ceara");
        Loja novaLoja2 = new Loja("Tapioca do claudio", "RUa 22", "Jangurussu", "Fortaleza", "Ceara");



        novaLoja.incluirProduto(produtoTeste);
        novaLoja.incluirProduto(produtoTeste2);

        novaLoja2.incluirProduto(tapioca);

        Sistema sistema = new Sistema();

        sistema.inserirLoja(novaLoja);
        sistema.inserirLoja(novaLoja2);

        for(Loja l: sistema.lojas){
            System.out.println(l.getNome());
            for(Produto p: l.produtos){
                System.out.println(p.getNome());
            }
        }


    }
}
