package model;

import java.io.Serializable;
// importa a contagem de tempo no historico
import java.time.LocalDateTime;


public class Transacao implements Serializable {

    private String acao;
    private String produto;
    private String tipo;
    private int quantidade;
    private String vendedor;
    private LocalDateTime data;

    public Transacao(String acao, String produto, String tipo,
                     int quantidade, String vendedor) {
        this.acao = acao;
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.vendedor = vendedor;
        this.data = LocalDateTime.now();
    }

    public String toLinha() {
        return data + " | " + vendedor + " | " +
                acao + " | " + tipo + " | " +
                produto + " | Qtd: " + quantidade;
    }
}
