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

public class Fachada {
    private ControladorLoja contLoja;
    private ControladorProduto contProduto;

    private static Fachada instancia = null;
    
    private Fachada() {
        RepositorioProdutos repProdutos = new RepositorioProdutos();
        RepositorioLojas repLojas = new RepositorioLojas();

        contProduto = new ControladorProduto(repProdutos);
        contLoja = new ControladorLoja(repLojas, contProduto);
    }

    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public void novoProduto(Produto prod) throws ProdutoJaExistente, ProdutoNaoExistente {
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
    public void adicionarProduto(Loja loja, Produto prod) throws ProdutoJaExistente, ProdutoNaoExistente {
        contLoja.adicionarProduto(loja, prod);
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
