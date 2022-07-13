package gui;

import data.Produto;
import exceptions.PreenchimentoInvalido;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoGui extends JFrame {

    private JLabel nomeLabel = new JLabel("Nome: ");
    private JTextField nomeProduto = new JTextField();

    private JLabel quantidadeLabel = new JLabel("Quantidade em Estoque: ");
    private JTextField quantidadeEmEstoque = new JTextField();

    private JLabel precoLabel = new JLabel("Preco: ");
    private JTextField preco = new JTextField();

    private JButton criarProdutoBotao = new JButton("Criar produto");

    public AdicionarProdutoGui(){
        super();
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(nomeLabel, gbc);

        gbc.gridx = 1;

        nomeProduto.setColumns(10);
        c.add(nomeProduto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        c.add(quantidadeLabel, gbc);

        gbc.gridx = 1;

        quantidadeEmEstoque.setColumns(10);
        c.add(quantidadeEmEstoque, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        c.add(precoLabel, gbc);

        gbc.gridx = 1;
        preco.setColumns(10);
        c.add(preco, gbc);

        gbc.gridy = 3;
        c.add(criarProdutoBotao, gbc);

        setSize(500, 500);
        setVisible(true);

        criarProdutoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto temp = new Produto(nomeProduto.getText(), Integer.parseInt(quantidadeEmEstoque.getText()), Double.parseDouble(preco.getText()));
                if(nomeProduto.getText().equalsIgnoreCase("") || quantidadeEmEstoque.getText().equalsIgnoreCase("") || preco.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
                }
                try {
                    Fachada.getInstancia().novoProduto(temp);
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                } catch (ProdutoNaoExistente ex) {
                } catch (ProdutoJaExistente ex) {
                    JOptionPane.showMessageDialog(null, "Esse produto já existe");
                }
            }
        });
        }


    public static void main(String[] args) {
        new AdicionarProdutoGui();
    }
}
