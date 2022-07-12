package gui;

import fachada.Fachada;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    private JButton criarProduto = new JButton("Criar produto");
    private JButton removerProduto = new JButton("Remover Produto");
    private JButton alterarProduto = new JButton("Alterar Produto");
    private JButton consultarProduto = new JButton("Consultar Produto");

    private JButton criarLoja = new JButton("Criar Loja");
    private JButton removerLoja = new JButton("Remover Loja");
    private JButton alterarLoja = new JButton("Alterar Loja");
    private JButton consultarLoja = new JButton("Consultar Loja");

    private JButton adicionarProdutoLoja = new JButton("Adicionar Produto em uma Loja");
    private JButton removerProdutoLoja = new JButton("Remover Produto em uma Loja");
    private JButton listarLojaBairro = new JButton("Listar Loja Por Bairro");
    private JButton listarLojaCidade = new JButton("Listar Loja por Cidade");

    private AdicionarProdutoGui adicionarProdutoGui;

    private Fachada fachada;

    public Principal(){
        super();
        Container c = getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        c.setLayout(new GridBagLayout());

        c.add(criarProduto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(removerProduto, gbc);

        gbc.gridx = 2;

        c.add(alterarProduto, gbc);

        gbc.gridx = 3;
        c.add(consultarProduto, gbc);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);

        gbc.gridx = 0;
        gbc.gridy = 1;

        c.add(criarLoja, gbc);

        gbc.gridx = 1;
        c.add(removerLoja, gbc);

        gbc.gridx = 2;
        c.add(alterarLoja, gbc);

        gbc.gridx = 3;
        c.add(consultarLoja, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        c.add(adicionarProdutoLoja, gbc);

        gbc.gridx = 1;
        c.add(removerProdutoLoja, gbc);

        gbc.gridx = 2;
        c.add(listarLojaCidade, gbc);

        gbc.gridx = 3;
        c.add(listarLojaBairro, gbc);


        setVisible(true);
    }


    public static void main(String[] args) {
        new Principal();
    }
}
