package Repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import data.Loja;

/** Repositório de lojas. Armazena as lojas como um banco de dados CRUD
 * @version 1.0
 * @since 1.0
 */
public class RepositorioLojas {
    private Map<String, Loja> listaLojas = new HashMap<String, Loja>();

   /** Registra uma nova loja
     * @param loja
     */
     public void novaLoja(Loja loja){
        listaLojas.put(loja.getNome(), loja);
    }

    /** Altera os dados de uma loja já existente. Sobrescreve a loja antiga com uma loja exatamente igual, mas com os dados atualizados
     * @param loja
     */
    public void alterarLoja(Loja loja){
        this.listaLojas.put(loja.getNome(), loja);
    }

    /** Remove uma loja
     * @param nomeLoja
     */
    public void removerLoja(String nomeLoja){
        this.listaLojas.remove(nomeLoja);
    }

    /** Lista todas as lojas registradas
     * @return
     */
    public Collection<Loja> listaLoja(){
        return listaLojas.values();
    }

    /** Procura por uma loja pelo nome
     * @param nomeLoja
     * @return
     */
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
}
