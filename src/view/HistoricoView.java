package view;

import repository.VendedorRepository;

import javax.swing.*;
import java.awt.*;

public class HistoricoView extends JPanel {

    private JTextArea area;

    public HistoricoView() {
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);

        atualizar();
    }

    public void atualizar() {
        area.setText("");

        for (String h : VendedorRepository
                .getVendedorAtual()
                .getHistorico()) {
            area.append(h + "\n");
        }
    }
}
