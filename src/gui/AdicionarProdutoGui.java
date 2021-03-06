package gui;

import data.Produto;
import exceptions.ProdutoJaExistente;
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
        setTitle("Adicionar Produto");
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());


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
        setLocationRelativeTo(null);


        criarProdutoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantidade = Integer.parseInt(quantidadeEmEstoque.getText());
                    double valor = Double.parseDouble(preco.getText());
                    if(quantidade <= 0 || valor <= 0){
                        throw new NumberFormatException();
                    }
                    Produto temp = new Produto(nomeProduto.getText(), quantidade, valor);
                    if(nomeProduto.getText().equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null, "Identifique o produto");
                    }
                    else {
                        Fachada.getInstancia().novoProduto(temp);
                        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                        setVisible(false);
                    }
                } catch (ProdutoJaExistente ex) {
                    JOptionPane.showMessageDialog(null, "Esse produto j?? existe");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Insira n??meros v??lidos");
                }
            }
        });
        }


}
