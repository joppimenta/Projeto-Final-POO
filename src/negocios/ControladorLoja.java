package negocios;

import dados.Loja;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;

import java.util.ArrayList;

public class ControladorLoja {

    ArrayList<Loja> lojas = new ArrayList<Loja>();


    public boolean existeLoja(String id){
        boolean achou = false;
        for(Loja l: lojas){
            if(l.getId() == id){
                achou = true;
                break;
            }
        }
        return achou;
    }

    public void inserir(Loja loja) throws LojaJaExistente {
        if(existeLoja(loja.getId())){
            throw new LojaJaExistente();
        }
        else{
            lojas.add(loja);
        }
    }

    public void excluir(Loja loja) throws LojaNaoExistente {
        if(!existeLoja(loja.getId())){
            throw new LojaNaoExistente();
        }
        else {
            lojas.remove(loja);
        }
    }

    public void alterar(Loja loja) throws LojaNaoExistente{
        try {
            for(Loja l: lojas){
                if(l.getId().equals(loja.getId())){
                    l = loja;
                }
            }
        } catch (Exception e) {
            throw new LojaNaoExistente();
        }
    }

    public Loja consultar(Loja loja) throws LojaNaoExistente{
        if(existeLoja(loja.getId())){
            return loja;
        }
        else {
            throw new LojaNaoExistente();
        }
    }
}