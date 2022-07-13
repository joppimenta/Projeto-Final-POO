package gui;

import data.Loja;
import exceptions.*;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaLojaGui extends JFrame {

    private JLabel nomeLabel = new JLabel("Nome da Loja: ");
    private JTextField nomeLoja = new JTextField();

    private JLabel enderecoLabel = new JLabel("Endereco: ");
    private JTextField endereco = new JTextField();

    private JLabel bairroLabel = new JLabel("Bairro: ");
    private JTextField bairro = new JTextField();

    private JLabel cidadeLabel = new JLabel("Cidade: ");
    private JTextField cidade = new JTextField();

    private JLabel estadoLabel = new JLabel("Estado: ");
    private JTextField estado = new JTextField();

    private JButton criarLojaBotao = new JButton("Criar loja");

    public NovaLojaGui(){
        super();
        setTitle("Nova Loja");
        Container c = this.getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();
        c.setLayout(new GridBagLayout());


        gbc.gridx = 0;
        gbc.gridy = 0;

        c.add(nomeLabel, gbc);

        gbc.gridx = 1;

        nomeLoja.setColumns(10);
        c.add(nomeLoja, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        c.add(enderecoLabel, gbc);

        gbc.gridx = 1;

        endereco.setColumns(10);
        c.add(endereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        c.add(bairroLabel, gbc);

        gbc.gridx = 1;
        bairro.setColumns(10);
        c.add(bairro, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        c.add(cidadeLabel, gbc);

        gbc.gridx = 1;
        cidade.setColumns(10);
        c.add(cidade, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;

        c.add(estadoLabel, gbc);

        gbc.gridx = 1;
        estado.setColumns(10);
        c.add(estado, gbc);

        gbc.gridy = 5;

        c.add(criarLojaBotao, gbc);

        setSize(500, 500);
        setLocationRelativeTo(null);
        criarLojaBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Loja temp = new Loja(nomeLoja.getText(), endereco.getText(), bairro.getText(), cidade.getText(), estado.getText());
                    if(nomeLoja.getText().equalsIgnoreCase("") || endereco.getText().equalsIgnoreCase("") || bairro.getText().equalsIgnoreCase("") ||
                    cidade.getText().equalsIgnoreCase("") || estado.getText().equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
                    }
                    else{
                        Fachada.getInstancia().novaLoja(temp);
                        JOptionPane.showMessageDialog(null, "Loja adicionada com sucesso");
                        setVisible(false);
                    }
                } catch (LojaJaExistente ex) {
                    JOptionPane.showMessageDialog(null, "Essa loja já existe");
                }
            }
        });
    }


}
