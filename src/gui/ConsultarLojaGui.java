package gui;

import data.Loja;
import data.Produto;
import exceptions.LojaNaoExistente;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarLojaGui extends JFrame {

    private JLabel questionLabel = new JLabel("Que Loja você deseja consultar?");

    private JTextArea lojaNome = new JTextArea();
    private JTextField lojaConsultada = new JTextField();
    private JButton consultarButao = new JButton("Consultar Loja");

    public ConsultarLojaGui(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        panel1.add(questionLabel, gbc);

        gbc.gridx = 1;

        lojaNome.setColumns(7);
        panel1.add(lojaNome, gbc);

        gbc.gridy = 1;
        panel1.add(consultarButao, gbc);

        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add(lojaConsultada);
        add(panel2, BorderLayout.CENTER);

        setSize(500, 500);

        consultarButao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Loja temp = Fachada.getInstancia().consultaLoja(lojaNome.getText());
                    String resp = "Nome da loja: " + temp.getNome() + System.lineSeparator() + "Endereço: " + temp.getEndereco()
                            + System.lineSeparator() + "Bairro: " + temp.getBairro() + System.lineSeparator() + "Cidade: " + temp.getCidade() + System.lineSeparator() + "Estado: " + temp.getEstado() + System.lineSeparator();
                } catch(LojaNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Loja especificada não existe");
                }
            }
        });

    }

}
