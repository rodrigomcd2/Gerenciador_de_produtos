package model;

public class Prototipagem extends Produto {

    public Prototipagem(String nome, int quantidade,double preco) {
        super(nome, quantidade,preco);
    }

    @Override
    public String getTipo() {
        return "Prototipagem";
    }

    @Override
    public String getDescricaoTecnica() {
        return "Componente utilizado para montagem e testes de circuitos.";
    }
}
