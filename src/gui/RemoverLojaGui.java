package gui;

import exceptions.LojaNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverLojaGui extends JFrame {
    private JLabel nomeLojaLabel = new JLabel("Digite o nome da loja você deseja remover: ");
    private JTextField nomeLoja = new JTextField();
    private JButton removerBotao = new JButton("Remover Loja");


    public RemoverLojaGui(){
        super();
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());
        setSize(500, 500);

        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(nomeLojaLabel, gbc);

        gbc.gridx = 1;

        nomeLoja.setColumns(10);

        c.add(nomeLoja, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        c.add(removerBotao, gbc);

        removerBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Fachada.getInstancia().removeLoja(nomeLoja.getText());
                    JOptionPane.showMessageDialog(null, "Loja removida com sucesso");
                    setVisible(false);
                } catch (LojaNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Essa loja não existe");
                }
            }
        });
    }

}
