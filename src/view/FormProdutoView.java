package view;

import model.*;
import repository.VendedorRepository;

import javax.swing.*;
import java.awt.*;

public class FormProdutoView extends JPanel {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JComboBox<String> cbTipo;

    public FormProdutoView(VitrineView vitrineView) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblPreco = new JLabel("Preço:");
        JLabel lblQtd = new JLabel("Quantidade:");
        JLabel lblTipo = new JLabel("Tipo:");

        txtNome = new JTextField(15);
        txtPreco = new JTextField(15);
        txtQuantidade = new JTextField(15);

        cbTipo = new JComboBox<>(new String[]{
                "Sensor",
                "Microcontrolador",
                "Prototipagem"
        });

        JButton btnSalvar = new JButton("Adicionar Produto");

        gbc.gridx = 0; gbc.gridy = 0;
        add(lblNome, gbc);
        gbc.gridx = 1;
        add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblPreco, gbc);
        gbc.gridx = 1;
        add(txtPreco, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblQtd, gbc);
        gbc.gridx = 1;
        add(txtQuantidade, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblTipo, gbc);
        gbc.gridx = 1;
        add(cbTipo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(btnSalvar, gbc);

        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            String tipo = (String) cbTipo.getSelectedItem();

            Produto produto;

            switch (tipo) {
                case "Sensor":
                    produto = new Sensor(nome, quantidade, preco);
                    break;
                case "Microcontrolador":
                    produto = new Microcontrolador(nome, quantidade, preco);
                    break;
                default:
                    produto = new Prototipagem(nome, quantidade, preco);
            }

            VendedorRepository.getVendedorAtual().adicionarProduto(produto);

            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");

            txtNome.setText("");
            txtPreco.setText("");
            txtQuantidade.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao adicionar produto",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
