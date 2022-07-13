package controllers;

import java.util.Collection;

import Repositorios.RepositorioProdutos;
import data.Produto;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

/** Controlador do repositório de produtos
 * @version 1.0
 * @since 1.0
 */
public class ControladorProduto {

    private RepositorioProdutos repositorioProdutos;

    /** Construtor do controlador
     * @param repositorioProdutos
     */
    public ControladorProduto(RepositorioProdutos repositorioProdutos) {
        this.repositorioProdutos = repositorioProdutos;
    }

    /** Método getter para o repositório de produtos, criado para que o ControladorLoja tenha acesso ao repositório por meio da fachada
     * @return
     */
    public RepositorioProdutos getRepositorioProdutos(){
        return repositorioProdutos;
    }

    /** Adiciona um novo produto a lista de produtos
     * @param prod
     * @throws ProdutoJaExistente
     * @throws ProdutoNaoExistente
     */
    public void novoProduto(Produto prod) throws ProdutoJaExistente, ProdutoNaoExistente{
        if (repositorioProdutos.consultaProduto(prod.getNome()) == null){
            repositorioProdutos.novoProduto(prod);
        }
        else{
            throw new ProdutoJaExistente();
        }
    }

    /** Altera um produto já existente
     * @param prod
     * @throws ProdutoNaoExistente
     */
    public void alteraProduto(Produto prod) throws ProdutoNaoExistente{
        consultaProduto(prod.getNome());
        repositorioProdutos.alterarProduto(prod);
    }

    /** Remove um produto já existente
     * @param produtoNome
     * @throws ProdutoNaoExistente
     */
    public void removeProduto(String produtoNome) throws ProdutoNaoExistente{
        consultaProduto(produtoNome);
        repositorioProdutos.removerProduto(produtoNome);
    }

    /** Consulta um produto
     * @param prod
     * @return Produto
     * @throws ProdutoNaoExistente
     */
    public Produto consultaProduto(String prod) throws ProdutoNaoExistente{
        if (repositorioProdutos.consultaProduto(prod) == null) {
            throw new ProdutoNaoExistente();
        }
        return repositorioProdutos.consultaProduto(prod);
    }

    /** Cria uma lista de produtos
     * @return lista de todos os produtos registrados
     * @throws ProdutoNaoExistente
     */
    public Collection<Produto> listaProduto() throws ProdutoNaoExistente{
        Collection<Produto> lista = repositorioProdutos.listaProduto();
        if (lista == null || lista.size() == 0) {
            throw new ProdutoNaoExistente();
        }
        return lista;
    }
}
