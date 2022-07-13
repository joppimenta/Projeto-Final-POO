package gui;

import exceptions.LojaNaoExistente;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveLojaGui extends JFrame {
    private JLabel nomeLojaLabel = new JLabel("Digite o nome da loja você deseja remover: ");
    private JTextArea nomeLoja = new JTextArea();

    private JButton removerBotao = new JButton("Remover Loja");


    public RemoveLojaGui(){
        super();
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(nomeLojaLabel, gbc);

        gbc.gridx = 1;

        nomeLoja.setColumns(200);

        c.add(nomeLoja, gbc);

        gbc.gridy = 1;

        c.add(removerBotao, gbc);

        removerBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Fachada.getInstancia().removeLoja(nomeLoja.getText());
                } catch (LojaNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Essa loja não existe");
                }
            }
        });
    }

    public static void main(String[] args) {
        new RemoverProdutoGui().setVisible(true);
    }
}
