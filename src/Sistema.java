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
import fachada.Fachada;

public class Sistema {

    public static void main(String[] args) throws ProdutoJaExistente, LojaJaExistente, LojaNaoExistente, ProdutoNaoExistente, ListaVazia {
        Produto produtoTeste = new Produto("Vassoura", 2, 13.50);
        Produto produtoTeste2 = new Produto("Lápis", 5, 3);
        Produto tapioca = new Produto("Tapioca", 55, 12);
        Loja novaLoja = new Loja("Claudinha LOja", "RUa 44", "Jangurussu", "Fortaleza", "Ceara");
        Loja novaLoja2 = new Loja("Tapioca do claudio", "RUa 22", "Jangurussu", "Fortaleza", "Ceara");

        Fachada fachada = Fachada.getInstancia();

        fachada.novoProduto(produtoTeste);
        fachada.novoProduto(produtoTeste2);

        fachada.novaLoja(novaLoja);

        fachada.adicionarProduto(novaLoja, produtoTeste);

        }
    }

