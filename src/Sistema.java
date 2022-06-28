import exceptions.LojaNaoExistente;
import exceptions.ProdutoNaoExistente;

import java.util.ArrayList;

public class Sistema {

    ArrayList<Loja> lojas = new ArrayList<Loja>();

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

    public boolean procurarProduto(Produto produto) throws ProdutoNaoExistente {
        for(Loja l: lojas){
            l.procurarProduto(produto);
        }
        throw new ProdutoNaoExistente();
    }

    void incluirProduto(Produto produto){

    }
}
