package gui;

import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private RemoverProdutoGui removerProdutoGui;
    private AlterarProdutoGui alterarProdutoGui;
    private ConsultarProdutoGui consultarProdutoGui;
    private NovaLojaGui novaLojaGui;
    private RemoveLojaGui removeLojaGui;
    private AlteraLojaGui alteraLojaGui;
    private AdicionarProdutoLojaGui adicionarProdutoLojaGui;
    private RemoverProdutoLojaGui removerProdutoLojaGui;


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

        adicionarProdutoGui = new AdicionarProdutoGui();
        removerProdutoGui = new RemoverProdutoGui();
        alteraLojaGui = new AlteraLojaGui();
        removeLojaGui = new RemoveLojaGui();
        adicionarProdutoGui = new AdicionarProdutoGui();
        consultarProdutoGui = new ConsultarProdutoGui();
        alterarProdutoGui = new AlterarProdutoGui();
        novaLojaGui = new NovaLojaGui();
        adicionarProdutoLojaGui = new AdicionarProdutoLojaGui();
        removerProdutoLojaGui = new RemoverProdutoLojaGui();

        criarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoGui.setVisible(true);
            }
        });

        removerProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProdutoGui.setVisible(true);
            }
        });

        alterarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarProdutoGui.setVisible(true);
            }
        });

        consultarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarProdutoGui.setVisible(true);
            }
        });

        criarLoja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaLojaGui.setVisible(true);
            }
        });

        removerLoja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeLojaGui.setVisible(true);
            }
        });

        alterarLoja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alteraLojaGui.setVisible(true);
            }
        });

        adicionarProdutoLoja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoLojaGui.setVisible(true);
            }
        });

        removerProdutoLoja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProdutoLojaGui.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new Principal();
    }
}
