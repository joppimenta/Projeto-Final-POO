package gui;

import data.Produto;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarProdutoGui extends JFrame {

    private JLabel nomeLabel = new JLabel("Que produto voce deseja alterar?: ");
    private JTextField nomeProduto = new JTextField();

    private JLabel quantidadeLabel = new JLabel("Quantidade em Estoque: ");
    private JTextField quantidadeEmEstoque = new JTextField();

    private JLabel precoLabel = new JLabel("Preco: ");
    private JTextField preco = new JTextField();

    private JButton alterarProdutoBotao = new JButton("Alterar Produto");

    public AlterarProdutoGui(){
        super();
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
        c.add(alterarProdutoBotao, gbc);

        setSize(500, 500);

        alterarProdutoBotao.addActionListener(new ActionListener() {
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
                    else{
                        Fachada.getInstancia().alteraProduto(temp);
                        JOptionPane.showMessageDialog(null, "Produto alterado com êxito");
                        setVisible(false);
                    }

                } catch (ProdutoNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Esse produto não existe");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Insira números válidos");
                }
            }
        });
    }


}