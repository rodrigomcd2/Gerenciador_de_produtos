package repository;

import model.Transacao;
import java.util.ArrayList;
import java.util.List;

public class HistoricoRepository {

    private static List<Transacao> historico = new ArrayList<>();

    public static void adicionar(Transacao t) {
        historico.add(t);
    }

    public static List<Transacao> getHistorico() {
        return historico;
    }

    public static void setHistorico(List<Transacao> lista) {
        historico = lista;
    }
}
