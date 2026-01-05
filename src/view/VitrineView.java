package view;

import model.Produto;
import model.Vendedor;
import repository.VendedorRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VitrineView extends JPanel {

    private JPanel painelCards;

    public VitrineView() {
        setLayout(new BorderLayout());

        painelCards = new JPanel();
        painelCards.setLayout(new GridLayout(0, 3, 10, 10));

        JScrollPane scroll = new JScrollPane(painelCards);
        add(scroll, BorderLayout.CENTER);

        atualizar();
    }

    public void atualizar() {
        painelCards.removeAll();

        Vendedor vendedor = VendedorRepository.getVendedorAtual();
        List<Produto> produtos = vendedor.getProdutos();

        for (Produto p : produtos) {
            painelCards.add(criarCard(p));
        }

        repaint();
        revalidate();
    }

    private JPanel criarCard(Produto produto) {

        JPanel card = new JPanel();
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel lblNome = new JLabel(produto.getNome());
        JLabel lblTipo = new JLabel("Tipo: " + produto.getTipo());
        JLabel lblPreco = new JLabel("Preço: R$ " + produto.getPreco());
        JLabel lblQtd = new JLabel("Quantidade: " + produto.getQuantidade());

        JTextField txtRemover = new JTextField(5);
        txtRemover.setMaximumSize(new Dimension(60,25));

        JButton btnRemover = new JButton("Remover");

        btnRemover.addActionListener(e -> {
            try {
                int qtd = Integer.parseInt(txtRemover.getText());

                VendedorRepository
                        .getVendedorAtual()
                        .removerQuantidade(produto, qtd);

                atualizar();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Quantidade inválida",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        card.add(lblNome);
        card.add(lblTipo);
        card.add(lblPreco);
        card.add(lblQtd);
        card.add(new JLabel("Qtd a remover:"));
        card.add(txtRemover);
        card.add(btnRemover);

        return card;
    }
}
