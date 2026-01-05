package app;

import view.*;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
    // Cria a tela
        SwingUtilities.invokeLater(() -> {

            VitrineView vitrineView = new VitrineView();// recebe as atualizações de Vitrine
            FormProdutoView formProdutoView = new FormProdutoView(vitrineView);
            HistoricoView historicoView = new HistoricoView();

            DashboardView dashboard = new DashboardView(
                    vitrineView,
                    formProdutoView,
                    null,
                    historicoView
            );

            AreaVendedorView areaVendedorView =
                    new AreaVendedorView(dashboard);

            dashboard.setAreaVendedorView(areaVendedorView);

            dashboard.setVisible(true);
        });
    }
}
