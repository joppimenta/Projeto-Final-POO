import exceptions.ListaVazia;
import exceptions.LojaJaExistente;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

import java.util.Collection;

import Repositorios.RepositorioLojas;
import Repositorios.RepositorioProdutos;
import controllers.ControladorLoja;
import controllers.ControladorProduto;
import data.Loja;
import data.Produto;

public class Sistema {

    public static void main(String[] args) throws ProdutoJaExistente, LojaJaExistente, LojaNaoExistente, ProdutoNaoExistente, ListaVazia {
        Produto produtoTeste = new Produto("Vassoura", 2, 13.50);
        Produto produtoTeste2 = new Produto("Lápis", 5, 3);
        Produto tapioca = new Produto("Tapioca", 55, 12);
        Loja novaLoja = new Loja("Claudinha LOja", "RUa 44", "Jangurussu", "Fortaleza", "Ceara");
        Loja novaLoja2 = new Loja("Tapioca do claudio", "RUa 22", "Jangurussu", "Fortaleza", "Ceara");


        RepositorioLojas repLojas = new RepositorioLojas();
        RepositorioProdutos repProdutos = new RepositorioProdutos();
        ControladorLoja contLoja = new ControladorLoja(repLojas);
        ControladorProduto contProduto = new ControladorProduto(repProdutos);

        contProduto.novoProduto(produtoTeste);
        contProduto.novoProduto(produtoTeste2);
        contProduto.novoProduto(tapioca);
    
        contLoja.novaLoja(novaLoja);
        contLoja.novaLoja(novaLoja2);

        contLoja.adicionarProduto(novaLoja, tapioca);
        contLoja.adicionarProduto(novaLoja2, produtoTeste);

        Collection<Loja> listaDeLoja = contLoja.listaLojaBairro("jangurussu");
        for (Loja loja : listaDeLoja) {
            System.out.println("nome: "+ loja.getNome() +"bairro: "+ loja.getBairro());
        }
    }
}
