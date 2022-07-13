package gui;

import data.Loja;
import data.Produto;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoLojaGui extends JFrame {

    private JLabel produtoLabel = new JLabel("Que produto você quer adicionar?");
    private JTextField produtoField = new JTextField();
    private JLabel lojaLabel = new JLabel("Em que loja voce quer adicionar o produto?");
    private JTextField lojaField = new JTextField();

    private JButton adicionarBotao = new JButton("Adicionar produto");

    public AdicionarProdutoLojaGui() {
        super();
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());

        setSize(500, 500);

        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(produtoLabel, gbc);

        gbc.gridx = 1;
        produtoField.setColumns(10);
        c.add(produtoField, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;

        c.add(lojaLabel, gbc);

        gbc.gridx = 1;
        lojaField.setColumns(10);
        c.add(lojaField, gbc);

        gbc.gridy = 2;

        c.add(adicionarBotao, gbc);

        adicionarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Loja lojaTemp = Fachada.getInstancia().consultaLoja(lojaField.getText());
                    Produto produtoTemp = Fachada.getInstancia().consultaProduto(produtoField.getText());
                    Fachada.getInstancia().adicionarProduto(lojaTemp, produtoTemp);
                } catch (LojaNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Essa loja não existe");
                } catch (ProdutoNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Produto especificado não existe");
                } catch (ProdutoJaExistente ex) {
                    JOptionPane.showMessageDialog(null, "Esse produto já está cadastrado");
                }
            }
        });
    }
}
