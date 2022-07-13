package Repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import data.Produto;

/** Repositório de produtos
 * @version 1.0
 * @since 1.0
 */
public class RepositorioProdutos {
    private Map<String, Produto> listaProdutos = new HashMap<String, Produto>();

    /** Adiciona um novo produto
     * @param prod
     */
    public void novoProduto(Produto prod){
        listaProdutos.put(prod.getNome(), prod);
    }

    /** Altera os dados de um produto já existente. Sobrescreve o produto com um novo exatamente igual, mas com os dados atualizados
     * @param prod
     */
    public void alterarProduto(Produto prod){
        this.listaProdutos.put(prod.getNome(), prod);
    }

    /** Remove um produto já existente
     * @param nomeProduto
     */
    public void removerProduto(String nomeProduto){
        this.listaProdutos.remove(nomeProduto);
    }

    /** Lista os produtos registrados
     * @return
     */
    public Collection<Produto> listaProduto(){
        return listaProdutos.values();
    }

    /** Consulta produtos com base no nome
     * @param nomeProduto
     * @return
     */
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
