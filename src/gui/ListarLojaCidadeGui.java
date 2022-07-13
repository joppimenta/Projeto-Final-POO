package gui;

import data.Loja;
import exceptions.ListaVazia;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ListarLojaCidadeGui extends JFrame {
    private JLabel cidadeLabel = new JLabel("Que cidade você quer consultar as lojas?");
    private JTextField cidadeField = new JTextField();
    private JButton listarLojaCidadeBotao = new JButton("Consultar");
    private JTextArea textArea = new JTextArea();

    public ListarLojaCidadeGui() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        panel1.add(cidadeLabel, gbc);

        gbc.gridx = 1;

        cidadeField.setColumns(7);
        panel1.add(cidadeField, gbc);

        gbc.gridy = 1;
        panel1.add(listarLojaCidadeBotao, gbc);

        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add(textArea);
        add(panel2, BorderLayout.CENTER);

        setSize(500, 500);

        listarLojaCidadeBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Collection<Loja> listaLojasCidade = Fachada.getInstancia().listaLojaCidade(cidadeField.getText());
                    String result = "";
                    for(Loja l : listaLojasCidade){
                        result = result + "Nome da loja: " + l.getNome() + System.lineSeparator() + "Endereço: " + l.getEndereco() +
                                System.lineSeparator() + "Bairro: " + l.getBairro() + System.lineSeparator() + "Cidade: " + l.getCidade() +
                                System.lineSeparator() + "Estado: " + l.getEstado() + System.lineSeparator() + System.lineSeparator();
                        textArea.setText(result);
                    }

                } catch (ListaVazia ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }
}
