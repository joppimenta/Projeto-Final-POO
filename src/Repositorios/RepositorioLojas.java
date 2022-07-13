package Repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import data.Loja;

public class RepositorioLojas {
    private Map<String, Loja> listaLojas = new HashMap<String, Loja>();

    public void novaLoja(Loja loja){
        listaLojas.put(loja.getNome(), loja);
    }

    public void alterarLoja(Loja loja){
        this.listaLojas.put(loja.getNome(), loja);
    }

    public void removerLoja(String nomeLoja){
        this.listaLojas.remove(nomeLoja);
    }

    public Collection<Loja> listaLoja(){
        return listaLojas.values();
    }

    public Loja consultaLoja(String nomeLoja){
        Loja existe = null;
        for (Loja loja : listaLojas.values()) {
            if (loja.getNome().equalsIgnoreCase(nomeLoja)) {
                existe = loja;
                break;
            }
        }
        return existe;
    }

    public ArrayList<Loja> listaLojaBairro(String bairro){
        ArrayList<Loja> lista = new ArrayList<Loja>();
        for (Loja loja : listaLojas.values()) {
            if (loja.getBairro().equalsIgnoreCase(bairro)) {
                lista.add(loja);
            }
        }
        return lista;
    }

}
