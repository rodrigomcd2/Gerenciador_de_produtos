package view;

import repository.VendedorRepository;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {

    private JPanel painelCentral;
    private JLabel lblLogin;

    private final VitrineView vitrineView;
    private final FormProdutoView formProdutoView;
    private AreaVendedorView areaVendedorView; // não é final, pois pode ser alterado depois
    private final HistoricoView historicoView;

    public DashboardView(
            VitrineView vitrineView,
            FormProdutoView formProdutoView,
            AreaVendedorView areaVendedorView,
            HistoricoView historicoView
    ) {
        this.vitrineView = vitrineView;
        this.formProdutoView = formProdutoView;
        this.areaVendedorView = areaVendedorView;
        this.historicoView = historicoView;

        setTitle("Dashboard - Produtos Eletrônicos");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        montarLayout();
    }

    private void montarLayout() {

        // Layout do topo
        JPanel topo = new JPanel(new BorderLayout());
        topo.setPreferredSize(new Dimension(0, 45));
        topo.setBackground(new Color(220, 220, 220));
        topo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        lblLogin = new JLabel(
                "Login: " + VendedorRepository.getVendedorAtual().getNome()
        );

        JLabel lblStatus = new JLabel("Status: conectado");
        lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);

        topo.add(lblLogin, BorderLayout.WEST);
        topo.add(lblStatus, BorderLayout.EAST);

        add(topo, BorderLayout.NORTH);

        // Layout do menu lateral
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setPreferredSize(new Dimension(220, 0));
        menu.setBackground(new Color(235, 235, 235));
        menu.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JButton btnVitrine = criarBotao("Vitrine");
        JButton btnAdicionar = criarBotao("Adicionar Produto");
        JButton btnVendedor = criarBotao("Área do Vendedor");
        JButton btnHistorico = criarBotao("Histórico");

        menu.add(btnVitrine);
        menu.add(Box.createVerticalStrut(8));
        menu.add(btnAdicionar);
        menu.add(Box.createVerticalStrut(8));
        menu.add(btnVendedor);
        menu.add(Box.createVerticalStrut(8));
        menu.add(btnHistorico);

        add(menu, BorderLayout.WEST);

        // Layout da Area Central
        painelCentral = new JPanel(new BorderLayout());
        add(painelCentral, BorderLayout.CENTER);

        trocarTela(vitrineView);

        btnVitrine.addActionListener(e -> {
            vitrineView.atualizar();
            trocarTela(vitrineView);
        });

        btnAdicionar.addActionListener(e ->
                trocarTela(formProdutoView)
        );

        btnVendedor.addActionListener(e -> {
            trocarTela(areaVendedorView);
            atualizarLogin();
        });

        btnHistorico.addActionListener(e -> {
            historicoView.atualizar();
            trocarTela(historicoView);
        });
    }

    private JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setMaximumSize(new Dimension(200, 45));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(245, 245, 245));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
        return btn;
    }
    //troca as telas sem perder a informação
    private void trocarTela(JComponent tela) {
        painelCentral.removeAll();
        painelCentral.add(tela, BorderLayout.CENTER);
        painelCentral.revalidate();
        painelCentral.repaint();
    }
    //Exibe o login do vendedor no topo
    public void atualizarLogin() {
        lblLogin.setText(
                "Login: " + VendedorRepository.getVendedorAtual().getNome()
        );
    }


    public void setAreaVendedorView(AreaVendedorView areaVendedorView) {
        this.areaVendedorView = areaVendedorView;
    }
}
