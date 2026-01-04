package model;

public class Sensor extends Produto {

    public Sensor(String nome, int quantidade,double preco) {
        super(nome, quantidade,preco);
    }

    @Override
    public String getTipo() {
        return "Sensor";
    }

    @Override
    public String getDescricaoTecnica() {
        return "Dispositivo utilizado para leitura de dados ambientais.";
    }
}
