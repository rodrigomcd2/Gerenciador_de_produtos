package view;

import repository.VendedorRepository;

import javax.swing.*;
import java.awt.*;

public class AreaVendedorView extends JPanel {

    public AreaVendedorView(DashboardView dashboard) {

        setLayout(new BorderLayout());

        String nome = VendedorRepository.getVendedorAtual().getNome();

        JLabel lblVendedor = new JLabel("Vendedor logado: " + nome);
        lblVendedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnExportar = new JButton("Exportar Planilha");

        JPanel botoes = new JPanel();
        botoes.add(btnExportar);

        add(lblVendedor, BorderLayout.NORTH);
        add(botoes, BorderLayout.CENTER);
    }
}
