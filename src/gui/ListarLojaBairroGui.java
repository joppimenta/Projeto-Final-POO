package gui;

import data.Loja;
import data.Produto;
import exceptions.ListaVazia;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ListarLojaBairroGui extends JFrame {
    private JLabel bairroLabel = new JLabel("Que bairro você quer consultar as lojas?");
    private JTextField bairroField = new JTextField();
    private JButton listarLojaBairroBotao = new JButton("Consultar");
    private JTextArea textArea = new JTextArea();

    public ListarLojaBairroGui() {
        setTitle("Listar Lojas por Bairro");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        panel1.add(bairroLabel, gbc);

        gbc.gridx = 1;

        bairroField.setColumns(7);
        panel1.add(bairroField, gbc);

        gbc.gridy = 1;
        panel1.add(listarLojaBairroBotao, gbc);

        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add(textArea);
        add(panel2, BorderLayout.CENTER);

        setSize(500, 500);
        setLocationRelativeTo(null);
        listarLojaBairroBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Collection<Loja> listaLojasBairro = Fachada.getInstancia().listaLojaBairro(bairroField.getText());
                    String result = "";
                    String produtos = "Lista de produtos: " + System.lineSeparator();
                    for(Loja l : listaLojasBairro){
                        result = result + "Nome da loja: " + l.getNome() + System.lineSeparator() + "Endereço: " + l.getEndereco() +
                                System.lineSeparator() + "Bairro: " + l.getBairro() + System.lineSeparator() + "Cidade: " + l.getCidade() +
                                System.lineSeparator() + "Estado: " + l.getEstado() + System.lineSeparator() + System.lineSeparator();
                        for (Produto produto : l.getProdutos()) {
                            produtos = produtos + produto.getNome() + ": " + produto.getPreco()+ "R$" + System.lineSeparator();
                        }
                    }
                    textArea.setText(result + produtos);

                } catch (ListaVazia ex) {
                    JOptionPane.showMessageDialog(null, "Não há lojas cadastradas");
                }
            }
        });



    }
}
