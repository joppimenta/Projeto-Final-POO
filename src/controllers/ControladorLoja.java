package controllers;

import java.util.ArrayList;
import java.util.Collection;

import Repositorios.RepositorioLojas;
import Repositorios.RepositorioProdutos;
import data.Loja;
import data.Produto;
import exceptions.*;

/** Controlador do repositório de lojas
 * @version 1.0
 * @since 1.0
 */
public class ControladorLoja {
    
    private RepositorioLojas repositorioLojas;

    /** Construtor do controlador de lojas
     * @param repositorioLojas
     */
    public ControladorLoja(RepositorioLojas repositorioLojas) {
        this.repositorioLojas = repositorioLojas;
    }

    /** Registra uma nova loja
     * @param loja
     * @throws LojaJaExistente
     * @throws LojaNaoExistente
     */
    public void novaLoja(Loja loja) throws LojaJaExistente{
        if (repositorioLojas.consultaLoja(loja.getNome()) == null){
            repositorioLojas.novaLoja(loja);
        }
        else{
            throw new LojaJaExistente();
        }
    }

    /** Altera os dados de uma loja já existente
     * @param loja
     * @throws LojaNaoExistente
     */
    public void alteraLoja(Loja loja) throws LojaNaoExistente{
        consultaLoja(loja.getNome());
        repositorioLojas.alterarLoja(loja);
    }

    /** Remove uma loja do repositório
     * @param nomeLoja
     * @throws LojaNaoExistente
     */
    public void removeLoja(String nomeLoja) throws LojaNaoExistente{
        consultaLoja(nomeLoja);
        repositorioLojas.removerLoja(nomeLoja);
    }

    /** Adiciona um produto em uma loja específica. Sempre verifica se o produto que está sendo adicionado existe no repositório de produtos
     * @param loja
     * @param prod
     * @param rep
     * @throws ProdutoJaExistente
     * @throws ProdutoNaoExistente
     */
    public void adicionarProduto(Loja loja, Produto prod, RepositorioProdutos rep) throws ProdutoJaExistente, ProdutoNaoExistente {
        ArrayList<Produto> lista = loja.getProdutos();
        for (Produto produto : lista) {
            if (produto.getNome().equalsIgnoreCase(prod.getNome())) {
                throw new ProdutoJaExistente();
            }
        }
        if(rep.consultaProduto(prod.getNome()) == null){
            throw new ProdutoNaoExistente();
        }
        lista.add(prod);
        loja.setProdutos(lista);
    }

   /** Remove um produto de uma loja
     * @param loja
     * @param prod
     * @throws ListaVazia
     */
     public void removerProduto(Loja loja, Produto prod) throws ListaVazia{
        ArrayList<Produto> lista = loja.getProdutos();
        if (lista == null || lista.size()== 0) {
            throw new ListaVazia();
        }
        lista.remove(prod);
        loja.setProdutos(lista);
    }

    /** Lista todas as lojas de um bairro específico
     * @param bairro
     * @return
     * @throws ListaVazia
     */
    public Collection<Loja> listaLojaBairro(String bairro) throws ListaVazia{
        Collection<Loja> lista = repositorioLojas.listaLoja();
        if (lista == null || lista.size() == 0) {
            throw new ListaVazia();
        }
        lista.removeIf(n -> (!n.getBairro().equalsIgnoreCase(bairro)));
        return lista;
    }

    /** Lista todas as lojas de uma cidade específica
     * @param cidade
     * @return
     * @throws ListaVazia
     */
    public Collection<Loja> listaLojaCidade(String cidade) throws ListaVazia{
        Collection<Loja> lista = repositorioLojas.listaLoja();
        if (lista == null || lista.size() == 0) {
            throw new ListaVazia();
        }
        lista.removeIf(n -> (!n.getCidade().equalsIgnoreCase(cidade)));
        return lista;
    }

    /** consulta por lojas com base no nome
     * @param loja
     * @return
     * @throws LojaNaoExistente
     */
    public Loja consultaLoja(String loja) throws LojaNaoExistente{
        if (repositorioLojas.consultaLoja(loja) == null) {
            throw new LojaNaoExistente();
        }
        return repositorioLojas.consultaLoja(loja);
    }
}
