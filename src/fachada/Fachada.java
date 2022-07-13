package fachada;

import java.util.Collection;

import Repositorios.RepositorioLojas;
import Repositorios.RepositorioProdutos;
import controllers.ControladorLoja;
import controllers.ControladorProduto;
import data.Produto;
import exceptions.ListaVazia;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;
import data.Loja;

/** Fachada do Projeto. Singleton
 * @see controllers para documentação dos métodos
 * @version 1.0
 * @since 1.0
 */
public class Fachada {
    private ControladorLoja contLoja;
    private ControladorProduto contProduto;

    private static Fachada instancia = null;
    
    /** Construtor da fachada, metódo privado para a implementação do singleton
     * 
     */
    private Fachada() {
        RepositorioProdutos repProdutos = new RepositorioProdutos();
        RepositorioLojas repLojas = new RepositorioLojas();

        contProduto = new ControladorProduto(repProdutos);
        contLoja = new ControladorLoja(repLojas);
    }

    /** Implementa o singleton, se uma fachada não existir uma é criada, se já, o método retorna a fachada
     * @return
     */
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public void novoProduto(Produto prod) throws ProdutoJaExistente{
        contProduto.novoProduto(prod);
    }
    public void alteraProduto(Produto prod) throws ProdutoNaoExistente{
        contProduto.alteraProduto(prod);
    }
    public void removeProduto(String nomeProduto) throws ProdutoNaoExistente{
        contProduto.removeProduto(nomeProduto);
    }
    public Produto consultaProduto(String prod) throws ProdutoNaoExistente{
        return contProduto.consultaProduto(prod);
    }
    public Collection<Produto> listaProduto() throws ProdutoNaoExistente{
        return contProduto.listaProduto();
    }

    public void novaLoja(Loja loja) throws LojaJaExistente, LojaNaoExistente{
        contLoja.novaLoja(loja);
    }
    public void alteraLoja(Loja loja) throws LojaNaoExistente{
        contLoja.alteraLoja(loja);
    }
    public void removeLoja(String loja) throws LojaNaoExistente{
        contLoja.removeLoja(loja);
    }
    /** Adiciona um novo produto a uma loja
     * @param loja
     * @param prod
     * @throws ProdutoJaExistente
     * @throws ProdutoNaoExistente
     */
    public void adicionarProduto(Loja loja, Produto prod) throws ProdutoJaExistente, ProdutoNaoExistente {
        contLoja.adicionarProduto(loja, prod, this.contProduto.getRepositorioProdutos());
    }
    public void removerProduto(Loja loja, Produto prod) throws ListaVazia{
        contLoja.removerProduto(loja, prod);
    }
    public Loja consultaLoja(String loja) throws LojaNaoExistente{
        return contLoja.consultaLoja(loja);
    }
    public Collection<Loja> listaLojaBairro(String bairro) throws ListaVazia{
        return contLoja.listaLojaBairro(bairro);
    }
    public Collection<Loja> listaLojaCidade(String cidade) throws ListaVazia{
        return contLoja.listaLojaCidade(cidade);
    }
}
