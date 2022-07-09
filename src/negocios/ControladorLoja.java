package negocios;

import dados.Loja;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;

import java.util.ArrayList;
import java.util.List;

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

    List<Loja> listarLojasBairro(String bairro){
        ArrayList<Loja> temporario = new ArrayList<>();
        for(Loja l: lojas){
            if(l.getBairro().equals(bairro)){
                temporario.add(l);
            }
        }
        return temporario;
    }

    List<Loja> listarLojasCidade(String cidade){
        ArrayList<Loja> temporario = new ArrayList<>();
        for(Loja l: lojas){
            if(l.getCidade().equals(cidade)){
                temporario.add(l);
            }
        }
        return temporario;
    }
}
