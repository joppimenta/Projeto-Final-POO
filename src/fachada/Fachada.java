package fachada;

import dados.Loja;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;
import negocios.ControladorLoja;

public class Fachada {
    private ControladorLoja controladorLoja;

    public Fachada(){

    }

    public void incluirLoja(Loja loja) throws LojaJaExistente {
        controladorLoja.inserir(loja);
    }

    public void excluirLoja(Loja loja) throws LojaNaoExistente {
        controladorLoja.excluir(loja);
    }

    public void alterarLoja(Loja loja) throws LojaNaoExistente {
        controladorLoja.alterar(loja);
    }

    public Loja consultarLoja(Loja loja) throws LojaNaoExistente {
        return controladorLoja.consultar(loja);
    }

}
