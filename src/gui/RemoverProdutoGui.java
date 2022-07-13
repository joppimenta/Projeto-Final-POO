package gui;

import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverProdutoGui extends JFrame {
    private JLabel nomeProdutoLabel = new JLabel("Digite o nome do produto você deseja remover: ");
    private JTextArea nomeProduto = new JTextArea();
    private JButton removerBotao = new JButton("Remover produto");

    public RemoverProdutoGui(){
        super();
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());
        setSize(500, 500);

        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(nomeProdutoLabel, gbc);

        gbc.gridx = 1;

        nomeProduto.setColumns(200);

        c.add(nomeProduto, gbc);

        gbc.gridy = 1;

        c.add(removerBotao, gbc);

        removerBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Fachada.getInstancia().removeProduto(nomeProduto.getText());
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                } catch (ProdutoNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Esse produto não existe");
                }
            }
        });
    }

}
