package gui;

import data.Produto;
import exceptions.ProdutoNaoExistente;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarProdutoGui extends JFrame {

    private JLabel questionLabel = new JLabel("Que produto você deseja consultar?");
    private JLabel nomeLabel = new JLabel("Nome do produto: ");
    private JLabel quantidadeLabel = new JLabel("Quantidade em estoque: ");
    private JLabel precoLabel = new JLabel("Preço: ");
    private JTextField produto = new JTextField();
    private JTextArea produtoConsultado = new JTextArea();
    private JButton consultarButao = new JButton("Consultar produto");

    public ConsultarProdutoGui(){
        setTitle("Consultar Produto");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        panel1.add(questionLabel, gbc);

        gbc.gridx = 1;

        produto.setColumns(10);
        panel1.add(produto, gbc);

        gbc.gridy = 1;
        panel1.add(consultarButao, gbc);

        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add(produtoConsultado);
        add(panel2, BorderLayout.CENTER);

        setSize(500, 500);
        setLocationRelativeTo(null);
        consultarButao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produto temp = Fachada.getInstancia().consultaProduto(produto.getText());
                    String resp = "Nome do produto: " + temp.getNome() + System.lineSeparator() + "Quantidade em estoque: " + temp.getQuantidadeEmEstoque()
                            + System.lineSeparator() + "Preco: " + temp.getPreco();
                    produtoConsultado.setText(resp);
                } catch (ProdutoNaoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Produto especificado não existe");
                }
            }
        });

    }

}
