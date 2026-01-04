package model;

public class Microcontrolador extends Produto {

    public Microcontrolador(String nome, int quantidade, double preco) {
        super(nome, quantidade,preco);
    }

    @Override
    public String getTipo() {
        return "Microcontrolador";
    }

    @Override
    public String getDescricaoTecnica() {
        return "Unidade de controle programável para sistemas embarcados.";
    }
}
